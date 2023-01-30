package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

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

	@GetMapping("/feed")
	public String feed(@RequestParam(name="Clarence", required=false, defaultValue="planty") String name, Model model){
		model.addAttribute("Clarence", name);
		Post plant = new Post(01, 01, 00, "plantbert", "green", "not green", "Alana", "pretty dead", "dfdhsjkf");
		ArrayList<Post> posts = new ArrayList<>();
		posts.add(plant);
		model.addAttribute(posts);
		return "/feed";
	}
}