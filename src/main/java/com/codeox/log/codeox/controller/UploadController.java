package com.codeox.log.codeox.controller;

import com.codeox.log.codeox.commen.enums.ResultEnum;
import com.codeox.log.codeox.commen.result.Result;
import com.codeox.log.codeox.commen.result.ResultUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Auther: duqingqing
 * @Date: 18-10-30 20:05
 * @Description:
 */
@Controller
@RequestMapping(value = "/upload")
public class UploadController {
    @Value("${codeox.imagePath}")
    private String imagePath;

    @GetMapping("/file")
    public ModelAndView file(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/file/file");
        return  modelAndView;
    }

    @RequestMapping(value="/image",produces="application/json;charset=UTF-8",method = RequestMethod.POST)
    @ResponseBody
    public Result uplocdFile(@RequestParam("fileName") MultipartFile file) {
        Result result = null;
        if (file.isEmpty()) {
            return  ResultUtil.error(ResultEnum.FILE_CANNOT_EMPTY);
        }
        String fileName = file.getOriginalFilename();
        fileName = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + "_" + fileName;

        String path = imagePath +fileName;
        File goalFile = new File(path);
        if (goalFile.exists()) {
            return ResultUtil.error(ResultEnum.FILE_IS_EXISTENCE);
        }
        if (!goalFile.getParentFile().exists()) {
            goalFile.getParentFile().mkdir();
        }
        try {
            //上传文件
            file.transferTo(goalFile); //保存文件
            System.out.print("保存文件路径"+path+"\n");
            result = ResultUtil.success(2,"文件上传地址"+path);
        } catch (IOException e) {
            return ResultUtil.error(ResultEnum.FILE_UPLOAD_ERROR);
        }
        return result;
    }
}
