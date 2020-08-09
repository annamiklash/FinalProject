package ania.miklash.pjatk.FinalProject.repository;

import ania.miklash.pjatk.FinalProject.model.dto.ItemDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<ItemDTO, Long> {
}
