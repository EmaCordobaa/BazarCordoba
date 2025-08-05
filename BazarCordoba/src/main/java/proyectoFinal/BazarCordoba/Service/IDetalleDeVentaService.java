
package proyectoFinal.BazarCordoba.Service;

import java.util.List;
import proyectoFinal.BazarCordoba.Model.DetalleVenta;

public interface IDetalleDeVentaService {
    
    public void saveDetalleVenta(DetalleVenta  unDetalleVenta);
    
    public List<DetalleVenta> getListDetalleVenta();
    
    public List<DetalleVenta> getByVenta(Long codigo_venta);
    
    public DetalleVenta GetByIDDetalleVenta(Long id_detalleVenta);
    
    public void deleleDetalleVentaByID(Long id_detalleVenta);
    
    public void editDetalleVenta(DetalleVenta unDetalleVenta);

}
