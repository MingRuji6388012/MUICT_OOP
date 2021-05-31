import java.util.ArrayList;
import java.util.List;

public class SpeakingRobot extends Robot{
    public SpeakingRobot(String _name, int _x, int _y, char _direction) {
        super(_name,_x,_y);
    }

    public SpeakingRobot(String _name, char _direction) {
        super(_name);
    }

    public void greeting(List<Robot> robots){
        ArrayList<Robot> sameLocationRobot = new ArrayList<Robot>();
        for(int i = 0 ; i < robots.size() ; i++){
            if(this.getLocX() == robots.get(i).getLocX() && this.getLocY() == robots.get(i).getLocY()){
                sameLocationRobot.add(robots.get(i));
            }
        }
        System.out.println("Hi "+sameLocationRobot+", I'm "+this.getName+". Nice to meet you");
    }
}
