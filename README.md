# Proyecto del Primer Parcial de Algorítmos y Lógica de Programación

<h2>Índice</h2>

- [Proyecto del Primer Parcial de Algorítmos y Lógica de Programación](#proyecto-del-primer-parcial-de-algorítmos-y-lógica-de-programación)
  - [Overview](#overview)
  - [Project Specifications](#project-specifications)
  - [Getting Started](#getting-started)
  - [Folder Structure](#folder-structure)
  - [Dependency Management](#dependency-management)
  - [Acknoledgements](#acknoledgements)

## Overview

Este proyecto es una aplicación que servirá como proyecto del primer parcial de la materia de Programación

## Project Specifications

Elaborar un programa que contenga un menú con 4 opciones, de acuerdo al siguiente detalle:

- **Opción 1:** Programa en donde se visualice la aplicación de varios métodos de la clase String, así como del método printf, generando ejemplos de los diversos tipos de formatos que puede aplicar a los textos.

- **Opción 2:** Aplicación para registrar la venta de boletos de buses interprovinciales.

  - Se debe ingresar la fecha y hora del viaje mediante una cadena de texto y luego almacenar de manera separada en variables de tipo entero.

  - Además, debe obtener la fecha y hora del inicio y final de la compra del boleto; al finalizar mostrar el tiempo que duró la compra.

  - El sistema le debe permitir al usuario ingresar la cantidad de viajeros que desee (es importante que solicite información de cada viajero como nombres, apellidos, edad, cédula) y luego seleccionar el destino, en donde el sistema le debe mostrar al menos 8destinos a los que puede viajar, tomando en cuenta que solo partirá de la ciudad de Ambato.

  - El sistema debe aplicar varios descuentos que deberán ser aplicados mediante condiciones elaboradas por Ustedes (al menos 5 condiciones anidadas).

  - Al finalizar el proceso de compra del boleto se debe mostrar en pantalla la información del boleto (fecha de compra, fecha del viaje, destino, viajeros, etc.) y adicionalmente la siguiente información: subtotal, subtotal + IVA, descuentos, valor total.

  - Mostrar el número de viajeros, el mayor descuento aplicado y el tiempo de compra expresada en minutos. Se recomienda utilizar printf para la impresión de resultados.

- **Opción 3:** Aplicación de Courier para gestionar los envíos de paquetes.

  El sistema debe permitir la gestión de paquetes, que debe cumplir los siguientes requerimientos:

  - El sistema de iniciar preguntando al encargado sobre los siguientes parámetros de cada paquete:

    - Destino de envío
    - Peso de la carga, en Kg
    - Tienda que vende
    - Fecha de compra
    - Precio antes del envío
    - Tipo de productos que contiene (requerido)

    - Información del comprador:

      - Nombres y Apellidos (Requerido)
      - Cédula (Requerido)
      - Dirección (Opcional)
      - Teléfono (Opcional)
      - Correo Electrónico (Opcional)

    - Tipo de envío (Requerido)

  - El sistema tiene que validar que todos los datos estén de acuerdo con lo solicitado:

        - Se debe controlar que el paquete esté en concordancia con el tipo de envío que se está aplicando.

          - **Categoría A:** Documentos
            Esta categoría está libre de impuestos y no requiere ningún documento de control previo a la importación.

          - **Categoría B:** 4 x 4
            Son todos los paquetes que pesan hasta 4 kilogramos y hasta USD$400, usado únicamente por personas naturales.

          - **Categoría C:** 50 Kg $2000
            Son todos los paquetes que pesan hasta 50 kilogramos y hasta USD $2.000 que no entren en ninguna otra categoría.
            Esta categoría si paga impuestos:
              - Advalorem: el porcentaje dependerá del producto
              - IVA: 12%
              - Fodinfa: 0.5%.

          - **Categoría D:** Textiles y Calzados
            El precio no puede excederse a los 20 kg ni el valor sobrepasar los US$ 2.000,00

            Esta categoría paga estos impuestos:
              - Advalorem: 10%
              - Específico: $5.5 por cada Kg de ropa, en el caso de calzado $6,00 por cada par de zapato.|
              - IVA: 12%
              - Fodinfa: 0.5%

  - El sistema debe retornar un mensaje de error en caso de que alguno de los datos no cumpla con lo solicitado y volver a solicitar el dato erroneo

  - El sistema debe generar un código de seguimiento que será un **código** de 10 dígitos, el cual debe ser único.

  - Al finalizar, se debe mostrar el resumen de la información, con los costos de envío totales, el valor total de la compra, el valor total de los impuestos, el valor total de los descuentos, el valor total de la compra con impuestos y descuentos, el tiempo de envío.

  - También, cuando el encargado termine su día de trabajo, se le debe mostrar el tiempo total de trabajo y el total de paquetes procesados bajo cada categoría.

- **Opción 4:** Salir.

En todas las opciones, al terminarla, se deberá preguntar al usuario si desea ejecutar esa opción otra vez o no, en caso de querer salir debe regresar al menú principal de opciones.

El programa deberá tener la mayor cantidad de controles posibles.

Se valorará de la aplicación: la efectividad, eficiencia, facilidad de uso, pertinencia de las sentencias y estructuras utilizadas, comentarios sobre el código y que tenga los controles correspondientes.

Adicionalmente, se expondrá el programa y cada integrante deberá demostrar que conoce el código y lo puede cambiar de acuerdo a lo que se pida en ese momento.

Las explicaciones deben ser puntuales y técnicamente fundamentadas, para lo cual es fundamental conocer la teoría explicada en clase.

Solo se pueden utilizar para la elaboración del programa las sentencias que se han revisado en clase. De preferencia, debe realizar el programa en un solo archivo “.java”.

## Getting Started

Si quiéres ejecutar el programa en tu entorno local, necesitas tener instalado el siguiente software:

- [JDK en su última versión](https://www.oracle.com/java/technologies/downloads/)
- [Git](https://git-scm.com/downloads)
- Cualquier IDE que tengas instalado en tu computadora, nosotros preferimos [Visual Studio Code](https://code.visualstudio.com/download)

Clona el repositorio de GitHub con el siguiente comando:

```bash
git clone https://github.com/Leninner/first-partial-project
```

Luego, compila el proyecto y mira la magia 🌟🌟

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).

## Acknoledgements

- [Cómo utilizar JOptionPane.showConfirmDialog() en Java](https://www.youtube.com/watch?v=GwjUKVeVtCo&ab_channel=FredyGeek)
- [Cómo crear un timer en Java](https://www.jc-mouse.net/java/contar-segundos-problema-resuelto)
