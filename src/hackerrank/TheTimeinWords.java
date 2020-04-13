package hackerrank;
import java.io.IOException;

public class TheTimeinWords {

	// Complete the timeInWords function below.
	static String timeInWords(int h, int m) {
		StringBuilder outputStr = new StringBuilder();
		String oClock = "o' clock";
		String past = "past";
		String to = "to";
		String space = " ";

		if (m == 0) {
			outputStr.append(getNumbersToWords(h)).append(space).append(oClock);
		} else if (m > 30) {
			m = 60 - m;
			h += 1;

			String minStr = getNumbersToWords(m);

			outputStr.append(minStr).append(space).append(minStr.equals("quarter") ? to : getMinutes(m) + space + to)
					.append(space).append(getNumbersToWords(h));
		} else if (m < 30) {
			String minStr = getNumbersToWords(m);

			outputStr.append(minStr).append(space)
					.append(minStr.equals("quarter") ? past : getMinutes(m) + space + past).append(space)
					.append(getNumbersToWords(h));
		} else {
			outputStr.append("half past ").append(getNumbersToWords(h));
		}

		return outputStr.toString();
	}

	private static String getMinutes(int n) {
		if (n == 1) {
			return "minute";
		}

		return "minutes";
	}

	private static String getNumbersToWords(int num) {
		if (num <= 10) {
			return getOneToTenInWords(num);
		} else if (num >= 20) {
			return getMoreThanTwentyinWords(num / 10) + (num % 10 != 0 ? " " + getOneToTenInWords(num % 10) : "");
		} else {
			return getTenToTwentyInWords(num);
		}
	}

	private static String getOneToTenInWords(int h) {
		switch (h) {
		case 1:
			return "one";
		case 2:
			return "two";
		case 3:
			return "three";
		case 4:
			return "four";
		case 5:
			return "five";
		case 6:
			return "six";
		case 7:
			return "seven";
		case 8:
			return "eight";
		case 9:
			return "nine";
		case 10:
			return "ten";
		default:
			return "Error";
		}
	}

	private static String getTenToTwentyInWords(int tens) {
		switch (tens) {
		case 11:
			return "eleven";
		case 12:
			return "twelve";
		case 13:
			return "thirteen";
		case 14:
			return "forteen";
		case 15:
			return "quarter";
		case 16:
			return "sixteen";
		case 17:
			return "seventeen";
		case 18:
			return "eighteen";
		case 19:
			return "nineteen";
		default:
			return "Error";
		}
	}

	private static String getMoreThanTwentyinWords(int t) {
		switch (t) {
		case 2:
			return "twenty";
		case 3:
			return "thirty";
		default:
			return "Error";
		}
	}

	public static void main(String[] args) throws IOException {

		System.out.println(timeInWords(5, 00));
		System.out.println(timeInWords(5, 01));
		System.out.println(timeInWords(5, 10));
		System.out.println(timeInWords(5, 15));
		System.out.println(timeInWords(5, 30));
		System.out.println(timeInWords(5, 40));
		System.out.println(timeInWords(5, 45));
		System.out.println(timeInWords(5, 47));
		System.out.println(timeInWords(5, 28));
	}
}
