
package proyectoFinal.BazarCordoba.Service;
import java.time.LocalDate;
import proyectoFinal.BazarCordoba.Model.Venta;
import java.util.List;
import proyectoFinal.BazarCordoba.Model.Producto;


public interface IVentaService {
    
    public void saveVenta(Venta unaVenta);
    
    public void deleteVenta(Long codigo_venta);
    
    public List<Venta> getVentas();
    
    public Venta findVenta(Long codigo_venta);
    
    public void editVenta(Venta unaVenta);
     
    public List<Producto> getVentaPorCodigo(Long codigo_venta);
    
    public void getPorFecha(LocalDate fecha_venta);
    
    // public DtoVentaCliente getMayorVenta();
    
}
