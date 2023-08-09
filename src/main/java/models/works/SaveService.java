package models.works;

public class SaveService {
    private WorkDao workDao;

    public SaveService(WorkDao workDao) { // 직접 생성하는 것이 아닌 외부에서 통제 가능하도록 (외부에서 주입)
        this.workDao = workDao;
    }

    public void save(Work work) {
        // work 데이터 검증 (유효성 검사)

        workDao.save(work); // 의존성
    }
}
