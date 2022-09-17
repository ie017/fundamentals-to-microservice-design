package com.example.mecroservicesdemo.Produit;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
@RequestMapping(path = "/produit")
@AllArgsConstructor
public class ProduitRestController {
    private ProduitRepository produitRepository;

    @GetMapping(path = "/list")
    public List<Produit> produitList(){
        return produitRepository.findAll();
    }
    @GetMapping(path = "/{id}")
    public Produit produit(@PathVariable String id){
        return produitRepository.findById(id).get();
    }
    @PostMapping(path = "/save")
    public Produit saveProduit(@RequestBody Produit produit){
        return produitRepository.save(produit);
    }
    @PutMapping(path = "/change/{id}")
    public void changeProduit(@PathVariable String id, @RequestParam(name = "name") String name){
        Produit produit = produitRepository.findById(id).get();
        produit.setName(name);
        produitRepository.save(produit);
    }
    @DeleteMapping(path = "/delete/{id}")
    public void deleteProduit(@PathVariable String id){
        produitRepository.deleteById(id);
    }
}
//Pour utiliser Spring data rest il faut désactiver RestController
