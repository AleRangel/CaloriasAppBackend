package com.example.demo.Security;

public class JWTAuthResonseDTO {
    
    private String tokenDeAcceso;
    private String tipoDeToken = "Bearer";
    
    

    public JWTAuthResonseDTO(String tokenDeAcceso) {
        this.tokenDeAcceso = tokenDeAcceso;
    }

    public JWTAuthResonseDTO(String tokenDeAcceso, String tipoDeToken) {
        this.tokenDeAcceso = tokenDeAcceso;
        this.tipoDeToken = tipoDeToken;
    }

    public String getTokenDeAcceso() {
        return tokenDeAcceso;
    }

    public void setTokenDeAcceso(String tokenDeAcceso) {
        this.tokenDeAcceso = tokenDeAcceso;
    }

    public String getTipoDeToken() {
        return tipoDeToken;
    }

    public void setTipoDeToken(String tipoDeToken) {
        this.tipoDeToken = tipoDeToken;
    }
    
}
