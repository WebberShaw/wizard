package edu.hunau.controller;

import com.microsoft.azure.storage.blob.CloudBlobContainer;
import com.microsoft.azure.storage.blob.CloudBlockBlob;
import edu.hunau.config.StorageConfig;
import edu.hunau.utils.BlobHelper;
import edu.hunau.utils.FileUploadUtil;
import edu.hunau.utils.MyUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static com.google.common.io.Files.getFileExtension;

//@Api(value = "微软云存储", description = "微软云存储")
@RestController
@RequestMapping("/files")
@Slf4j
public class FileUploadController {
    @Autowired
    FileUploadUtil fileUploadUtil;
    @RequestMapping(value = "/uploadAvatar", method = RequestMethod.POST, consumes = "multipart/*", headers = "content-type=multipart/form-data")
    public Object uploadAvatar(@RequestBody MultipartFile file, HttpServletRequest request) {
        if(request.getSession().getAttribute("User")==null){
            return new Result(Code.NOT_LOGIN,null,"用户登录已失效，请重新登录");
        }
        if (!(file.getContentType().toLowerCase().equals("image/jpg")
                || file.getContentType().toLowerCase().equals("image/jpeg")
                || file.getContentType().toLowerCase().equals("image/png"))) {
            return new Result(Code.ERR,null,"头像上传失败,仅支持jpg,png或jpeg格式的图片");
        }
        String url = fileUploadUtil.uploadFile(file);
        if(url!=null){
            return new Result(Code.OK,url,"头像上传成功");
        }
        return new Result(Code.ERR,null,"头像上传失败");


    }


}