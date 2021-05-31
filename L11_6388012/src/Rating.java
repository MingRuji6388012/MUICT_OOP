//**************************** DO NOT MODIFY THIS CLASS **********************************//

public class Rating {
	public Movie m = null;
	public double rating = -1;	// rating can be [0, 5]
	public long timestamp = -1;	// timestamp tells you the time this rating was recorded
	
	public Rating(Movie _m, double _rating, long _timestamp) {
		m = _m;
		rating = _rating;
		timestamp = _timestamp;
	}
	
	public String toString() {
		return "[mid: "+m.mid+" rating: "+rating+"/5 timestamp: "+timestamp+"]";
	}

}


//*****************************************************************************//

