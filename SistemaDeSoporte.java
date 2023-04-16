import java.util.HashSet;

/**
 * Esta clase implementa un sistema de soporte técnico. Es la clase de
 * mayor nivel del proyecto. El sistema de soporte se comunica mediante
 * la terminal de texto con entradas y salidas en ella.
 * 
 * La clase usa un objeto de clase LectorDeEntrada para leer las entradas
 * del usuario y un objecto de clase Contestador para generar las 
 * respuestas. Contiene un ciclo que repetidamente lee las entradas y
 * genera las respuestas hasta que el usuario decide salir.
 * 
 * @author     Michael Kolling and David J. Barnes
 * @version    1.0
 */
public class SistemaDeSoporte
{
    private LectorDeEntrada lector;
    private Contestador contestador;
    
    /**
     * Crea un sistema de soporte técnico.
     */
    public SistemaDeSoporte()
    {
        lector = new LectorDeEntrada();
        contestador = new Contestador();
    }

    /**
     * Inicia el sistema de soporte técnico. Imprimirá un mensaje de bienvenida
     * y establece un diálogo con el usuario hasta que el usuario lo finalice.
     */
    public void iniciar()
    {
        boolean terminado = false;

        imprimirBienvenida();

        while(!terminado) {
            HashSet<String> entrada = lector.getEntrada();

            if(entrada.contains("bye")) {
                terminado = true;
            }
            else {
                String respuesta = contestador.generarRespuesta(entrada);
                System.out.println(respuesta);
            }
        }
        imprimirDespedida();
    }

    /**
     * Imprime un mensaje de Bienvenida en la pantalla
     */
    private void imprimirBienvenida()
    {
        System.out.println("Bienvenido");
    
    }

    /**
     * Imprime un mensaje de Despedida en la pantalla
     */
    private void imprimirDespedida()
    {
        System.out.println("Un gusto hablar con usted. Bye...");
    }
}
