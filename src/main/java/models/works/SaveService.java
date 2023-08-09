package models.works;

import jakarta.servlet.http.HttpServletRequest;
import validators.Validator;

public class SaveService {
    private WorkDao workDao;
    private Validator<Work> validator;

    public SaveService(WorkDao workDao, Validator<Work> validator) { // 직접 생성하는 것이 아닌 외부에서 통제 가능하도록 (외부에서 주입)
        this.workDao = workDao;
        this.validator = validator;
    }

    public void save(Work work) {
        // 유효성 검사
        validator.check(work);

        boolean result = workDao.save(work);
        if (!result) { // 등록 실패
            throw new WorkSaveException();
        }
    }

    public void save(HttpServletRequest req) {
        Work work = new Work();
        work.setSubject(req.getParameter("subject"));
        work.setContent(req.getParameter("content"));

        String status = req.getParameter("status");
        work.setStatus(status == null || status.isBlank() ? Status.READY : Status.valueOf(status));

        String workNo = req.getParameter("workNo");
        if (workNo != null && !workNo.isBlank()) {
            work.setWorkNo(Long.parseLong(workNo));
        }

        save(work);
    }
}
