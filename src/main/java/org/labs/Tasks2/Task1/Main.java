package org.labs.Tasks2.Task1;

public class Main {
    public static void main(String[] args) {
        ComplaintHandler callCenter = new CallCenterHandler();
        ComplaintHandler manager = new ManagerHandler();
        ComplaintHandler seniorManager = new SeniorManagerHandler();
        ComplaintHandler legalDept = new LegalDepartmentHandler();

        callCenter.setNextHandler(manager);
        manager.setNextHandler(seniorManager);
        seniorManager.setNextHandler(legalDept);

        Complaint complaint1 = new Complaint("Неправильное списание средств", 2);
        Complaint complaint2 = new Complaint("Проблемы с оформлением кредита", 5);
        Complaint complaint3 = new Complaint("Ошибка в работе банковской системы", 8);
        Complaint complaint4 = new Complaint("Масштабное мошенничество", 10);

        callCenter.handleComplaint(complaint1);
        callCenter.handleComplaint(complaint2);
        callCenter.handleComplaint(complaint3);
        callCenter.handleComplaint(complaint4);
    }
}
