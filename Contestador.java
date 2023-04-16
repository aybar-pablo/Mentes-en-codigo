import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/**
 * La clase Contestador represante un objeto generador de respuestas.
 * Se lo usa para generar una respuesta autom�tica por azar seleccionando 
 * una frase de una lista predefinida de respuestas.
 * 
 * @version    1.0
 * @author     Michael Kolling and David J. Barnes
 */
public class Contestador
{
    // Usado para mapear palabras clave con respuestas.
    private HashMap<String, String> mapaDeRespuestas;
    // Respuesta por defecto usada cuando no reconocemos una palabra
    private ArrayList<String> respuestaPorDefecto;
    private Random generadorDeAzar;

    /**
     * Crea un Contestador
     */
    public Contestador()
    {
        mapaDeRespuestas = new HashMap<String, String>();
        respuestaPorDefecto = new ArrayList<String>();
        rellenarRespuestas();
        rellenarRespuestaPorDefecto();
        generadorDeAzar = new Random();
    }

    /**
     * Genera una respuesta desde un set de palabras de entrada dado
     * 
     * @param palabras  Un set de palabras ingresado por el usuario
     * @return       Una cadena que se podr�a mostrar como respuesta
     */
    public String generarRespuesta(HashSet<String> palabras)
    {
        Iterator<String> it = palabras.iterator();
        while(it.hasNext()) {
            String palabra = it.next();
            String respuesta = mapaDeRespuestas.get(palabra);
            if(respuesta != null) {
                return respuesta;
            }
        }
        // si llegamos aqu�, ninguna de las palabras ingresadas fue reconocida
        // en este caso, elegimos una de nuestras respuestas por defecto (lo que
        // respondemos cuando no podemos pensar otra cosa que decir...)
        
        return elegirRespuestaPorDefecto();
    }

    /**
     * Ingresar todas las palabras clave conocidas y sus respuesta asociadas
     * en nuestro mapa de respuestas.
     */
    private void rellenarRespuestas()
    {
     mapaDeRespuestas.put("hola", 
                        "Que onda como estas?.\n");
     mapaDeRespuestas.put("bien", 
                        "Que es esto? es la primera versi�n de algo epico \n" +
                        "es un sistema que realiza la busqueda de palabras clave en las colecci�nes \n"
                        );
    mapaDeRespuestas.put("suena", 
                        "Este es un sistema creado por vos, en donde responde automaticamente \n");
    mapaDeRespuestas.put("se", 
                        "si mal, con una base de datos mas grande..."+ 
                        "y alguna forma de incrustar esta funci�n \n" +
                        "fuera de este entorno de desarrollo");
    mapaDeRespuestas.put("parece", 
                        "reee aunque para ser esta una primer versi�n \n" +
                        "funciona genial, que te dije yo");
    //mapaDeRespuestas.put("que", 
    //                    "y damos gracias");
     
          
      /*mapaDeRespuestas.put("Hola","Que onda como estas?.");
      
      mapaDeRespuestas.put("bien", 
                        "Que es esto? es la primera versi�n de algo epico");
      mapaDeRespuestas.put("epico", 
                        "Este es un sistema creado por vos, en donde responde automaticamente tu mensaje");
      mapaDeRespuestas.put("cosas", 
                        "si mal, con una base de datos mas grande..."+ 
                        "y alguna forma de incrustar esta funci�n fuera de este entorno de desarrollo");
      mapaDeRespuestas.put("parece", 
                        "reee aunque para ser esta tu primer versi�n esta genial, que te dije yo");
       */
    }

    /**
     * Construye una lista de respuestas por defecto desde donde se tomar�
     * una cuando no sepamso m�s qu� decir.
     */
    private void rellenarRespuestaPorDefecto()
    {
        respuestaPorDefecto.add("El programa no puede reconocer aun esto");
        
    }

    /**
     * Selecciona una respuesta por defecto al azar.
     * @return     Una respuesta al azar
     */
    private String elegirRespuestaPorDefecto()
    {
        // Elige un n�mero aleatorio al azar par el index en la lista de 
        // de respuestas por defecto
        // El n�mero ser� entre 0 (inclusive) y el tama�o de la lista (excluye)
        int index = generadorDeAzar.nextInt(respuestaPorDefecto.size());
        return respuestaPorDefecto.get(index);
    }
}
