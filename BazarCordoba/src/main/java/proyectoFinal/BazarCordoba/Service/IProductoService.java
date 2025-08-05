
package proyectoFinal.BazarCordoba.Service;
import proyectoFinal.BazarCordoba.Model.Producto;
import java.util.List;



public interface IProductoService {
    
    public void saveProducto(Producto unProducto);
    
    public void deleteProductoByCod(Long codigo_producto);
    
    public List<Producto> getListaProductos();
    
    public Producto findProductoByCod(Long codigo_producto);
    
    public void editProducto(Producto unProducto);
    
    public List<Producto> faltaStock ();
    
    public void devolucionDeProducto(Long codigo_producto,Double cantidad_producto);
    
}
