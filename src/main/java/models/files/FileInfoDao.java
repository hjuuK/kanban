package models.files;

import configs.DBConnection;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class FileInfoDao {
    public boolean add(FileInfo fileInfo) {
        SqlSession session = DBConnection.getSession();
        int affectedRows = session.insert("FileInfoMapper.add", fileInfo);
        session.commit();

        return affectedRows > 0;
    }

    public FileInfo get(long id) {
        FileInfo param = new FileInfo();
        param.setId(id);

        FileInfo data = DBConnection.getSession().selectOne("FileInfoMapper.each", param);

        return data;
    }

    public List<FileInfo> getList(String gid, String location) {
        FileInfo param = new FileInfo();
        param.setGid(gid);
        param.setLocation(location);

        List<FileInfo> items = DBConnection.getSession().selectList("FileInfoMapper.list", param);

        return items;
    }

    public List<FileInfo> getList(String gid) {
        return getList(gid, null);
    }

    public boolean delete(long id) {
        FileInfo param = new FileInfo();
        param.setId(id);
        SqlSession session = DBConnection.getSession();

        int affectedRows = session.delete("FileInfoMapper.delete", param);

        session.commit();

        return affectedRows > 0;
    }

    public boolean delete(String gid, String location) {
        FileInfo param = new FileInfo();
        param.setGid(gid);
        param.setLocation(location);

        SqlSession session = DBConnection.getSession();

        int affectedRows = session.delete("FileInfoMapper.deletes", param);

        session.commit();

        return affectedRows > 0;
    }

    public boolean delete(String gid) {
        return delete(gid, null);
    }
}
