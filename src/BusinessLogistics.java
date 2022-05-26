import java.time.LocalDateTime;
import javax.swing.JOptionPane;

public class BusinessLogistics {
  void manageBusinessLogistics() {
    final double IVA = 0.15, Fodinfa = 0.05, advalorem = 0.1, especifico = 5.5;

    LocalDateTime startWorkTime = LocalDateTime.now();

    int totalApprovedPackages = 0;
    int totalRejectedPackages = 0;
    double weight = 0;
    double price = 0;
    int shippingType = 0;

    // Variables de tipo string utilizadas
    String customerName = "";
    String customerId = "";
    String shippingDestination = "";
    String customerPhone = "";
    String customerEmail = "";
    String storeName = "";
    String purchaseDate = "";
    String productType = "";
    String packageCode = generatePackageCode();

    // Regex para validaciones
    String regexName = "^[a-zA-Z\\s]+$";
    String regexCedula = "^[0-9]*$";
    String regexDate = "^[0-9]{4}-[0-9]{2}-[0-9]{2}$";

    JOptionPane.showMessageDialog(null,
        "* * * * * * * * * * * * * * * * * * * * * * * * * * *"
            + "\nBienvenido al Sistema de envíos de Cool Courier\n"
            + "* * * * * * * * * * * * * * * * * * * * * * * * * * *");

    do {
      // Petición de datos del cliente junto con validaciones
      do {
        customerName = JOptionPane.showInputDialog("Ingrese el nombre del comprador");

        if (customerName.trim().isEmpty()) {
          JOptionPane.showMessageDialog(null, "El nombre no puede estar vacío");
          continue;
        }

        if (!customerName.matches(regexName)) {
          JOptionPane.showMessageDialog(null, "El nombre debe contener solo letras");
          continue;
        }
      } while (customerName.matches(regexName) == false || customerName.trim().isEmpty());

      do {
        customerId = JOptionPane.showInputDialog("Ingrese el número de cédula del comprador");

        if (customerId.trim().isEmpty()) {
          JOptionPane.showMessageDialog(null, "El numero de cedula no puede estar vacío");
          continue;
        }

        if (!customerId.matches(regexCedula) || customerId.length() != 10) {
          JOptionPane.showMessageDialog(null, "El numero de cedula debe contener solo números y solo 10 dígitos");
          continue;
        }

      } while (!customerId.matches(regexCedula) || customerId.trim().isEmpty() || customerId.length() != 10);

      do {
        shippingDestination = JOptionPane.showInputDialog("Ingrese el destino de envío del paquete");

        if (shippingDestination.trim().isEmpty()) {
          JOptionPane.showMessageDialog(null, "El campo del destino de envío no puede estar vacio");
        }
      } while (shippingDestination.trim().isEmpty());

      customerPhone = JOptionPane.showInputDialog("Ingrese el número de telefono del comprador");
      customerEmail = JOptionPane.showInputDialog("Ingrese el e-mail del comprador");
      storeName = JOptionPane.showInputDialog("Ingrese la tienda que vende el paquete");

      do {
        purchaseDate = JOptionPane.showInputDialog("Ingrese la fecha de compra del paquete (YYYY-MM-DD)");

        if (!purchaseDate.matches(regexDate)) {
          JOptionPane.showMessageDialog(null, "La fecha debe tener el formato YYYY-MM-DD");
        }
      } while (!purchaseDate.matches(regexDate));

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
                      weight, price, shippingDestination, customerPhone, customerEmail, storeName, purchaseDate);

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
                      price, shippingDestination, customerPhone, customerEmail, storeName, purchaseDate);

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
                      price, IVA, Fodinfa, shippingDestination, customerPhone, customerEmail, storeName, purchaseDate);

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
                      price, IVA, Fodinfa, advalorem, especifico, shippingDestination, customerPhone, customerEmail,
                      storeName, purchaseDate);

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

        long seconds = startWorkTime.until(endWorkTime, java.time.temporal.ChronoUnit.SECONDS);
        long minutes = startWorkTime.until(endWorkTime, java.time.temporal.ChronoUnit.MINUTES);
        long hours = startWorkTime.until(endWorkTime, java.time.temporal.ChronoUnit.HOURS);

        JOptionPane.showMessageDialog(null,
            "El tiempo total de trabajo es de: "
                + (hours % 24) + " horas, "
                + (minutes % 60) + " minutos y "
                + (seconds % 60) + " segundos"
                + "\nEl total de paquetes aprovados es de: " + totalApprovedPackages
                + "\nEl total de paquetes rechazados es de: " + totalRejectedPackages);

        break;
      }
    } while (true);
  }

  // Método para obtener un código de paquete aleatorio único
  String generatePackageCode() {
    String packageCode = "";

    for (int i = 0; i < 10; i++) {
      int randomNumber = (int) (Math.random() * 10);
      packageCode += randomNumber;
    }

    return packageCode;
  }

  // Sobrecarga de métodos para controlar los parámetros opcionales
  void showInvoice(String customerName, String customerId, String packageCode, String productType, int shippingType,
      double weight, double price, String shippingDestination, String customerPhone, String customerEmail,
      String storeName, String purchaseDate) {

    JOptionPane.showMessageDialog(null,
        "***  Factura  ***" + "\n\n"
            + "* * * * * * * * * * * * * * * * * * * * * * * * *"
            + "\nNombre: " + customerName
            + "\nCédula: " + customerId
            + "\nTeléfono: " + customerPhone
            + "\nCorreo: " + customerEmail
            + "\nFecha de Compra: " + purchaseDate
            + "\n\nCódigo del paquete: " + packageCode
            + "\nTienda: " + storeName
            + "\nDirección de envío: " + shippingDestination
            + "\nTipo de producto: " + productType
            + "\nTipo de envío: " + shippingType
            + "\nPeso del paquete: " + Math.round((weight * 2.2) * 100.0) / 100.0 + " lb"
            + "\n\nIVA: 0%"
            + "\nSubtotal: $" + Math.round((price) * 100.0) / 100.0
            + "\n\n* * * * * * * * * * * * * * * * * * * * * * * * *"
            + "\nPrecio Total: $" + (Math.round((price) * 100.0) / 100.0));
  }

  void showInvoice(String customerName, String customerId, String packageCode, String productType, int shippingType,
      double weight, double price, double IVA, double Fodinfa, String shippingDestination, String customerPhone,
      String customerEmail,
      String storeName, String purchaseDate) {

    JOptionPane.showMessageDialog(null,
        "***  Factura ***" + "\n\n"
            + "* * * * * * * * * * * * * * * * * * * * * * * * *"
            + "\nNombre: " + customerName
            + "\nCédula: " + customerId
            + "\nTeléfono: " + customerPhone
            + "\nCorreo: " + customerEmail
            + "\nFecha de Compra: " + purchaseDate
            + "\n\nCódigo del paquete: " + packageCode
            + "\nTienda: " + storeName
            + "\nDirección de envío: " + shippingDestination
            + "\nTipo de producto: " + productType
            + "\nTipo de envío: " + shippingType
            + "\nPeso del paquete: " + Math.round((weight * 2.2) * 100.0) / 100.0 + " lb"
            + "\n\nIVA: " + (IVA * 100) + "%"
            + "\nFodinfa: " + (Fodinfa * 100) + "%"
            + "\nSubtotal: $" + (Math.round((price) * 100.0) / 100.0)
            + "\n\n* * * * * * * * * * * * * * * * * * * * * * * * *"
            + "\nPrecio Total: $" + Math.round(((price + (IVA * price) + (Fodinfa * price))) * 100.0) / 100.0);
  }

  void showInvoice(String customerName, String customerId, String packageCode, String productType, int shippingType,
      double weight, double price, double IVA, double Fodinfa, double advalorem, double especifico,
      String shippingDestination, String customerPhone, String customerEmail,
      String storeName, String purchaseDate) {

    JOptionPane.showMessageDialog(null,
        "***  Factura ***" + "\n\n"
            + "* * * * * * * * * * * * * * * * * * * * * * * * *"
            + "\nNombre: " + customerName
            + "\nCédula: " + customerId
            + "\nTeléfono: " + customerPhone
            + "\nCorreo: " + customerEmail
            + "\nFecha de Compra: " + purchaseDate
            + "\n\nCódigo del paquete: " + packageCode
            + "\nTienda: " + storeName
            + "\nDirección de envío: " + shippingDestination
            + "\nTipo de producto: " + productType
            + "\nTipo de envío: " + shippingType
            + "\nPeso del paquete: " + Math.round((weight * 2.2) * 100.0) / 100.0 + " lb"
            + "\n\nIVA: " + (IVA * 100) + "%"
            + "\nFodinfa: " + (Fodinfa * 100) + "%"
            + "\nAdvalorem: " + (advalorem * 100) + "%"
            + "\nEspecífico: $" + (especifico) + " por kg"
            + "\nSubtotal: $" + (Math.round((price) * 100.0) / 100.0)
            + "\n\n* * * * * * * * * * * * * * * * * * * * * * * * *"
            + "\nPrecio Total: $"
            + Math.round(
                ((price + (IVA * price) + (Fodinfa * price) + (advalorem * price) + (especifico * weight))) * 100.0)
                / 100.0);
  }
}
