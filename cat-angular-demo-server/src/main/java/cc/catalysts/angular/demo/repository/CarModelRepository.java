package cc.catalysts.angular.demo.repository;

import cc.catalysts.angular.demo.entity.CarModel;
import cc.catalysts.angular.demo.entity.Manufacturer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarModelRepository extends JpaRepository<CarModel, Long> {

    Page<CarModel> findAllByManufacturer(Manufacturer manufacturer, Pageable pageable);
}
