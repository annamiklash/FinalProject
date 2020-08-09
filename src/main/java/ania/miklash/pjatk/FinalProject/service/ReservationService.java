package ania.miklash.pjatk.FinalProject.service;

import ania.miklash.pjatk.FinalProject.model.dto.ReservationDTO;
import ania.miklash.pjatk.FinalProject.repository.ReservationRepository;
import com.google.common.collect.ImmutableList;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class ReservationService {

    private final ReservationRepository reservationRepository;


    public ImmutableList<ReservationDTO> getAllReservations() {
        return ImmutableList.copyOf(reservationRepository.findAll());

    }

    public void addReservation(ReservationDTO reservation) {
        reservationRepository.save(reservation);
    }


}
