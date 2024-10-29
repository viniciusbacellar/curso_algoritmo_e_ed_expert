package org.example.models;

public class EmailInfo {

    private String usuario;
    private String dominio;
    private String brasileiro;

    public EmailInfo(String usuario, String dominio, String brasileiro) {
        this.usuario = usuario;
        this.dominio = dominio;
        this.brasileiro = brasileiro;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getDominio() {
        return dominio;
    }

    public void setDominio(String dominio) {
        this.dominio = dominio;
    }

    public String getBrasileiro() {
        return brasileiro;
    }

    public void setBrasileiro(String brasileiro) {
        this.brasileiro = brasileiro;
    }

    @Override
    public String toString() {
        return "usuario: " + usuario +
                ", dominio: " + dominio +
                ", brasileiro: " + brasileiro;
    }
}
