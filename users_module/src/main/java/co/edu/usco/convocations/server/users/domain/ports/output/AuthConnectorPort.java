package co.edu.usco.convocations.server.users.domain.ports.output;

import co.edu.usco.convocations.server.users.domain.model.auth.LoginRequest;

import java.util.Map;

public interface AuthConnectorPort {


    Map<String, String> login(LoginRequest loginRequest);
    void logout(String refreshToken);
    Map<String, Object> validateToken(String token);
    Map<String, String> refresh(String refreshToken);

}
