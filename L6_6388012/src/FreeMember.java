public class FreeMember extends Member {
    private static final int FREE_LIMITED_VDOs = 3;
    private int numDownloadedVDO = 0;

    public FreeMember(String email, String password){
        super(email,password);
    }

    public Boolean addVideo(Video vdo){
        if(numDownloadedVDO >= FREE_LIMITED_VDOs){
            System.out.println(vdo.toString());
            System.out.println("Cannot be downloaded because the number of the video is reaching the limit");
            return super.addVideo(null);
        }else {
            numDownloadedVDO++;
            return super.addVideo(vdo);
        }
    }

    public Boolean removeVideo(Video vdo){
       if(super.removeVideo(vdo)){
           numDownloadedVDO--;
           return true;
       }else return false;
    }

    public void printMemberInfo(){
        System.out.println("---- FREE MEMBER ----");
        super.printMemberInfo();
    }

    public int getNumVideo(){
        return numDownloadedVDO;
    }

}
