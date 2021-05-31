public class Point extends Object{
    private int x;
    private int y;
    public Point(){
        this(0,0);
    }
    public Point(int Xcor, int Ycor){
        x = Xcor;
        y = Ycor;
    }
    //Overriding
    public String toString(){
        return "X coordinate: "+ x + ",Y coordinate:"+ y;
    }
}
