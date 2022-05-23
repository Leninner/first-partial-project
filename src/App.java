import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) throws Exception {
        char userMainOption;
        boolean exit = false;

        do {
            userMainOption = JOptionPane
                    .showInputDialog(
                            "¿Qué quieres hacer hoy?\n1. Métodos de Strings\n2. Manejar la venta de boletos en un terminal de buses\n3. Manejar la logística de los productos de una empresa\n4. Salir")
                    .charAt(0);

            int isAgain = 0;

            while (isAgain == 0 && userMainOption != '4') {
                switch (userMainOption) {
                    case '1':
                        new App().showStringMethods();
                        break;
                    case '2':
                        new App().manageBusTicketSales();
                        break;

                    case '3':
                        new App().manageBusinessLogistics();
                        break;

                    default:
                        JOptionPane.showMessageDialog(null, "Opción no  válida, vuelve a intentarlo");
                        isAgain = 1;
                        // Se hace uso de `continue` para que no me vuelva a preguntar si deseo repetir
                        // la
                        // opción
                        continue;
                }

                isAgain = JOptionPane.showConfirmDialog(null, "¿Quiéres volver a repetir esta opción?",
                        "Confirmación de repetición",
                        JOptionPane.YES_NO_OPTION);
            }

            // Controles para comprobar si el usuario quiere salir del menú principal o no
            if (userMainOption == '4') {
                int exitOption = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que quieres salir?", "",
                        JOptionPane.YES_NO_OPTION);
                exit = exitOption == JOptionPane.YES_OPTION;
            }
        } while (!exit);
    }

    // Lógica del menú de opciones

    // Option 1:

    void showStringMethods() {
        /**
         * TODO: Implementar un menú para que el usuario seleccione el método que desea
         * utilizar y muestre la descripción del método junto a un ejemplo de su uso,
         * haciendo uso de JOptionPane. El menú debe estar en un loop infinito hasta que
         * el usuario seleccione
         * la opción de salir.
         * 
         * Métodos de Strings:
         * .charAt(int index)
         * .compareTo(String str)
         * .contains(String str)
         * .endsWith(String str)
         * .equals(String str)
         * .equalsIgnoreCase(String str)
         * .indexOf(String str)
         * .lastIndexOf(String str)
         * .length()
         * .replace(String target, String replacement)
         * .startsWith(String str)
         * .substring(int beginIndex, int endIndex)
         * .toLowerCase()
         * .toUpperCase()
         * .trim()
         * .split(String regex)
         */

        JOptionPane.showMessageDialog(null, "Leninsin");
    }

    // Option 2:

    void manageBusTicketSales() {
        JOptionPane.showMessageDialog(null, "Leninsin, opción 2");
    }

    // Option 3:

    void manageBusinessLogistics() {
        JOptionPane.showMessageDialog(null, "Leninsin, opción 3");
    }

}
