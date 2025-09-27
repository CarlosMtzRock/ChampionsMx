package com.uacm.edu.championsmx.dao;

import com.uacm.edu.championsmx.modelo.*;

public interface DaoManager {
    Gol getGol();
    Jugador getJugador();
    Equipo getEquipo();
    Posicion getPosicion();
    Partido getPartido();
}
