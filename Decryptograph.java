public class Decryptograph
{
	//array for letters
	char[] letters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

	//turns numbers to characters
	public char numToChar(int i)
	{
		char letter = letters[i];
		return letter;
	}

	//turns characters to numbers
	//couldn't figure out a more efficient way to execute this
	public int charToNum(char encryptChar)
	{
		int charNum = 0;
		//for(int i = 0; i < length; i++)

		switch(encryptChar)
		{
			case 'a': case 'A':
				charNum = 0;
				break;

			case 'b': case 'B':
				charNum = 1;
				break;

			case 'c': case 'C':
				charNum = 2;
				break;

			case 'd': case 'D':
				charNum = 3;
				break;

			case 'e': case 'E':
				charNum = 4;
				break;

			case 'f': case 'F':
				charNum = 5;
				break;

			case 'g': case 'G':
				charNum = 6;
				break;

			case 'h': case 'H':
				charNum = 7;
				break;

			case 'i': case 'I':
				charNum = 8;
				break;

			case 'j': case 'J':
				charNum = 9;
				break;

			case 'k': case 'K':
				charNum = 10;
				break;

			case 'l': case 'L':
				charNum = 11;
				break;

			case 'm': case 'M':
				charNum = 12;
				break;

			case 'n': case 'N':
				charNum = 13;
				break;

			case 'o': case 'O':
				charNum = 14;
				break;

			case 'p': case 'P':
				charNum = 15;
				break;

			case 'q': case 'Q':
				charNum = 16;
				break;

			case 'r': case 'R':
				charNum = 17;
				break;

			case 's': case 'S':
				charNum = 18;
				break;

			case 't': case 'T':
				charNum = 19;
				break;

			case 'u': case 'U':
				charNum = 20;
				break;

			case 'v': case 'V':
				charNum = 21;
				break;

			case 'w': case 'W':
				charNum = 22;
				break;

			case 'x': case 'X':
				charNum = 23;
				break;

			case 'y': case 'Y':
				charNum = 24;
				break;

			case 'z': case 'Z':
				charNum = 25;
				break;

			default:
				charNum = 100;
				break;

		}

		return charNum;
	}

	//Encryption with a shift to the left
	//Decryption with a shift to the right
	public char cipher_EnL_DeR(char ch, int shiftKey)
	{
		int nch = 0;
		char message = ' ';

		//case for ' ' since they count as characters
		if((charToNum(ch) - shiftKey) >= 52)
		{
			message = ch;
		}

		//case for int nch when out of bounds (positive)
		else if((charToNum(ch) - shiftKey) > 26)
		{
			nch = (charToNum(ch) - shiftKey) - 26;
			message = numToChar(nch);
		}

		//case for int nch when out of bounds (negative)
		else if((charToNum(ch) - shiftKey) < 0)
		{
			nch = (charToNum(ch) - shiftKey) + 26;
			message = numToChar(nch);
		}

		//default
		else
		{
			nch = charToNum(ch) - shiftKey;
			message = numToChar(nch);
		}

		return message;
	}

	//Encryption with a shift to the right
	//Decryption with a shift to the left
	public char cipher_EnR_DeL(char ch, int shiftKey)
	{
		int nch = 0;
		char message = ' ';

		//case for ' ' since they count as characters
		if((charToNum(ch) + shiftKey) >= 52)
		{
			message = ch;
		}

		//case for int nch when out of bounds (positive)
		else if((charToNum(ch) + shiftKey) > 26)
		{
			nch = (charToNum(ch) + shiftKey) - 26;
			message = numToChar(nch);
		}

		//case for int nch when out of bounds (negative)
		else if((charToNum(ch) + shiftKey) < 0)
		{
			nch = (charToNum(ch) + shiftKey) + 26;
			message = numToChar(nch);
		}

		//default
		else
		{
			nch = charToNum(ch) + shiftKey;
			message = numToChar(nch);
		}

		return message;
	}
}

//unused/failed methods
	/*public int charNum(char c)
	{
		int num = 0;

		for(int i = 0; i < (letters.length + 1); i++)
		{
			if(letters[i] == c)
			{
				num = i;
				i = letters.length + 2;
			}

			else if(i > letters.length)
			{
				num = 100;
			}
		}

		return num;
	}*/

	/*public char numToCharAlt(int decryptChar)
	{
		char letter = letters[decryptChar];
		return letter;
	}*/

	/*will take in the shift key
	will determine whether to add or subtract depending on the shift variable
	uses charToNum for the change
	returns teh decrypted message
	public void decryption(int shiftKey, String shift)
	{

	}*/