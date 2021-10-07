package socialDevs.AppiFreya.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import socialDevs.AppiFreya.models.UsuarioModel;
import socialDevs.AppiFreya.repositories.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;
    
    /* Método para listar los usuarios */
    public ArrayList<UsuarioModel> obtenerUsuarios() {
        return (ArrayList<UsuarioModel>) usuarioRepository.findAll();
    }

    /* Guarda un usuario */
    public UsuarioModel guardarUsuario(UsuarioModel usuario){
        return usuarioRepository.save(usuario);
    }

    /* Se obtiene Usuario por ID */
    public Optional<UsuarioModel> obtenerPorID(Long id){
        return usuarioRepository.findById(id); 
    }

    /* Se obtiene Usuario por email */
    public ArrayList<UsuarioModel> obtenerPorEmail(String email){ 
        return usuarioRepository.findByEmail(email);
    }
    
    /* Se obtiene Usuario por nombre */
    public ArrayList<UsuarioModel> obtenerPorNombre(String nombre){ 
        return usuarioRepository.findByNombre(nombre);
    }

    /* Método para eliminar Usuario consultado por Id */    
    public boolean eliminarUsuario(long id){
        try {
            usuarioRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;    
        }
    }

}
