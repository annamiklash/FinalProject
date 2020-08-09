package ania.miklash.pjatk.FinalProject.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NewCustomerResponse {

    private Long id;
    private String firstName;
    private String lastName;
}
