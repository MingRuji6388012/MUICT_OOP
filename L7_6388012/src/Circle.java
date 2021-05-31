public class Circle extends Shape{
    private static final double PI = Math.PI;
    private double radius = 0;
    public Circle(){
        this("Magenta",5);
    }
    public Circle(String color, double radius){
        super(color);
        this.radius = radius;
    }
    @Override
    public double getArea() {
        if(this.radius > 0) {
            return Math.round(PI * Math.pow(radius,2));
        }
        return super.getArea();
    }
    public double getArea(double radius){
        this.radius = radius;
        return getArea();
    }

    public String toString(){
        if(super.getColor() != null &&  this.radius >0){
            return getClass().getSimpleName() +"[radius ="+this.radius +
                    ","+super.toString()+"]";
        }
        return  super.toString();
    }

}
