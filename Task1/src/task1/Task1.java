package task1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Task1 {
	public static void main(String[] args) throws IOException {
		
		FileReader input = null;
		BufferedReader buffInput = null;
		String innerLine = null;
		try {
			input = new FileReader("INPUT.TXT");
			buffInput = new BufferedReader(input);
			innerLine = buffInput.readLine();
		} catch (IOException e) {
			System.out.println("ERROR");
		} finally {
			input.close();
			buffInput.close();
		}

		long max = searchMax(innerLine);

		System.out.println(max);

		FileWriter output = null;
		try {
			output = new FileWriter("OUTPUT.TXT");
			output.write("" + max);
		} catch (IOException e) {
			System.out.println("ERROR");
		} finally {
			output.close();
		}

	}

	public static long searchMax(String innerLine) {
		long max = 0;
		long array[] = new long[innerLine.length()];

		if (innerLine.charAt(0) == '0') {
			array[0] = 1;
			max = 1;
		} else {
			array[0] = 0;
		}

		if (innerLine.length() > 1) {
			for (int i = 1; i < innerLine.length(); ++i) {
				if (innerLine.charAt(i) == '0') {
					array[i] = array[i - 1] + 1;
					if (array[i] > max)
						max = array[i];
				} else {
					array[i] = 0;
				}
			}
		}

		return max;
	}

}
