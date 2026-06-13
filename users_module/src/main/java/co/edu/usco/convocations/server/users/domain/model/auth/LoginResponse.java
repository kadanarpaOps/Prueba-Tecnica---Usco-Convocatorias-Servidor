package co.edu.usco.convocations.server.users.domain.model.auth;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class LoginResponse extends SessionResponse {

    private String refreshToken;
    private String userId;

}
