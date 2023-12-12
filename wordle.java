import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

public class Wordle {
    public static void main(String[] args) throws IOException {

        FileReader f = new FileReader("dict.txt");
        BufferedReader in = new BufferedReader(f);

        String[] line = new String[2317];
        for (int i = 0; i < line.length; i++) {
            line[i] = in.readLine();
        }

        Random randomNumber = new Random();
        int randomIndex = randomNumber.nextInt(line.length);
        String keyword = line[randomIndex];

        char[] keywordChars = keyword.toCharArray();

        String word1 = args[0];
        String word2 = args[1];
        String word3 = args[2];
        String word4 = args[3];
        String word5 = args[4];
        String word6 = args[5];

        for (int i = 0; i < args.length; i++) {

            System.out.println("Try" + (i + 1) + " (" + args[i] + "):");

            //checking the length
            if (args[i].length() != 5) {
                System.out.println("The length of word must be five!");
            }
            //checking if it's not in the dictionary
            else {
                if (!Arrays.asList((line)).contains(args[i])) {
                    System.out.println("The word does not exist in the dictionary!");
                }
                //checking if the arguments are the same as the keyword
                else {
                    if (Objects.equals(args[i], keyword)) {
                        System.out.println("Congratulations! You guess right in " + (i + 1) + ". shot!");
                        break;
                    }
                    //checking letters
                    else {
                        for (int m = 0; m < 5; m++) {
                            if (args[i].charAt(m) == keywordChars[m]) {
                                System.out.println((m + 1) + ". letter exists and located right position.");
                            } else {
                                if (keyword.contains(String.valueOf(args[i].charAt(m))) && args[i].charAt(m) != keywordChars[m]) {
                                    System.out.println((m + 1) + ". letter exists but located wrong position.");
                                } else {
                                    System.out.println((m + 1) + ". letter does not exist.");
                                }
                            }
                        }
                    }
                }
            }
            //checking for maximum attempts reached
            if ((i == 5) && !Objects.equals(args[i], keyword)) {
                System.out.println("You exceeded maximum try shot!");
                System.out.println("You failed! The key word is " + keyword + ".");
            }
        }
    }
}