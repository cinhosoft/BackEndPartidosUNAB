package com.example.unab.Model;

import java.io.Serializable;

public class JwtResponse implements Serializable {

	private static final long serialVersionUID = -8091879091924046844L;
	private final String jwttoken;
        private String idUsuario;
        private String username;
	public JwtResponse(String jwttoken, String idUsuario, String username) {
		this.jwttoken = jwttoken;
                this.idUsuario = idUsuario;
                this.username = username;
                
	}

	public String getToken() {
		return this.jwttoken;
	}

        public String getIdUsuario() {
            return idUsuario;
        }

    public String getUsername() {
        return username;
    }
        
        
        
}