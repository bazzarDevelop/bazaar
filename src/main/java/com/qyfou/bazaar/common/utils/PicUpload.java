package com.qyfou.bazaar.common.utils;

import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.util.List;

public class PicUpload {
     public static String uploadFile(List<MultipartFile> files, int type)throws Exception{
        MultipartFile file = null;
        File fileRealPath=null;   //文件存放地址//linux系统
        //获取根目录
        //如果是在本地windows环境下，目录为项目的target\classes下
        //如果是linux环境下，目录为jar包同级目录
        File rootPath = new File(ResourceUtils.getURL("classpath:").getPath());
        if(!rootPath.exists()){
            rootPath = new File("");
        }
        switch (type) {
            case 0:
                fileRealPath = new File(rootPath.getAbsolutePath() + "/image/user");
                break;
            case 1:
                fileRealPath = new File(rootPath.getAbsolutePath() + "/image/goods");
                break;
        }
        //判断文件夹是否存在
        if(!fileRealPath.exists()){
            //不存在，创建
            fileRealPath.mkdirs();
        }


        for (int i = 0; i < files.size(); ++i) {
            file = files.get(i);
            if (!file.isEmpty()) {
                try {
                    //获取文件名称
                    String fileName = file.getOriginalFilename();
                    //创建文件存放地址
                    File resultPath = new File(fileRealPath+"/"+fileName);
                    file.transferTo(resultPath);
                } catch (Exception e) {
                    return "You failed to upload " + i + " => " + e.getMessage();
                }
            } else {
                return "You failed to upload " + i + " because the file was empty.";
            }
        }
        return "upload successful";
    }
}
