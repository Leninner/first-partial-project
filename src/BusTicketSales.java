import java.time.LocalDateTime;
import javax.swing.JOptionPane;

public class BusTicketSales {
  void manageBusTicketSales() {
    // LocalDAteTime es un objeto que nos permite de fecha y hora inmutable que
    // representa una fecha y hora,
    // a menudo visto como año-mes-día-hora-minuto-segundo.
    // También se puede acceder a otros campos de fecha y hora, como día del año,
    // día de la semana y semana del año.
    // El tiempo se representa con una precisión de nanosegundos. Por ejemplo, el
    // valor "2 de octubre de 2007 a las 13:45.30.123456789"
    // se puede almacenar en LocalDateTime.

    int travelers = 0, choose_option_travel = 0, reenterdata = 0;

    float total_price = 0, price_travel = 0, price_travel_discount = 0, discount_option1 = 0, discount_option2 = 0,
        discount_option3 = 0, discount_option4 = 0, discount_option5 = 0;

    float price_option1 = 2.50f, price_option2 = 1.50f, price_option3 = 3.80f, price_option4 = 3.60f,
        price_option5 = 3.00f, price_option6 = 4.30f, price_option7 = 1.80f, price_option8 = 3.50f;

    String option_travel1 = "Ambato --> Quito", option_travel2 = "Ambato --> Latacunga",
        option_travel3 = "Ambato --> Cuenca", option_travel4 = "Ambato --> Guayaquil";
    String option_travel5 = "Ambato --> Puyo", option_travel6 = "Ambato --> Loja",
        option_travel7 = "Ambato --> Riobamba", option_travel8 = "Ambato --> Tena";
    
    JOptionPane.showMessageDialog(null, "*****************************************************\n"+
                                                        "* Bienvenido a la venta de boletos de autobús  *\n"+
                                                        "*****************************************************");
    do {
      try {
        String date = JOptionPane.showInputDialog("Ingrese la fecha del viaje (dd/mm/aaaa)");
        int day = Integer.parseInt(date.substring(0, 2));
        int month = Integer.parseInt(date.substring(3, 5));
        int year = Integer.parseInt(date.substring(6, 10));

        // LocalDateTime travelDateTime = LocalDateTime.of(year, month, day, hour,
        // minute);
        if (day > 31 || day < 1) {
          JOptionPane.showMessageDialog(null, "El dia ingresado no es valido");
          reenterdata = JOptionPane.showConfirmDialog(null, "¿Volver a ingresar la fecha del viaje?", "",
              JOptionPane.YES_NO_OPTION);
              continue;
        } else if (month > 12 || month < 1) {
          JOptionPane.showMessageDialog(null, "El mes ingresado no es valido");
          reenterdata = JOptionPane.showConfirmDialog(null, "¿Volver a ingresar la fecha del viaje?", "",
              JOptionPane.YES_NO_OPTION);
              continue;
        } else if (year > 2025 || year < 1) {
          JOptionPane.showMessageDialog(null, "El año ingresado no es valido");
          reenterdata = JOptionPane.showConfirmDialog(null, "¿Volver a ingresar la fecha del viaje?", "",
              JOptionPane.YES_NO_OPTION);
              continue;
        } else if (year % 4 == 0 && month == 2 && day > 29) {
          JOptionPane.showMessageDialog(null, "El dia ingresado no es valido");
          reenterdata = JOptionPane.showConfirmDialog(null, "¿Volver a ingresar la fecha del viaje?", "",
              JOptionPane.YES_NO_OPTION);
        } else {
          reenterdata = 1;
        }
      } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error en la fecha ingresada");
        reenterdata = JOptionPane.showConfirmDialog(null, "¿Volver a ingresar la fecha del viaje?", "",
            JOptionPane.YES_NO_OPTION);
      }
    } while (reenterdata == JOptionPane.YES_OPTION);

    do {
      try {
        String time = JOptionPane.showInputDialog("Ingrese la hora del viaje (hh:mm)");
        int hour = Integer.parseInt(time.substring(0, 2));
        int minute = Integer.parseInt(time.substring(3, 5));
        if (hour > 23 || hour < 0) {
          JOptionPane.showMessageDialog(null, "La hora ingresada no es valida");
          reenterdata = JOptionPane.showConfirmDialog(null, "¿Volver a ingresar la hora del viaje?", "",
              JOptionPane.YES_NO_OPTION);
              continue;
        } else if (minute > 59 || minute < 0) {
          JOptionPane.showMessageDialog(null, "Los minutos ingresados no son válidos");
          reenterdata = JOptionPane.showConfirmDialog(null, "¿Volver a ingresar la hora del viaje?", "",
              JOptionPane.YES_NO_OPTION);
              continue;
        } else {
          reenterdata = 1;
        }
      } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error en la hora ingresada");
        reenterdata = JOptionPane.showConfirmDialog(null, "¿Volver a ingresar la hora del viaje?", "",
            JOptionPane.YES_NO_OPTION);
        ;
      }
    } while (reenterdata == JOptionPane.YES_OPTION);


    LocalDateTime purchaseStartTime = LocalDateTime.now();
    String purchaseStartTimeString = purchaseStartTime.toString();

    int confirmSale = JOptionPane.showConfirmDialog(null,
        "¿Quieres vender un boleto de bus?\n" + "Fecha y Hora actual: "
            + purchaseStartTimeString.replace("T", " - ").substring(0, 21),
        "",
        JOptionPane.YES_NO_OPTION);

    if (confirmSale == JOptionPane.YES_OPTION) {
      travelers = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de viajeros: "));
      JOptionPane.showMessageDialog(null, "Los viajeros son: " + travelers);
      String name_travelers[] = new String[travelers];
      String last_name_travelers[] = new String[travelers];
      String age_travelers[] = new String[travelers];
      String id_travelers[] = new String[travelers];
      int discapacity [] = new int[travelers];
      for (int i = 0; i < travelers; i++) {
        try {
          name_travelers[i] = JOptionPane.showInputDialog("Ingrese el nombre del viajero " + (i + 1) + ": ");
          last_name_travelers[i] = JOptionPane.showInputDialog("Ingrese el apellido del viajero " + (i + 1) + ": ");
          age_travelers[i] = JOptionPane.showInputDialog("Ingrese la edad del viajero " + (i + 1) + ": ");
          id_travelers[i] = JOptionPane.showInputDialog("Ingrese la cédula del viajero " + (i + 1) + ": ");
          discapacity[i] = JOptionPane.showConfirmDialog(null,
              "¿El viajero " + (i + 1) + " es discapacitado?", "", JOptionPane.YES_NO_OPTION);
        } catch (Exception e) {
          JOptionPane.showMessageDialog(null, "Error en los datos ingresados");
          i--;
        }
      }
      do {
        try {
          choose_option_travel = Integer.parseInt(JOptionPane.showInputDialog(null,
              "Escoge una opción de viajes disponible: \n1." + option_travel1 + " - $" + price_option1 + "\n2."
                  + option_travel2 + " - $" + price_option2 + "\n3." + option_travel3 + " - $" + price_option3 + "\n4."
                  + option_travel4 + " - $" + price_option4 + "\n5." + option_travel5
                  + " - $" + price_option5 + "\n6." + option_travel6 + " - $" + price_option6 + "\n7." + option_travel7
                  + " - $" + price_option7 + "\n8." + option_travel8 + " - $"
                  + price_option8
                  + "\nLista de descuentos posibles: \n1. Más de 10 pasajeros = -15% al total \n2. Menores de 5 años = -10% en su entrada\n"
                  +
                  "3. Tercera edad = -8% en su entrada \n4. Estudiantes = -5% en su entrada \n5. Persona con discapaciodad = -20% en su entrada\n\n Ingrese el número de la opción que desea: "));
        } catch (Exception e) {
          JOptionPane.showMessageDialog(null, "Error en la opción de viaje ingresada");
          choose_option_travel = 0;
        }
      } while (choose_option_travel == 0);
      

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
