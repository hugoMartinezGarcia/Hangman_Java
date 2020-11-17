/* Hangman Game
* By Hugo Martinez
*/
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Hangman
{
	public static String checkLetter(char[] wordaux, String word, String letter)
	{
		for (int i = 0; i < word.length(); i++)
		{	
			if (word.charAt(i) == letter.charAt(0))
				wordaux[i] = letter.charAt(0);
		}
		String wordauxstring = String.valueOf(wordaux);
		return wordauxstring;
	}
	
	public static void main(String[] args)
	{
		String word;
		int temps = 1;
		String letter;
		boolean win = false;
		String[] words = {"CASA", "COCHE", "BICICLETA", "MESA", "SILLA", "PERRO", "GATA", "COCINA", "TELEVISOR", "LAMPARA", "LINTERNA", 
			"CAMA", "ORDENADOR", "ANDROID", "JERSEY"};
		
		Scanner sc = new Scanner(System.in);
		
		int aleatoryIndex = ThreadLocalRandom.current().nextInt(0, words.length - 1);
		
		word = words[aleatoryIndex];

		word = word.toUpperCase();

		//Create a array of characters to store the hidden word
		char[] wordaux = new char[word.length()];
		
		for (int i =0; i < word.length(); i++)
		{
			wordaux[i] = '-';
		}
		//Program allow 10 attempts to get the secret word
		do
		{
			//Program ask for a letter until user introduces a valid one
			do
			{
				System.out.printf("Type a letter (attempt %d):", temps);
				letter = sc.nextLine();
				letter = letter.toUpperCase();
				
				if (letter.length() > 1 || letter.matches("[0-9]*"))
					System.out.println ("Invalid letter");
			}
			while (letter.length() > 1 || letter.matches("[0-9]*"));
			
			//Show the discovered letters
			System.out.println(checkLetter(wordaux, word, letter));
			
			//Program finish if the user find all the letters
			if (checkLetter(wordaux, word, letter).equalsIgnoreCase(word))
			{	 win = true;
				System.out.println("\nCongratulations, you are right!");
			}
			temps++;
		}
		while (temps <= 10 && win != true);	
		
		//Program finish if the attempts are finished and show a message
		if (win != true)
		{
			System.out.println("\nYou have finished your attempts!");
			System.out.println("SOLUTION: " + word);
		}		
		System.out.println("End of the program!");

		sc.close();
	}
}
