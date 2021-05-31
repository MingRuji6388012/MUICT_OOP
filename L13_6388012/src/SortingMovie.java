import java.util.ArrayList;

public class SortingMovie {

    public static void main(String[] args) {
        ArrayList<Movie> movieList = new ArrayList<Movie>();
        movieList.add(new Movie(1, "The Intern", 2009));
        movieList.add(new Movie(2, "The Gift", 2009));
        movieList.add(new Movie(3, "The Lost Room", 2009));
        movieList.add(new Movie(4, "The Gift", 2012));
        movieList.add(new Movie(5, "Pasolini", 2012));
        movieList.add(new Movie(6, "The Intern", 2009));
        movieList.add(new Movie(7, "American Ultra", 2019));
        movieList.add(new Movie(8, "Sweet Red Bean Paste", 2019));

        System.out.println("=== === === BEFORE SORTING === === ===");
        for(int i = 0 ; i < movieList.size() ; i++){
            System.out.println(movieList.get(i).toString());
        }

        sort(movieList);

        System.out.println("\n=== === === AFTER SORTING (BUBBLE SORT) === === ===");
        for(int i = 0 ; i < movieList.size() ; i++){
            System.out.println(movieList.get(i).toString());
        }
    }

    public static void sort (ArrayList<Movie>  movies) {
        for (int i = 0; i < movies.size() - 1; i++) {
            for (int j = 0; j < movies.size() - i - 1; j++) {
                if (movies.get(j).compareTo(movies.get(j+1)) == 1) { // ABC[j]  DEF[j+1]
                    Movie temp = movies.get(j);      // Movie temp = ABC
                    movies.set(j,movies.get(j + 1)); // index j has DEF
                    movies.set(j+1,temp);            // index j+1 had ABC
                }
            }
        }
    }

}
