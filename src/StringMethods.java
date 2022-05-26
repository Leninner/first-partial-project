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
      userMainOption =Integer.parseInt(
        JOptionPane.showInputDialog("Escoge el método que deseas utilizar\n1.charAt\n2.compareTo\n3.contains\n4.endsWith\n5.equals\n6.equalsIgnoreCase\n7.indexOf\n8.lastIndexOf\n9.length\n10.replace\n11.startsWith\n12.substring\n13.toLowerCase\n14.toUpperCase\n15.trim\n16.split\n17.Salir"));
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
        JOptionPane.showMessageDialog(null, "El método endsWith se usa para verificar si la cadena termina \ncon la subcadena especificada por el usuario o no. En función de esta \ncomparación, devolverá booleano Verdadero o Falso.");
          break;
        case 5:
        JOptionPane.showMessageDialog(null, "El método equals se utiliza para comparar dos objetos. Ojo no \nconfundir con el operador ==; se usa para saber si dos objetos son del \nmismo tipo y tienen los mismos datos. Nos dara el valor true si son\n iguales y false si no.");
          break;
        case 6:
        JOptionPane.showMessageDialog(null, "El método equalsIgnoreCase compara dos strings para ver si son \niguales ignorando las diferencias entre mayúsculas y minúsculas. Este \nmétodo es necesario porque no es posible comparar strings usando el \noperador de igualdad (==). Retorna true si los strings son iguales y\n false si no lo son.");
          break;
        case 7:
        JOptionPane.showMessageDialog(null, "");
          break;
        case 8:
        JOptionPane.showMessageDialog(null, "");
          break;
        case 9:
        JOptionPane.showMessageDialog(null, "");
          break;
        case 10:
        JOptionPane.showMessageDialog(null, "");
          break;
        case 11:
        JOptionPane.showMessageDialog(null, "");
          break;
        case 12:
        JOptionPane.showMessageDialog(null, "");
          break;
        case 13:
        JOptionPane.showMessageDialog(null, "");
          break;
        case 14:
        JOptionPane.showMessageDialog(null, "");
          break;
        case 15:
        JOptionPane.showMessageDialog(null, "");
          break;
        case 16:
        JOptionPane.showMessageDialog(null, "");
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
