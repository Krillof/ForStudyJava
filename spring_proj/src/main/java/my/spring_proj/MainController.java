package my.spring_proj;

import my.spring_proj.model.DoTask;
import my.spring_proj.model.MyDB;
import my.spring_proj.model.entities.Competition;
import my.spring_proj.model.entities.Result;
import my.spring_proj.model.entities.Sportsman;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    @GetMapping("/")
    public String hello(
            Model model
    ) {
        model.addAttribute("competitions", MyDB.getAllCompetitions());
        model.addAttribute("results", MyDB.getAllResults());
        model.addAttribute("sportsmans", MyDB.getAllSportsmans());

        model.addAttribute("competitions_h", DoTask.justGetHeader(Competition.class));
        model.addAttribute("results_h",  DoTask.justGetHeader(Result.class));
        model.addAttribute("sportsmans_h", DoTask.justGetHeader(Sportsman.class));

        return "index";
    }

    @GetMapping("/task/{id}")
    public String task(
            @PathVariable("id") int id,
            @RequestParam(value = "sportsman_id", required = false, defaultValue = "1") int sp_id,
            @RequestParam(value = "competition_id", required = false, defaultValue = "1") int cp_id,
            Model model
    ){

        DoTask.sportman_id_param = sp_id;
        DoTask.competition_id_param = cp_id;

        model.addAttribute("id", id);
        model.addAttribute("values", DoTask.withNumber(id));
        model.addAttribute("header", DoTask.getLastTaskHeader());
        return "task_res";
    }
}
