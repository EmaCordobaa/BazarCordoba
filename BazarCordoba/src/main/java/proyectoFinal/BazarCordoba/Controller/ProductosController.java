
package proyectoFinal.BazarCordoba.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
    
    //CREAR PRODUCTO 
    @PostMapping("/producto/crear")
    
    public String createProducto(@RequestBody Producto unProducto){
        
        IProduServ.saveProducto(unProducto);
        
        return "se ah creado con exito";
    }
    
    //LISTA DE PRODUCTOS 
    @GetMapping("/producto")
    
    public List<Producto> getProductos(){
        
        return IProduServ.getListaProductos();
        
    }
    
    //TRAER PRUDUCTO POR CODIGO 
    @GetMapping("/producto/{codigo_producto}")
    
    public Producto getUnProducto(@PathVariable Long codigo_producto){
        
        return IProduServ.findProductoByCod(codigo_producto);
         
    }
    
    //BORRAR PRODUCTO 
    @DeleteMapping ("/producto/eliminar/{codigo_producto}")
    
    public String deleteProducto(@PathVariable Long codigo_producto){
        
        IProduServ.deleteProductoByCod(codigo_producto);
        
        return "se ah eliminado correctamente";
        
    }
    
    //EDITAR PRODUCTO
    @PutMapping("/producto/editar")
    
    public Producto editProductos(@RequestBody Producto unProducto){
        
        IProduServ.editProducto(unProducto);
        
        return IProduServ.findProductoByCod(unProducto.getCodigo_producto());
        
    }
    
    //CONSULTA DE FALTA DE STOCK 
    @GetMapping ("/producto/falta_stock")
    
    public List<Producto> FaltaStock(){
        
       return IProduServ.faltaStock();
        
    }
    
    //DEVOLUCION DE PRODUCTO 
    @PutMapping("/producto/devolucion/{codigo_producto}/{cantidad_producto}")
    public void devolucionDeproducto(@PathVariable Long codigo_producto,
                                     @PathVariable Double cantidad_producto){
        
           IProduServ.devolucionDeProducto(codigo_producto, cantidad_producto);
        
    }
        
        
}
