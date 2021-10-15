package socialDevs.AppiFreya.controllers;



import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import socialDevs.AppiFreya.models.UsuarioModel;
import socialDevs.AppiFreya.services.UsuarioService;


@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    
    @Autowired
    UsuarioService usuarioService;

    /* Se obtiene el listado de Usuario*/
    @GetMapping()
    public ArrayList<UsuarioModel> obtenerUsuarios(){
        return usuarioService.obtenerUsuarios();
    }

     /* Se va guarda el usuario */
    @PostMapping()
    public UsuarioModel guardarUsuario(@RequestBody UsuarioModel usuario){
        return this.usuarioService.guardarUsuario(usuario);
    }

    /* Obtiene el usuario por Id */
    @GetMapping(path = "/{id}")
    public Optional<UsuarioModel> obtenerUsuarioPorID(@PathVariable("id") long id /* Parametro por variable */){
        return this.usuarioService.obtenerPorID(id);
    }

    /* Se realiza la consulta por email con query */
    @GetMapping("/query")
    public ArrayList<UsuarioModel> obtenerPorEmail(@RequestParam("email") String email){
        return this.usuarioService.obtenerPorEmail(email);
    }

    /* Eliminando un Usuario*/
    @DeleteMapping(path = "/{id}")
    public String eliminarPorID(@PathVariable("id") long id){
        boolean ok = this.usuarioService.eliminarUsuario(id);
        if (ok){
            return "Se eliminó correctamente el usuaio" + id;
        } else {
            return "No se pudo eliminar el usuario " + id;
        }
    }
}
