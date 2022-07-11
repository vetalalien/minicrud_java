package com.vetalalien.miniservice.controllers;

import com.vetalalien.miniservice.dto.CommonEntityFilterDto;
import com.vetalalien.miniservice.dto.Create;
import com.vetalalien.miniservice.dto.PaginationDto;
import com.vetalalien.miniservice.dto.Person;
import com.vetalalien.miniservice.service.ProductApi;
import com.vetalalien.miniservice.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/v1/user")
@Slf4j
public class PersonController extends CrudController<Person> implements ProductApi { //смысл апишек, что они являются фейн-клиентами, вызываемыми из другого сервиса
    //ниже есть метод /filtered, который не помещён в ProductApi, поскольку он не требуется для других сервисов

    @Autowired
    private PersonService personService;

    @Override
    protected CrudService<Person> getCrudService() {
        return personService;
    }

    @Override
    //@AuditableMethod(name = "Создание", operationEntity = Product.class, idExtractorClass = FromResultEntityIdExtractor.class)
    public Person save(@Validated({Create.class}) @RequestBody Person request) {
        return super.save(request);
    }


    @RequestMapping(value = "/filtered", method = RequestMethod.POST)
    public PaginationDto<Person> getProductByFilter(@RequestBody CommonEntityFilterDto filter) {
        return personService.filtered(filter);
    }

    //@RequestMapping(value = "/ready", method = RequestMethod.GET)
//    public ResponseEntity<String> checkReadiness() {
//        try {
//            PersonEntity person = personService.findMyFirst();
//            if (person != null) return ResponseEntity.ok("No person found, but DB engine is ready");
//            else {
//                return ResponseEntity.ok("Some person was found, DB engine is ready");
//            }
//        } catch (Exception e){
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something is wrong" + e.getMessage());
//        }
//    }

}

