package com.itbge.controller;

import com.itbge.pojo.Result;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
public class FileUploadController {

    // 将此路径修改为你希望上传文件存储的位置
    private final Path storageDirectory = Paths.get("uploads");

    /**
     * 上传图片接口
     *
     * 请求路径: /upload
     * 请求方式: POST
     * 接口描述: 接收上传的图片文件并将其保存到指定目录
     *
     * @param file 上传的图片文件
     * @param redirectAttributes 重定向属性
     * @return 返回上传结果的JSON字符串
     */
    @PostMapping("/upload")
    public Result handleFileUpload(@RequestParam("image") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {
        try {
            // 确保上传目录存在
            Files.createDirectories(storageDirectory);

            // 将文件保存到上传目录
            Path destinationFile = storageDirectory.resolve(
                    Paths.get(file.getOriginalFilename())).normalize().toAbsolutePath();
            if (!destinationFile.getParent().equals(storageDirectory.toAbsolutePath())) {
                // 安全考虑：拒绝保存到上传目录之外的路径
                throw new RuntimeException("Cannot store file outside current directory.");
            }
            file.transferTo(destinationFile);

            // 返回文件访问路径（这里假设是可以通过web直接访问的路径）
            String fileUrl = "/uploads/" + file.getOriginalFilename();
            return Result.success(fileUrl);
        } catch (IOException e) {
            e.printStackTrace();
            return Result.error("file upload failed");
        }
    }
}
