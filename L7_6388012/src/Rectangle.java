public class Rectangle extends Shape{
    private double length = 0;
    private double width = 0;

    public Rectangle(){
        this("Magenta",5,5);
    }

    public Rectangle(String color, double length, double width){
        super(color);
        this.length = length;
        this.width = width;
    }
    @Override
    public double getArea() {
        if(this.width > 0 && this.length >0) {
            return length * width;
        }
        return super.getArea();
    }
    public double getArea(double width , double length){
        this.width = width;
        this.length = length;
        return getArea();
    }

    public String toString(){
        if(super.getColor() != null && this.width > 0 && this.length >0){
            return getClass().getSimpleName() +"[length ="+this.length +
                                                ",width ="+this.width +
                                                ","+super.toString()+"]";
        }
        return  super.toString();
    }
}
