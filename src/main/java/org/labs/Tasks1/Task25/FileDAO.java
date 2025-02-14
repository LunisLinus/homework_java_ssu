package org.labs.Tasks1.Task25;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FileDAO {

    private static final String INSERT_FILE_SQL = "INSERT INTO files (file_name, file_binary) VALUES (?, ?)";
    private static final String SELECT_ALL_FILES_SQL = "SELECT id, file_name FROM files";
    private static final String SELECT_FILE_BY_ID_SQL = "SELECT file_name, file_binary FROM files WHERE id = ?";

    public void saveFile(File file) throws SQLException, IOException {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_FILE_SQL)) {

            statement.setString(1, file.getName());

            try (FileInputStream fis = new FileInputStream(file)) {
                byte[] fileBytes = new byte[(int) file.length()];
                fis.read(fileBytes);
                statement.setBytes(2, fileBytes);
            }

            statement.executeUpdate();
            System.out.println("Файл " + file.getName() + " успешно сохранен в базу данных.");
        }
    }

    public List<FileRecord> listFiles() throws SQLException {
        List<FileRecord> files = new ArrayList<>();

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL_FILES_SQL);
             ResultSet rs = statement.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String fileName = rs.getString("file_name");
                files.add(new FileRecord(id, fileName));
            }
        }

        return files;
    }

    public FileRecord getFileById(int id) throws SQLException {
        FileRecord fileRecord = null;

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_FILE_BY_ID_SQL)) {

            statement.setInt(1, id);

            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    String fileName = rs.getString("file_name");
                    byte[] fileBytes = rs.getBytes("file_binary");
                    fileRecord = new FileRecord(id, fileName, fileBytes);
                }
            }
        }

        return fileRecord;
    }

    public void saveFileToLocal(FileRecord fileRecord, String directoryPath) throws IOException {
        File outputFile = new File(directoryPath, fileRecord.getFileName());
        try (FileOutputStream fos = new FileOutputStream(outputFile)) {
            fos.write(fileRecord.getFileBinary());
        }
        System.out.println("Файл " + fileRecord.getFileName() + " успешно сохранен в " + directoryPath);
    }
}

