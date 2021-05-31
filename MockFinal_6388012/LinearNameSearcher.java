

public class LinearNameSearcher extends NameSearcher{
    public LinearNameSearcher(String filename){
        super(filename);
    }

    public String find(String query){
//        sortName();
        String queryLowerCase = query.toLowerCase();
        for(int i = 0 ; i< readNames.size() ; i++){
            ++number_of_compared;
            if(readNames.get(i).equals(queryLowerCase)){
                return "Found"+ " '" + query + "' AT_INDEX(" + i + ")";
            }
        }
        return "Not Found Name: '"+query+"'" ;
    }
}
