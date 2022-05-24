import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import javax.swing.JOptionPane;

public class BusinessLogistics {
  /**
   * Aplicación de Courier para gestionar los envíos de paquetes.
   * 
   * El sistema debe permitir la gestión de paquetes, que debe cumplir los
   * siguientes requerimientos:
   * 
   * - El sistema de iniciar preguntando al encargado sobre los siguientes
   * parámetros de cada paquete:
   * 
   * - Destino de envío
   * - Peso de la carga, en Kg
   * - Tienda que vende
   * - Fecha de compra
   * - Precio antes del envío
   * - Tipo de productos que contiene (requerido)
   * 
   * - Información del comprador:
   * 
   * - Nombres y Apellidos (Requerido)
   * - Cédula (Requerido)
   * - Teléfono (Opcional)
   * - Correo Electrónico (Opcional)
   * 
   * - Tipo de envío (Requerido)
   * 
   * - El sistema tiene que validar que todos los datos estén de acuerdo con lo
   * solicitado:
   * 
   * - Se debe controlar que el paquete esté en concordancia con el tipo de envío
   * que se está aplicando.
   * 
   * - **Categoría A:** Documentos
   * Esta categoría está libre de impuestos y no requiere ningún documento de
   * control previo a la importación.
   * 
   * - **Categoría B:** 4 x 4
   * Son todos los paquetes que pesan hasta 4 kilogramos y hasta USD$400, usado
   * únicamente por personas naturales.
   * 
   * - **Categoría C:** 50 Kg $2000
   * Son todos los paquetes que pesan hasta 50 kilogramos y hasta USD $2.000 que
   * no entren en ninguna otra categoría.
   * Esta categoría si paga impuestos:
   * - Advalorem: el porcentaje dependerá del producto
   * - IVA: 12%
   * - Fodinfa: 0.5%.
   * 
   * - **Categoría D:** Textiles y Calzados
   * El precio no puede excederse a los 20 kg ni el valor sobrepasar los US$
   * 2.000,00
   * 
   * Esta categoría paga estos impuestos:
   * - Advalorem: 10%
   * - Específico: $5.5 por cada Kg de ropa, en el caso de calzado $6,00 por cada
   * par de zapato.|
   * - IVA: 12%
   * - Fodinfa: 0.5%
   * 
   * - El sistema debe retornar un mensaje de error en caso de que alguno de los
   * datos no cumpla con lo solicitado y volver a solicitar el dato erroneo
   * 
   * - El sistema debe generar un código de seguimiento que será un **código** de
   * 10 dígitos, el cual debe ser único.
   * 
   * - Al finalizar, se debe mostrar el resumen de la información, con los costos
   * de envío totales, el valor total de la compra, el valor total de los
   * impuestos, el valor total de los descuentos, el valor total de la compra con
   * impuestos y descuentos, el tiempo de envío.
   * 
   * - También, cuando el encargado termine su día de trabajo, se le debe mostrar
   * el tiempo total de trabajo y el total de paquetes procesados bajo cada
   * categoría.
   */

  void manageBusinessLogistics() {
    LocalDateTime startWorkTime = LocalDateTime.now();
    int totalPackages = 0;
    String customerName = "";
    String customerId = "";
    String shippingDestination = "";
    String customerPhone = "";
    String customerEmail = "";
    double weight = 0;
    String storeName = "";
    String purchaseDate = "";
    double price = 0;
    String productType = "";
    int shippingType = 0;

    // Regex para validaciones
    String regexName = "^[a-zA-Z]*$";
    String regexCedula = "^[0-9]*$";
    String regexDate = "^[0-9]{4}-[0-9]{2}-[0-9]{2}$";

    JOptionPane.showMessageDialog(null,
        "Bienevenido al Sistema de Courier\nEmpezamos ingresando los datos del paquete");

    do {
      // Petición de datos del cliente junto con validaciones

      do {
        customerName = JOptionPane.showInputDialog("Ingrese el nombre del comprador");

        if (!customerName.matches(regexName)) {
          JOptionPane.showMessageDialog(null, "El nombre debe contener solo letras");
        }
      } while (customerName.matches(regexName) == false);

      do {
        customerId = JOptionPane.showInputDialog("Ingrese el numero de cedula del comprador");

        if (!customerId.matches(regexCedula)) {
          JOptionPane.showMessageDialog(null, "El numero de cedula debe contener solo numeros");
        }
      } while (customerId.matches(regexCedula) == false);

      do {
        shippingDestination = JOptionPane.showInputDialog("Ingrese el destino del paquete");

        if (shippingDestination.trim().isEmpty()) {
          JOptionPane.showMessageDialog(null, "El destino no puede estar vacio");
        }
      } while (shippingDestination.trim().isEmpty());

      customerPhone = JOptionPane.showInputDialog("Ingrese el numero de telefono del comprador");
      customerEmail = JOptionPane.showInputDialog("Ingrese el correo electronico del comprador");
      storeName = JOptionPane.showInputDialog("Ingrese la tienda que vende el paquete");

      do {
        purchaseDate = JOptionPane.showInputDialog("Ingrese la fecha de compra del paquete");

        if (!purchaseDate.matches(regexDate)) {
          JOptionPane.showMessageDialog(null, "La fecha debe tener el formato YYYY-MM-DD");
        }
      } while (purchaseDate.matches(regexDate) == false);

      boolean error = false;

      do {

        do {
          weight = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el peso del paquete en kilogramos"));

          if (weight <= 0) {
            JOptionPane.showMessageDialog(null, "El peso debe ser mayor a 0 y no puede estar vacío");
            continue;
          }
        } while (weight <= 0);

        do {
          price = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio del paquete"));

          if (price <= 0) {
            JOptionPane.showMessageDialog(null, "El precio debe ser mayor a 0");
            continue;
          }
        } while (price <= 0);

        do {
          productType = JOptionPane.showInputDialog("Ingrese el tipo de producto que tiene la carga");

          if (productType.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El tipo de producto no puede estar vacio");
            continue;
          }
        } while (productType.trim().isEmpty());

        shippingType = Integer
            .parseInt(
                JOptionPane.showInputDialog("Selecciona la categoria del paquete\n1 -> A\n2 -> B\n3 -> C\n4 -> D"));

        error = false;

        switch (shippingType) {
          case 1:
            if (!productType.toUpperCase().contains("DOCUMENTOS")) {
              JOptionPane.showMessageDialog(null,
                  "El tipo de producto en la categoría A admite solo documentos. Intenta de nuevo");
              error = true;
            }

            break;

          case 2:
            if (price > 400 || weight > 4) {
              JOptionPane.showMessageDialog(null,
                  "El precio del paquete no puede ser mayor a 400 y el peso no puede ser mayor a 4. Prueba usando la categoría C");
              error = true;
            }

            break;

          case 3:
            if (price > 2000 || weight > 50) {
              JOptionPane.showMessageDialog(null,
                  "El precio del paquete no puede ser mayor a $2000 y el peso no puede ser mayor a 50 kg");
              error = true;
            }

            break;

          case 4:

            if (price > 2000 || weight > 20) {
              JOptionPane.showMessageDialog(null,
                  "El precio del paquete no puede ser mayor a $2000 y el peso no puede ser mayor a 20 kg. Reingresa los datos");
              error = true;
            }

            if (!productType.toUpperCase().contains("ROPA")) {
              JOptionPane.showMessageDialog(null,
                  "El tipo de producto en la categoría D admite solo ropa y calzado. Intenta de nuevo");
              error = true;
            }

            break;

          default:
            JOptionPane.showMessageDialog(null, "La opción seleccionada no es valida");
            error = true;

            break;
        }

      } while (error == true);

      totalPackages++;

      int endOfWorkDay = JOptionPane.showConfirmDialog(null, "¿Deseas ingresar la información de otro paquete?",
          "Continuar", JOptionPane.YES_NO_OPTION);

      // Condicional para comprobar si el encargado quiere ingresar información de más
      // productos. Si el
      // usuario presiona NO, se termina el programa

      if (endOfWorkDay == JOptionPane.NO_OPTION) {
        LocalDateTime endWorkTime = LocalDateTime.now();

        long totalTime = ChronoUnit.MINUTES.between(startWorkTime, endWorkTime);

        JOptionPane.showMessageDialog(null,
            "El tiempo total de trabajo es de: " + totalTime + " minutos. \n"
                + "El total de paquetes procesados es de: " + totalPackages + " paquetes.");

        break;
      }
    } while (true);
  }
}
