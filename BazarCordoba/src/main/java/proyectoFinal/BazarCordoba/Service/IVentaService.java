
package proyectoFinal.BazarCordoba.Service;
import java.time.LocalDate;
import proyectoFinal.BazarCordoba.Model.Venta;
import java.util.List;
import proyectoFinal.BazarCordoba.Model.DetalleVenta;


public interface IVentaService {
    
    public void saveVenta(Venta unaVenta);
    
    public void deleteVenta(Long codigo_venta);
    
    public List<Venta> getVenta();
    
    public Venta findVentaByCod(Long codigo_venta);
    
    public void editVenta(Venta unaVenta);
     
    public List<DetalleVenta> getDetalleVentaPorCodigoVenta(Long codigo_venta);
    
    public List<Venta> getPorFecha(LocalDate fecha_venta);
    
    public List<Venta> listaComprasCliente(Long id_cliente);
    
    
}
