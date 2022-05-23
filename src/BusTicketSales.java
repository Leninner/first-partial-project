import java.time.LocalDateTime;
import javax.swing.JOptionPane;

public class BusTicketSales {
  void manageBusTicketSales() {
    LocalDateTime startTimeFromBuy = LocalDateTime.now();

    int confirmSale = JOptionPane.showConfirmDialog(null,
        "¿Quieres vender un boleto de bus?\n" + "Hora actual: " + startTimeFromBuy.toString(), "",
        JOptionPane.YES_NO_OPTION);

    if (confirmSale == JOptionPane.YES_OPTION) {
      JOptionPane.showMessageDialog(null, "Venta realizada");
      LocalDateTime endTimeFromBuy = LocalDateTime.now();

      // Encontrar la resta entre las dos horas en minutos y segundos
      long seconds = startTimeFromBuy.until(endTimeFromBuy, java.time.temporal.ChronoUnit.SECONDS);
      long minutes = startTimeFromBuy.until(endTimeFromBuy, java.time.temporal.ChronoUnit.MINUTES);
      long hours = startTimeFromBuy.until(endTimeFromBuy, java.time.temporal.ChronoUnit.HOURS);

      JOptionPane.showMessageDialog(null, "Tiempo de espera: " + (hours % 24) + " horas, " + (minutes % 60)
          + " minutos y " + (seconds % 60) + " segundos");
    }

    System.out.println("Hora actual: " + startTimeFromBuy);
  }

}
