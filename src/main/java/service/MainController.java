package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.*;

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

	@GetMapping ("/uploadPage")
	public String uploadPage(Model m){
		Post post = new Post(); // needs arguments but if i keep the default then the upload success page doesn't work
		m.addAttribute("plant");

		List<String> listStatus = Arrays.asList("Alive", "Dead", "Watered", "Un-Watered");
		m.addAttribute("post", post);
		m.addAttribute("listStatus", listStatus);

		return "uploadPage";
	}

	@PostMapping("/uploadPage")
	public String submitUploadPage(@ModelAttribute("post") Post post, Model m, @RequestParam MultipartFile f ){
		m.addAttribute("Age", post.getAge());
		m.addAttribute("PlantName", post.getPlantName());
		m.addAttribute("Species", post.getSpecies());
		m.addAttribute("NameOfUser", post.getNameOfUser());
		m.addAttribute("Caption", post.getCaption());
		m.addAttribute("PhotoUrl", post.getPhotoUrl());
		System.out.print(post);
		BlobServiceClient b = new BlobServiceClient();
		String url;
		try{
			url = b.BlobServiceClient(f);
		}catch(IOException e){
			e.printStackTrace();
			url = "didnt work";
		}
		post.setPhotoUrl(url);


		sqlDB.uploadPost(post);
		return "uploadSuccess";

	}

	@GetMapping ("/delete") // delete testing, works (just need to implement button)
	public String delete(Model m){
		sqlDB.deletePosts(6);

		return "index";
	}

	@GetMapping("/feed")
	public String feed(@RequestParam(name="Clarence", required=false, defaultValue="planty") String name, Model model){
		model.addAttribute("Clarence", name);
		ArrayList<Post> posts = new ArrayList<>();

		TreeMap<Integer, Post> data = sqlDB.viewAllPosts();
		for (Post plant : data.values()) { // enhanced for to loop through all the post and put into an array
			posts.add(plant);
			System.out.print(plant.PlantName);
			System.out.print(plant.PhotoUrl);
			System.out.println(plant.Caption);
		}

		model.addAttribute("posts", posts);
		return "/feed";
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
}