import java.util.*;

public class SpyDecoder {
    public static void start(){
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        System.out.println("Spy Decoder Game!");
        System.out.println("A secret word is jumbled. Can you unscramble it?\n");

        String[] words = {
                "encryption", "algorithm", "ciphertext", "steganography",
                "obfuscation", "cryptanalysis", "polymorphic", "rendezvous"
        };

        //pick random word
        String secretWord = words[rand.nextInt(words.length)];

         //jumble the word
        String jumbled = jumbleWord(secretWord , rand);

        //show
        System.out.println("Jumbled Word: " + jumbled + "\n");

        System.out.println("Your guess: ");
        String guess = sc.nextLine().toLowerCase();

        if(guess.equals(secretWord)){
            System.out.println("Correct! you cracked the code.");
        }else {
            System.out.println("Wrong! the word was: " + secretWord);
        }
    }

    //method for jumble letters of word
    private static String jumbleWord(String word, Random rand){
        char[] letters = word.toCharArray();
        for(int i = 0; i < letters.length; i++){
            int j = rand.nextInt(letters.length);
            //swap letters[i] and letters[j]
            char temp = letters[i];
            letters[i] = letters[j];
            letters[j] = temp;
        }
        return new String(letters);
    }
}
