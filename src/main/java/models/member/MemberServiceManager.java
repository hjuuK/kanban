package models.member;

public class MemberServiceManager {
    private static MemberServiceManager instance; // 싱글턴 패턴

    private MemberServiceManager() {}

    public static MemberServiceManager getInstance() {
        if (instance == null) {
            instance = new MemberServiceManager(); // 객체 생성
        }

        return instance;
    }

    private UsersDao usersDao() {
        return new UsersDao();
    }

    public JoinValidator joinValidator() {
        return new JoinValidator(usersDao());
    }

    public JoinService joinService() {
        return new JoinService(usersDao(), joinValidator());
    }
}
