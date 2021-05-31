public class CovidReporter {
    public static void main(String[] args){
        CovidProfile COVID1 = new CovidProfile(); //Object 1
        COVID1.printCovidInfo();
        COVID1.num = 1;
        System.out.println(COVID1.num);
        System.out.println();
        CovidProfile COVID2 = new CovidProfile("2021-02-04","UNITED KINGDOM",3882972,9936	,109547); //Object 2
        COVID2.printCovidInfo();
        COVID2.num = 2;
        System.out.println(COVID2.num);
        System.out.println();
        COVID1.printCovidInfo();
    }
}
