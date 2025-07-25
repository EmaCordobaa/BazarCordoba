/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
import proyectoFinal.BazarCordoba.Model.Producto;
import proyectoFinal.BazarCordoba.Service.IVentaService;
import proyectoFinal.BazarCordoba.Model.Venta;


@RestController
public class VentasController {
    
    @Autowired 
    private IVentaService IventServ;
    
    @PostMapping("/ventas/crear")
    public String createVenta(@RequestBody Venta unaVenta){
        
        IventServ.saveVenta(unaVenta);
        
        return "se ah creado con exito";
    }
    
    @GetMapping("/ventas")
    public List<Venta> getVentas(){
        
        return IventServ.getVentas();
        
    }
    
    @GetMapping("/ventas/{codigo_venta}")
    
    public Venta getUnaVenta(@PathVariable Long codigo_venta){
        
        return IventServ.findVenta(codigo_venta);
         
    }
    
    @DeleteMapping ("/venta/eliminar/{codigo_venta}")
    
    public String deleteVenta(@PathVariable Long codigo_venta){
        
        IventServ.deleteVenta(codigo_venta);
        
        return "se ah eliminado correctamente";
        
    }
    
    @PutMapping("/venta/editar")
    
    public Venta editVenta(@RequestBody Venta unaVenta){
        
        IventServ.editVenta(unaVenta);
        
        return IventServ.findVenta(unaVenta.getCodigo_venta());
        
    }
    
    @GetMapping ("/venta/productos/{codigo_venta}")
    
    public List<Producto> getListaProdPorCodigo_venta(@PathVariable Long codigo_venta){
    
    return IventServ.getVentaPorCodigo(codigo_venta);
    
    }
    
    @GetMapping ("/ventas/{fecha_venta}")
    public void getVentaFecha(@PathVariable LocalDate fecha_venta){
        
        IventServ.getPorFecha(fecha_venta);
           
        
    } 
    /*        
    @GetMapping ("/ventas/mayor_venta")
    public DtoVentaCliente getDto (){
        
        return IventServ.getMayorVenta();
        
        
    }
    */      
            
            
}
