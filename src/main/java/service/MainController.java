package service;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.*;

@Controller
public class MainController {

    @GetMapping("/")
    public String home() {

        return "Home";
    }

    @GetMapping("/Department")
    public String department(@RequestParam(name = "department", required = true) String department, Model model) {
        model.addAttribute("department", department); // make the variable subject available in your html
        // this is where you call methods you've written to get information from your database, then store it a variable
        // and call model.addAttribute with that variable so you can use it in your html

        //Fix this code-
        ConnectToTeacherDatabase database = new ConnectToTeacherDatabase();
        ArrayList<String> teacherNames = database.getDepartmentNames(department);
        model.addAttribute("teachers", teacherNames);

        return "department";

        //model.addAttribute("teachers", teacherNames); // make the variable subject available in your html
        // this is where you call methods you've written to get information from your database, then store it a variable
        // and call model.addAttribute with that variable so you can use it in your html
    }

    @GetMapping("/Teacher")
    public String teacher(@RequestParam(name = "teacher", required = true) String teacher, Model model) {
        model.addAttribute("teacher", teacher); // make the variable subject available in your html
        // this is where you call methods you've written to get information from your database, then store it a variable
        // and call model.addAttribute with that variable so you can use it in your html

        //fix below
        ArrayList<Recommendations> studentRecommendation = ConnectToStudentDatabase.recommendationInfo();
        model.addAttribute("studentRecommendation", studentRecommendation);

        return "teacher";

        //model.addAttribute("teachers", teacherNames); // make the variable subject available in your html
        // this is where you call methods you've written to get information from your database, then store it a variable
        // and call model.addAttribute with that variable so you can use it in your html
    }

}
