package firstproject.demo.repository;

import firstproject.demo.entity.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Elza
 */
@Repository
public interface CreditCardRepository extends JpaRepository<CreditCard, String> {
}
