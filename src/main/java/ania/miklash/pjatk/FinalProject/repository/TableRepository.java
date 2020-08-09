package ania.miklash.pjatk.FinalProject.repository;

import ania.miklash.pjatk.FinalProject.model.dto.TableDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TableRepository extends JpaRepository<TableDTO, Long> {
}
