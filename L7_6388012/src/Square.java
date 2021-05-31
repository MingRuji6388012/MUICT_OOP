public class Square extends Shape {
        private double length = 0;
        public Square(){
            this("Magenta",5);
        }
        public Square(String color, double length){
            super(color);
            this.length = length;
        }
        @Override
        public double getArea() {
            if(this.length > 0) {
                return length * length;
            }
            return super.getArea();
        }
        public double getArea(double length){
            this.length = length;
            return getArea();
        }

        public String toString(){
            if(super.getColor() != null &&  this.length >0){
                return getClass().getSimpleName() +"[length ="+this.length +
                        ","+super.toString()+"]";
            }
            return  super.toString();
        }


}
