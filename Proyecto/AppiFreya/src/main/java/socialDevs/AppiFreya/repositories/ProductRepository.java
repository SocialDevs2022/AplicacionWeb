package socialDevs.AppiFreya.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import socialDevs.AppiFreya.models.ProductModel;

@Repository
public interface ProductRepository extends CrudRepository<ProductModel,Long>{

    public abstract ArrayList<ProductModel> findByNombre(String nombre);
    public abstract ArrayList<ProductModel> findByPrecio(Integer precio);
    
}
