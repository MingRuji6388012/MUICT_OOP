public class Movie implements Comparable<Movie> {
	public int mid = -1;
	public String title = null;
	public int year = -1;
	
	public Movie(int _mid, String _title, int _year)
	{
		mid = _mid;
		title = _title;
		year = _year;
	}
	
	
	public String toString()
	{
		return "[mid:"+mid+" |"+title+" |"+year+"]";
	}
	
	
	public int compareTo(Movie m) {
		// YOUR CODE GOES HERE
		return -1;
	}
}