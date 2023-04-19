import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;

public class Journal9_Decryptograph
{
	public static void main(String[] args) throws IOException
	{
		Decryptograph a = new Decryptograph();

		//variables and arrays
		//nch = number for character
		//sch = shifted character
		//ch = character (default use)
		//var = variable (default use)
		int shiftKey, var = 0, nch = 0;
		char ch = 'a', sch = 'a', err1 = ' ', err2 = ' ', cont = ' ';
		String decMes = "", encMes = " ", cipher, shift, error = "", history = "";

		Scanner keyBd = new Scanner(System.in);

		do
		{
			//user input
			System.out.print("Decryption or Encryption?: ");
			cipher = keyBd.nextLine();

			System.out.print("Input your message: ");
			encMes = keyBd.nextLine();

			System.out.print("Input your shift key: ");
			shiftKey = keyBd.nextInt();

			keyBd.nextLine();

			System.out.print("Is the shift to the left or right?: ");
			shift = keyBd.nextLine();

			//reading the characters from the encrypted message String to make the length of the array
			char[] encCharArr = encMes.toCharArray();

			//printing/reading chars of encryptMes String
			for(var = 0; var < encCharArr.length; var++)
			{
				ch = encMes.charAt(var);	//reads each char from String
				encCharArr[var] = ch;			//puts chars into array
				//System.out.print(encCharArr[var]); -- test for verification
			}

			System.out.println();

			//turns characters to numbers
			for(var = 0; var < encCharArr.length; var++)
			{
				ch = encCharArr[var];

				if((shift.equalsIgnoreCase("left") && cipher.equalsIgnoreCase("encryption")) || (shift.equalsIgnoreCase("right") && cipher.equalsIgnoreCase("decryption")))
				{
					decMes = decMes + (a.cipher_EnL_DeR(ch, shiftKey));
				}

				else if((shift.equalsIgnoreCase("left") && cipher.equalsIgnoreCase("decryption")) || (shift.equalsIgnoreCase("right") && cipher.equalsIgnoreCase("encryption")))
				{
					decMes = decMes + (a.cipher_EnR_DeL(ch, shiftKey));
				}
			}

			//making history
			history = decMes + "\n" + history;

			//printing out message
			System.out.println(decMes + "\n");

			System.out.print("Do you want to convert another message?(y or n): ");
			cont = keyBd.next().charAt(0);

			keyBd.nextLine();
			encMes = "";
			decMes = "";
		}while(cont == 'y');

		System.out.println("\nHistory: \n" + history);
	}
}


//unused code/failed attempts

	//writing file to read encrypted messages
		/*//FileWriter file1 = new FileWriter("Encrypted_Message.txt");
		PrintWriter outputFile = new PrintWriter("Encrypted_Message.txt");
		/*File file2 = new File("Encrypted_Message.txt");
		Scanner inputFile = new Scanner(file2);

		outputFile.println(encryptMes);
		outputFile.close();

		File file = new File("Encrypted_Message.txt");
		Scanner inputFile = new Scanner(file);*/

	//from while loop for reading chars from file
		/*
		inputFile.useDelimiter("");

		char cha = inputFile.next().charAt(var);
		System.out.print(cha + " ");
		var++;*/

	//testing
	//getter
		//System.out.print(a.getLetter(10));

	//Attempt to understand/scan characters in a string
		/*Scanner mes = new Scanner(encryptMes);
		mes.useDelimiter("");*/

	//Making length for array
	//didn't work because cannot convert string to char
		/*charNum = encryptMes.length;
		char[] encryptChar = new char[charNum];*/

	//original itteration loop for decryption class/method
		/*for(var = 0; var < encryptChar.length; var++)
		{
			encryptChar[var] = ch;
			System.out.print(a.decrypt(ch, shiftKey, shift, mesLength));
		}*/

	//utilising ascii to shift characters
	//failed because ascii doesn't just use the alphabet
		/*ch = encryptChar[var];
		nch = a.charToNum(ch, encryptChar.length);
		sch = (char) (ch + nch);

		System.out.print(nch + " ");
		System.out.print(sch + " ");*/

	//from turning chars to numbers
		/*nch = a.charToNum(ch, encryptChar.length);
		sch = (char) (ch + 5);*/

		//System.out.print(a.charToNum(ch));
		//nch = a.charToNum(ch) - shiftKey;

		//System.out.print(nch);

	//encryption/decrytion method
	//put into Decryptograph.class
		/*ch = encCharArr[var];

		//case for ' ' since they count as characters
		if((a.charToNum(ch) - shiftKey) >= 52)
		{
			System.out.print(ch);
		}

		//case for int nch when out of bounds (positive)
		else if((a.charToNum(ch) - shiftKey) > 25)
		{
			nch = (a.charToNum(ch) - shiftKey) - 25;
			System.out.print((a.numToChar(nch)));
		}

		//case for int nch when out of bounds (negative)
		else if((a.charToNum(ch) - shiftKey) < 0)
		{
			nch = (a.charToNum(ch) - shiftKey) + 25;
			System.out.print((a.numToChar(nch)));
		}

		//default
		else
		{
			nch = a.charToNum(ch) - shiftKey;
			System.out.print((a.numToChar(nch)));
		}*/


		//making history
		//it didn't repeat for some reason
		//kill me
			/*FileWriter myFile = new FileWriter("History.txt");
			PrintWriter outputFile = new PrintWriter(myFile);

			outputFile.printf("%S %n", cipher);
			outputFile.println("Message: " + encMes);
			outputFile.println("Shift Key: " + shiftKey);
			outputFile.println("Shift Direction: " + shift);
			outputFile.println("New Message: " + decMes);
			outputFile.println("----------------");
			outputFile.close();*/

			/*FileWriter myFile1 = new FileWriter("History.txt");
			PrintWriter outputFile1 = new PrintWriter(myFile1);
			Scanner keyBd = new Scanner(System.in);

			outputFile1.println("---HISTORY---");
			outputFile1.close();*/