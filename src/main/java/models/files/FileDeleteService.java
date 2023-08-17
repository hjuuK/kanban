package models.files;

import jakarta.servlet.http.HttpServletRequest;

public class FileDeleteService {
    private FileInfoDao fileInfoDao;

    public FileDeleteService(FileInfoDao fileInfoDao) {
        this.fileInfoDao = fileInfoDao;
    }

    public void delete(long id, HttpServletRequest req) {

    }

    public void delete(String gid, String location, HttpServletRequest req) {

    }

    public void delete(String gid, HttpServletRequest req) {
        delete(gid, null, req);
    }
}
