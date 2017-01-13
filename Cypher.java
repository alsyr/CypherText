/*
* Alik-Serguy Alphonsovich Rukubayihunga
* CS166-Information Security
* TuTh 9:00-10:15 Spring 2016
*/
import java.util.Scanner;

public class Cypher {

	//function to count how many times
	//a character appears in the cyphertext
	public int countChar(String input, char theChar){
		int result = 0;

		char[] theCypher = input.toLowerCase().toCharArray();

		for(int i=0; i<theCypher.length; i++){
			if(theCypher[i]==Character.toLowerCase(theChar))
				result++;
		}

		return result;
	}

	//function to produce statistiques, the number of times 
	//a character appears in the cyphertext
	public String produceStat(String input){
		StringBuilder builder = new StringBuilder();

		for(int i=0; i<26; i++){
			char theChar = (char)(65+i);
			builder.append(theChar);
			builder.append(": ");
//			builder.append((double)countChar(input,theChar)*100/input.length());
			builder.append(countChar(input,theChar));
			builder.append("\t");
		}

		return builder.toString();
	}

	//function to find the index of a character in the key array
	public int lookup(char[] key, char aChar){
		char theChar = Character.toUpperCase(aChar);
		boolean found = false;
		int result = 100;
		int count = 0;

		while(!found){
			if(key[count] == theChar){
				result = count;
				found = true;
			}
			count++;
		}

		return result;
	}

	//function to decrypt a cyphertext by taking the input and the key
	public String tryDecrypt(String cypher, String key){
		StringBuilder builder = new StringBuilder();

		char[] theCypher = cypher.toLowerCase().toCharArray();
		char[] theKey = key.toUpperCase().toCharArray();

		for(int i=0; i<theCypher.length; i++){
			builder.append((char)(65+lookup(theKey, theCypher[i])));
		}

		return builder.toString();
	}


	// main function to run the program
	public static void main(String [] args) {
		Cypher test =  new Cypher();

		Scanner reader = new Scanner(System.in);
		System.out.println("Enter the cypherText: ");
		String cypherText = reader.nextLine();
		
//		String cypherText = "PBFPVYFBQXZTYFPBFEQJHDXXQVAPTPQJKTOYQWIPBVWLXTOXBTFXQWAXBVCXQWAXFQJVWLEQNTOZQGGQLFXQWAKVWLXQWAEBIPBFXFQVXGTVJVWLBTPQWAEBFPBFHCVLXBQUFEVWLXGDPEQVPQGVPPBFTIXPFHXZHVFAGFOTHFEFBQUFTDHZBQPOTHXTYFTODXQHFTDPTOGHFQPBQWAQJJTODXQHFOQPWTBDHHIXQVAPBFZQHCFWPFHPBFIPBQWKFABVYYDZBOTHPBQPQJTQOTOGHFQAPBFEQJHDXXQVAVXEBQPEFZBVFOJIWFFACFCCFHQWAUVWFLQHGFXVAFXQHFUFHILTTAVWAFFAWTEVOITDHFHFQAITIXPFHXAFQHEFZQWGFLVWPTOFFA";
//		String key = "qgzafolbvmkjywtcrhxpduenis".toUpperCase();

		System.out.println(test.produceStat(cypherText));
		System.out.println(cypherText);
		
		System.out.println("Enter the key: ");
		String key = reader.nextLine();
		System.out.println(test.tryDecrypt(cypherText, key));
	}


}

