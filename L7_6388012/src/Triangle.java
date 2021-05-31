public class Triangle extends Shape{
    private double base = 0;
    private double height = 0;
    public Triangle(){
        this("Magenta",5,5);
    }

    public Triangle(String color, double base, double height){
        super(color);
        this.base = base;
        this.height = height;
    }
    @Override
    public double getArea() {
        if(this.base > 0 && this.height >0) {
            return ((double)1/2) *base * height;
        }
        return super.getArea();
    }
    public double getArea(double base , double height){
        this.base = base;
        this.height = height;
        return getArea();
    }

    public String toString(){
        if(super.getColor() != null && this.base > 0 && this.height >0){
            return getClass().getSimpleName() +"[base ="+this.base +
                    ",height ="+this.height +
                    ","+super.toString()+"]";
        }
        return  super.toString();
    }
}
