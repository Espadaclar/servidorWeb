
/**
 * Tener un constructor al que se le pasen 5 parámetros de tipo entero: el año, el mes, el día, la hora y los minutos.
 *Tener 1 método getter que informe de la hora del acceso.
 */
public class Acceso
{
     private int anno;
    private int mes;
    private int dia;
    private int hora;
    private int minutos;

    public Acceso(int anno, int mes, int dia, int hora, int minutos) {
        this.anno = anno;
        this.mes = mes;
        this.dia = dia;
        this.hora = hora;
        this.minutos = minutos;
    }

    public int getAnno() {
        return anno;
    }

    public int getMes() {
        return mes;
    }

    public int getDia() {
        return dia;
    }

    public int getHora() {
        return hora;
    }

    public int getMinutos() {
        return minutos;
    }
    
    
    @Override
    public String toString() {
        return "Acceso{" + "anno; " + anno + ", mes; " + mes + ", dia;" + dia 
                + ", hora; " + hora + ", minutos; " + minutos + '}';
    }
}
