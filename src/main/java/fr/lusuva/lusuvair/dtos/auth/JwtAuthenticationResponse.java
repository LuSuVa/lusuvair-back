package fr.lusuva.lusuvair.dtos.auth;

/**
 * Dto usually used to send a Response containing a JWT
 */
public class JwtAuthenticationResponse {
    /**
     * Token
     */
    private String token;

    /**
     * Empty constructor
     */
    public JwtAuthenticationResponse() {
        super();
    }

    /**
     * Token constructor
     * 
     * @param token String
     */
    public JwtAuthenticationResponse(String token) {
        super();
        this.token = token;
    }

    /**
     * Get token
     * 
     * @return String representing a token
     */
    public String getToken() {
        return token;
    }

    /**
     * Set token
     * 
     * @param token
     */
    public void setToken(String token) {
        this.token = token;
    }
}
