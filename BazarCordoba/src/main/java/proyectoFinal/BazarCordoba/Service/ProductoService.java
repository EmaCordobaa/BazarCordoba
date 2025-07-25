
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
    
    @Override
    public void saveProducto(Producto unProducto) {
       
        IProdRepo.save(unProducto);
       
    }

    @Override
    public void deleteProducto(Long codigo_producto) {
        
        IProdRepo.deleteById(codigo_producto);
        
    }

    @Override
    public List<Producto> getProductos() {
        
        List<Producto> listaProductos = IProdRepo.findAll();
        return listaProductos;
        
    }

    @Override
    public Producto findProducto(Long codigo_producto) {
        
       return IProdRepo.findById(codigo_producto).orElse(null);
        
    }

    @Override
    public void editProducto(Producto unProducto) {
            
        this.saveProducto(unProducto);
    
    }

    @Override
    public List<Producto> faltaStock() {
        
        List<Producto> listaProductos = IProdRepo.findAll();
        
        List<Producto> faltaStock = listaProductos.stream().filter(p-> p.getCantidad_disponible() > 5).collect(Collectors.toList());
        
        return faltaStock;
        
        
    }

    
    
}
