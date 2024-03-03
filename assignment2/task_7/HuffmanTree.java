package task_7;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.HashMap;

// Represents a node in the Huffman tree
public class HuffmanTree {
    private String text;
    private HuffmanNode root;

    public HuffmanTree(String text) {
        this.text = text;
        root = buildHuffmanTree();
    }

    // Build the Huffman tree based on the input text
    private HuffmanNode buildHuffmanTree() {

        // Create a frequency map to store character frequencies
        HashMap<Character, Integer> fr = new HashMap<>();
        for (char c : text.toCharArray()) {
            fr.put(c, fr.getOrDefault(c, 0) + 1);
        }

        // Create a priority queue.
        PriorityQueue<HuffmanNode> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.frequency));

        // Create nodes for each character and add them to the priority queue
        for (var p : fr.entrySet()) {
            HuffmanNode node = new HuffmanNode(p.getKey(), p.getValue());
            pq.add(node);
        }

        // Build the Huffman tree
        while (pq.size() > 1) {
            // Extract the two nodes with the lowest frequencies
            HuffmanNode left = pq.poll();
            HuffmanNode right = pq.poll();

            // Calculate the sum of frequencies
            int totalFrequency = left.frequency + right.frequency;

            // Create a new parent node
            HuffmanNode creatingNode = new HuffmanNode('-', totalFrequency);

            // Make the extracted nodes the left and right children of the new parent node
            creatingNode.left = left;
            creatingNode.right = right;

            //Add the new parent node back to the priority queue
            pq.add(creatingNode);
        }


        // return huffman tree root node
        return pq.poll();
    }


    // Print Huffman codes for each character in the tree
    public void printHuffmanCodes() {
        printHuffmanCodes(root,"");
    }

    // Recursive method to print Huffman codes
    private  void printHuffmanCodes(HuffmanNode root, String code) {
        if (root != null) {

            if (root.left == null && root.right == null) {
                System.out.println(root.data + ": " + code);

            } else {

                printHuffmanCodes(root.left, code + "0");
                printHuffmanCodes(root.right, code + "1");
            }
        }
    }

    // Add this method to your HuffmanTree class
    public void printHuffmanOneCode(char c) {
        String code = getHuffmanCode(root, c, "");
        if (code != null) {
            System.out.println(c + ": " + code);
        } else {
            System.out.println("Character '" + c + "' not found in the Huffman tree.");
        }
    }

    // Recursive method to find the Huffman code for a specific character
    private String getHuffmanCode(HuffmanNode root, char target, String currentCode) {
        if (root != null) {
            if (root.data == target && root.left == null && root.right == null) {
                return currentCode;
            }

            String leftCode = getHuffmanCode(root.left, target, currentCode + "0");
            if (leftCode != null) {
                return leftCode;
            }

            String rightCode = getHuffmanCode(root.right, target, currentCode + "1");
            if (rightCode != null) {
                return rightCode;
            }
        }
        return null; // Character not found
    }


}

