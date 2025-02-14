package org.labs.Tasks2.Task1;

class SeniorManagerHandler extends ComplaintHandler {
    @Override
    protected boolean canHandle(Complaint complaint) {
        return complaint.getDifficulty() <= 9;
    }

    @Override
    protected void resolve(Complaint complaint) {
        System.out.println("Старший менеджер решил проблему: " + complaint.getDescription());
    }
}
