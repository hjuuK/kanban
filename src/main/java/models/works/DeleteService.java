package models.works;

public class DeleteService {
    private WorkDao workDao;

    public DeleteService(WorkDao workDao) { // 생성자 매개변수 이용 -> 의존성 주입
        this.workDao = workDao;
    }

    public void delete(long workNo) {
        if (!workDao.exists(workNo)) {
            throw new WorkNotFoundException();
        }

        if (!workDao.delete(workNo)) {
            throw new WorkDeleteException();
        }
    }
}
