package com.restfull.activos.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.restfull.activos.Services.ArticuloService;

@RestController
@RequestMapping("/")
public class OtroController {

  @GetMapping("/algo")
  public ResponseEntity<String> test() {
    return ResponseEntity.ok("test");
  }
}
