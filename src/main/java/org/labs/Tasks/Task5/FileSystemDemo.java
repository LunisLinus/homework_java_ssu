package org.labs.Tasks.Task5;

public class FileSystemDemo {
    public static void main(String[] args) {
        File file1 = new File("file1.txt", 500);
        File file2 = new File("file2.txt", 1500);
        File file3 = new File("file3.txt", 200);

        Folder folder1 = new Folder("Folder1");
        Folder folder2 = new Folder("Folder2");

        folder1.add(file1);
        folder1.add(file2);

        folder2.add(file3);
        folder2.add(folder1);

        folder2.display("");

        System.out.println("Total size of " + folder2.getName() + ": " + folder2.getSize() + " bytes");

        folder2.remove(file3);

        folder2.display("");

        System.out.println("Total size of " + folder2.getName() + ": " + folder2.getSize() + " bytes");
    }
}