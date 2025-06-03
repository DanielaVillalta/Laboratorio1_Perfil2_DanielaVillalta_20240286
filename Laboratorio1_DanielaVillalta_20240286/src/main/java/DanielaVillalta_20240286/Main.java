package DanielaVillalta_20240286;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static Scanner sc = new Scanner(System.in);
    //ID     cantidad
    static TreeMap<Integer, Integer> productos = new TreeMap<>();
    static int productoid = 10;


    public static void main(String[] args) {
        int opcion = 0;

        productos.put(1, 50);
        productos.put(2, 20);
        productos.put(3, 80);
        productos.put(4, 5);
        productos.put(5, 63);
        productos.put(6, 2);
        productos.put(7, 10);
        productos.put(8, 96);
        productos.put(9, 1);
        productos.put(10, 120);

        do {
            System.out.println("\nElija una opción:");
            System.out.println("1 - Agregar un producto.");
            System.out.println("2 - Actualizar stock de un producto.");
            System.out.println("3 - Mostrar lista de productos con stock bajo.");
            System.out.println("4 - Motrar lista de productos.");
            System.out.println("5 - Salir");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    productoid++;
                    agregarProducto();
                    break;
                case 2:
                    actualizarStock();
                    break;
                case 3:
                    alertarStockBajo();
                    break;
                case 4:
                    mostrarProductos();
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("La opción no es válida.");
                    break;
            }

        } while (opcion < 5 && opcion > 0);
    }

    public static void agregarProducto() {
        int stock = 0;
        System.out.println("Ingrese el stock del nuevo producto:");
        stock = sc.nextInt();
        productos.put(productoid, stock);
        System.out.println("Producto agregado, el ID se genera automáticamente.");
    }

    public static void actualizarStock() {
        System.out.println("Ingrese el ID del producto: ");
        int id = sc.nextInt();
        int nuevoStock = 0;

        if (productos.get(id) == null) {
            System.out.println("Producto no registrado.");
        } else {
            System.out.println("Ingrese la nueva cantidad de stock: ");
            nuevoStock = sc.nextInt();
            for (Map.Entry<Integer, Integer> entrada : productos.entrySet()) {
                if (entrada.getKey() == id) {
                    entrada.setValue(nuevoStock);
                }
            }
            System.out.println("Stock actualizado.");
        }
    }

    public static void alertarStockBajo() {
        for (Map.Entry<Integer, Integer> entrada : productos.entrySet()) {
            if (entrada.getValue() < 10) {
                System.out.println("ID: " + entrada.getKey() + ", stock: " + entrada.getValue());
            }
        }
    }

    public static void mostrarProductos() {
        for (Map.Entry<Integer, Integer> entrada : productos.entrySet()) {
            System.out.println("ID: " + entrada.getKey() + ", stock: " + entrada.getValue());
        }
    }
}