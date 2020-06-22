package clasesextra;

import com.company.Avion;
import com.company.Motor;

import interfaz.Catering;

public class Silver extends Avion implements Catering{
    public Silver(float capConbustible, float costoXkm, int sizePasajeros, float velMaxima, Motor motor,String tipoAvion,int id, int tarifa,String wifi, String catering) {
        super(capConbustible, costoXkm, sizePasajeros, velMaxima, motor, tipoAvion,id,tarifa,wifi,catering);
    }

    ///-----------------------------------IMPLEMENTACION DE INTERFAZ--------------------------------

    @Override
    public void catering() {

    }
}
