import java.util.Scanner;
import java.io.File;  //la clase File está en el paquete io.
import java.io.FileNotFoundException;
import java.util.ArrayList;
/**
 *• Tener un método llamado analizarArchivoDeLog que requiere de un parámetro String que informe del nombre del archivo 
 *de log a leer. Este método lee el archivo de log.
 *
 *Tener un método llamado òbtenerHoraMasAccesos que, a partir de los procesos hechos por el método anterior encuentra la 
 *hora (solo la hora, sin tener en cuenta los minutos) a la que se producen más accesos al servidor. El método muestra por 
 *pantalla dicha hora y la devuelve. En caso de que se invoque este método sin haberse invocado el anterior el método informa
 *por pantalla de que no tiene datos y no hace nada más.
 */
public class AnalizadorAccesosAServidor
{
    // almaceno todas las entradas al servidor
    private ArrayList<Acceso> entradasServidor;
    //almacena en cada posición el nº de entradas por cada hora.
    private ArrayList<Integer> entradasEnHora;
    /**
     * Constructor for objects of class AnalizadorAccesosAServidor
     */
    public AnalizadorAccesosAServidor()
    {
        entradasServidor = new ArrayList<>();
        entradasEnHora = new ArrayList<>();
    }

    /**
     * Requiere de un parámetro String que informe del nombre del archivo 
     *de log a leer. Este método lee el archivo de log 
     */
    public void analizarArchivoDeLog(String nameArchivo)
    {
        entradasServidor.clear(); // pongo la colección a 0, por si albergase algún residuo.
        //PARA LEER UN ARCHIVO ES OBLIGATORIO UTILIZAR  try y cath
        //try y cath -------- SIRVEN PARA CAPTURAR POSIBLES EXCEPCIONES.
        // Si en try se produce la excepción puesta en catch 'FileNotFoundException e' salta al 'catch' anucia el error y el programa sigue.
        try{
            File archivo = new File(nameArchivo);// SE crea una vl de tipo File con un objeto File.
            Scanner sc = new Scanner(archivo);    // le pasamos archivo. queremos leer de un sitio.. del archivo especificado arriba
            while(sc.hasNextLine()){            // hasNextLine() de la variable sc devuelve true, cuando hay linea.
                
                // cadena, VL para almacenar el valor de cada linea del documento, en cada iteración.
                String cadena = sc.nextLine();
                // entradas, Array que almacena  en cada iteración cada una de las partes de la cadena, utilizando el mt split().
                String[] entradas = cadena.split(" "); 

                String anno = entradas[0];
                int numAnno = Integer.parseInt(anno);// paso todas los elementos del Array entradas a enteros para poder crear  -----
                String mes = entradas[1];            //-------- objetos Acceso.
                int numMes = Integer.parseInt(mes);
                String dia = entradas[2];
                int numDia = Integer.parseInt(dia);
                String hora = entradas[3];
                int numHora = Integer.parseInt(hora);
                String minuto = entradas[4];
                int numMinuto = Integer.parseInt(minuto);
                // por cada línea del documento se crea un objeto Acceso.
                Acceso acceso = new Acceso(numAnno, numMes, numDia, numHora, numMinuto);
                // cada uno de los ojetos Acceso creado los almaceno en el arrayList de Acceso
                entradasServidor.add(acceso);
            }
            sc.close();
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }

    

}





