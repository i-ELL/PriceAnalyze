package analyzer.repos;

import analyzer.domain.models.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopRepository extends JpaRepository<Shop, Long> {
    Shop findByName(String name);

}
