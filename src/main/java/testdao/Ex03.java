package testdao;

import models.works.InfoService;
import models.works.Status;
import models.works.Work;
import models.works.WorkServiceManager;

import java.util.List;
import java.util.Map;

public class Ex03 {
    public static void main(String[] args) {
        InfoService infoService = WorkServiceManager.getInstance().infoService();
        //Work work = infoService.get(3L); // 개별 조회
        //System.out.println(work);
        Work work = new Work();
        work.setStatus(null);
        Map<Status, List<Work>> items = infoService.getList(work);
        System.out.println(items);
    }
}
