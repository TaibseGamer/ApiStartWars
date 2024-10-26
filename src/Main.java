import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        System.out.println("Escriba el numero de la pelicula de Star wars que quiere consultar: ");


        ConsultaPelicula consulta = new ConsultaPelicula();

        try {
            var numeroDePelicula = Integer.valueOf(lectura.nextLine());

            Pelicula pelicula = consulta.buscarPelicula(numeroDePelicula);
            System.out.println(pelicula);
            GeneradorDeArchivo generador = new GeneradorDeArchivo();
            generador.guardarJson(pelicula);

        } catch (NumberFormatException e) {
            System.out.println("Numero no encontrado" + e.getMessage());
        } catch (RuntimeException | IOException e) {

            System.out.println(e.getMessage());
            System.out.println("Finalizando la aplicacion");

        }

    }
}
