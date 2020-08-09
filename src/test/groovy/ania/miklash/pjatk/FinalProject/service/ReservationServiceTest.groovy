package ania.miklash.pjatk.FinalProject.service


import ania.miklash.pjatk.FinalProject.model.dto.ReservationDTO
import ania.miklash.pjatk.FinalProject.repository.ReservationRepository
import com.google.common.collect.ImmutableList
import spock.lang.Specification
import spock.lang.Subject

import java.time.LocalDate
import java.time.LocalTime

class ReservationServiceTest extends Specification {

    @Subject
    ReservationService reservationService

    ReservationRepository repository

    def setup() {
        repository = Mock()

        reservationService = new ReservationService(repository)
    }

    def "getAllReservations positive case scenario"() {
        given:
        def reservation = ReservationDTO.builder()
                .id(1)
                .reservationDate(LocalDate.now())
                .reservationTime(LocalTime.now())
                .table(null)
                .customer(null)
                .guestsNumber(4)
                .build()

        def reservationList = Arrays.asList(reservation)

        def target = ImmutableList.copyOf(reservationList)

        when:
        def result = reservationService.getAllReservations()

        then:
        1 * repository.findAll() >> reservationList

        result == target
    }

    def "addReservation positive test scenario"() {
        given:
        def reservation = ReservationDTO.builder()
                .id(1)
                .reservationDate(LocalDate.now())
                .reservationTime(LocalTime.now())
                .guestsNumber(4)
                .table(null)
                .customer(null)
                .build()

        when:
        reservationService.addReservation(reservation)

        then:
        1 * repository.save(reservation)
    }


}
