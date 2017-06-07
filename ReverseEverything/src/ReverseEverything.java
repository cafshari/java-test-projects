
public class ReverseEverything {

	public static void main(String[] args) {

		String message = "hope you are doing well";
		System.out.println("Before reverse: " + message);
		
		message = reverseEverything(message);

		System.out.println("After reverse: " + message);

	}

	/**
	 * @author Cyrus
	 * @param s - the string to reverse
	 */
	public static String reverseEverything(String s)
	{

		String reversedString = "";

		/* Works, uses StringBuilder class:
		reversedString = new StringBuilder(s).reverse().toString();
		return reversedString;
		*/
		
		char[] toBeReversed = s.toCharArray();
		char[] reversedArray = new char[toBeReversed.length];
		
		int counter = 0;
		for(int i=toBeReversed.length-1; i>=0; i--)
		{
			reversedArray[counter] = toBeReversed[i];
			counter++;
		}		
		
		reversedString = java.lang.String.valueOf(reversedArray);
		return reversedString;
	}
}
