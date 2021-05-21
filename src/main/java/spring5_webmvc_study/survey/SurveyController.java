package spring5_webmvc_study.survey;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/survey")
public class SurveyController {
	@GetMapping
    public String form() {
        return "survey/surveyForm";
    }

    @PostMapping
    public String submit(@ModelAttribute("ansData") AnsweredData data) {
    	System.out.println("AnsweredData >> " + data);
        return "survey/submitted";
    }

}
