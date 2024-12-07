package org.labs.Tasks.Task22;

// Main.java

public class Main {
    public static void main(String[] args) {
        Dictionary<String, Integer> dictionary = new Dictionary<>();
        dictionary.put("Alice", 25);
        dictionary.put("Bob", 30);
        System.out.println("Значение для 'Alice': " + dictionary.get("Alice"));
        System.out.println("Значение для 'Bob': " + dictionary.get("Bob"));

        dictionary.put("Alice", 26);
        System.out.println("Обновленное значение для 'Alice': " + dictionary.get("Alice"));

        System.out.println("Содержит ключ 'Charlie'? " + dictionary.containsKey("Charlie"));

        dictionary.put("Charlie", 28);
        System.out.println("Содержит ключ 'Charlie'? " + dictionary.containsKey("Charlie"));
        System.out.println("Значение для 'Charlie': " + dictionary.get("Charlie"));

        System.out.println("Размер словаря: " + dictionary.size());

        dictionary.remove("Bob");
        System.out.println("После удаления 'Bob': " + dictionary);

        dictionary.clear();
        System.out.println("После очистки словаря: " + dictionary);
        System.out.println("Размер словаря после очистки: " + dictionary.size());

        Dictionary<Integer, String> intToStringDict = new Dictionary<>();
        intToStringDict.put(1, "One");
        intToStringDict.put(2, "Two");
        intToStringDict.put(3, "Three");
        System.out.println("Значение для ключа 2: " + intToStringDict.get(2));

        intToStringDict.remove(1);
        System.out.println("После удаления ключа 1: " + intToStringDict);
    }
}
