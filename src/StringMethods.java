import javax.swing.JOptionPane;

public class StringMethods {
  void showStringMethods() {
    int userMainOption;
    boolean exit = false;
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
    do {
      userMainOption =Integer.parseInt(JOptionPane.showInputDialog("Escoge el método que deseas utilizar\n1.charAt\n2.compareTo\n3.contains\n4.endsWith\n5.equals\n6.equalsIgnoreCase\n7.indexOf\n8.lastIndexOf\n9.length\n10.replace\n11.startsWith\n12.substring\n13.toLowwerCase\n14.toUpperCase\n15.trim\n16.split"));
      switch (userMainOption) {
        case 1:
        JOptionPane.showMessageDialog(null,"El método .charAt devuelve el carácter en el índice definido.\nEn este método, el valor del índice debe estar entre 0 y la longitud \nde la cadena menos 1");
          
          break;
        case 2:
        JOptionPane.showMessageDialog(null, "El método compareTo se usa para realizar una ordenación natural\nen una cadena.Clasificación natural significa el orden de clasificación \nque se aplica al objeto, por ejemplo, orden léxico para Cadena,\n orden numérico para ordenar enteros, etc.");
          break;
        case 3:
        JOptionPane.showMessageDialog(null, "El método contains es un método Java para verificar si String \ncontiene otra subcadena o no.Devuelve un valor booleano para que pueda\n usarse directamente dentro de sentencias if.");
          break;
        case 4:
        JOptionPane.showMessageDialog(null, "");
          break;
        case 5:
          
          break;
      
        case 6:
          
          break;
      
        case 7:
          
          break;
      
        case 8:
          
          break;
      
        case 9:
          
          break;
      
        case 10:
          
          break;
      
        case 11:
          
          break;
      
        case 12:
          
          break;
      
        case 13:
          
          break;
      
        case 14:
          
          break;
        case 15:
          
          break;
        case 16:
          
          break;
        case 17:
          exit = true;
          break;
        default:
          break;
      }
    } while (!exit);

    JOptionPane.showMessageDialog(null, "Emilia");
  }
}
