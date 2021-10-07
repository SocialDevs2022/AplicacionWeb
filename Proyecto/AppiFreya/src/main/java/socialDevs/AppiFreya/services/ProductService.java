package socialDevs.AppiFreya.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import socialDevs.AppiFreya.models.ProductModel;
import socialDevs.AppiFreya.repositories.ProductRepository;


@Service
public class ProductService {
    
    @Autowired
    ProductRepository productRepository;

    /* Método para listar los productos */
    public ArrayList<ProductModel> obtenerProductos() { 
        return (ArrayList<ProductModel>) productRepository.findAll();
    }
  
    /* Metodo para buscar producto por nombre */
    public ArrayList<ProductModel> obtenerPorNombre(String nombre){ 
        return productRepository.findByNombre(nombre);
    }

    /* Metodo para buscar producto por precio */
    public ArrayList<ProductModel> obtenerPorPrecio(Integer precio){
        return productRepository.findByPrecio(precio);
    }
   
}
