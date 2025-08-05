
package proyectoFinal.BazarCordoba.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyectoFinal.BazarCordoba.Model.DetalleVenta;
import proyectoFinal.BazarCordoba.Model.Producto;
import proyectoFinal.BazarCordoba.Repository.IDetalleVentaRepository;
import proyectoFinal.BazarCordoba.Repository.IProductoRepository;

@Service
public class DetalleVentaService implements IDetalleDeVentaService{
    
    @Autowired 
    private IDetalleVentaRepository IDetaVenRepo;
    @Autowired
    private IProductoRepository IProdRepo;
    
    //OBTENER TODOS LOS DETALLES DE VENTA  
    @Override
    public List<DetalleVenta> getListDetalleVenta() {
        
        List<DetalleVenta> listaDetalleVentas = IDetaVenRepo.findAll();
        return listaDetalleVentas;
        
    }
    
    
    //OBTENER TODOS LOS DETALLES DE VENTA DE UNA VENTA 
    @Override
    public List<DetalleVenta> getByVenta(Long codigo_venta) {
        
        List<DetalleVenta> listaDetalleVenta = IDetaVenRepo.findAll();
        List<DetalleVenta> listaDetaVenById = new ArrayList<>();
        
        for (DetalleVenta unDetVen : listaDetalleVenta){
            
            if(unDetVen.getUnaVenta().getCodigo_venta() == codigo_venta ){
            
                listaDetaVenById.add(unDetVen);
            }
            
        }
        
        return listaDetaVenById;
        
    }
    
    
    //OBTENER UN DETALLE DE VENTA ESPECIFICO
    @Override
    public DetalleVenta GetByIDDetalleVenta(Long id_detalleVenta) {
        
        List<DetalleVenta> listaDetalleVenta = IDetaVenRepo.findAll(); 
        List<DetalleVenta> listaDetalleVentaById = new ArrayList<>();
        
        for(DetalleVenta unDetVen : listaDetalleVenta){
            
            if(unDetVen.getId_detalleVenta()== id_detalleVenta){
                
              
                listaDetalleVentaById.add(unDetVen);
                
                
            }
        }
        
        return GetByIDDetalleVenta(id_detalleVenta);
        
    }
    
    
    //BORRAR DETALLE DE VENTA
    @Override
    public void deleleDetalleVentaByID(Long id_detalleVenta) {
   
        IDetaVenRepo.deleteById(id_detalleVenta);
    
    }

    
    //EDITAR DETALLE VENTA 
    @Override
    public void editDetalleVenta(DetalleVenta unDetalleVenta) {
        
        IDetaVenRepo.save(unDetalleVenta);
        
    }
    //CREAR DETALLE VENTA VALIDANDO STOCK
    @Override
    public void saveDetalleVenta(DetalleVenta unDetalleVenta) {
        
            
        Producto productoBD = IProdRepo.findById(unDetalleVenta.getUnProducto().getCodigo_producto()).orElseThrow(() -> new IllegalArgumentException("Producto no encontrado"));

        double stockActual = Optional.ofNullable(productoBD.getCantidad_disponible()).orElse(0.0);

            if (stockActual < unDetalleVenta.getCantidadVendida()) {
                throw new IllegalArgumentException("No se cuenta con el stock solicitado para la venta");
            }
            
       
        double subtotal = productoBD.getCosto() * unDetalleVenta.getCantidadVendida();
        unDetalleVenta.setSubtotal(subtotal);
        
        productoBD.setCantidad_disponible(stockActual - unDetalleVenta.getCantidadVendida());
        IProdRepo.save(productoBD);
        unDetalleVenta.setUnProducto(productoBD);
        IDetaVenRepo.save(unDetalleVenta);
    }

   
}
