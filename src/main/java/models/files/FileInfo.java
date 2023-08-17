package models.files;

import jakarta.servlet.http.HttpServletRequest;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class FileInfo {
    private long id;
    private long userNo;
    private String gid;
    private String location;
    private String fileName;
    private String extension;
    private String fileType;
    private LocalDateTime regDt;

    public String getUrl(HttpServletRequest request) {
        String url = request.getContextPath() + "/static/upload" + (id % 10) + "/" + id;
        if (extension != null && !extension.isBlank()) url += "." + extension;

        return url;
    }

    public String getPath(HttpServletRequest request) {
        String uploadPath = request.getServletContext().getRealPath("/static/uploads");

        String path = uploadPath + "/" + (id % 10) + "/" + id;
        if (extension != null && !extension.isBlank()) path += "." + extension;

        return path;
    }
}
