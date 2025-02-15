package org.labs.Tasks2.Task1;

public class Main {
    public static void main(String[] args) {
        ComplaintHandler chain = new CallCenterHandler();

        Complaint complaint1 = new Complaint("Неправильное списание средств", 2);
        Complaint complaint2 = new Complaint("Проблемы с оформлением кредита", 5);
        Complaint complaint3 = new Complaint("Ошибка в работе банковской системы", 8);
        Complaint complaint4 = new Complaint("Масштабное мошенничество", 10);

        chain.handleComplaint(complaint1);
        chain.handleComplaint(complaint2);
        chain.handleComplaint(complaint3);
        chain.handleComplaint(complaint4);
    }
}
