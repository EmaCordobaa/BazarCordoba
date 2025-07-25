
package proyectoFinal.BazarCordoba.Service;
import proyectoFinal.BazarCordoba.Model.Producto;
import java.util.List;



public interface IProductoService {
    
    public void saveProducto(Producto unProducto);
    
    public void deleteProducto(Long codigo_producto);
    
    public List<Producto> getProductos();
    
    public Producto findProducto(Long codigo_producto);
    
    public void editProducto(Producto unProducto);
    
    public List<Producto> faltaStock ();
    
    
}
