
abstract class Shape implements Comparable{
    static double PI = 3.14;
    private String color;
    private String description;

    abstract public double getArea(); // implement abstract method
    public Shape(String color, String description){
        this.color = color;
        this.description = description;
    }

    public void setColor(String color){
        this.color = color;
    }

    public String getColor(){
        return color;
    }

    public String toString(){
        return description + " (color="+this.color+", area="+ getArea() +")";
    }

    public int compareTo(Object comparedShape){
        Shape shapeBrah = (Shape) comparedShape; //เชฟบร้ะ
        System.out.println("Given shape area is: "+ shapeBrah.getArea() + " and this shape area is: "+ this.getArea());
        if(this.getArea() > shapeBrah.getArea()){
            return 1;
        }else if(this.getArea() < shapeBrah.getArea()){
            return -1;
        }else if(this.getArea() == shapeBrah.getArea()){
            return 0;
        }
        return -2;
    } 

}
