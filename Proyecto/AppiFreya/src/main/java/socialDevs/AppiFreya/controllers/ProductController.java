package socialDevs.AppiFreya.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import socialDevs.AppiFreya.models.ProductModel;
import socialDevs.AppiFreya.services.ProductService;

@RestController
@RequestMapping("/producto")
public class ProductController {
    
    @Autowired
    ProductService productService;

    @GetMapping()
    public ArrayList<ProductModel> obtenerProductos(){
        return productService.obtenerProductos();
    }
    
    @GetMapping(path = "/{nombre}")
    public ArrayList<ProductModel> obtenerPorNombre(@PathVariable ("nombre") String nombre){
        return this.productService.obtenerPorNombre(nombre);
    }

    @GetMapping("/query")
    public ArrayList<ProductModel> obtenerPorPrecio(@RequestParam("precio")Integer precio){
        return this.productService.obtenerPorPrecio(precio);
    }

}
