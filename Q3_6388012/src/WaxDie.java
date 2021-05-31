public class WaxDie extends Cube implements Comparable{
    public WaxDie(String _name, double _edge){
        super(_name,Object3D.Material.Wax,_edge);
    }

    public int compareTo(Object o){
        WaxDie wax = (WaxDie) o;
            if(this.getVolume() == wax.getVolume() && this.getName().compareTo(wax.getName()) == 0) {
                return 0;
            }
            else if (this.getName().compareTo(wax.getName()) > 0){
                return 1;
            }
            else if(this.getName().compareTo(wax.getName()) < 0){
                return -1;
            }
        return -2;
    }
    public Object3D convertToOtherShape(){
        return new Sphere(this.getName(),this.getMaterial(),getVolume());
    }

}
