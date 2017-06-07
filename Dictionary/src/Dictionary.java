import java.io.File;

public class Dictionary {

	public static void main(String[] args) {

		//check if file exists
		String filePath = System.getProperty("user.dir") + "\\Dictionary.txt";
		doesFileExist(filePath);
	}

	/**
	 * @author Cyrus
	 * @param path - path of the file to check if the file exists at that path
	 * @return boolean - true, if the file exists at that path; otherwise, false
	 */
	public static boolean doesFileExist(String path)
	{
		File f = new File(path);
		
		try
		{
			//Use java.io.File.exists() to determine whether the file exists at the provided path
			if(f.exists() ) 
			{ 
			    //File does exist at the provided path, return true
				System.out.println("File exists at specified path.");
				return true;
			}
			else	//File doesn't exist at the provided path
				throw new Exception("File does not exist at path: " + path);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
}
