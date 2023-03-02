package by.itstep.session.web;

import by.itstep.session.model.Car;
import by.itstep.session.model.UserForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/test")
public class TestController {

    @GetMapping("/echo")
    public ModelAndView test(@RequestParam String msg, HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        String title = "It Step session example";
        modelAndView.setViewName("index.html");
        modelAndView.addObject("msg", msg);
        modelAndView.addObject("title", title);
        session.setAttribute("echoMsg", msg);
        session.setAttribute("title", title);
        return modelAndView;
    }

    @GetMapping("/forward")
    public ModelAndView forward(ModelAndView modelAndView, HttpSession session) {
        String echoMsg = session.getAttribute("echoMsg").toString();
        String title = session.getAttribute("title").toString();
        modelAndView.addObject("echo", echoMsg);
        modelAndView.addObject("title", title);
        modelAndView.setViewName("forward");
        return modelAndView;
    }

    @PostMapping("/postForm")
    public ModelAndView handleForm(UserForm form, ModelAndView modelAndView) {
        modelAndView.addObject("name", form.getName());
        modelAndView.addObject("age", form.getAge());
        modelAndView.setViewName("greetings");
        return modelAndView;
    }


    @GetMapping("/car")
    public @ResponseBody Car getCar() {
        return Car.builder()
                .id(1L)
                .name("Subaru")
                .weight(1.3F)
                .build();
    }
}
