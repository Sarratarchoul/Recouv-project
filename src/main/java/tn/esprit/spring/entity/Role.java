package tn.esprit.spring.entity;

public enum Role {
	    ADMINISTRATEUR,
	    COMMERCIAL,
	    CHARGERECOUVREMENT,
		CREDITMANAGER;
	
	public static Role getRole(String role) {
        switch (role) {
            case "ADMINISTRATEUR":return ADMINISTRATEUR;
            case "COMMERCIAL":return COMMERCIAL;
            case "CHARGERECOUVREMENT":return CHARGERECOUVREMENT;
            default:return CREDITMANAGER;
        }
    }
}
