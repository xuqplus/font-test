package cn.xuqplus.fonttest;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Properties;

@SpringBootApplication
public class FontTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(FontTestApplication.class, args);
    }

}
