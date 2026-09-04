package com.sky.controller.admin;

import java.io.File;
import java.util.UUID;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sky.constant.FileUploadConstant;
import com.sky.result.Result;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/admin/common")
@Api(tags = "通用接口")
@Slf4j
public class CommonControoller {
    
    @PostMapping("/upload")
    @ApiOperation("文件上传")
    public Result<String> upload(MultipartFile file){
        log.info("文件上传:{}",file);
    try {
        String originalFilename=file.getOriginalFilename();
        String extension=originalFilename.substring(originalFilename.lastIndexOf("."));
        if(!extension.equals(".png")&&!extension.equals(".jpg")&&!extension.equals(".jpeg")){
            log.info("文件不合法{}",originalFilename);
            return Result.error("文件不合法，重新上传");
        }
        String newFileName=UUID.randomUUID().toString()+extension;
        String path=FileUploadConstant.FILE_UPLOAD_PATH+newFileName;
        file.transferTo(new File(path));
        return Result.success(FileUploadConstant.FILE_VIVST_PATH+newFileName);
    } catch (Exception e) {
        log.info("文件上传失败{}",e);
        throw new RuntimeException(e);
    }
    }
}
