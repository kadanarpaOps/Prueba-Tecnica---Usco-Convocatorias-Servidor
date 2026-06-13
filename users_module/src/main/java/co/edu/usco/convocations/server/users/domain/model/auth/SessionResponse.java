package co.edu.usco.convocations.server.users.domain.model.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class SessionResponse {

    private String accessToken;

}
