public class ButterBall extends Sphere implements Comparable, Meltable{
    public ButterBall(String _name, double _radius){
        super(_name,Object3D.Material.Butter,_radius);
    }

    public int compareTo(Object o){
        ButterBall wax = (ButterBall) o;
        if(this.getSurface() == wax.getSurface() && this.getName().compareTo(wax.getName()) == 0) {
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
        return new Cube(this.getName(),this.getMaterial(),Math.cbrt(getVolume()));
    }
}
