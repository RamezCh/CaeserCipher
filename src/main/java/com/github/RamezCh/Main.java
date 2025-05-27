package com.github.RamezCh;

public class Main {
    private static final int ALPHABET_SIZE = 26;
    
    public static void main(String[] args) {
        String originalText = "I can encrypt and decrypt";
        int key = 11;

        String encoded = encode(originalText, key);
        System.out.println("Encoded: " + encoded);

        String decoded = decode(encoded, key);
        System.out.println("Decoded: " + decoded);
    }

    public static String encode(String text, int key) {
        key = ((key % ALPHABET_SIZE) + ALPHABET_SIZE) % ALPHABET_SIZE;
        StringBuilder encodedSentence = new StringBuilder();
        for(char letter : text.toCharArray()) {
            if(Character.isLetter(letter)) {
                char base = Character.isUpperCase(letter) ? 'A' : 'a';
                letter = (char) ( (letter - base + key) % ALPHABET_SIZE + base);
            }
            encodedSentence.append(letter);
        }
        return encodedSentence.toString();
    }

    public static String decode(String text, int key) {
        return encode(text, (ALPHABET_SIZE - (key % ALPHABET_SIZE)));
    }
}