package jp.co.sfk25.annually_report;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping(value = "/")
    public String index() {
        return "index";
    }
    @RequestMapping(value = "/sample")
    public String sample() {
        return "index";
    }
}
