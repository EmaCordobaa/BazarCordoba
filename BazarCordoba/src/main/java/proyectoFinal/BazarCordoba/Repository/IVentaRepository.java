
package proyectoFinal.BazarCordoba.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import proyectoFinal.BazarCordoba.Model.Venta;

@Repository
public interface IVentaRepository extends JpaRepository<Venta, Long>{
    
}
