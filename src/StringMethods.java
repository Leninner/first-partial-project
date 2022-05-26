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
      userMainOption = Integer.parseInt(
          JOptionPane.showInputDialog(
              "Escoge el método que deseas utilizar\n1.charAt\n2.compareTo\n3.contains\n4.endsWith\n5.equals\n6.equalsIgnoreCase\n7.indexOf\n8.lastIndexOf\n9.length\n10.replace\n11.startsWith\n12.substring\n13.toLowerCase\n14.toUpperCase\n15.trim\n16.split\n17.Salir"));
      switch (userMainOption) {
        case 1:
          JOptionPane.showMessageDialog(null,
              "El método .charAt devuelve el carácter en el índice definido.\nEn este método, el valor del índice debe estar entre 0 y la longitud \nde la cadena menos 1 \n Ejemplo:\n String name = 'mathias' \n name.charAt(0)-> m");
          break;
        case 2:
          JOptionPane.showMessageDialog(null,
              "El método .compareTo se usa para realizar una ordenación natural\nen una cadena.Clasificación natural significa el orden de clasificación \nque se aplica al objeto, por ejemplo, orden léxico para Cadena,\n orden numérico para ordenar enteros, etc.\n Ejemplo:\n String s1 = lapiz1\nString s2 = lapiz2\n int s = s1.compareTo(s2)");
          break;
        case 3:
          JOptionPane.showMessageDialog(null,
              "El método .contains es un método Java para verificar si String \ncontiene otra subcadena o no.Devuelve un valor booleano para que pueda\n usarse directamente dentro de sentencias if.\n Ejemplo:\n String str1 = 'En el libro hay un Ejemplo' \n if (str1.contains('ejemplo')) {\nSystem.out.println('La variable :ejemplo:  se encuentra en la cadena');\n} else {\nSystem.out.println(La variable :ejemplo: no se encuentra en la cadena')\nLa variable :ejemplo: no se encuentra en la cadena");
          break;
        case 4:
          JOptionPane.showMessageDialog(null,
              "El método .endsWith se usa para verificar si la cadena termina \ncon la subcadena especificada por el usuario o no. En función de esta \ncomparación, devolverá booleano Verdadero o Falso.\n Ejemplo:\n String phrase = 'Las matematicas son geniales'\n System.out.println(EndsWith character 's':  + str_Sample.endsWith('s')");
          break;
        case 5:
          JOptionPane.showMessageDialog(null,
              "El método .equals se utiliza para comparar dos objetos. Ojo no \nconfundir con el operador ==; se usa para saber si dos objetos son del \nmismo tipo y tienen los mismos datos. Nos dara el valor true si son\n iguales y false si no.\n Ejemplo:\n String date = 'siempre'\n String date2 = 'siempre'\n if(date.equals(dos)){\n System.out.println('Coinciden')}\n Coinciden");
          break;
        case 6:
          JOptionPane.showMessageDialog(null,
              "El método .equalsIgnoreCase compara dos strings para ver si son \niguales ignorando las diferencias entre mayúsculas y minúsculas. Este \nmétodo es necesario porque no es posible comparar strings usando el \noperador de igualdad (==). Retorna true si los strings son iguales y\n false si no lo son.\n Ejemplo:\n String date = 'SieMpre'\nString date2 = 'siempre'\n if(date.equalsIgnoreCase(dos)==true){\n System.out.println('Coinciden sin importar la diferencia\n de mayúsculas o minúsculas')}\nCoinciden sin importar la diferencia\n de mayúsculas o minúsculas");
          break;
        case 7:
          JOptionPane.showMessageDialog(null,
              "El método .indexOf se usa para obtener el valor entero de un índice\n particular de objeto tipo String, en base a los criterios especificados\n en los parámetros del método IndexOf.\n Ejemplo:\n Strind date = 'Programacion'\n System.out.println(date.indexOf('P'))-> 0 \nSystem.out.println(date.indexOf('p'))-> -1 \n  \n //- 1= no existe ");
          break;
        case 8:
          JOptionPane.showMessageDialog(null,
              "El método .lastIndexOf se utiliza para averiguar el índice de la última\n ocurrencia de un carácter o una subcadena en un String dado.\n Ejemplo:\n String date = 'caminando con C'\n System.out.println(date.lastIndexOf(str:'c'))\n 14 ");
          break;
        case 9:
          JOptionPane.showMessageDialog(null,
              "El método .length se usa para obtener la longitud de una cadena Java.\n El método de longitud de cadena devuelve la cantidad de caracteres escritos\n en la Cadena.\n Ejemplo:\n String date = 'Hola'\n  System.out.println(date.length)-> 8");
          break;
        case 10:
          JOptionPane.showMessageDialog(null,
              "El método .replace devuelve una nueva cadena resultante de reemplazar\n cada aparición de caracteres con un nuevo carácter\n Ejemplo:\n String date = new String('Las matematicas son utiles en la vida')\n System.out.println(date.replace('a', 'i')\n -> Lis mitemiticis son utiles en la vidi)");
          break;
        case 11:
          JOptionPane.showMessageDialog(null,
              "El método .startsWith se usa para verificar el prefijo de una cadena.\n Devuelve un valor booleano verdadero o falso dependiendo de si la cadena dada\n comienza con la letra o palabra especificada.\n Ejemplo:\n String date ='Vive cada dia como si fuera el ultimo'\nSystem.out.println(date.startsWith('Vive')\n True)");
          break;
        case 12:
          JOptionPane.showMessageDialog(null,
              "El método .substring devuelve un tipo String y nos pide como parámetros\n uno o dos valores enteros. \n Ejemplo:\n String date = 'La vida es hermosa'\n String nuevo = date.substring(0, 2)\n System.out.println(nuevo)\n -> La");
          break;
        case 13:
          JOptionPane.showMessageDialog(null,
              "El método .toLowerCase convierte cada carácter de la cadena en particular\n en la minúscula mediante el uso de las reglas de la configuración regional \npredeterminada.\n Ejemplo:\n String date = 'MaRIA'\n String date2 = date.toLowerCase()\n System.out.println(date2)\n -> maria");
          break;
        case 14:
          JOptionPane.showMessageDialog(null,
              "El método .toUpperCase se usa para convertir todos los caracteres de una \ncadena dada a mayúsculas. Devuelve el valor: Cadena en una letra mayúscula.\n Ejemplo:\n String date = 'MaRIA'\n String date2 = date.toUpperCase()\n System.out.println(date2)\n -> MARIA");
          break;
        case 15:
          JOptionPane.showMessageDialog(null,
              "El método .trim elimina los espacios en blanco en ambos extremos del string.\n Los espacios en blanco en este contexto, son todos los caracteres sin \ncontenido (espacio, tabulación, etc.).\n Ejemplo:\n String date = '    Hola, Bienvenidos    '\n System.out.println(date.trim())\n Hola, Bienvenidos");
          break;
        case 16:
          JOptionPane.showMessageDialog(null,
              "El método .split se utiliza para dividir una cadena en función del carácter\n especificado. Es un método de clase String y devuelve un array de cadena \ndespués de escupir la cadena. Podemos acceder más a cada \ncadena del array utilizando su valor de índice.\n Ejemplo:\n String date = 'hola / bienvenido / a / java'\nString []partes = date.split('/')\n for (int i = 0; i < partes.length;i++){\nSystem.out.println (parte[i])}\n hola \n bienvenido \n a \n java");
          break;
        case 17:
          exit = true;
          break;
        default:
        JOptionPane.showMessageDialog(null, "La opción ingresada no existe, ingresa una opción correcta");
          break;
      }
    } while (!exit);
  }
}
