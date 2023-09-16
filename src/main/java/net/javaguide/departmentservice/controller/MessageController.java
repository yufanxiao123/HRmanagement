package net.javaguide.departmentservice.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope //@RefreshScope annotation indicates that the configuration properties for this bean (MessageController) can be refreshed at runtime.
@RestController
//github中配置的自动更新，必须通过refresh rate api激活，即http://localhost:8080/actuator/refresh，(每个application根据地址不同，uri不同)或者使用SPRING CLOUD BUS
public class MessageController {
   private String message;

   @GetMapping("message")
   private String getMessage(@Value("${spring.boot.message}") String message){
      this.message=message;
      return this.message;
   }
}
