
package proyectoFinal.BazarCordoba.Service;

import java.util.List;
import proyectoFinal.BazarCordoba.Model.DetalleVenta;

public interface IDetalleDeVentaService {
    
    public List<DetalleVenta> getListDetalleVenta();
    
    public List<DetalleVenta> getByVenta(Long id_venta);
    
    public DetalleVenta GetByIDDetalleVenta(Long id_detalleVenta);
    
    public void deleleDetalleVentaByID(Long id_detalleVenta);
    
    
}
