package most_asked;

import java.io.BufferedReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

/**
 * Created by jalpanranderi on 11/7/14.
 */
public class WordSearchInFileTrie {
    public static void main(String[] args) {


        long startTime = System.currentTimeMillis();


        String text = readFile("trietest.txt");
        String[] words = getWords(text);
        Trie t = createIndex(words);
        //t.print();


        startTime = System.currentTimeMillis();

        printPositions(t, "and");
        printPositions(t, "aberrant");


        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println(elapsedTime);


    }

    static void printPositions(Trie t, String s) {
        if (t.contains(s)) {
            System.out.println(s + ": " + t.getItem(s));
        }
    }

    static Trie createIndex(String[] words) {
        Trie t = new Trie();
        for (int i = 0; i < words.length; i++) {
            t.getItem(words[i]).add(i);
        }
        return t;
    }

    static String[] getWords(String text) {
        return text.toLowerCase().split(" ");
    }

    static String readFile(String filename) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(filename), Charset.defaultCharset())) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }


/*
from http://alexcode.tumblr.com/question_9
Given a text file and a word, find the positions that the word occurs in the file.
We’ll be asked to find the positions of many words in the same file.
*/


}


class Trie {


    Node root = new Node();

    boolean contains(String word) {
        Node current = root;
        char[] word_ = word.toCharArray();

        for (Character c : word_) {

            Node next = current.children.get(c);

            if (next == null) {
                return false;
            }else {
                current = next;
            }
        }

        return current.isTerminal;
    }


    List<Integer> getItem(String word) {
        Node current = root;
        char[] word_ = word.toCharArray();
        for (Character c : word_) {
            Node next = current.children.get(c);
            if (next == null) {
                next = new Node(c);
                current.children.put(c, next);
            }
            current = next;
        }
        current.isTerminal = true;
        return current.positions;
    }

    void print() {
        List<Node> l = new ArrayList<>();
        l.add(root);
        output(l, "");
    }

    //Depth First Search
    void output(List<Node> currentPath, String indent) {
        Node current = currentPath.get(currentPath.size() - 1);
        if (current.isTerminal) {
            String word = "";
            for (Node n : currentPath) word += n.letter;
            System.out.println(indent + word + " " + current.positions);
            indent += "  ";
        }
        for (Entry<Character, Node> e : current.children.entrySet()) {
            Node node = e.getValue();
            List<Node> newlist = new ArrayList<>();
            newlist.addAll(currentPath);
            newlist.add(node);
            output(newlist, indent);
        }
    }

}

class Node {
    char letter;
    boolean isTerminal = false;
    Map<Character, Node> children = new TreeMap<>();
    List<Integer> positions = new ArrayList<>();

    public Node() {
    }

    public Node(char letter) {
        this.letter = letter;
    }
}
