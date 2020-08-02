package ania.miklash.pjatk.FinalProject.common;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;

@Data
@Validated
@ConfigurationProperties(prefix = "final.project")
public class Properties {

    @NotEmpty
    private String testProperty;
}
