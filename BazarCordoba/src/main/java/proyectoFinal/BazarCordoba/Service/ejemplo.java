/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoFinal.BazarCordoba.Service;

/**
 *
 * @author Usuario
 */
public class ejemplo {
 
    /*
    @Override
    public List<Producto> getVentaPorCodigo(Long codigo_venta) {
    
        Venta unaVenta = IVentaRepo.findById(codigo_venta).orElseThrow(()-> new RuntimeException("no se ah encontrado venta con ese codigo"));
        
        return unaVenta.getListaProductos();
        
    }
    
    @Override
    public void getPorFecha(LocalDate fecha_venta) {
        List<Venta> listaVentas = IVentaRepo.findAll();
        List<Venta> listaVentaUnDia = new ArrayList<>();

        for (Venta unaVenta : listaVentas) {
            if (unaVenta.getFecha_venta().equals(fecha_venta)) {
                listaVentaUnDia.add(unaVenta);
            }
        }

        long totalVentas = listaVentaUnDia.stream().count(); 
        double montoTotal = 0;

        for (Venta unaVenta2 : listaVentaUnDia) {
            montoTotal += unaVenta2.getTotal(); 
        }

        System.out.println("Total de ventas: " + totalVentas);
        System.out.println("Monto total vendido: $" + montoTotal);
        
    }

    @Override
    public DtoVentaCliente getMayorVenta() {
        
        List<Venta> listaVentas = IVentaRepo.findAll();                
        DtoVentaCliente dto = new DtoVentaCliente();
       
        Optional<Venta> unaVenta = listaVentas.stream().max(Comparator.comparing(Venta::getTotal));
        
        dto.setTotal(unaVenta.get().getTotal());
        dto.setCodigo_venta(unaVenta.get().getCodigo_venta());
        int max = unaVenta.get().getListaProductos().size();
        dto.setCantidadProductos(max);
        dto.setApellido(unaVenta.get().getUnCliente().getApellido());
        dto.setNombre(unaVenta.get().getUnCliente().getNombre());
        
        return dto;
        
      
    }
    */
    
    
    
}
