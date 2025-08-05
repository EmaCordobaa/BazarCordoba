
package proyectoFinal.BazarCordoba.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyectoFinal.BazarCordoba.Model.DetalleVenta;
import proyectoFinal.BazarCordoba.Model.Venta;
import proyectoFinal.BazarCordoba.Repository.IVentaRepository;

    
@Service    
public class VentaService implements IVentaService{
    
    @Autowired private IVentaRepository IVentaRepo;
    
    
    //CREAR VENTA
    @Override
    public void saveVenta(Venta unaVenta) {
        
        double totalVenta = 0.0;

    if (unaVenta.getListaDetallesVentas() != null) {
        for (DetalleVenta detalle : unaVenta.getListaDetallesVentas()) {
            // Calcular el subtotal si no está seteado
            if (detalle.getSubtotal() == null && detalle.getUnProducto() != null) {
                detalle.setSubtotal(detalle.getUnProducto().getCosto() * detalle.getCantidadVendida());
            }
            totalVenta += detalle.getSubtotal();

            // Asociar la venta al detalle
            detalle.setUnaVenta(unaVenta);
        }
    }

    unaVenta.setTotal(totalVenta);
    unaVenta.setFecha_venta(LocalDate.now());

    IVentaRepo.save(unaVenta);   
        
    }
    
    
    //BORRAR VENTA 
    @Override
    public void deleteVenta(Long codigo_venta) {
        
        IVentaRepo.deleteById(codigo_venta);
        
    }
    
    //LISTA VENTAS 
    @Override
    public List<Venta> getVenta() {
        
        List<Venta> listaVentas = IVentaRepo.findAll();
        return listaVentas;
        
    }
    
    //OBTENER VENTA POR CODIGO
    @Override
    public Venta findVentaByCod(Long codigo_venta) {
        
        return IVentaRepo.findById(codigo_venta).orElse(null);
        
    }
    
    
    //EDITAR VENTA 
    @Override
    public void editVenta(Venta unaVenta) {
        
        IVentaRepo.save(unaVenta);
        
    }

    //DETALLE DE VENTA DE UNA COMPRA ESPECIFICA 
    @Override
    public List<DetalleVenta> getDetalleVentaPorCodigoVenta(Long codigo_venta) {
        
        Venta unaVenta = IVentaRepo.getById(codigo_venta);
        List<DetalleVenta> listaDetalles = unaVenta.getListaDetallesVentas(); 
  
        return listaDetalles;
       
        
    }
    
    
    //BUSCAR VENTA POR FECHA
    @Override
    public List<Venta> getPorFecha(LocalDate fecha_venta) {
       
        List<Venta> listaVentas = IVentaRepo.findAll();
        List<Venta> listaVentasFecha = new ArrayList<>();
        for (Venta unaVenta : listaVentas){
            
            if(unaVenta.getFecha_venta()== fecha_venta){
                
                listaVentasFecha.add(unaVenta);
                
            }    
        }
        
        return listaVentasFecha;
        
    }
  
    
    
    //TRAE LISTA DE LAS TODAS LAS COMPRAS DE UN CLIENTE ESPECIFICO
    @Override
    public List<Venta> listaComprasCliente(Long id_cliente) {
      
        List <Venta> listaVentas= IVentaRepo.findAll();
        List <Venta> listaCompras = new ArrayList<>();
            for (Venta unaVenta : listaVentas){

                if (unaVenta.getUnCliente().getId_cliente() == id_cliente){

                    listaCompras.add(unaVenta);

                }

            }
        return listaCompras;
    
    }
    

    
    
    
    
    
    
    
    
}
