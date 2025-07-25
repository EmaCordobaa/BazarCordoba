 
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
    
    @Override
    public void saveCliente(Cliente unCliente) {
        
        IClienRepo.save(unCliente);
        
    }

    @Override
    public void deleteCliente(Long id_cliente) {
        
        IClienRepo.deleteById(id_cliente);
        
    }

    @Override
    public List<Cliente> getClientes() {
        
        List<Cliente> listaClientes = IClienRepo.findAll();
        return listaClientes;
                
    }

    @Override
    public Cliente findCliente(Long id_cliente) {
       
        return IClienRepo.findById(id_cliente).orElse(null);
        
    }

    @Override
    public void editCliente(Cliente unCliente) {
        
        IClienRepo.save(unCliente);
        
    }
    
}
