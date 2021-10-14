package utils;

public class Utils {

	public static int generateRandomNumber(int min, int max) {
		return (int)(Math.random() * ((min - max) + 1)) + min;
	}
}
