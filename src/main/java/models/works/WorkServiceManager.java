package models.works;

public class WorkServiceManager { // 의존하는 부분들을 모아서? 통제 가능하도록 만듦
    private static WorkServiceManager instance; // 싱글턴

    private WorkServiceManager() {}

    public static WorkServiceManager getInstance() {
        if (instance == null) {
            instance = new WorkServiceManager();
        }

        return instance;
    }

    public WorkDao workDao() { // 이 메서드를 통하여 객체 생성 -> 의존성 주입
        return new WorkDao();
    }

    public WorkSaveValidator workSaveValidator() {
        return new WorkSaveValidator();
    }

    public SaveService saveService() {
        return new SaveService(workDao(), workSaveValidator());
    }

    public InfoService infoService() { // setter를 통한 주입
        InfoService infoService = new InfoService();
        infoService.setWorkDao(workDao());

        return infoService;
    }

    public DeleteService deleteService() { // 생성자를 통한 주입
        return new DeleteService(workDao());
    }
}
