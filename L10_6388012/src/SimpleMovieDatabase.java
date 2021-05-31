import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SimpleMovieDatabase {
    public Map<Integer, Movie> movies = new HashMap<Integer,Movie>();

    public void importMovies(String movieFilename)
    {
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
                Pattern moviePattern = Pattern.compile(("([\\d]+)([,]+)([\\w]+[\\w\\W]+)([,]+)([\\S]+)"));  //("[\\d]+[,]+[\\w]+[^,]+[\\S]");
                Matcher messageGrouping =  moviePattern.matcher(eachMovie);
                if(messageGrouping.matches()){
//                    System.out.println( count+": "+messageGrouping.group(1) +
//                                       " ||Movie name: "+ messageGrouping.group(3) +
//                                       " ||tag: "+ messageGrouping.group(5));
                    movieID = Integer.parseInt(messageGrouping.group(1));
                    movieTitle = messageGrouping.group(3);
                    Movie movie = new Movie(movieID,movieTitle);
                    allTags = messageGrouping.group(5).split("[\\|]");
                    for(String eachTag : allTags){
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


    //-------------------BONUS----------------------
    public List<Movie> searchMovies(String query)
    {
        String queryButUppercase = query.substring(0, 1).toUpperCase() + query.substring(1); //Ex) query = "america" -->

        List<Movie> movieWithKeyword = new ArrayList<>();
        for(Movie eachMovie : movies.values()) {
            if (eachMovie.title.contains(queryButUppercase)) {
                movieWithKeyword.add(eachMovie);
            }
        }
        return movieWithKeyword;
    }
    public List<Movie> getMoviesByTag(String tag)
    {
        List<Movie> movieWithKeyword = new ArrayList<>();
        for(Movie eachMovie : movies.values()) {
            if (eachMovie.tags.contains(tag)) {
                movieWithKeyword.add(eachMovie);
            }
        }
        return movieWithKeyword;
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();

//        SimpleMovieDatabase mdb = new SimpleMovieDatabase();
//        mdb.importMovies("C:\\Users\\Chaiyakorn\\Desktop\\Java Workspace\\L10_6388012\\.idea\\lab10_movies.txt");
//        System.out.println("Done importing "+mdb.movies.size()+" movies");
//        int[] mids = new int[]{139747, 141432, 139415, 139620, 141305};
//        for(int mid: mids)
//        {
//            System.out.println("Retrieving movie ID "+mid+": "+mdb.movies.get(mid));
//        }
//
//
//		System.out.println("\n////////////////////////// BONUS ///////////////////////////////");
//		String[] queries = new String[]{"america", "thai", "thailand"};
//		for(String query: queries)
//		{
//			System.out.println("Results for movies that match: "+query);
//			for(Movie m: mdb.searchMovies(query))
//			{
//				System.out.println("\t"+m);
//			}
//			System.out.println();
//		}
//
//		String[] tags = new String[]{"Musical", "Action", "Thriller"};
//		for(String tag: tags)
//		{
//			System.out.println("Results for movies in category: "+tag);
//			for(Movie m: mdb.getMoviesByTag(tag))
//			{
//				System.out.println("\t"+m);
//			}
//			System.out.println();
//		}

    }

}
