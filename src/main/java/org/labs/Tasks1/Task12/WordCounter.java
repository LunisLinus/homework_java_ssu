package org.labs.Tasks1.Task12;

import java.io.IOException;
import java.nio.file.*;


public class WordCounter {

    public static void main(String[] args) {
        Path startingDir = Paths.get("src/main/resources");

        WordCountingFileVisitor visitor = new WordCountingFileVisitor();

        try {
            Files.walkFileTree(startingDir, visitor);
            System.out.println("Общее количество слов во всех текстовых файлах: " + visitor.getTotalWordCount());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

