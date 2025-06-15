package jwt_security_auth.Entity;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ADMIN,
    MANAGER,
    SUPERVISOR,
    CUSTOMER;

    @Override
    public String getAuthority() {
        return this.name();
    }
}
