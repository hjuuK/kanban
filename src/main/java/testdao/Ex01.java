package testdao;

import models.works.Status;
import models.works.Work;
import models.works.WorkDao;

public class Ex01 {
    public static void main(String[] args) {
        /**
        WorkDao dao = new WorkDao();
        Work work = dao.get(1L);
        System.out.println(work);
        */

        /**
        Work work = new Work();
        work.setStatus(Status.PROGRESS);
        work.setSubject("작업 제목...");
        work.setContent("작업 내용....");

        boolean result = dao.save(work);
        System.out.println(result);
        System.out.println(work);
         */
    }
}
