import java.util.ArrayList;

public class Member {
    private String email;
    private String password;
    private ArrayList<Video> vdoList;

    public Member(String email, String password){
        this.email = email;
        this.password = password;
        this.vdoList = new ArrayList<Video>();
    }

    public Boolean addVideo(Video vdo){
        if(vdo != null){
            vdoList.add(vdo);
            return true;
        }else return false;
    }

    public Boolean removeVideo(Video vdo){
        for(int i = 0 ; i < vdoList.size(); i++){
            if(vdo.isEqual(vdoList.get(i))){
                Video video = vdoList.remove(i);
                System.out.println(video.toString());
                System.out.println("is successfully removed");
                return true; // tell that this method is successful
            }
        }
        return false;
    }

    public void printMemberInfo() {
        System.out.println("Email: " + email + " (pwd: " + password + ")");
        System.out.println("List of Videos");
        for (int i = 0; i < vdoList.size(); i++) {
            System.out.print("[" + (i+1) + "] ");
            System.out.println(vdoList.get(i).toString());
        }
        System.out.println("---------------------------");
    }
    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
