
package proyectoFinal.BazarCordoba.Service;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyectoFinal.BazarCordoba.Model.Producto;
import proyectoFinal.BazarCordoba.Repository.IProductoRepository;


@Service     
public class ProductoService implements IProductoService{
    
    @Autowired
    private IProductoRepository IProdRepo;
    
    
    //CREAR PRUDUCTO 
    @Override
    public void saveProducto(Producto unProducto) {
       
        IProdRepo.save(unProducto);
       
    }
    
    //BORRAR PRODUCTO
    @Override
    public void deleteProductoByCod(Long codigo_producto) {
        
        IProdRepo.deleteById(codigo_producto);
        
    }
    
    //LISTA DE PRODUCTOS 
    @Override
    public List<Producto> getListaProductos() {
        
        List<Producto> listaProductos = IProdRepo.findAll();
        return listaProductos;
        
    }
    
    //TRAER PRODUCTO POR CODIGO
    @Override
    public Producto findProductoByCod(Long codigo_producto) {
        
       return IProdRepo.findById(codigo_producto).orElse(null);
        
    }
    
    //EDITAR PRODUCTO 
    @Override
    public void editProducto(Producto unProducto) {
            
        this.saveProducto(unProducto);
    
    }
    
    //AVISO FALTA STOCK
    @Override
    public List<Producto> faltaStock() {
        
        List<Producto> listaProductos = IProdRepo.findAll();
        
        List<Producto> faltaStock = listaProductos.stream().filter(p-> p.getCantidad_disponible() < 5).collect(Collectors.toList());
        
        return faltaStock;
    
    }
    
    //DEVOLUCION DE UN PRODUCTO
    @Override
    public void devolucionDeProducto(Long codigo_producto,Double cantidad_producto) {
        
        Producto unProducto = IProdRepo.findById(codigo_producto).orElseThrow(() -> new RuntimeException("No se ha encontrado un producto con ese código"));
        unProducto.setCantidad_disponible(unProducto.getCantidad_disponible()+cantidad_producto);
        IProdRepo.save(unProducto);
        
    }

    
    
}
