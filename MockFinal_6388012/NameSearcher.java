import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import org.apache.commons.io.FileUtils;

public abstract class NameSearcher {

	protected static ArrayList<String> readNames = null;
	protected int number_of_compared = 0; 
	
	NameSearcher(String filename)
	{
		try {
			readNames = (ArrayList<String>) FileUtils.readLines(new File(filename), "UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		}

		//clean word
        readNames.replaceAll(name -> name.toLowerCase());  
        	
	}

	public int getNumComparisons() {
		return number_of_compared;
	}

	public void resetCompareCounter() {
		number_of_compared = 0;
	}
	
	/**
	 * This method will be used in the EXTRA TASK
	 */
    public void sortName() {
		for (int i = 0; i < readNames.size() - 1; i++) {
			for (int j = 0; j < readNames.size() - i - 1; j++) {
				if (readNames.get(j).compareTo(readNames.get(j+1)) > 0) {
					String temp = readNames.get(j);
					readNames.set(j,readNames.get(j + 1));
					readNames.set(j+1,temp);
				}
			}
		}
//		System.out.println(readNames);
    }

	public abstract String find(String query);

}


