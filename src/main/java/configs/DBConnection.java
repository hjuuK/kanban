package configs;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.ResourceBundle;

public class DBConnection {
    private static SqlSessionFactory sqlSessionFactory;

    static {
        try {
            // 설정
            ResourceBundle bundle = ResourceBundle.getBundle("configs.application");
            String env = bundle.getString("environment");

            String mode = env.equals("real") ? "real" : "dev";
            Reader reader = Resources.getResourceAsReader("mybatis/config/config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader, mode);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSession getSession() {
        return sqlSessionFactory.openSession();
    }
}
