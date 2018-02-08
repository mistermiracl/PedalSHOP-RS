/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pedalshop.entity;

/**
 *
 * @author User
 */
public class UserBE {
    private int userId;
    private String username;
    private String password;
    private String email;
    private String nombre;
    private String apellido;

    public UserBE(int userId, String username, String password, String email, String nombre, String apellido) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.email = email;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public UserBE() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int user_id) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}
