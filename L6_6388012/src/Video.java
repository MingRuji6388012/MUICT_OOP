public class Video{
    private String title;
    private String url;
    public Video(String aTitle, String aURL){
        title = aTitle;
        url = aURL;
    }
    /*
     * Return the title of this video
     */
    public String getTitle(){
        return this.title;
    }
    /*
     * Return the url of this video
     */
    public String getURL(){
        return this.url;
    }

    /*
     * Check whether the given video is equal to this video or not.
     * Two videos will be equal if their title are the same and their url are the same as well.
     */
    public boolean isEqual(Video vdo){
        return (this.title.equals(vdo.getTitle()) && this.url == vdo.getURL());
    }

    /*
     * Return a string with video's name and url.
     */
    public String toString(){
        return "Title: " + this.title +  " URL: "+this.url;
    }
}
