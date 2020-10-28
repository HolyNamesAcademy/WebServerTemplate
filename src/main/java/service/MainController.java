package service;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

	@GetMapping("/subject")
	public String subject(@RequestParam(name="subject", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("subject", name);
		return "subject";
	}


}