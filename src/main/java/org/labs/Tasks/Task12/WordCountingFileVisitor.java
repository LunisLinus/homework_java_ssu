package org.labs.Tasks.Task12;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

class WordCountingFileVisitor extends SimpleFileVisitor<Path> {
    private long totalWordCount = 0;

    public long getTotalWordCount() {
        return totalWordCount;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
        if (file.toString().toLowerCase().endsWith(".txt")) {
            long fileWordCount = 0;
            try (BufferedReader reader = Files.newBufferedReader(file, StandardCharsets.UTF_8)) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] words = line.split("\\s+");
                    for (String word : words) {
                        word = word.replaceAll("^\\p{Punct}+|\\p{Punct}+$", "");
                        if (word.isEmpty()) {
                            continue;
                        }
                        if (word.length() == 1) {
                            if (Character.isLetter(word.charAt(0))) {
                                fileWordCount++;
                            }
                        } else {
                            fileWordCount++;
                        }
                    }
                }
                totalWordCount += fileWordCount;
                System.out.println("Файл: " + file + " - Слов: " + fileWordCount);
            } catch (IOException e) {
                System.err.println("Не удалось прочитать файл: " + file);
                e.printStackTrace();
            }
        }
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) {
        System.err.println("Не удалось посетить файл: " + file);
        return FileVisitResult.CONTINUE;
    }
}
