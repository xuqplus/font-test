package cn.xuqplus.fonttest.controller;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Log
@Api
@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    DefaultKaptcha defaultKaptcha;

    @GetMapping("captcha")
    public void captcha(HttpServletResponse response, String text) throws IOException {
        BufferedImage bufferedImage = defaultKaptcha.createImage("hello, 你好, " + text);
        response.setContentType("image/jpg");
        ImageIO.write(bufferedImage, "jpg", response.getOutputStream());

    }

    @ApiOperation("log")
    @GetMapping("log")
    public void log(String text) throws IOException {
        log.info(String.format("%s", text));
    }

    @ApiOperation("body/String")
    @PostMapping("body/String")
    public String bodyString(@RequestBody String text) throws IOException {
        return text;
    }

    @ApiOperation("body/List")
    @PostMapping("body/List")
    public Object body(@RequestBody List<String> text) throws IOException {
        return text;
    }

    @ApiOperation("body/Map")
    @PostMapping("body/Map")
    public Object body(@RequestBody Map text) throws IOException {
        return text;
    }
}
