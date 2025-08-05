package proyectoFinal.BazarCordoba.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import proyectoFinal.BazarCordoba.Service.IClienteService;
import proyectoFinal.BazarCordoba.Model.Cliente;

@RestController
public class ClienteController {
    
    @Autowired 
    private IClienteService IClienServ;
    
    //CREAR CLIENTE
    @PostMapping("/cliente/crear")
    public String createCliente(@RequestBody Cliente unCliente){
        
        IClienServ.saveCliente(unCliente);
        
        return "se ah creado con exito";
    }
    
    //OBTENER LISTA DE CLIENTES
    @GetMapping("/cliente")
    public List<Cliente> getCliente(){
        
        return IClienServ.getClientes();
        
    }
    
    //BUSCAR CLIENTE BY ID
    @GetMapping("/cliente/{id_cliente}")
    
    public Cliente getUnaCliente(@PathVariable Long id_cliente){
        
        return IClienServ.findClienteByID(id_cliente);
         
    }
    
    //ELIMINAR CLIENTE
    @DeleteMapping ("/cliente/eliminar/{id_cliente}")
    
    public String deleteCliente(@PathVariable Long id_cliente){
        
        IClienServ.deleteCliente(id_cliente);
        
        return "se ah eliminado correctamente";
        
    }
    
    //EDITAR CLIENTE
    @PutMapping("/cliente/editar")
    
    public Cliente editCliente(@RequestBody Cliente unCliente){
        
        IClienServ.editCliente(unCliente);
        
        return IClienServ.findClienteByID(unCliente.getId_cliente());
         
    }
    
}
