package models.works;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class InfoService {
    private WorkDao workDao; // 여기서 객체를 생성하여 사용하면 효율적이지 못함 -> WorkServiceManager 를 통하여 관리

    public void setWorkDao(WorkDao workDao) { // setter 이용 -> 의존성 주입
        this.workDao = workDao;
    }

    public Work get(long workNo) {
        Work work = workDao.get(workNo);
        return work;
    }

    public Map<Status, List<Work>> getList(Work work) {
        List<Work> items = workDao.gets(work);
        if (items == null) {
            return null;
        }

        Map<Status, List<Work>> data = items.stream().collect(Collectors.groupingBy(Work::getStatus));

        return data;
    }

    // 작업 준비중 목록
    public List<Work> getListReady() {
        return getList(Status.READY);
    }

    // 작업 진행중 목록
    public List<Work> getListProgress() {
        return getList(Status.PROGRESS);
    }

    // 작업 완료 목록
    public List<Work> getListDone() {
        return getList(Status.DONE);
    }

    // 작업 보류 목록
    public List<Work> getListPostPone() {
        return getList(Status.POSTPONE);
    }

    public List<Work> getList(Status status) {
        Work work = new Work();
        work.setStatus(status);

        Map<Status, List<Work>> items = getList(work);

        return items == null ? null : items.get(status);
    }
}
