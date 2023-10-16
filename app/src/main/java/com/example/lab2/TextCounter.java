package com.example.lab2;

public class TextCounter {
    public static int countSymbols(String phrase){
        return phrase.length();
    }
    public static int countWords(String text){
        if(text == null || text.isEmpty()){
            return 0;
        }
        String[] words = text.trim().split("\\s+");
        return words.length;
    }
}
