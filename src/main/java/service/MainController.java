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


		sqlDB.uploadPost(test);
		return "index";
	}

	@GetMapping("/feed")
	public String feed(@RequestParam(name="Clarence", required=false, defaultValue="planty") String name, Model model){
		model.addAttribute("Clarence", name);
		Post plant1 = new Post(01, 01, 00, "plantbert", "green", "not green", "Alana", "pretty dead", "https://asset.bloomnation.com/c_pad,d_vendor:global:catalog:product:image.png,f_auto,fl_preserve_transparency,q_auto/v1627197230/vendor/2864/catalog/product/2/0/20200304122155_file_5e5ef4a3ccb60_5e5ef7b7cd5fa_600b664eac11a._600b6650be20c..jpg");
		Post plant2 = new Post(02, 02, 00, "Belle-adona", "~~blue belle*&^$#@", "livin' life to the fullest", "Alana", "IM BLUE`*%@^!", "https://www.woodlandtrust.org.uk/media/4272/bluebells-close-up-wtml-1024791-web-upload.jpg");


		ArrayList<Post> posts = new ArrayList<Post>();
		posts = sqlDB.viewPosts();
		posts.add(plant1);
		posts.add(plant2);
		model.addAttribute("posts", posts);
		return "/feed";
	}
}