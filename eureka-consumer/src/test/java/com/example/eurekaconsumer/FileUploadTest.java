package com.example.eurekaconsumer;

import com.example.eurekaconsumer.client.DcClient;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class FileUploadTest {

    @Autowired
    DcClient dcClient;

    @Test
    public void testHanlerFileUpload(){
        File file = new File("F:\\78\\P\\njupt\\IMG_3225.JPG");
        FileItem fileItem = new DiskFileItemFactory().createItem("file", MediaType.MULTIPART_FORM_DATA_VALUE, true, file.getName());
        try (InputStream input = new FileInputStream(file); OutputStream os = fileItem.getOutputStream()) {
            IOUtils.copy(input, os);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid file: " + e, e);
        }
        MultipartFile multipartFile = new CommonsMultipartFile(fileItem);
        try{
            String result = dcClient.handleFileUpload(multipartFile);
            System.out.println(result);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
