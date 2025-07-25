
package proyectoFinal.BazarCordoba.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import proyectoFinal.BazarCordoba.Model.Cliente;


@Repository
public interface IClienteRepository extends JpaRepository<Cliente, Long>{
    
    
}
