package hello.springmvc.basic.request;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;

@Slf4j
@Controller
public class RequestParamController {

        @RequestMapping("/request-param-v1")
        public void requestParamV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
            String username = request.getParameter("username");
            int age = Integer.parseInt(request.getParameter("age"));
            log.info("username = {}, age={}", username, age);

            response.getWriter().write("ok");

        }

        @ResponseBody //Stirng을 ResponseBody에 반환 가능
        @RequestMapping("/request-param-v2")
        public String requestPramV2(
                @RequestParam("username") String memberName,
                @RequestParam("age") int memberAge ){

            log.info("username={}, age={}", memberName, memberAge);
            return "ok";
        }

        @ResponseBody //Stirng을 ResponseBody에 반환 가능
        @RequestMapping("/request-param-v3")
        public String requestPramV3(
                @RequestParam String username,
                @RequestParam int age){

            log.info("username={}, age={}", username, age);
            return "ok";
        }

        @ResponseBody //Stirng을 ResponseBody에 반환 가능
        @RequestMapping("/request-param-v4")
        public String requestPramV4(String username, int age){

            log.info("username={}, age={}", username, age);
            return "ok";
        }

        /**
         * required = true 인 값은 필수
         * required = false 인 값은 선택
         * 만약 false값에 null이 들어가게 할려면 int가 아닌 Integer로 선언 해야함
         * 기본형은 null XX
         */
        @ResponseBody //Stirng을 ResponseBody에 반환 가능
        @RequestMapping("/request-param-required")
        public String requestPramRequired(
                @RequestParam(required = true) String username,
                @RequestParam(required = false) Integer age){

            log.info("username={}, age={}", username, age);
            return "ok";
        }

        /**
         * defaultValue를 설정하면 기본값을 할당할 수 있다.
         * 빈문자(username= )일떄도 기본값으로 할당.
         */
        @ResponseBody
        @RequestMapping("/request-param-default")
        public String requestPramDefault(
                @RequestParam(required = true, defaultValue = "guest") String username,
                @RequestParam(required = false, defaultValue = "-1") Integer age){

            log.info("username={}, age={}", username, age);
            return "ok";
        }

        /**
         * parameter를 map으로 받을수 있다
         */
        @ResponseBody
        @RequestMapping("/request-param-map")
        public String requestPramMap(@RequestParam Map<String, Objects> paramMap) {
            log.info("username={}, age={}", paramMap.get("username"), paramMap.get("age"));
            return "ok";
        }

//        @ResponseBody
//        @RequestMapping("/model-atrribute-v1")
//        public String modelAttributeV1(@)
//        }

}
