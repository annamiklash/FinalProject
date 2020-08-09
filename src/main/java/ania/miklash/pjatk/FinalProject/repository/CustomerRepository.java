package ania.miklash.pjatk.FinalProject.repository;

import ania.miklash.pjatk.FinalProject.model.dto.CustomerDTO;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerDTO, Long> {
}
