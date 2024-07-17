package fr.lusuva.lusuvair.dtos.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public class UserLoginDto {
    @NotNull
    @Email
    private String email;

    @NotNull
    private String password;

    public UserLoginDto() {
        super();
    }

    public UserLoginDto(String email, String password) {
        super();
        this.email = email;
        this.password = password;
    }

    /**
     * Get email
     * @return String representing email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Get password
     * @return String representing password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set email
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Set password
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
