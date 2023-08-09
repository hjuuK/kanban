package models.works;

import configs.DBConnection;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class WorkDao {
    /**
     * 작업 저장
     *
     * @param work
     *              - workNo가 있으면 수정, 없으면 추가
     * @return
     */
    public boolean save(Work work) {
        SqlSession sqlSession = DBConnection.getSession();
        long workNo = work.getWorkNo();
        int affectedRows = 0;
        if (workNo > 0L) { // 수정
            affectedRows = sqlSession.update("WorkListMapper.edit", work);
        } else { // 추가
            affectedRows = sqlSession.insert("WorkListMapper.add", work);
        }

        sqlSession.commit();

        return affectedRows > 0;
    }

    /**
     * 삭제
     *
     * @param workNo
     * @return
     */
    public boolean delete(long workNo) {
        SqlSession sqlSession = DBConnection.getSession();
        Work params = new Work();
        params.setWorkNo(workNo);

        int affectedRows = sqlSession.delete("WorkListMapper.delete", params);

        sqlSession.commit();

        return affectedRows > 0;
    }

    /**
     * 개별 조회
     *
     * @param workNo
     * @return
     */
    public Work get(long workNo) {
        Work params = new Work();
        params.setWorkNo(workNo);

        SqlSession sqlSession = DBConnection.getSession();
        Work work = sqlSession.selectOne("WorkListMapper.each", params);

        return work;
    }

    /**
     * 목록 조회
     *
     * @param work
     *          - status, subject, content에 따라서 검색 조건 생성
     * @return
     */
    public List<Work> gets(Work work) {
        SqlSession sqlSession = DBConnection.getSession();

        List<Work> items = sqlSession.selectList("WorkListMapper.list", work);

        return items;
    }
}
