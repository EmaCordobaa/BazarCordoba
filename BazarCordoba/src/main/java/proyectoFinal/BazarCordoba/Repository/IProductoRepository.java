
package proyectoFinal.BazarCordoba.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import proyectoFinal.BazarCordoba.Model.Producto;

@Repository
public interface IProductoRepository extends JpaRepository<Producto, Long>{
    
    
}
