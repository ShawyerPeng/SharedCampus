package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import service.UploadService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.UUID;

@Controller
@RequestMapping("/image")
public class UploadController {
    @Autowired
    private UploadService uploadService;

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile pictureFile) throws Exception {
        String FILEPATH = "C:\\Users\\ShawyerPeng\\Desktop\\pictures\\";
        String originalFilename = "";
        String newFileName = "";

        //进行图片的上传
        if (pictureFile != null && pictureFile.getOriginalFilename() != null && pictureFile.getOriginalFilename().length() > 0) {
            //图片上传成功后，将图片的地址写到数据库
            originalFilename = pictureFile.getOriginalFilename();

            String uuid = UUID.randomUUID().toString();
            newFileName = uuid.replace("-", "") + originalFilename.substring(originalFilename.lastIndexOf("."));

            //新文件
            File file = new File(FILEPATH + newFileName);

            //将内存中的文件写入磁盘
            pictureFile.transferTo(file);
        }

        uploadService.insertFile(originalFilename, newFileName);

        return newFileName;
    }

    @RequestMapping(value = "/uploadWithDescription", method = RequestMethod.POST)
    @ResponseBody
    public String uploadWithDescription(@RequestParam("file") MultipartFile pictureFile, @RequestParam("description") String description) throws Exception {
        String FILEPATH = "C:\\Users\\ShawyerPeng\\Desktop\\pictures\\";
        String originalFilename = "";
        String newFileName = "";

        //进行图片的上传
        if (pictureFile != null && pictureFile.getOriginalFilename() != null && pictureFile.getOriginalFilename().length() > 0) {
            //图片上传成功后，将图片的地址写到数据库
            originalFilename = pictureFile.getOriginalFilename();

            String uuid = UUID.randomUUID().toString();
            newFileName = uuid.replace("-", "") + originalFilename.substring(originalFilename.lastIndexOf("."));

            //新文件
            File file = new File(FILEPATH + newFileName);

            //将内存中的文件写入磁盘
            pictureFile.transferTo(file);
        }

        uploadService.insertFileWithDescription(originalFilename, FILEPATH + newFileName, description);

        return "ok";
    }

    @RequestMapping(value = "/uploadMultipart", method = RequestMethod.POST)
    @ResponseBody
    public String uploadMultipart(@RequestParam("file") MultipartFile[] pictureFile, @RequestParam("description") String description) throws Exception {
        String FILEPATH = "C:\\Users\\ShawyerPeng\\Desktop\\pictures\\";
        String originalFilename = "";
        String newFileName = "";

        //进行图片的上传
        for (int i = 0; i < pictureFile.length; i++) {
            if (pictureFile[i] != null && pictureFile[i].getOriginalFilename() != null && pictureFile[i].getOriginalFilename().length() > 0) {
                originalFilename = pictureFile[i].getOriginalFilename();
                newFileName = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));

                File file = new File(FILEPATH + newFileName);

                pictureFile[i].transferTo(file);
            }
            uploadService.insertFileWithDescription(originalFilename, FILEPATH + newFileName, description);
        }

        return "ok";
    }

    /**
     * 获取图片保存的绝对路径
     */
    public static String imagePath(String relative, HttpServletRequest request) {
        String path = null;
        if (relative != null || !"".equals(relative)) {
            String projectPath = request.getServletContext().getRealPath("/");
            path = new File(projectPath).getParentFile().getAbsolutePath() + relative;
            path = path.replaceAll("\\\\", "/");
			System.out.println(path);
        }
        return path;
    }
}
