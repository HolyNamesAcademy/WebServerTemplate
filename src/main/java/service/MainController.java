package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

	/* function httpGet(Url)
	{
		var xmlHttp = new XMLHttpRequest();
		xmlHttp.open( "GET", https://house-plants.p.rapidapi.com/common/coralberry, false ); // false for synchronous request
		xmlHttp.send( https://house-plants.p.rapidapi.com/common/coralberry );
		return xmlHttp.responseText;
	}
	HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
	public respHttpResponse<String> getResponse() {return response;}
	 */

	@GetMapping("/upload") // change to post later
	public String uploadPost() {
		// Post(int PlantId, int Age, String PlantName, String Species, String Status, String NameOfUser, String Caption, String PhotoUrl)
		Post test = new Post(459, 987, "hi", "kjhgfd", "jgyhtg", "Sophia", "Penguins!", "https://flowermag.com/wp-content/uploads/2018/02/shasta-daisies-becky-1000x669.jpg");

	@GetMapping("/feed")
	public String feed(@RequestParam(name="Clarence", required=false, defaultValue="planty") String name, Model model){
		model.addAttribute("Clarence", name);
		Post plant = new Post(01, 01, 00, "plantbert", "green", "not green", "Alana", "pretty dead", "dfdhsjkf");
		ArrayList<Post> posts = new ArrayList<>();
		posts.add(plant);
		model.addAttribute(posts);
		return "/feed";
	}

		sqlDB.uploadPost(test);
		return "index";
	}
}