package com.mimimetr.model;


import org.aspectj.util.FileUtil;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.io.File;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class CatService {
    @Autowired
    private CatRepo catRepo;


    public void InsertStandartValues() {

        if (!catRepo.existsById(1L)){
            try {
                Random random = new Random(100);
                for (int f = 1; f <= 4; f++){
                    Cat cat = new Cat();
                    cat.setId(Integer.toUnsignedLong(f));
                    cat.setName("Cat number " + f);


                    cat.setPicture(FileUtil.readAsByteArray(
                            new File(
                                    (new File("").getAbsolutePath()) + "/target/classes" + "/static/img/" + Integer.toString(f) + ".jpg"
                            )
                    ));


                    cat.setRating(random.nextInt(100));

                    catRepo.save(cat);
                }
            } catch (Exception ex){
                System.out.println(ex.getMessage());
            }
        }


    }

    public List<Cat> GetAllCats(){
        List<Cat> cats = new ArrayList<>();
        catRepo.findAll().forEach(cats::add);
        return cats;
    }

    public Cat GetCatById(Long id){
        Optional<Cat> cat_op = catRepo.findById(id);
        return cat_op.orElse(null);
    }

    public void SaveCat(Cat cat){
        catRepo.save(cat);
    }
}
