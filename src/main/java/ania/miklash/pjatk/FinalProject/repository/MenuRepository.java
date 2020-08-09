package ania.miklash.pjatk.FinalProject.repository;

import ania.miklash.pjatk.FinalProject.model.dto.MenuDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<MenuDTO, Long> {
}
