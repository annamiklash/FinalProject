package ania.miklash.pjatk.FinalProject.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "reservation_table")
public class TableDTO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private int tableNumber;
    @NotNull
    private int maxGuestsNumber;

    @OneToMany(mappedBy = "table")
    private List<ReservationDTO> reservation;
}
