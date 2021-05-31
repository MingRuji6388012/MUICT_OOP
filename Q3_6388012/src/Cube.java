public class Cube extends Object3D{
    private double edge;
    public Cube(String _name, Material _matType, double _edge)
    {
        super(_name,_matType);
        edge = _edge;
    }

    public double getEdge(){
        return edge;
    }

    public double getVolume(){
        return Math.pow(edge,3);
    }
    public double getSurface(){
        return 6 * Math.pow(edge,2);
    }
}
