package testdao;

import models.works.*;

public class Ex02 {
    public static void main(String[] args) {
        SaveService saveService = WorkServiceManager.getInstance().saveService(); // 싱글턴

//        WorkDao workDao = new WorkDao();
//        SaveService saveService = new SaveService(workDao);

//        WorkServiceManager serviceManager = new WorkServiceManager();
//        SaveService saveService = serviceManager.saveService();

        Work work = new Work();
        work.setWorkNo(3L);
        work.setStatus(Status.PROGRESS);
        work.setSubject("(수정)작업 제목...");
        work.setContent("(수정)작업 내용....");

        try {
            saveService.save(work);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
