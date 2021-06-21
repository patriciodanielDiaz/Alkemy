package alkemy.challenger.Alkemy.controller;

import alkemy.challenger.Alkemy.model.Category;
import alkemy.challenger.Alkemy.repository.CategoryRepository;
import alkemy.challenger.Alkemy.service.CategoryService;
import alkemy.challenger.Alkemy.util.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.apache.commons.lang3.StringUtils;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api")
public class CategoryController {

    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/categories")
    public ResponseEntity<?> addCategories(@RequestBody @Valid Category category) {

        if (StringUtils.isBlank(category.getName())) {
            return new ResponseEntity(new Message("campo nombre no puede estar vacio."),
                    HttpStatus.BAD_REQUEST);
        }
        if (!StringUtils.isAlpha(category.getName())) {
            return new ResponseEntity(new Message("Debe contener solo letras."),
                    HttpStatus.BAD_REQUEST);
        } else {
            categoryService.createCategory(category);
            return new ResponseEntity(new Message("categoria creada."),
                    HttpStatus.OK);
        }
    }

    @GetMapping("/categories")
    public ResponseEntity<?> getCategories(){
        List<Category> listCategories = categoryService.findAll();
        List<String> listCategoriesByname = new ArrayList<>();
        for (Category c : listCategories) {
            listCategoriesByname.add(c.getName());
        }
        return new ResponseEntity(listCategoriesByname, HttpStatus.OK);
    }
}
