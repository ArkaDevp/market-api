package com.arka.market.web.controller;

import com.arka.market.domain.dto.ShoppingDTO;
import com.arka.market.domain.service.ShoppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shopping")
public class ShoppingController {
    private final ShoppingService shoppingService;

    @Autowired
    public ShoppingController(ShoppingService shoppingService) {
        this.shoppingService = shoppingService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<ShoppingDTO>> getAll(){
        return new ResponseEntity<>(shoppingService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/client/{id}")
    public ResponseEntity<List<ShoppingDTO>> getByClient(@PathVariable("id") String clientId){
        return shoppingService.getByClient(clientId)
                .map(shoppingDTOS -> new ResponseEntity<>(shoppingDTOS, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }

    @PostMapping("/save")
    public ResponseEntity<ShoppingDTO> save(@RequestBody ShoppingDTO shoppingDTO) {
        return new ResponseEntity<>(shoppingService.save(shoppingDTO), HttpStatus.CREATED);
    }
}
