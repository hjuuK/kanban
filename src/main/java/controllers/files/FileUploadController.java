package controllers.files;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.files.FileInfo;
import models.files.FileServiceManager;
import models.files.FileUploadService;

import java.io.IOException;
import java.util.List;

@WebServlet("/file/upload")
public class FileUploadController extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        FileUploadService uploadService = FileServiceManager.getInstance().fileUploadService();

        List<FileInfo> items = uploadService.uploads(req);
        items.stream().forEach(System.out::println);
    }
}
