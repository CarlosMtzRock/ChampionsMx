package com.uacm.edu.championsmx.dao;

import com.uacm.edu.championsmx.modelo.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DaoManagerImplement implements DaoManager{
    private static final String URL = "jdbc:mariadb://localhost:3306/championsmx";
    private static final String USER = "root";
    private static final String PASSWORD = "123";
    private Connection conn;
    private IEquipoDao equipoDao;
    private IPartidoDao partidoDao;
    private IPosicionDao posicionDao;
    private IGolDao golDao;
    private IJugadorDao jugadorDao;

    public DaoManagerImplement() throws SQLException {
        try{
            conn = DriverManager.getConnection(URL,USER,PASSWORD);
        }catch(SQLException e){
            throw e;
        }

    }

    @Override
    public Gol getGol() {
        return null;
    }

    @Override
    public Jugador getJugador() {
        return null;
    }

    @Override
    public Equipo getEquipo() {
        return null;
    }

    @Override
    public Posicion getPosicion() {
        return null;
    }

    @Override
    public Partido getPartido() {
        return null;
    }
}
