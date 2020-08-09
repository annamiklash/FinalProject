package ania.miklash.pjatk.FinalProject.repository;

import ania.miklash.pjatk.FinalProject.model.dto.ReservationDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<ReservationDTO, Long> {
}
