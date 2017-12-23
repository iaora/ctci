import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.util.HashMap;

/*
 * Word Frequencies: Design a method to find the frequencies of
 * occurrences of any given word in a book. What if we were running
 * this algorithm many times?
 */

public class Pr2{
    public static void main(String[] args){
        String fileName = "book.txt";
        String targetWord = "books";
        try{
            countWord(fileName, targetWord);
            HashMap<String, Integer> dict = countManyWords(fileName);
            printHashMap(dict);
        }catch(IOException e){
            System.out.println("there was an error");
        }
    }

    private static void printHashMap(HashMap<String, Integer> dict){
        for (String str: dict.keySet()){
            String key = str.toString();
            String value = dict.get(str).toString();
            System.out.println(key + " " + value);
        } 
    }

    private static HashMap<String, Integer> countManyWords(String fileName)
            throws IOException{
        BufferedReader buffReader = openFile(fileName);
        HashMap<String, Integer> dict = new HashMap<String, Integer>();
        String line;
        int count;
        while((line = buffReader.readLine()) != null){
            String[] lineArr = line.split(" |,|!|\\?|\"");
            
            for(String str : lineArr){
                if(!dict.containsKey(str))
                    dict.put(str, 1);
                count = dict.get(str);
                dict.replace(str, count+1);
            }
        }
        return dict;

    }

    private static void countWord(String fileName, String targetWord)
            throws IOException{
        /*
         *  This is the implementation for 1 single word search. Does not make sense
         *  to create a HashMap to contain all of the values of the book if only
         *  searching for 1 item.
         */

        BufferedReader buffReader = openFile(fileName);
        int count = 0;
        String line;
        while((line = buffReader.readLine()) != null){
            count += countLine(line, targetWord);
        }
        System.out.println(targetWord + " appeared " + count + " times.");

    }

    private static BufferedReader openFile(String fileName)
            throws IOException{
        File file = new File(fileName);
        FileReader fileReader = new FileReader(file);
        return new BufferedReader(fileReader);
    }

    private static int countLine(String line, String word)
            throws IOException{
        int count = 0;
        String[] lineSplit = line.split(" ");
        for (String str : lineSplit)
            if (str.toLowerCase().contains(word))
                count++;
        return count;
    }

}
