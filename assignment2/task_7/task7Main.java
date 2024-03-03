package task_7;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class task7Main {

    public static void main(String[] args) throws IOException {
        // Read input text from a file
        String inputText = Files.readString(Path.of("text.txt"));
        // Create a Huffman tree based on the input text
        HuffmanTree huffmanTree= new HuffmanTree(inputText);
        // Print Huffman codes for each character
        huffmanTree.printHuffmanCodes();
        System.out.println(" enter a character ");
        Scanner scanner =  new Scanner(System.in);
        char c = scanner.next().charAt(0);

        huffmanTree.printHuffmanOneCode(c);

    }
}
