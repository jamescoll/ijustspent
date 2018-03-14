package com.ijustspent.main.controllers.resources;

import com.budgetmaster.main.controllers.BaseController;
import com.budgetmaster.main.models.resources.Icon;
import com.budgetmaster.main.repositories.resources.IconRepository;
import com.ijustspent.main.repositories.resources.IconRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1")
public class IconController extends BaseController {


    @Autowired
    IconRepository iconRepository;


    @RequestMapping(value = "/icons", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> getIcons() {
        return ok(iconRepository.findAll());
    }

    @RequestMapping(value = "/icons/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> getIcon(@PathVariable String id) {
        return ok(iconRepository.findById(id));
    }

    @RequestMapping(value = "/icons", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public ResponseEntity<?> createIcon(@RequestBody Icon icon) {

        return ok(iconRepository.save(icon));
    }

    @RequestMapping(value = "/icons", method = RequestMethod.PUT, consumes = "application/json")
    @ResponseBody
    public ResponseEntity<?> updateIcon(@RequestBody Icon icon) {

        return ok(iconRepository.save(icon));
    }

    @RequestMapping(value = "/icons/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<?> deleteIcon(@PathVariable String id) {

        iconRepository.deleteById(id);
        return ok();
    }

    @RequestMapping(value = "/icons", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<?> deleteIcons() {

        iconRepository.deleteAll();
        return ok();
    }


}
