package london.domain;

import lombok.Setter;
import lombok.Data;
import lombok.ToString;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Data
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

    private String username;

    private Long age;

}