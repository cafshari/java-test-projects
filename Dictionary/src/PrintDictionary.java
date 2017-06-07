import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class PrintDictionary {

	public static void main(String[] args) throws IOException {

		String filePath = System.getProperty("user.dir") + "\\Dictionary.txt";
		File dictionaryFile = new File(filePath);

		//Read in the file and create a String of its entire text
		BufferedReader br = new BufferedReader(new FileReader(dictionaryFile));
		try {
		    StringBuilder sb = new StringBuilder();
		    String line = br.readLine();

		    while (line != null) {
		        sb.append(line);
		        sb.append(System.lineSeparator());
		        line = br.readLine();
		    }
		    String everything = sb.toString();
		    //System.out.println(everything);
		    
		    //Replace dash and comma separators with line separators, as per the requirement
		    everything = everything.replaceAll(" - ", System.lineSeparator());
		    everything = everything.replaceAll(", ", System.lineSeparator());
		    
		    //Split each line so that we can make each line start with an upper case letter
		    String[] linesArray = everything.split("\r\n|\r|\n");
		    for (String eachline : linesArray) 
		    {
		    	//Get the first letter of the current line and save it's Upper Case version in a new string
		    	String firstLetterUpperCase = eachline.substring(0, 1).toUpperCase();
		    	
		    	//replace the current line with a version of it that starts with an upper case letter
		    	eachline = firstLetterUpperCase + eachline.substring(1, eachline.length());	//index 1 will cut out the pre-existing (possibly lower case) first letter
		        
		    	//Print each line
		    	System.out.println(eachline);
		    }		    
		} finally {
		    br.close();
		}
	}

}
