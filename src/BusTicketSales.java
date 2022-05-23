import java.time.LocalDateTime;
import javax.swing.JOptionPane;

public class BusTicketSales {
  void manageBusTicketSales() {
    LocalDateTime purchaseStartTime = LocalDateTime.now();
    //LocalDAteTime es un objeto que nos permite de fecha y hora inmutable que representa una fecha y hora, 
    //a menudo visto como año-mes-día-hora-minuto-segundo. 
    //También se puede acceder a otros campos de fecha y hora, como día del año, día de la semana y semana del año. 
    //El tiempo se representa con una precisión de nanosegundos. Por ejemplo, el valor "2 de octubre de 2007 a las 13:45.30.123456789" 
    //se puede almacenar en LocalDateTime.

    int confirmSale = JOptionPane.showConfirmDialog(null,
        "¿Quieres vender un boleto de bus?\n" + "Hora actual: " + purchaseStartTime.toString(), "",
        JOptionPane.YES_NO_OPTION);

    if (confirmSale == JOptionPane.YES_OPTION) {
      JOptionPane.showMessageDialog(null, "Venta realizada");
      LocalDateTime endTimeFromBuy = LocalDateTime.now();

      // Encontrar la resta entre las dos horas en minutos y segundos
      long seconds = purchaseStartTime.until(endTimeFromBuy, java.time.temporal.ChronoUnit.SECONDS);
      long minutes = purchaseStartTime.until(endTimeFromBuy, java.time.temporal.ChronoUnit.MINUTES);
      long hours = purchaseStartTime.until(endTimeFromBuy, java.time.temporal.ChronoUnit.HOURS);

      JOptionPane.showMessageDialog(null, "Tiempo de espera: " + (hours % 24) + " horas, " + (minutes % 60)
          + " minutos y " + (seconds % 60) + " segundos");
    }

    System.out.println("Hora actual: " + purchaseStartTime);
  }

}
