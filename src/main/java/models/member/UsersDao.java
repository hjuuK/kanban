package models.member;

import configs.DBConnection;
import controllers.member.UserForm;
import models.works.Work;
import org.apache.ibatis.session.SqlSession;
import org.mindrot.jbcrypt.BCrypt;

public class UsersDao {
    public boolean register(UserForm users) {
        SqlSession sqlSession = DBConnection.getSession();
        String hash = BCrypt.hashpw(users.getUserPw(), BCrypt.gensalt(12)); // 10번이 기본값 / salt: 몇번반복
        users.setUserPw(hash);

        int affectedRows = sqlSession.insert("UserMapper.add", users);

        sqlSession.commit();

        return affectedRows > 0;
    }

    public Users get(String userId) {
        SqlSession sqlSession = DBConnection.getSession();
        UserForm params = new UserForm();
        params.setUserId(userId);

        Users users = sqlSession.selectOne("UserMapper.info", params);

        return users;
    }

    public boolean exists(String userId) {
        SqlSession sqlSession = DBConnection.getSession();
        UserForm params = new UserForm();
        params.setUserId(userId);
        int cnt = sqlSession.selectOne("UserMapper.exists", params);

        return cnt > 0;
    }
}
