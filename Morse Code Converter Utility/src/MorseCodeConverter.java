import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * MorseCodeConverter
 * 
 * @author Zhiming Lin
 *
 */
public class MorseCodeConverter {
	private static MorseCodeTree tree = new MorseCodeTree();

	/**
	 * Constructor
	 */
	MorseCodeConverter() {
	}

	/**
	 * returns a string with all the data in the tree in LNR order with an space in
	 * between them.
	 * 
	 * @return the data in the tree in LNR order separated by a space.
	 */
	public static String printTree() {
		String code = "";
		ArrayList<String> list = tree.toArrayList();
		for (String s : list) {
			code += s + " ";
		}
		return code;
	}

	/**
	 * Converts Morse code into English. Each letter is delimited by a space (กฎ กฎ).
	 * Each word is delimited by a กฎ/กฏ.
	 * 
	 * @param code - the morse code
	 * @return the English translation
	 */
	public static String convertToEnglish(String code) {
		String[] words = code.split("/");
		String letter = "";
		int n = 0;
		for (String word : words) {
			// System.out.println(word);
			String[] alph = word.strip().split(" ");
			for (String a : alph) {
				// System.out.println(a);
				letter += tree.fetch(a);
			}
			n++;
			if (n < words.length) {
				letter += " ";
			}
		}
		return letter;
	}

	/**
	 * Converts a file of Morse code into English Each letter is delimited by a
	 * space (กฎ กฎ). Each word is delimited by a กฎ/กฏ.
	 * 
	 * @param input - name of the File that contains Morse Code
	 * @return the English translation of the file
	 * @throws FileNotFoundException
	 */
	public static String convertToEnglish(File input) throws FileNotFoundException {
		Scanner file = new Scanner(input);
		String code = "";
		while (file.hasNext()) {
			code += file.next() + " ";
		}
//		while (file.hasNextLine()) {
//			code += file.nextLine() + "\n";
//			System.out.println(code);
//		}

//		while (file.hasNextLine()) {
//			code = file.nextLine();
//			letter += convertToEnglish(code) + "\n";
//		}
		String letter = convertToEnglish(code);
		file.close();
		return letter;
	}
}
