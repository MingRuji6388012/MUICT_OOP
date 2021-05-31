public class CovidProfile {
    private String date; //"10-02-59"
    private String location;
    private int accumulatedCases;
    private int curedCases;
    private int deathCases;
    static int num;

    public CovidProfile(){
        this( "none", "none", 0, 0, 0);
    }
    public CovidProfile(String _date, String loc, int noACC, int noCured, int noDeath){
        setDate(_date);
        setLocation(loc);
        setAccumulatedCases(noACC);
        setCuredCases(noCured);
        setDeathCases(noDeath);
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
        System.out.println("Death Case: "+this.deathCases);
        // THAILAND at 2021-01-29
        // Accumulative Patient: 17023
        // Cured Patient: 11396
        // Death Case: 76
    }

}

