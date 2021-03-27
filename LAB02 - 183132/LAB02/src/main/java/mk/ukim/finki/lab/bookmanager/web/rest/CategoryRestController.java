package mk.ukim.finki.lab.bookmanager.web.rest;

import mk.ukim.finki.lab.bookmanager.model.enumerations.EnumCategory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/restapi/categories")
public class CategoryRestController {

    @GetMapping
    public List<EnumCategory> getAllCategories() {
        return listCategories();
    }


    public List<EnumCategory> listCategories() {
        return Arrays.asList(EnumCategory.values());
    }

}
