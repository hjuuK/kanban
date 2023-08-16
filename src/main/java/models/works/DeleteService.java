package models.works;

import commons.MemberUtil;
import jakarta.servlet.http.HttpServletRequest;

public class DeleteService {
    private WorkDao workDao;

    public DeleteService(WorkDao workDao) { // 생성자 매개변수 이용 -> 의존성 주입
        this.workDao = workDao;
    }

    public void delete(long workNo, HttpServletRequest req) {
        if (!workDao.exists(workNo)) {
            throw new WorkNotFoundException();
        }

        Work work = workDao.get(workNo);
        MemberUtil.isMine(req, work.getUserNo());  // 본인 작업 내용만 삭제 가능 체크

        if (!workDao.delete(workNo)) {
            throw new WorkDeleteException();
        }
    }
}
