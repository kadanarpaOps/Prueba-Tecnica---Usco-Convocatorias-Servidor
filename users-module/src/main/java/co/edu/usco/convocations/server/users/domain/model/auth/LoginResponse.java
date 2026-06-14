package co.edu.usco.convocations.server.users.domain.model.auth;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LoginResponse extends SessionResponse {

    public LoginResponse(String userId, String accessToken, String refreshToken) {
        super(accessToken);
        this.refreshToken = refreshToken;
        this.userId = userId;
    }

    private String refreshToken;
    private String userId;

}
