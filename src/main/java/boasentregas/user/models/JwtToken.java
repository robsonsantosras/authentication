package boasentregas.user.models;


import lombok.Builder;
import lombok.Getter;


@Builder
@Getter
public class JwtToken {

    private String type;
    private String token;

}
