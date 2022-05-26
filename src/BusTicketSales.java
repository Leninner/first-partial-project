import java.time.LocalDateTime;
import javax.swing.JOptionPane;
import java.util.ArrayList;

public class BusTicketSales {
  void manageBusTicketSales() {
    // LocalDAteTime es un objeto de fecha y hora inmutable que
    // representa una fecha y hora,
    // a menudo visto como año-mes-día-hora-minuto-segundo.
    // También se puede acceder a otros campos de fecha y hora, como día del año,
    // día de la semana y semana del año.
    // El tiempo se representa con una precisión de nanosegundos. Por ejemplo, el
    // valor "2 de octubre de 2007 a las 13:45.30.123456789"
    // se puede almacenar en LocalDateTime.

    int travelers = 0, choose_option_travel = 0, reenterdata = 0, day = 0, month = 0, year = 0, hour = 0, minute = 0;
    ArrayList<String> name_travelers = new ArrayList<String>();
    ArrayList<String> lastname_travelers = new ArrayList<String>();
    ArrayList<String> id_travelers = new ArrayList<String>();
    ArrayList<Integer> age_travelers = new ArrayList<Integer>();
    ArrayList<Integer> discapacity = new ArrayList<Integer>();
    ArrayList<Integer> student_travelers = new ArrayList<Integer>();

    ArrayList<Float> price_traveler_discount = new ArrayList<Float>();
    Float price_traveler_discount_total = 0f;

    String date = "", time = "";

    Float price_option1 = 2.50f, price_option2 = 1.50f, price_option3 = 3.80f, price_option4 = 3.60f,
        price_option5 = 3.00f, price_option6 = 4.30f, price_option7 = 1.80f, price_option8 = 3.50f, total_price = 0f, aux_total_price = 0f;

    ArrayList<String> option_travel = new ArrayList<String>();
    option_travel.add("Ambato --> Quito");
    option_travel.add("Ambato --> Latacunga");
    option_travel.add("Ambato --> Cuenca");
    option_travel.add("Ambato --> Guayaquil");
    option_travel.add("Ambato --> Puyo");
    option_travel.add("Ambato --> Loja");
    option_travel.add("Ambato --> Riobamba");
    option_travel.add("Ambato --> Tena");

    JOptionPane.showMessageDialog(null, "*****************************************************\n" +
        "* Bienvenido a la venta de boletos de autobús  *\n" +
        "*****************************************************");

    LocalDateTime purchaseStartTime = LocalDateTime.now();
    String purchaseStartTimeString = purchaseStartTime.toString();

    int confirmSale = JOptionPane.showConfirmDialog(null,
        "¿Quieres registrar la venta de un boleto de bus?\n" + "Fecha y Hora actual: "
            + purchaseStartTimeString.replace("T", " - ").substring(0, 21),
        "",
        JOptionPane.YES_NO_OPTION);

    // Validadción de la respuesta del usuario

    if (confirmSale == JOptionPane.YES_OPTION) {

      do {
        try {
          date = JOptionPane.showInputDialog("Ingrese la fecha del viaje (dd/mm/aaaa)");
          day = Integer.parseInt(date.substring(0, 2));
          month = Integer.parseInt(date.substring(3, 5));
          year = Integer.parseInt(date.substring(6, 10));

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
          time = JOptionPane.showInputDialog("Ingrese la hora del viaje (hh:mm)");
          hour = Integer.parseInt(time.substring(0, 2));
          minute = Integer.parseInt(time.substring(3, 5));
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

      // Se pide al usuario que ingrese el número de pasajeros y su validación
      do {
        try {
          travelers = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de viajeros: "));
        } catch (Exception e) {
          JOptionPane.showMessageDialog(null, "Error en el número de viajeros");
          reenterdata = JOptionPane.showConfirmDialog(null, "¿Volver a ingresar el número de viajeros?", "",
              JOptionPane.YES_NO_OPTION);
          continue;
        }
        if (travelers < 1 || travelers > 40) {
          JOptionPane.showMessageDialog(null, "El número de viajeros ingresado no es válido");
          reenterdata = 1;
          reenterdata = JOptionPane.showConfirmDialog(null, "¿Volver a ingresar el número de pasajeros?", "",
              JOptionPane.YES_NO_OPTION);
        } else {

          JOptionPane.showMessageDialog(null, "Los viajeros son: " + travelers);

          for (int i = 0; i < travelers; i++) {
            try {
              name_travelers.add(JOptionPane.showInputDialog("Ingrese el nombre del pasajero " + (i + 1) + ": "));
              lastname_travelers.add(JOptionPane.showInputDialog("Ingrese el apellido del viajero " + (i + 1) + ": "));
              age_travelers
                  .add(Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad del viajero " + (i + 1) + ": ")));
              id_travelers.add(JOptionPane.showInputDialog("Ingrese la cédula del viajero " + (i + 1) + ": "));
              discapacity.add(JOptionPane.showConfirmDialog(null,
                  "¿El viajero " + (i + 1) + " es discapacitado?", "", JOptionPane.YES_NO_OPTION));
              student_travelers.add(JOptionPane.showConfirmDialog(null,
                  "¿El viajero " + (i + 1) + " es estudiante?", "", JOptionPane.YES_NO_OPTION));
            } catch (Exception e) {
              JOptionPane.showMessageDialog(null, "Error en los datos ingresados");
              i--;
            }
          }
        }
        /*while (reenterdata == JOptionPane.YES_OPTION)
          ;
        reenterdata = JOptionPane.showConfirmDialog(null, "¿Desea confirmar los datos ingresados?", "",
            JOptionPane.YES_NO_OPTION);*/
      } while (reenterdata == JOptionPane.YES_OPTION);
      do {
        try {
          JOptionPane.showMessageDialog(null,
              "\nLista de descuentos posibles: \n1. Más de 10 pasajeros = -15% al total \n2. Menores de 5 años = -10% en su entrada\n"
                  +
                  "3. Tercera edad = -8% en su entrada \n4. Estudiantes = -5% en su entrada \n5. Persona con discapaciodad = -20% en su entrada\n\n ");
          choose_option_travel = Integer.parseInt(JOptionPane.showInputDialog(null,
              "Escoge una opción de viajes disponible: \n1." + option_travel.get(0) + " - $" + price_option1 + "\n2."
                  + option_travel.get(1) + " - $" + price_option2 + "\n3." + option_travel.get(2) + " - $" + price_option3 + "\n4."
                  + option_travel.get(3) + " - $" + price_option4 + "\n5." + option_travel.get(4)
                  + " - $" + price_option5 + "\n6." + option_travel.get(5) + " - $" + price_option6 + "\n7." + option_travel.get(6)
                  + " - $" + price_option7 + "\n8." + option_travel.get(7) + " - $"
                  + price_option8 + "\n\nIngrese el número de la opción que desea: "));
          if (choose_option_travel > 8 || choose_option_travel < 1) {
            JOptionPane.showMessageDialog(null, "La opción ingresada no es valida");
            reenterdata = JOptionPane.showConfirmDialog(null, "¿Volver a ingresar la opción de viaje?", "",
                JOptionPane.YES_NO_OPTION);
            continue;
          } else {
            reenterdata = 1;
          }
        } catch (Exception e) {
          JOptionPane.showMessageDialog(null, "Error en la opción de viaje ingresada");
          choose_option_travel = 0;
        }
      } while (choose_option_travel == 0);

      // Lógica de descuentos

      if (choose_option_travel == 1) {
        total_price = price_option1 * travelers;
      } else if (choose_option_travel == 2) {
        total_price = price_option2 * travelers;
      } else if (choose_option_travel == 3) {
        total_price = price_option3 * travelers;
      } else if (choose_option_travel == 4) {
        total_price = price_option4 * travelers;
      } else if (choose_option_travel == 5) {
        total_price = price_option5 * travelers;
      } else if (choose_option_travel == 6) {
        total_price = price_option6 * travelers;
      } else if (choose_option_travel == 7) {
        total_price = price_option7 * travelers;
      } else if (choose_option_travel == 8) {
        total_price = price_option8 * travelers;
      }

      aux_total_price = total_price;

      if (travelers > 10) {
        price_traveler_discount.add(((aux_total_price / travelers) * 0.15f));
      } else {
        for (int i = 0; i < travelers; i++) {
          if (age_travelers.get(i) < 5) {
            price_traveler_discount.add(((aux_total_price / travelers) * 0.1f));
            price_traveler_discount_total += price_traveler_discount.get(i);
          }
          if (age_travelers.get(i) > 64) {
            price_traveler_discount.add(((aux_total_price / travelers) * 0.08f));
            price_traveler_discount_total += price_traveler_discount.get(i);
          }
          if (student_travelers.get(i) == JOptionPane.YES_OPTION) {
            price_traveler_discount.add(((aux_total_price / travelers) * 0.05f));
            price_traveler_discount_total += price_traveler_discount.get(i);
          }
          if (discapacity.get(i) == JOptionPane.YES_OPTION) {
            price_traveler_discount.add(((aux_total_price / travelers) * 0.2f));
            price_traveler_discount_total += price_traveler_discount.get(i);
          } aux_total_price -= price_traveler_discount_total;

        }
      } aux_total_price -= price_traveler_discount_total;

      JOptionPane.showMessageDialog(null, "Venta realizada");
      LocalDateTime endTimeFromBuy = LocalDateTime.now();

      // Encontrar la resta entre las dos horas en minutos y segundos
      long seconds = purchaseStartTime.until(endTimeFromBuy, java.time.temporal.ChronoUnit.SECONDS);
      long minutes = purchaseStartTime.until(endTimeFromBuy, java.time.temporal.ChronoUnit.MINUTES);
      long hours = purchaseStartTime.until(endTimeFromBuy, java.time.temporal.ChronoUnit.HOURS);

      JOptionPane.showMessageDialog(null, "Tiempo de espera: " + (hours % 24) + " horas, " + (minutes % 60)
          + " minutos y " + (seconds % 60) + " segundos");
      //Mostrar la factura de la compra indicando la fecha de la compra, fecha del viaje, destino, el numero de viajeros, nombres de viajeros, edad de viajeros, subtototal = (total_price*0.88), IVA = (total_price*0.12), Descuentos = price_traveler_discount_total, valor total = (aux_total_price*1.12)
      name_travelers.toString();
      JOptionPane.showMessageDialog(null, "Fecha de compra: " + purchaseStartTime.getDayOfMonth() + "/"
          + purchaseStartTime.getMonthValue() + "/" + purchaseStartTime.getYear() + "\nFecha del viaje: "
          + date + "\nDestino: "
          + option_travel.get(choose_option_travel-1) + "\nNumero de viajeros: " + travelers + "\nNombres de viajeros: " + name_travelers + "\nEdad de viajeros: "
          + age_travelers + "\nSubtotal: " + (total_price * 0.88) + "\nIVA: " + (total_price * 0.12)
          + "\nDescuentos: " + price_traveler_discount_total + "\nValor total: " + (aux_total_price * 1.12));
    }

    System.out.println("Hora actual: " + purchaseStartTime);
  }

}
