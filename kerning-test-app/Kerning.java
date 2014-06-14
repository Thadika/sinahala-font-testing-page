import java.io.*;
import java.util.Scanner;

public class Kerning {

    public static void main(String[] args) {
            BufferedWriter bw = null;
            try {
                Scanner in = new Scanner(new FileReader("Input.txt"));
                bw = new BufferedWriter(new FileWriter("Output.txt"));
                int wordLength = in.nextInt();
                int t = in.nextInt();
                char[] charSet = new char[t];
                char[] pattern = new char[wordLength];
                for (int i = 0; i < t; i++) {
                charSet[i] = in.next().charAt(0);
                }
                generatePatterns(charSet,wordLength,pattern,bw);

            } catch (IOException ex) {
                
            } finally {
                try {
                    bw.close();
                } catch (IOException ex) {
                   
                }
            }   
    }

    private static void generatePatterns(char[] charSet, int wordLength, char[] pattern, BufferedWriter bw) throws IOException {
        if(wordLength==0){ 
            bw.write(pattern);
            bw.write("\n");
            return;
        }
        for (int i = 0; i < charSet.length; i++) {
            pattern[pattern.length-wordLength] = charSet[i];
            generatePatterns(charSet, wordLength-1,pattern, bw);
        }      
    }
}
