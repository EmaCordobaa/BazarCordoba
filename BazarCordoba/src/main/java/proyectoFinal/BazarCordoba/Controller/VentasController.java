
package proyectoFinal.BazarCordoba.Controller;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import proyectoFinal.BazarCordoba.Model.DetalleVenta;
import proyectoFinal.BazarCordoba.Service.IVentaService;
import proyectoFinal.BazarCordoba.Model.Venta;


@RestController
public class VentasController {
    
    @Autowired 
    private IVentaService IventServ;
    
    //CREAR VENTA
    @PostMapping("/venta/crear")
    public String createVenta(@RequestBody Venta unaVenta){
        
        IventServ.saveVenta(unaVenta);
        
        return "se ah creado con exito";
    }
    
    //LISTA VENTAS
    @GetMapping("/venta")
    public List<Venta> getVentas(){
        
        return IventServ.getVenta();
        
    }
    
    //OBTENER VENTA POR CODIGO
    @GetMapping("/venta/{codigo_venta}")
    
    public Venta getUnaVenta(@PathVariable Long codigo_venta){
        
        return IventServ.findVentaByCod(codigo_venta);
         
    }
    
    //BORRAR VENTA
    @DeleteMapping ("/venta/eliminar/{codigo_venta}")
    
    public String deleteVenta(@PathVariable Long codigo_venta){
        
        IventServ.deleteVenta(codigo_venta);
        
        return "se ah eliminado correctamente";
        
    }
    
    //EDITAR VENTA
    @PutMapping("/venta/editar")
    
    public Venta editVenta(@RequestBody Venta unaVenta){
        
        IventServ.editVenta(unaVenta);
        
        return IventServ.findVentaByCod(unaVenta.getCodigo_venta());
        
    }
    
    //DETALLE DE VENTA DE UNA COMPRA ESPECIFICA
    @GetMapping ("/venta/productos/{codigo_venta}")
    
    public List<DetalleVenta> getListaProdPorCodigo_venta(@PathVariable Long codigo_venta){
    
    return IventServ.getDetalleVentaPorCodigoVenta(codigo_venta);
    
    }
    
    //BUSCAR VENTA POR FECHA
    @GetMapping ("/venta/fecha/{fecha_venta}")
    public void getVentaFecha(@PathVariable LocalDate fecha_venta){
        
        IventServ.getPorFecha(fecha_venta);
           
        
    } 
    
    //TRAER LISTA DE TODAS LAS COMPRAS DE UN CLIENTE ESPECIFICO
    @GetMapping("/venta/compras/{id_cliente}")
    public List<Venta> listaVentasIdCliente(@PathVariable Long id_cliente){
        
        return IventServ.listaComprasCliente(id_cliente);
        
    }
            
}
