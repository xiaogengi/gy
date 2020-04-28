package com.lw.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.*;

/**
 * @program: gy_system
 * @description:
 * @author: gzk
 * @create: 2020-04-28 21:09
 **/
public class UploadUtil {

    public static synchronized String downloadFileImg(MultipartFile file, String path){
        OutputStream os = null;
        InputStream inputStream = null;
        String fileName = null;
        String filePath = "";
        try {
            inputStream = file.getInputStream();
            fileName = file.getOriginalFilename();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            // 2、保存到临时文件
            // 10M的数据缓冲
            byte[] bs = new byte[1024 * 1024 * 10];
            // 读取到的数据长度
            int len;
            // 输出的文件流保存到本地文件
            File tempFile = new File(path);
            if (!tempFile.exists()) {
                tempFile.mkdirs();
            }
            filePath = tempFile.getPath() + File.separator + fileName;
            os = new FileOutputStream(filePath);
            // 开始读取
            while ((len = inputStream.read(bs)) != -1) {
                os.write(bs, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 完毕，关闭所有链接
            try {
                os.close();
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return filePath;
    }

}
