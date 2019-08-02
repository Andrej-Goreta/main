package ProgrammingExercise.Mastermind;


import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class MasterMind {
	
	
	public static void main(String[] args) { 
		
		
	
		
		String answer = "";
		int counter = 0;
		String indicator = "";
		String plus = "+";
		String minus = "-";
		
		
		
		int firstDigit = ThreadLocalRandom.current().nextInt(1, 6);
		String firstDigitStr = Integer.toString(firstDigit);
		answer += firstDigitStr;
		
		int secondDigit = ThreadLocalRandom.current().nextInt(1, 6);
		String secondDigitStr = Integer.toString(secondDigit);
		answer += secondDigitStr;
		
		int thirdDigit = ThreadLocalRandom.current().nextInt(1, 6);
		String thirdDigitStr = Integer.toString(thirdDigit);
		answer += thirdDigitStr;
		
		int fourthDigit = ThreadLocalRandom.current().nextInt(1, 6);
		String fourthDigitStr = Integer.toString(fourthDigit);
		answer += fourthDigitStr;
		
		
		
		System.out.println("Welcome to a beautiful game of Mastermind! Can you guess the 4 digit number? Give it a shot.");
		System.out.println("'Couple hints: each digit is between 1 to 6, 4 digit length, and no space inbetween numbers." + "\n" + 
							" Also, (+) means correct number and position, (-) means correct number, but wrong position," + "\n" +
							" and a space means incorrect number. Numbers can be repeated and if the same number has a " + "\n" +
							" (+) or (-) then that only indicates that the one with the (+) is the only number in the answer sequence.'");
		
		System.out.println("-------------------" + "\n");
		
		@SuppressWarnings("resource")
		Scanner userInput = new Scanner(System.in);
		for(int k = 1; k <= 10; k++) {
			counter += 1;
		System.out.print("Enter Combination:");
		String keyboard = userInput.nextLine();
			if(keyboard.length() < 4 || keyboard.length() > 4) {
				System.out.println("Re-enter guess. Needs to be 4 digits only" + "\n");
				counter -= 1;
				k -= 1;
				
			}
			else {
		
			
			for(int i = 0; i < keyboard.length(); i++) {
				if(keyboard.charAt(i) == answer.charAt(i)) {
					indicator += plus;
				}
				else if((i == 0) && ((keyboard.charAt(i) == answer.charAt(i+1))|| 
						(keyboard.charAt(i) == answer.charAt(i+2))||
						(keyboard.charAt(i) == answer.charAt(i+3)))){
						
						indicator += minus;
				}
				else if((i == 1) && ((keyboard.charAt(i) == answer.charAt(i+1))|| 
						(keyboard.charAt(i) == answer.charAt(i+2))||
						(keyboard.charAt(i) == answer.charAt(i-1)))){
						
						indicator += minus;
				}
				else if((i == 2) && ((keyboard.charAt(i) == answer.charAt(i+1))|| 
						(keyboard.charAt(i) == answer.charAt(i-1)) ||
						(keyboard.charAt(i) == answer.charAt(i-2)))){
						
						indicator += minus;
				}
				else if((i == 3) && ((keyboard.charAt(i) == answer.charAt(i-1))|| 
						(keyboard.charAt(i) == answer.charAt(i-2)) ||
						(keyboard.charAt(i) == answer.charAt(i-3)))){
						
						indicator += minus;
				}
				else {
					indicator += " ";
				}
				
			}
			
			if(indicator.contentEquals("++++")) {
				System.out.println("\n" + "Congratulations! You guessed the right sequence of numbers. Gold Star for you! Thank you for playing Mastermind. Have a wonderful day");
				System.out.println(answer + " (Answer)");
				System.out.println(keyboard + " (Your Guess)");
				System.exit(0);
			}else {
				System.out.println("\n" + "Try again. You have " + (10 - counter) + " trys left" + "\n");
				System.out.println(keyboard);
				System.out.println(indicator);
				indicator = "";
				System.out.println("-------------------" + "\n");
			}
			
			
		
			}
		}
		System.out.println("Run out of trys. Sorry, you lose but better luck next time! Thank you for playing Mastermind and have a wonderful day.");
	
	
	
	
	}	

}
