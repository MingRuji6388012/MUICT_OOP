public class Sphere extends Object3D{
    private double radius;
    public Sphere(String _name, Material _matType, double _radius)
    {
        super(_name,_matType);
        radius = _radius;
    }

    public double getRadius(){
        return radius;
    }
    public double getVolume(){
        return (double)4/3 * PI *Math.pow(radius,3);
    }
    public double getSurface(){
        return 4 * PI *Math.pow(radius,2);
    }
}
