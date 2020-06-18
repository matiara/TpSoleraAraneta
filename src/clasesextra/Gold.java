package clasesextra;

import com.company.Avion;
import com.company.Motor;

import interfaz.Catering;
import interfaz.ConexionWifi;

public class Gold extends Avion implements Catering, ConexionWifi{


    public Gold(float capConbustible, float costoXkm, int sizePasajeros, float velMaxima, Motor motor ,String tipoAvion) {
        super(capConbustible, costoXkm, sizePasajeros, velMaxima, motor,tipoAvion);
    }

    ///------------------------- IMPLEMENTACIONES DE LAS INTERFASES -------------------------------

    @Override
    public void catering() {

    }

    @Override
    public void conexionWifi() {

    }

    ///---------------------------------------------------------------------------------------------

}

