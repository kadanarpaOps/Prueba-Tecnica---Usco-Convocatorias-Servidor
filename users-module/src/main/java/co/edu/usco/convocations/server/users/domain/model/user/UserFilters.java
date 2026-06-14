package co.edu.usco.convocations.server.users.domain.model.user;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class UserFilters {

    private String uscoCode;
    private String userName;
    private String userEmail;
    private boolean userStatus;

}
