


import java.util.Random;

public class PasswordGenerator {

	private static PasswordGenerator instance;

	public static PasswordGenerator getInstance() {
		if(instance == null) {
			instance = new PasswordGenerator();			
		}
		return instance;			
	}
	/**
	 * Password generator - creates a random password with each type of char :
	 * 
	 * @param integer
	 * @param lowerCase
	 * @param upperCase
	 * @param symbol
	 */
	public String generateRandom() {

		int length = 16;
		int intNum = 0;
		int lowerCaseNum = 0;
		int upperCaseNum = 0;
		int symbolNum = 0;

		while (intNum + lowerCaseNum + upperCaseNum + symbolNum != length) {
			intNum = (int) (Math.random() * 16 + 1); // 1
			symbolNum = (int) (Math.random() * 16 + 1); // 2
			lowerCaseNum = (int) (Math.random() * 16 + 1); // 3
			upperCaseNum = (int) (Math.random() * 16 + 1); // 4
		}

		Random rnd = new Random();
		String generatedPassword = "";

		while (generatedPassword.length() != length) {
			int x = (int) (Math.random() * 5);
			if (x == 1 && intNum != 0) {
				generatedPassword += (int) (Math.random() * 10);
				intNum--;
				continue;
			} else if (x == 2 && symbolNum != 0) {
				generatedPassword += (char) (rnd.nextInt(14) + '!');
				symbolNum--;
				continue;
			} else if (x == 3 && lowerCaseNum != 0) {
				generatedPassword += (char) (rnd.nextInt(26) + 'a');
				lowerCaseNum--;
				continue;
			} else if (x == 4 && upperCaseNum != 0) {
				generatedPassword += (char) (rnd.nextInt(26) + 'A');
				upperCaseNum--;
				continue;
			}
		}
		return generatedPassword;
	}
}
