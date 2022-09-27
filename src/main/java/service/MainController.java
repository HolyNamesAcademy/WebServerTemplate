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
	// the request param section means that this page accepts a query parameter in the url called name.
	// for example, if we had typed the url localhost:8080/hello?name=Sage
	// the value of that parameter stored in a String variable called name that we can use in this method.
	// the parameter is not required, and if we don't provide it, the default value of the name variable will be "World"
	public String hello(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		// make the "name" variable available to use in html
		model.addAttribute("name", name);

		// get the age by calling a method in our database class and make it available to use in html
		int age = SqlDB.getAge(name);
		model.addAttribute("age", age);

		// display the html file called hello.html
		return "hello";
	}
}