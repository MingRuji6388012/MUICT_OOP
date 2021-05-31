// Student ID:
// Name:
// Section:

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class BasicMovieDatabase {

	// DO NOT MODIFY THIS
	public static final String INIT_PATH = Paths.get("").toAbsolutePath().toString()
			+ File.separator + "init" +  File.separator;

	public Map<Integer, Movie> movies = null;

	public static enum OPERATOR {EQ, LT, GT, LTE, GTE};
	// EQ = Equal, LT = Less than, GT = Greater than
	// LTE = Less than or equal, GTE = Greater than or equal

	// ---------------------------------------------------------------------

	public void importMovies(String movieFilename) {
		movies = new HashMap<Integer, Movie>();
		// -------- Using your code from Lab 10 -------------- //
		try{
			File file = new File(movieFilename);
			FileReader fileReader = new FileReader(file);
			BufferedReader reader = new BufferedReader(fileReader);
			String eachMovie = "";
			int movieID = 0;
			String movieTitle = null;
			String[] allTags = null;
			int count = 1;
			while(((eachMovie = reader.readLine()) != null)){
				Pattern moviePattern = Pattern.compile(("([\\d]+)([,]+)([\\w]+[\\w\\W]+)([,]+)([\\S|(\\w\\W)]+)"));  //("[\\d]+[,]+[\\w]+[^,]+[\\S]");
				Matcher messageGrouping =  moviePattern.matcher(eachMovie);
				if(messageGrouping.matches()){
//						System.out.println( count+": "+messageGrouping.group(1) +
//								" ||Movie name: "+ messageGrouping.group(3) +
//								" ||tag: "+ messageGrouping.group(5));
					movieID = Integer.parseInt(messageGrouping.group(1));
					movieTitle = messageGrouping.group(3);
					Movie movie = new Movie(movieID,movieTitle);
					allTags = messageGrouping.group(5).split("[\\|]");
					for (String eachTag : allTags) {
						movie.tags.add(eachTag);
					}
					movies.put(movieID,movie);
					count++;
				}
			}
		}
		catch(FileNotFoundException fileNotFoundException){
			fileNotFoundException.printStackTrace();
			System.out.println("File Not found");
		}
		catch(IOException ioException){
			ioException.printStackTrace();
		}
		catch (Exception e){
			e.printStackTrace();
			System.out.println("Another error, please edit your file & especially code carefully");
		}
	}



	/**
	 * Import movie ratings from text file and update into each specific movie
	 * @param filename
	 */
	public void importRating(String filename) {
		try{
			FileReader fileReader = new FileReader(new File(filename));
			BufferedReader reader = new BufferedReader(fileReader);
			String eachRating = "";
			String[] splited_rating = null;
			while((eachRating = reader.readLine()) != null) {
				splited_rating = eachRating.split("[\\,]");
				int movieID = Integer.parseInt(splited_rating[0]);
				double rating = Double.parseDouble(splited_rating[1]);
				long timestamp = Long.parseLong(splited_rating[2]);
				Rating eachrating = new Rating(movies.get(movieID), rating, timestamp);
				movies.get(movieID).ratingList.add(eachrating);
			}
		}
		catch(FileNotFoundException fileNotFoundException){
			fileNotFoundException.printStackTrace();
			System.out.println("File Not found");
		}
		catch(IOException ioException){
			ioException.printStackTrace();
		}
		catch (Exception e){
			e.printStackTrace();
			System.out.println("Another error, please edit your file & especially code carefully");
		}

	}

	/**
	 * Exporting movie with the valid format
	 * <mid>,<title>,<tag1>|<tag2>|...|<tagN> and write to the given file
	 * @param filename
	 * @return number of exported movies
	 */
	public int exportMovies(String filename) {
		try{
			FileWriter writer = new FileWriter(new File(filename));
//				int count = 1;s
			for(Movie eachmovie : movies.values()){
				int movieID = eachmovie.getMid();
				String movieTitle = eachmovie.getTitle();
//					System.out.print("#"+count+": "+movieID+">,<"+movieTitle+">,");
				writer.write("<"+movieID+">,<"+movieTitle+">,");
				Set<String> Tags = eachmovie.getTags();
//					System.out.println("Tags: " + Tags);
//					count++;
				StringBuilder alltags = new StringBuilder();
				for(String eachTag : Tags){
					alltags.append("<"+eachTag+">|");
				}
				if(alltags.length() != 0) {
					writer.write(alltags.substring(0,alltags.length()-1));
				}
				writer.write(System.lineSeparator());
			}
			writer.close();
		}catch (FileNotFoundException e){
			System.out.println("This file is invalid");
		}catch (IOException ioException){
			ioException.printStackTrace();
		}finally {
			return movies.size();
		}
	}


	/**
	 * If you want to use this method, you can copy your code from lab 10
	 * @param query
	 * @return
	 */
	public List<Movie> searchMovies(String query) {
		// -------- Using your code from Lab 10 -------------- //
		String queryButLowercase = query.toLowerCase(); //Ex) query = "America" --> america

		List<Movie> movieWithKeyword = new ArrayList<>();
		for(Movie eachMovie : movies.values()) {
			if (eachMovie.title.toLowerCase().contains(queryButLowercase)) {
				movieWithKeyword.add(eachMovie);
			}
		}
		return movieWithKeyword;
	}

	/**
	 * Search movies by the query and the rating
	 * The operator indicate the comparison operator on the rating value
	 * (note. You may reuse the searchMovies method here)
	 * @param query
	 * @param op
	 * @param rating
	 * @return List of movies that satisfied the conditions
	 */
	public List<Movie> searchMoviesWithRating(String query, OPERATOR op, double rating) {

		// YOUR CODE GOES HERE //
		List<Movie> allSearchedMovie = searchMovies(query);
		List<Movie> MovieWithCompleteCompare = new ArrayList<Movie>();
		try {
			switch (op){
				case EQ :
					for(Movie eachMovie: allSearchedMovie){
						if(eachMovie.getAverageRating() == rating){
							MovieWithCompleteCompare.add(eachMovie);
						}
					}
					break;
				case LT :
					for(Movie eachMovie: allSearchedMovie){
						if(eachMovie.getAverageRating() < rating){
							MovieWithCompleteCompare.add(eachMovie);
						}
					}
					break;
				case GT :
					for(Movie eachMovie: allSearchedMovie){
						if(eachMovie.getAverageRating() > rating){
							MovieWithCompleteCompare.add(eachMovie);
						}
					}
					break;
				case LTE :
					for(Movie eachMovie: allSearchedMovie){
						if(eachMovie.getAverageRating() <= rating){
							MovieWithCompleteCompare.add(eachMovie);
						}
					}
					break;
				case GTE :
					for(Movie eachMovie: allSearchedMovie){
						if(eachMovie.getAverageRating() >= rating){
							MovieWithCompleteCompare.add(eachMovie);
						}
					}
					break;
			}
		}catch (MovieException e){
			System.out.println("no_rating");
		}finally {
			return MovieWithCompleteCompare;
		}

	}

	// ********************************************************************************
	// DO NOT MODIFY THIS MAIN METHOD (except to uncomment the bonus part)
	public static void main(String[] args){

		BasicMovieDatabase mdb = new BasicMovieDatabase();
		mdb.importMovies(INIT_PATH + "lab10_movies.txt");
		System.out.println("Done importing "+mdb.movies.size()+" movies");
		int[] mids = new int[]{139747, 141432, 139415, 139620, 141305, 140715, 148626};

		System.out.println("-- before adding ratings --");
		for(int mid: mids) {
			System.out.println("Retrieving movie ID "+mid+": "+mdb.movies.get(mid));
		}

		// Task 1: importing movies rating file and update the movies rating
		System.out.println("-- after adding ratings --");
		mdb.importRating(INIT_PATH + "lab11_ratings.txt");
		for(int mid: mids) {
			System.out.println("Retrieving movie ID "+mid+": "+mdb.movies.get(mid));

		}


		// Task 2: exporting movies into a new file
		System.out.println("-- exporting movies --");

		// add two more movies
		mdb.movies.put(999999, new Movie(999999, "Harry Potter"));
		mdb.movies.put(888888, new Movie(888888, "Up"));
		mdb.movies.get(888888).tags.add("Animation");

		// export movie into the text file
		try {
			File export = new File(INIT_PATH + "lab11_movies.txt");
			Files.deleteIfExists(export.toPath());
		} catch (IOException e) {
			e.printStackTrace();
		}
		int count = mdb.exportMovies(INIT_PATH + "lab11_movies.txt");
		System.out.println("Done exporting " + count + " movies");
		// The file should contains 50 movies


		//Uncomment for bonus

		System.out.println("\n////////////////////////// BONUS ///////////////////////////////");
		double[] ratings = {0.0, 2.5, 4.0};
		String query = "america";

		OPERATOR[] ops = {OPERATOR.EQ, OPERATOR.GT, OPERATOR.GTE};
		for(OPERATOR op: ops) {
			for(int i = 0; i < 3; i++) {
				double rating = ratings[i];
				System.out.println("Results for movies that match: ["+query + "] and have rating " + op.toString() + " " + rating);
				for(Movie m: mdb.searchMoviesWithRating(query, op, rating)) {
					System.out.println("\t"+m);
				}
				System.out.println();
			}
		}

	}

}
