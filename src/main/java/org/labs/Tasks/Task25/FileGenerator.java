package org.labs.Tasks.Task25;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class FileGenerator {
    public static void createRandomFile(String filePath, long sizeInBytes) throws IOException {
        Random random = new Random();
        byte[] buffer = new byte[1024];
        long bytesWritten = 0;

        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            while (bytesWritten < sizeInBytes) {
                int bytesToWrite = (int) Math.min(buffer.length, sizeInBytes - bytesWritten);
                random.nextBytes(buffer);
                fos.write(buffer, 0, bytesToWrite);
                bytesWritten += bytesToWrite;
            }
        }

        System.out.println("Файл создан: " + filePath + " (" + sizeInBytes + " байт)");
    }

    public static void main(String[] args) {
        String resourcesPath = "src/main/resources/files/";

        File resourcesDir = new File(resourcesPath);

        if (!resourcesDir.exists()) {
            boolean created = resourcesDir.mkdirs();
            if (created) {
                System.out.println("Папка resources создана по пути: " + resourcesPath);
            } else {
                System.err.println("Не удалось создать папку resources по пути: " + resourcesPath);
                return;
            }
        }

        FileSpecification[] filesToCreate = {
                new FileSpecification("file6MB.bin", 6 * 1024),
                new FileSpecification("file5MB.bin", 5 * 1024 * 1024),
                new FileSpecification("file10MB.bin", 10 * 1024 * 1024),
                new FileSpecification("file15MB.bin", 15 * 1024 * 1024)
        };

        for (FileSpecification spec : filesToCreate) {
            String fullPath = resourcesPath + spec.getFileName();
            try {
                createRandomFile(fullPath, spec.getSizeInBytes());
            } catch (IOException e) {
                System.err.println("Ошибка при создании файла " + spec.getFileName() + ": " + e.getMessage());
            }
        }

        System.out.println("Все файлы успешно созданы в папке resources.");
    }
}


