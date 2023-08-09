package models.works;

public class InfoService {
    private WorkDao workDao = new WorkDao();

    public Work get(long workNo) {
        Work work = workDao.get(workNo);
        return work;
    }
}
