package org.labs.Tasks1.Task5;

interface FileSystemComponent {
    String getName();

    int getSize();

    default void add(FileSystemComponent component) {
        throw new UnsupportedOperationException("Operation not supported");
    }

    default void remove(FileSystemComponent component) {
        throw new UnsupportedOperationException("Operation not supported");
    }

    void display(String indent);
}
