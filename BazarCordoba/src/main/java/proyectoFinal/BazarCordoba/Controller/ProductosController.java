
package proyectoFinal.BazarCordoba.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import proyectoFinal.BazarCordoba.Service.IProductoService;
import proyectoFinal.BazarCordoba.Model.Producto;



@RestController
public class ProductosController {
    
    @Autowired 
    private IProductoService IProduServ;
    
    @PostMapping("/productos/crear")
    
    public String createProducto(@RequestBody Producto unProducto){
        
        IProduServ.saveProducto(unProducto);
        
        return "se ah creado con exito";
    }
    
    @GetMapping("/productos")
    
    public List<Producto> getProductos(){
        
        return IProduServ.getProductos();
        
    }
    
    @GetMapping("/productos/{codigo_producto}")
    
    public Producto getUnProducto(@PathVariable Long codigo_producto){
        
        return IProduServ.findProducto(codigo_producto);
         
    }
    
    @DeleteMapping ("/productos/eliminar/{codigo_producto}")
    
    public String deleteProducto(@PathVariable Long codigo_producto){
        
        IProduServ.deleteProducto(codigo_producto);
        
        return "se ah eliminado correctamente";
        
    }
    
    @PutMapping("/productos/editar")
    
    public Producto editProductos(@RequestBody Producto unProducto){
        
        IProduServ.editProducto(unProducto);
        
        return IProduServ.findProducto(unProducto.getCodigo_producto());
        
    }
    
    @GetMapping ("/productos/falta_stock")
    
    public List<Producto> FaltaStock(){
        
       return IProduServ.faltaStock();
        
    }
    
}
