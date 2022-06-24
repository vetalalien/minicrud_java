package com.vetalalien.miniservice.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainPageController {
    @GetMapping("/")
    ResponseEntity checkHealth(){
        return ResponseEntity.ok(
      "<h2>"

        + "Hello, Otus World!!!"
        + "</h2>"
        + "<p><ul>"
        + "<li>Для создания пользователя используйте POST /v1/user</li>"
        + "<li>Для чтения всех пользователей используйте GET /v1/user/"
        + "<li>Для чтения пользователя с идентификатором user_id используйте POST /v1/user/{user_id}"
        + "<li>Для обновления пользователя с идентификатором user_id используйте PUT /v1/user/{user_id}"
        + "<li>Для удаления пользователя с идентификатором user_id используйте DELETE /v1/user/{user_id}"
        + "</ul></p>"
        + "<h4>"
        +  "Формат представления данных пользователя:"
        + "</h4>"
        + "<p>"
        +  "{"
        + "<br>  \"id\": long,"
        + "<br>  \"firstName\": string,"
        + "<br>  \"lastName\": string,"
        + "<br>  \"middleName\": string,"
        + "<br>}"
        + "</p>"
        );
    }
}