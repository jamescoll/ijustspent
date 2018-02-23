package com.budgetmaster.main.controllers.incomes;

import com.budgetmaster.main.controllers.BaseController;
import com.budgetmaster.main.models.incomes.IncomeCategory;
import com.budgetmaster.main.repositories.incomes.IncomeCategoryRepository;
import com.budgetmaster.main.repositories.resources.IconRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1")
public class IncomeCategoryController extends BaseController {


    @Autowired
    IncomeCategoryRepository incomeCategoryRepository;

    @Autowired
    IconRepository iconRepository;

    @RequestMapping(value = "/incomecategories", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> getIncomeCategories() {

        return ok(incomeCategoryRepository.findAll());

    }

    @RequestMapping(value = "/incomecategories/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> getIncomeCategory(@PathVariable String id) {

        return ok(incomeCategoryRepository.findById(id));

    }

    @RequestMapping(value = "/incomecategories/icon/{id}", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> createIncomeCategory(
            @PathVariable String id,
            @RequestBody IncomeCategory incomeCategory
    ) {

        iconRepository.findById(id).ifPresent(incomeCategory::setIcon);

        return ok(incomeCategoryRepository.save(incomeCategory));

    }

    @RequestMapping(value = "/incomecategories/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<?> deleteIncomeCategory(@PathVariable String id) {

        incomeCategoryRepository.deleteById(id);

        //todo fix all of these in delete as we don't want to be returning emptiness
        return ok();

    }

    @RequestMapping(value = "/incomecategories", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<?> deleteIncomeCategories() {

        incomeCategoryRepository.deleteAll();

        return ok();

    }

    @RequestMapping(value = "/incomecategories/icon/{iconId}", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<?> updateIncomeCategory(
            @PathVariable String iconId,
            @RequestBody IncomeCategory incomeCategory) {

        iconRepository.findById(iconId).ifPresent(incomeCategory::setIcon);

        return ok(incomeCategoryRepository.save(incomeCategory));

    }


}
