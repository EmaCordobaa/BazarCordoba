
package proyectoFinal.BazarCordoba.Service;
import proyectoFinal.BazarCordoba.Model.Cliente;
import java.util.List;


public interface IClienteService {
    
    public void saveCliente(Cliente unCliente);
    
    public void deleteCliente(Long id_cliente);
    
    public List<Cliente> getClientes();
    
    public Cliente findCliente(Long id_cliente);
    
    public void editCliente(Cliente unCliente);
    
    
}
