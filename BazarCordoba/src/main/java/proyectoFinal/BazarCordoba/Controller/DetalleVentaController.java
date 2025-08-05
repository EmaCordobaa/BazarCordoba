/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
import proyectoFinal.BazarCordoba.Service.IDetalleDeVentaService;
import proyectoFinal.BazarCordoba.Model.DetalleVenta;

@RestController
public class DetalleVentaController {
    
    @Autowired private IDetalleDeVentaService IDetaVenServ; 
    
    //CREAR DETALLE VENTA
    @PostMapping("/detalleventa/crear")
    public String createDetalleVenta(@RequestBody DetalleVenta unDetalleVenta){
        
        IDetaVenServ.saveDetalleVenta(unDetalleVenta);
        
        return "se ah creado con exito";
                
    }
    
    //TRAER LISTA DETALLES DE VENTA
    @GetMapping("/detalleventa")
    public List<DetalleVenta> getListaDetalleVenta(){
        
        return IDetaVenServ.getListDetalleVenta();
        
    }
    
    //DETALLE DE VENTA POR ID 
    @GetMapping("/detalleventa/{id_detalleVenta}")
    
    public DetalleVenta getDetalleVenta(@PathVariable Long id_detalleVenta){
        
        return IDetaVenServ.GetByIDDetalleVenta(id_detalleVenta);
                
    }
    
    //DETALLES DE VENTAS POR ID VENTA 
    @GetMapping("/detalleVenta/venta/{codigo_venta}")
    
    public List<DetalleVenta> GetVentaByIdVenta(@PathVariable Long codigo_venta){
        
        return IDetaVenServ.getByVenta(codigo_venta);
       
    }
    
    //BORRAR DETALLE DE VENTA 
    @DeleteMapping("/detalleventa/eliminar/{id_detalleVenta}")
    public void deleteDetalleVenta(@PathVariable Long id_detalleVenta){
        
        IDetaVenServ.deleleDetalleVentaByID(id_detalleVenta);
        
    }
    
    //EDITAR DETALLE VENTA
    @PutMapping("/detalleventa/editar")
    public DetalleVenta editDetalleVenta(@RequestBody DetalleVenta unDetalleVenta){
        
        IDetaVenServ.editDetalleVenta(unDetalleVenta);
        
        return IDetaVenServ.GetByIDDetalleVenta(unDetalleVenta.getId_detalleVenta());
        
    } 
}
