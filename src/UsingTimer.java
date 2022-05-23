import javax.swing.JOptionPane;

public class UsingTimer {

  public static void main(String[] args) {
    Tiempo tiempo = new Tiempo();

    tiempo.Contar();

    int option = JOptionPane.showConfirmDialog(null, "¿Quieres detener el contador ahora?", "",
        JOptionPane.YES_NO_OPTION);

    if (option == JOptionPane.YES_OPTION) {
      tiempo.Detener();
      System.out.println("Segundos transcurridos: " + tiempo.getSegundos());
    }

  }
}
