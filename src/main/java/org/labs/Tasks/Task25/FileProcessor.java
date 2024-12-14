package org.labs.Tasks.Task25;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class FileProcessor {

    private static final long MAX_FILE_SIZE = 10 * 1024 * 1024; // 10 MB
    private final FileDAO fileDAO = new FileDAO();

    public void processFiles(String path) {
        File fileOrDir = new File(path);
        if (!fileOrDir.exists()) {
            System.out.println("Указанный путь не существует.");
            return;
        }

        if (fileOrDir.isFile()) {
            processSingleFile(fileOrDir);
        } else if (fileOrDir.isDirectory()) {
            File[] files = fileOrDir.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        processSingleFile(file);
                    }
                }
            }
        }
    }

    private void processSingleFile(File file) {
        if (file.length() < MAX_FILE_SIZE) {
            try {
                fileDAO.saveFile(file);
            } catch (SQLException | IOException e) {
                System.err.println("Ошибка при сохранении файла " + file.getName() + ": " + e.getMessage());
            }
        } else {
            System.out.println("Файл " + file.getName() + " превышает 10 MB и не будет сохранен.");
        }
    }

    public void listFiles() {
        try {
            List<FileRecord> files = fileDAO.listFiles();
            if (files.isEmpty()) {
                System.out.println("В базе данных нет сохраненных файлов.");
            } else {
                System.out.println("Список файлов в базе данных:");
                for (FileRecord file : files) {
                    System.out.println("ID: " + file.getId() + ", Имя файла: " + file.getFileName());
                }
            }
        } catch (SQLException e) {
            System.err.println("Ошибка при получении списка файлов: " + e.getMessage());
        }
    }

    public void saveLocal(int id) {
        try {
            FileRecord fileRecord = fileDAO.getFileById(id);
            if (fileRecord != null) {
                String currentDir = System.getProperty("user.dir");
                fileDAO.saveFileToLocal(fileRecord, currentDir);
            } else {
                System.out.println("Файл с ID " + id + " не найден.");
            }
        } catch (SQLException | IOException e) {
            System.err.println("Ошибка при сохранении файла: " + e.getMessage());
        }
    }
}
