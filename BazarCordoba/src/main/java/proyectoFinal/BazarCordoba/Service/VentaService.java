
package proyectoFinal.BazarCordoba.Service;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyectoFinal.BazarCordoba.Model.Producto;
import proyectoFinal.BazarCordoba.Model.Venta;
import proyectoFinal.BazarCordoba.Repository.IVentaRepository;

    
@Service    
public class VentaService implements IVentaService{
    
    @Autowired private IVentaRepository IVentaRepo;
    
    @Override
    public void saveVenta(Venta unaVenta) {
        
        IVentaRepo.save(unaVenta);      
        
    }

    @Override
    public void deleteVenta(Long codigo_venta) {
        
        IVentaRepo.deleteById(codigo_venta);
        
    }

    @Override
    public List<Venta> getVentas() {
        
        List<Venta> listaVentas = IVentaRepo.findAll();
        return listaVentas;
        
    }

    @Override
    public Venta findVenta(Long codigo_venta) {
        
        return IVentaRepo.findById(codigo_venta).orElse(null);
        
    }

    @Override
    public void editVenta(Venta unaVenta) {
        
        IVentaRepo.save(unaVenta);
        
    }

    
    
    @Override
    public List<Producto> getVentaPorCodigo(Long codigo_venta) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    
    @Override
    public void getPorFecha(LocalDate fecha_venta) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    /*
    @Override
    public DtoVentaCliente getMayorVenta() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    */
    
    
    
    
    
    
    
}
