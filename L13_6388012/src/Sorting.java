import java.io.*;
import java.util.ArrayList;

public class Sorting {
    static final String filename = "C:\\Users\\Chaiyakorn\\Desktop\\MUICT_OOP\\L13_6388012\\unsorted.txt";
    static ArrayList<String> somethingList = new ArrayList<>();
    static ArrayList<String> unsortedForBubble = new ArrayList<>();
    static ArrayList<String> unsortedForInsertion = new ArrayList<>();


    public static void main(String[] args) {
        //Read file first
        System.out.println(" === === === Before sorting === === === ");
        System.out.println(readFile(filename));

        //Sort the String
        System.out.println("\n === === === After sorting (BUBBLE SORT) === === === ");
        System.out.println("Original: "+ somethingList);
        sortStringBubbleSort(unsortedForBubble);

        System.out.println("\n === === === After sorting (INSERTION SORT) === === === ");
        System.out.println("Original: "+ somethingList);
        sortStringInsertion(unsortedForInsertion);
    }

    public static ArrayList<String> readFile(String filename){
        try{
            File file = new File(filename);
            FileReader fileReader = new FileReader(file);
            BufferedReader reader = new BufferedReader(fileReader);
            String eachLine = "";
            String[] eachItem;
            while((eachLine = reader.readLine()) != null) {
               eachItem = eachLine.split("[\\s]");
               //eachItem[] = [[ink],[steak],[...],[...],...,[wood]
               for(int i = 0 ; i < eachItem.length ; i++){
                   somethingList.add(eachItem[i]);
                   unsortedForBubble.add(eachItem[i]);
                   unsortedForInsertion.add(eachItem[i]);
               }
            }
        }
        catch(FileNotFoundException fileNotFoundException){
            fileNotFoundException.printStackTrace();
            System.out.println("File Not found");
        }
        catch(IOException ioException){
            ioException.printStackTrace();
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println("Another error, please edit your file & especially code carefully");
        }
        return somethingList;
    }

    public static void sortStringBubbleSort(ArrayList<String> someList) {
        int count = 0;
        for (int i = 0; i < someList.size() - 1; i++) {
            for (int j = 0; j < someList.size() - i - 1; j++) {
                if (someList.get(j).compareTo(someList.get(j+1)) > 0) {
//                  someList.get(j).compareTo(someList.get(j+1)) > 0 -> If String at index j alphabetically more than at index j+1
                    String temp = someList.get(j);
                    someList.set(j,someList.get(j + 1));
                    someList.set(j+1,temp);
                }
            }
            printList(++count, someList); //print list
        }
    }

    public static void sortStringInsertion(ArrayList<String> someList) {
        int count = 0;
        for (int i = 1; i < someList.size(); ++i) {
            String key = someList.get(i);
            int j = i - 1;
            while (j >= 0 && someList.get(j).compareTo(key)<0) {
                someList.set(j+1,someList.get(j));
                j = j - 1;
            }
            someList.set(j+1,key);
            printList(++count , someList);
        }
    }

    public static void printList(int count, ArrayList someList){
        System.out.println("Pass "+ count + ": " + someList);
    }
}
