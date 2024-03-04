package com.example.Proyecto1.Controllers;

import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class RestNumController {
    public ArrayList<Integer> lista= new ArrayList<Integer>();


 @RequestMapping(value = "/addJsNumber",consumes = "application/json")
 public ResponseEntity<String> addNumber(@RequestBody Map<String, String> numeroAleatorio) {
     numeroAleatorio.forEach((key,value)->{
         System.out.println(key+"value: "+ value);
     });
     if(numeroAleatorio.containsKey("numero")){
          lista.add(Integer.valueOf(numeroAleatorio.get("numero")));
     }

     return ResponseEntity.ok("algo");
   }
}
