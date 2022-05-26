import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Hashtable;

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
   * que se está aplicando. Si no es así, el sistema debe mostrar un mensaje y
   * permitirle hacer un nuevo ingreso
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
    int totalApprovedPackages = 0;
    int totalRejectedPackages = 0;
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
    String packageCode = generatePackageCode();

    // Regex para validaciones
    // regex para validar nombre y apellido del cliente que permita espacios
    // entre palabras
    String regexName = "^[a-zA-Z\\s]+$";
    String regexCedula = "^[0-9]*$";
    String regexDate = "^[0-9]{4}-[0-9]{2}-[0-9]{2}$";

    final double IVA = 0.15, Fodinfa = 0.05, advalorem = 0.1, especifico = 5.5;

    JOptionPane.showMessageDialog(null,
        "* * * * * * * * * * * * * * * * * * * * * * * * * * *"
            + "\nBienvenido al Sistema de envíos de Cool Courier\n"
            + "* * * * * * * * * * * * * * * * * * * * * * * * * * *");

    do {
      // Petición de datos del cliente junto con validaciones
      // do {
      // customerName = JOptionPane.showInputDialog("Ingrese el nombre del
      // comprador");

      // if (customerName.trim().isEmpty()) {
      // JOptionPane.showMessageDialog(null, "El nombre no puede estar vacío");
      // continue;
      // }

      // if (!customerName.matches(regexName)) {
      // JOptionPane.showMessageDialog(null, "El nombre debe contener solo letras");
      // continue;
      // }
      // } while (customerName.matches(regexName) == false ||
      // customerName.trim().isEmpty());

      // do {
      // customerId = JOptionPane.showInputDialog("Ingrese el número de cédula del
      // comprador");

      // if (customerId.trim().isEmpty()) {
      // JOptionPane.showMessageDialog(null, "El numero de cedula no puede estar
      // vacío");
      // continue;
      // }

      // if (!customerId.matches(regexCedula) || customerId.length() != 10) {
      // JOptionPane.showMessageDialog(null, "El numero de cedula debe contener solo
      // números. Y solo 10 dígitos");
      // continue;
      // }

      // } while (!customerId.matches(regexCedula) || customerId.trim().isEmpty());

      // do {
      // shippingDestination = JOptionPane.showInputDialog("Ingrese el destino de
      // envío del paquete");

      // if (shippingDestination.trim().isEmpty()) {
      // JOptionPane.showMessageDialog(null, "El campo del destino de envío no puede
      // estar vacio");
      // }
      // } while (shippingDestination.trim().isEmpty());

      // customerPhone = JOptionPane.showInputDialog("Ingrese el número de telefono
      // del comprador");
      // customerEmail = JOptionPane.showInputDialog("Ingrese el e-mail del
      // comprador");
      // storeName = JOptionPane.showInputDialog("Ingrese la tienda que vende el
      // paquete");

      // do {
      // purchaseDate = JOptionPane.showInputDialog("Ingrese la fecha de compra del
      // paquete (YYYY-MM-DD)");

      // if (!purchaseDate.matches(regexDate)) {
      // JOptionPane.showMessageDialog(null, "La fecha debe tener el formato
      // YYYY-MM-DD");
      // }
      // } while (!purchaseDate.matches(regexDate));

      boolean error = false;

      do {

        do {
          try {
            weight = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el peso del paquete en kilogramos"));

            if (weight <= 0) {
              JOptionPane.showMessageDialog(null, "El campo del peso del paquete debe ser mayor a 0");
              continue;
            }

            error = false;
          } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "El campo del peso del paquete debe ser un número");
            error = true;
          }
        } while (weight <= 0 || error);

        do {
          try {
            price = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio del paquete"));

            if (price <= 0) {
              JOptionPane.showMessageDialog(null, "El precio debe ser mayor a 0");
            }

            error = false;
          } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "El precio debe ser un número");
            error = true;
          }
        } while (price <= 0 || error);

        boolean productTypeError = false;

        do {
          try {
            productType = JOptionPane.showInputDialog("Ingrese el tipo de producto que tiene la carga" + "\n"
                + "1. Documentos" + "\n" + "2. Ropa/Calzado" + "\n" + "3. Otros");

            if (Integer.parseInt(productType) < 1 || Integer.parseInt(productType) > 3) {
              JOptionPane.showMessageDialog(null, "El tipo de producto debe ser un número entre 1 y 3");
              productTypeError = true;
              continue;
            }

            if (productType.trim().isEmpty()) {
              JOptionPane.showMessageDialog(null, "El tipo de producto no puede estar vacio");
              continue;
            }

            productTypeError = false;
            if (productType.equals("1")) {
              productType = "Documentos";
            } else if (productType.equals("2")) {
              productType = "Ropa/Calzado";
            } else {
              productType = "Otros";
            }
          } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "El tipo de producto debe ser un número entre 1 y 3");
            productTypeError = true;
          }

        } while (productType.trim().isEmpty() || productTypeError);

        do {
          try {
            shippingType = Integer
                .parseInt(
                    JOptionPane
                        .showInputDialog(
                            "Selecciona la categoría del paquete\n1 -> A" + "\n2 -> B"
                                + "\n3 -> C\n4 -> D\n"
                                + "\nPara más información visita https://www.aduana.gob.ec/envios-courier-postal/"));

            if (shippingType < 1 || shippingType > 4) {
              JOptionPane.showMessageDialog(null, "El tipo de envío debe ser un número entre 1 y 4");
              error = true;
              continue;
            }

            // Confirmación de datos del paquete

            int isCorrectPackageInformation = JOptionPane.showConfirmDialog(null,
                "¿Los siguientes datos están correctos?" + "\n" + "\n" + "Peso del paquete: " + weight + "kg\n"
                    + "Precio del paquete: $" + price + "\n" + "Tipo de producto: " + productType + "\n" + "Categoría: "
                    + shippingType,
                "Confirmación", JOptionPane.YES_NO_OPTION);

            if (isCorrectPackageInformation == JOptionPane.NO_OPTION) {
              JOptionPane.showMessageDialog(null, "Reingrese los datos");
              error = true;
              break;
            }

            error = false;

            switch (shippingType) {
              case 1:
                if (!productType.toUpperCase().contains("DOCUMENTOS")) {
                  JOptionPane.showMessageDialog(null,
                      "El tipo de producto en la categoría A admite solo documentos y tu carga contiene" + "\n"
                          + "\n->" + productType
                          + "\n\n*** Paquete rechazado ***");

                  totalRejectedPackages++;
                } else {
                  JOptionPane.showMessageDialog(null,
                      "El paquete fue aprovado");
                  new BusinessLogistics().showInvoice(customerName, customerId, packageCode, productType, shippingType,
                      weight, price);

                  totalApprovedPackages++;
                }

                break;

              case 2:
                if (price > 400 || weight > 4) {
                  JOptionPane.showMessageDialog(null,
                      "El precio del paquete en categoría B no puede ser mayor a 400 y el peso no puede ser mayor a 4."
                          + "\nTu paquete tiene la siguiente información:"
                          + "\n\n-> Peso: " + weight + "kg" + "\n-> Precio: $" + price
                          + "\n\n***  Paquete rechazado  ***");

                  totalRejectedPackages++;
                } else {
                  JOptionPane.showMessageDialog(null,
                      "El paquete fue aprovado");
                  new BusinessLogistics().showInvoice(customerName, customerId, packageCode, productType, shippingType,
                      weight,
                      price);

                  totalApprovedPackages++;
                }

                break;

              case 3:
                if (price > 2000 || weight > 50) {
                  JOptionPane.showMessageDialog(null,
                      "El precio del paquete no puede ser mayor a $2000 y el peso no puede ser mayor a 50 kg."
                          + "\n\nTu paquete tiene la siguiente información:"
                          + "\n-> Peso: " + weight + "kg"
                          + "\n-> Precio: $" + price
                          + "\n\n***  Paquete rechazado  ***");

                  totalRejectedPackages++;
                } else {
                  JOptionPane.showMessageDialog(null,
                      "El paquete fue aprovado");
                  new BusinessLogistics().showInvoice(customerName, customerId, packageCode, productType, shippingType,
                      weight,
                      price, IVA, Fodinfa);

                  totalApprovedPackages++;
                }

                break;

              case 4:

                if (price > 2000 || weight > 20) {
                  JOptionPane.showMessageDialog(null,
                      "El precio del paquete no puede ser mayor a $2000 y el peso no puede ser mayor a 20 kg."
                          + "\n\nTu paquete tiene la siguiente información:"
                          + "\n-> Peso: " + weight + "kg"
                          + "\n-> Precio: $" + price
                          + "\n\n***  Paquete rechazado  ***");

                  totalRejectedPackages++;
                } else if (!productType.toUpperCase().contains("ROPA")) {
                  JOptionPane.showMessageDialog(null,
                      "El tipo de producto en la categoría D admite solo ropa y calzado. Tu carga contiene"
                          + "\n\n->" + productType
                          + "\n\n*** Paquete rechazado ***");

                  totalRejectedPackages++;
                } else {
                  JOptionPane.showMessageDialog(null,
                      "El paquete fue aprovado");
                  new BusinessLogistics().showInvoice(customerName, customerId, packageCode, productType, shippingType,
                      weight,
                      price, IVA, Fodinfa, advalorem, especifico);

                  totalApprovedPackages++;
                }

                break;

              default:
                JOptionPane.showMessageDialog(null, "La categoría seleccionada no es valida. Intenta de nuevo");
                error = true;
                break;
            }
          } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "El tipo de envío debe ser un número entre 1 y 4");
            error = true;
          }
        } while (error);

      } while (error);

      int endOfWorkDay = JOptionPane.showConfirmDialog(null, "¿Deseas ingresar la información de otro paquete?",
          "Continuar", JOptionPane.YES_NO_OPTION);

      // Condicional para comprobar si el encargado quiere ingresar información de más
      // productos. Si el
      // usuario presiona NO, se termina el programa

      if (endOfWorkDay == JOptionPane.NO_OPTION) {
        LocalDateTime endWorkTime = LocalDateTime.now();

        long totalTime = ChronoUnit.MINUTES.between(startWorkTime, endWorkTime);

        JOptionPane.showMessageDialog(null,
            "El tiempo total de trabajo es de: " + totalTime + " minutos."
                + "\nEl total de paquetes procesados es de: " + totalApprovedPackages + " paquetes.");

        break;
      }
    } while (true);
  }

  String generatePackageCode() {
    String packageCode = "";

    for (int i = 0; i < 6; i++) {
      int randomNumber = (int) (Math.random() * 10);
      packageCode += randomNumber;
    }

    return packageCode;
  }

  // Sobrecarga de métodos para controlar los parámetros opcionales

  void showInvoice(String customerName, String customerId, String packageCode, String productType, int shippingType,
      double weight, double price) {

    JOptionPane.showMessageDialog(null,
        "***  Factura  ***" + "\n\n"
            + "* * * * * * * * * * * * * * * * * * * * * * * * *"
            + "\nNombre: " + customerName
            + "\nCédula: " + customerId
            + "\n\nCódigo del paquete: " + packageCode
            + "\nTipo de producto: " + productType
            + "\nTipo de envío: " + shippingType
            + "\nPeso del paquete: " + weight + "kg"
            + "\n\nIVA: 0%"
            + "\nSubtotal: $" + (price)
            + "\n\n* * * * * * * * * * * * * * * * * * * * * * * * *"
            + "\nPrecio Total: $" + (price));
  }

  void showInvoice(String customerName, String customerId, String packageCode, String productType, int shippingType,
      double weight, double price, double IVA, double Fodinfa) {

    JOptionPane.showMessageDialog(null,
        "***  Factura ***" + "\n\n"
            + "* * * * * * * * * * * * * * * * * * * * * * * * *"
            + "\nNombre: " + customerName
            + "\nCédula: " + customerId
            + "\n\nCódigo del paquete: " + packageCode
            + "\nTipo de producto: " + productType
            + "\nTipo de envío: " + shippingType
            + "\nPeso del paquete: " + weight + "kg"
            + "\n\nIVA: " + (IVA * 100) + "%"
            + "\nFodinfa: " + (Fodinfa * 100) + "%"
            + "\nSubtotal: $" + (price)
            + "\n\n* * * * * * * * * * * * * * * * * * * * * * * * *"
            + "\nPrecio Total: $" + (price + IVA + Fodinfa));
  }

  void showInvoice(String customerName, String customerId, String packageCode, String productType, int shippingType,
      double weight, double price, double IVA, double Fodinfa, double advalorem, double especifico) {

    JOptionPane.showMessageDialog(null,
        "***  Factura ***" + "\n\n"
            + "* * * * * * * * * * * * * * * * * * * * * * * * *"
            + "\nNombre: " + customerName
            + "\nCédula: " + customerId
            + "\n\nCódigo del paquete: " + packageCode
            + "\nTipo de producto: " + productType
            + "\nTipo de envío: " + shippingType
            + "\nPeso del paquete: " + (weight * 2.2) + "lb"
            + "\n\nIVA: " + (IVA * 100) + "%"
            + "\nFodinfa: " + (Fodinfa * 100) + "%"
            + "\nAdvalorem: " + (advalorem * 100) + "%"
            + "\nEspecífico: $" + (especifico) + " por kg"
            + "\nSubtotal: $" + (price)
            + "\n\n* * * * * * * * * * * * * * * * * * * * * * * * *"
            + "\nPrecio Total: $" + (price + IVA + Fodinfa + advalorem + (especifico * weight)));
  }
}
