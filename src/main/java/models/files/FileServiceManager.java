package models.files;

public class FileServiceManager {
    private static FileServiceManager instance; // 싱글턴

    private FileServiceManager() {}

    public static FileServiceManager getInstance() {
        if (instance == null) {
            instance = new FileServiceManager();
        }

        return instance;
    }

    public FileInfoDao fileInfoDao() {
        return new FileInfoDao();
    }

    public FileUploadService fileUploadService() {
        return new FileUploadService(fileInfoDao());
    }

    public FileDeleteService fileDeleteService() {
        return new FileDeleteService(fileInfoDao());
    }

    public FileInfoService fileInfoService(){
        return new FileInfoService(fileInfoDao());
    }
}
