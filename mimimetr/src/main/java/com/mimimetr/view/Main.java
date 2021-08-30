package com.mimimetr.view;

import com.mimimetr.model.Cat;
import com.mimimetr.model.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

@Controller
public class Main {
    @Autowired
    private CatService catService;

    @GetMapping("/")
    public String just_main(Model model){
        catService.InsertStandartValues();
        model.addAttribute("cats", catService.GetAllCats());
        return "main";
    }

    @RequestMapping(value = "/get_picture/{id}")
    public ResponseEntity<byte[]> get_picture(@PathVariable("id") String id) throws SQLException, IOException {
        Cat cat = catService.GetCatById(Long.parseLong(id));
        if (cat != null){
            HttpHeaders httpHeaders = new HttpHeaders();
            InputStream img_stream = new ByteArrayInputStream(cat.getPicture());
            InputStreamResource inputStreamResource = new InputStreamResource(img_stream);
            httpHeaders.setContentLength(inputStreamResource.contentLength());

            InputStream img_stream2 = new ByteArrayInputStream(cat.getPicture());
            InputStreamResource inputStreamResource2 = new InputStreamResource(img_stream2);
            return new ResponseEntity(inputStreamResource2, httpHeaders, HttpStatus.OK);
        } else {
            return null;
        }
    }

    @GetMapping(value="/vote")
    public String votes(HttpServletRequest request, Model model, @RequestParam(value = "cat_num", defaultValue = "1") int num){
        HttpSession session = request.getSession();
        List<Cat> cats = catService.GetAllCats();
        boolean is_over = false;
        int cur_cat_n = 1;
        int cur_sub_cat_n = 2;

        if (session.getAttribute("current_cat") != null){
            cur_cat_n = (int)session.getAttribute("current_cat");
            cur_sub_cat_n = (int)session.getAttribute("current_sub_cat");


            Cat ccat = cats.get(cur_cat_n-1);
            Cat scat = cats.get(cur_sub_cat_n-1);
            if (num == 1){
                ccat.setRating(ccat.getRating()+1);
                catService.SaveCat(ccat);
            } else {
                scat.setRating(scat.getRating()+1);
                catService.SaveCat(scat);
            }



            int max = cats.size();
            if (cur_sub_cat_n == max) {
                if (cur_cat_n+1 == max) {
                    is_over = true;

                }
                else {
                    cur_cat_n += 1;
                    cur_sub_cat_n = cur_cat_n + 1;
                }
            }
            else {
                cur_sub_cat_n += 1;
            }

            if (is_over){
                session.setAttribute("current_cat", null);
                session.setAttribute("current_sub_cat", null);
            } else {
                session.setAttribute("current_cat", cur_cat_n);
                session.setAttribute("current_sub_cat", cur_sub_cat_n);
            }


        } else {
            session.setAttribute("current_cat", cur_cat_n);
            session.setAttribute("current_sub_cat", cur_sub_cat_n);
        }



        if (is_over) return "redirect:/";
        else{
            Cat cur_cat = cats.get(cur_cat_n-1);
            Cat sub_cat = cats.get(cur_sub_cat_n-1);

            model.addAttribute("cur_cat", cur_cat);
            model.addAttribute("sub_cat", sub_cat);
            return "vote";
        }
    }
}
