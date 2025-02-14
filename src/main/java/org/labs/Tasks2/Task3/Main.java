package org.labs.Tasks2.Task3;

public class Main {
    public static void main(String[] args) {
        try {
            Transport transport = TransportFactory.createTransport("business");
            System.out.println(transport.getSpecifications());
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
}
