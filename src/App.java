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
                        new StringMethods().showStringMethods();
                        break;
                    case '2':
                        new BusTicketSales().manageBusTicketSales();
                        break;

                    case '3':
                        new BusinessLogistics().manageBusinessLogistics();
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

}
