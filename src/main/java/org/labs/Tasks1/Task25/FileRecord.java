package org.labs.Tasks1.Task25;

public class FileRecord {
    private final int id;
    private final String fileName;
    private byte[] fileBinary;

    public FileRecord(int id, String fileName) {
        this.id = id;
        this.fileName = fileName;
    }

    public FileRecord(int id, String fileName, byte[] fileBinary) {
        this.id = id;
        this.fileName = fileName;
        this.fileBinary = fileBinary;
    }

    public int getId() {
        return id;
    }

    public String getFileName() {
        return fileName;
    }

    public byte[] getFileBinary() {
        return fileBinary;
    }
}

