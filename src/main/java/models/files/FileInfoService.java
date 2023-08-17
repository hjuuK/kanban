package models.files;

import java.util.List;

public class FileInfoService {
    private FileInfoDao fileInfoDao;

    public FileInfoService(FileInfoDao fileInfoDao) {
        this.fileInfoDao = fileInfoDao;
    }

    public FileInfo get(long id) {

        return null;
    }

    public List<FileInfo> getList(String gid, String location) {

        return null;
    }

    public List<FileInfo> getList(String gid) {
        return  getList(gid, null);
    }
}
