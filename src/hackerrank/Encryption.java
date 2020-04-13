package hackerrank;
import java.io.IOException;

public class Encryption {

	// Complete the encryption function below.
	static String encryption(String s) {
		StringBuilder sb = new StringBuilder();

		// Number of spaces will be one less than number of words in the sentence.
		int numSpaces = s.split(" ").length - 1;
		int finalLength = s.length() - numSpaces;
		// Floor
		int rows = (int) Math.floor((Math.sqrt(finalLength)));
		// Ceil
		int columns = (int) Math.ceil(Math.sqrt(finalLength));

		if (rows*columns < finalLength) {
			rows++;
		}
		
		char[][] encodeMsg = new char[rows][columns];

		int index = 0, currRow = 0, currCol = 0;
		while (index != s.length()) {
			char c = s.charAt(index++);

			if (c == ' ') {
				continue;
			}

			encodeMsg[currRow][currCol++] = c;

			currRow = currCol != columns ? currRow : ++currRow;
			currCol %= columns;
		}

		for (int column = 0; column < columns; column++) {
			for (int row = 0; row < rows; row++) {
				if(encodeMsg[row][column] != '\0'){
					sb.append(encodeMsg[row][column]);
                }
			}
			if (column != columns -1) {
				sb.append(" ");
			}
		}

	return sb.toString();

	}

	public static void main(String[] args) throws IOException {

//		System.out.println(encryption("haveaniceday"));
//		System.out.println(encryption("if man was meant to stay on the ground god would have given us roots"));
//		System.out.println(encryption("feedthedog"));
//		System.out.println(encryption("chillout"));
		System.out.println(encryption("iffactsdontfittotheorychangethefacts"));
	}
}
