public class BinaryNameSearcher extends NameSearcher {
    public BinaryNameSearcher(String filename){
        super(filename);
    }

    public String find(String query){
        sortName();
        String queryLowerCase = query.toLowerCase();
        int LowestPosition = 0;
        int HighestPosition = readNames.size() - 1;
        int mid;
        while (LowestPosition <= HighestPosition){
            mid = LowestPosition + ((HighestPosition - LowestPosition) / 2);
            ++number_of_compared;
            if(readNames.get(mid).equals(queryLowerCase)){
                return "Found"+ " '" + queryLowerCase + "' AT_INDEX (" + mid + ")";
            }else if(readNames.get(mid).compareTo(queryLowerCase) < 0){
                LowestPosition = mid + 1;
            }else{
                HighestPosition = mid - 1;
            }
        }
        return "Not Found Name: '"+queryLowerCase+"'" ;
    }
}
