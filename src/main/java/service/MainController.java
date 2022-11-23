package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
	@Autowired
	private SqlDB sqlDB;

	@GetMapping("/")
	public String index() {
		return "index";
	}

	@GetMapping("/hello")
	public String hello(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("name", name);
		return "hello";
	}

	public void uploadPost() {
		Post test = new Post(null, 600, 16, "Penguins", "Left", "Dead", "Sophia", "Penguins!", "https://flowermag.com/wp-content/uploads/2018/02/shasta-daisies-becky-1000x669.jpg");

		SqlDB.uploadPost(test);
	}
}