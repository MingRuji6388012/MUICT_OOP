public class CovidProfile {
    private String date;
    private String location;
    private int accumulatedCases; // Recent = Accumulate - cured - death
    private int curedCases;
    private int deathCases;
    static int frequency;
    public CovidProfile() {
        this("2563-02-05","RUSSIA",3874830,3352720,74005);
    }

    public CovidProfile(String _date, String loc, int noACC, int noCured, int noDeath) {
        setDate(_date);
        setLocation(loc);
        setAccumulatedCases(noACC);
        setCuredCases(noCured);
        setDeathCases(noDeath);
        frequency++;
    }

    public static int getFrequency() {
        return frequency;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setAccumulatedCases(int accumulatedCases) {
        this.accumulatedCases = accumulatedCases;
    }

    public void setCuredCases(int curedCases) {
        this.curedCases = curedCases;
    }

    public void setDeathCases(int deathCases) {
        this.deathCases = deathCases;
    }

    public String getDate() {
        return date;
    }

    public String getLocation() {
        return location;
    }

    public int getAccumulatedCases() {
        return accumulatedCases;
    }

    public int getCuredCases() {
        return curedCases;
    }

    public int getDeathCases() {
        return deathCases;
    }

    public void printCovidInfo(){
        System.out.println(this.location + " at " + this.date);
        System.out.println("Accumulative Patient: "+ this.accumulatedCases);
        System.out.println("Cured Patient: "+ this.curedCases);
        System.out.println("Death Case: "+ this.deathCases);
    }

    public boolean isSevere(){
        if(this.deathCases > 10000)
            return true;
        else return false;
    }

    public void printRecentCase(){
        System.out.println("Recent Case : "+ (accumulatedCases-curedCases-deathCases));
    }


}
