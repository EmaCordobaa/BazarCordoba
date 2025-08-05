 
package proyectoFinal.BazarCordoba.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyectoFinal.BazarCordoba.Model.Cliente;
import proyectoFinal.BazarCordoba.Repository.IClienteRepository;

@Service
public class ClienteService implements IClienteService{
    
    @Autowired
    private IClienteRepository IClienRepo;
    
    
    //CREAR CLIENTE
    @Override
    public void saveCliente(Cliente unCliente) {
        
        IClienRepo.save(unCliente);
        
    }
    
    
    //BORRAR CLIENTE
    @Override
    public void deleteCliente(Long id_cliente) {
        
        IClienRepo.deleteById(id_cliente);
        
    }
    
    
    //OBTENER LISTA CLIENTES
    @Override
    public List<Cliente> getClientes() {
        
        List<Cliente> listaClientes = IClienRepo.findAll();
        return listaClientes;
                
    }
    
    
    //OBTENER CLIENTE ESPECIFICO 
    @Override
    public Cliente findClienteByID(Long id_cliente) {
       
        return IClienRepo.findById(id_cliente).orElse(null);
        
    }
    
    
    //EDITAR CLIENTE 
    @Override
    public void editCliente(Cliente unCliente) {
        
        IClienRepo.save(unCliente);
        
    }




}
    

