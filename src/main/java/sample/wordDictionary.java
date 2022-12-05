package sample;

import java.io.*;
import java.util.HashMap;

public class wordDictionary {
    HashMap<String,String> wordList;

    wordDictionary()
    {
        this.wordList = new HashMap<>();
    }

    void addWord(String Word, String Meaning){
        wordList.put(Word, Meaning);
    }

    HashMap<String, String> getWordList()
    {
        return wordList;
    }

    void serializeMap()
    {
        try{
            FileOutputStream os = new FileOutputStream("wordList2");
            ObjectOutputStream oos = new ObjectOutputStream(os);

            oos.writeObject(wordList);
            oos.close();
            os.close();
        }
        catch(IOException io)
        {
            io.printStackTrace();
        }
    }
    void deserializeMap() {
        try {
            FileInputStream is = new FileInputStream("wordList2");
            ObjectInputStream ois = new ObjectInputStream(is);

            wordList = (HashMap<String, String>) ois.readObject();
        } catch (IOException io) {
            io.printStackTrace();
        }
        catch(ClassNotFoundException ex)
        {
            System.out.println("Class Not Found");
        }
    }
}
