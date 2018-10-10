package cn.xuqplus.fonttest.controller;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    DefaultKaptcha defaultKaptcha;

    @GetMapping("")
    public void captcha(HttpServletResponse response, String text) throws IOException {
        BufferedImage bufferedImage = defaultKaptcha.createImage("hello, 你好, " + text);
        response.setContentType("image/jpg");
        ImageIO.write(bufferedImage, "jpg", response.getOutputStream());
    }
}
