package clasesextra;

import com.company.Avion;
import com.company.Motor;

import interfaz.Catering;

public class Silver extends Avion implements Catering{
    public Silver(float capConbustible, float costoXkm, int sizePasajeros, float velMaxima, Motor motor,String tipoAvion,int id, int tarifa) {
        super(capConbustible, costoXkm, sizePasajeros, velMaxima, motor, tipoAvion,id,tarifa);
    }

    ///-----------------------------------IMPLEMENTACION DE INTERFAZ--------------------------------

    @Override
    public void catering() {

    }
}
