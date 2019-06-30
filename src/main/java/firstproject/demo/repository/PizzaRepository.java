package firstproject.demo.repository;

import firstproject.demo.entity.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Elza
 */
@Repository
public interface PizzaRepository extends JpaRepository<Pizza,String> {
    Pizza findAllByTypeAndSize(String type, double size);
}
