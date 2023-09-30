import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
public class codigoMerma {

    public static void main(String[] args) {

        Scanner datos = new Scanner(System.in);
        //DATOS PROPORCIONADOS AL SISTEMA
        String[] codigoBloque={"1","2","3","4","5"};
        double []metrosCuadrados={367.2,417.2,476,468,699.2};
        int [] cantidadLaminas={120,140,250,180,230};
        double[] costoBloque= {12000,15000,17000,20000,35000};
        String[] motivoMerma= {"roto en caja","roto en proceso de habilitado","roto por mala manipulacion"};

        ArrayList<String> registroCodigo =cargarDatosDesdeArchivo("codigos.txt");
        ArrayList<String> registroLote =cargarDatosDesdeArchivo("lotes.txt");
        ArrayList<String> registroFecha =cargarDatosDesdeArchivo("fechas.txt");
        ArrayList<String> registroUsuario =cargarDatosDesdeArchivo("usuarios.txt");
        ArrayList<String> registroProveedor =cargarDatosDesdeArchivo("proveedores.txt");
        ArrayList<String> registroPlanta =cargarDatosDesdeArchivo("plantas.txt");
        ArrayList<String> registroMotivo =cargarDatosDesdeArchivo("motivos.txt");
        ArrayList<String> registroDocumento =cargarDatosDesdeArchivo("documentos.txt");
        ArrayList<String> registroCentro =cargarDatosDesdeArchivo("centros.txt");
        ArrayList<String> registroLaminas=cargarDatosDesdeArchivo("laminas.txt");
        ArrayList<String> registrom2 =cargarDatosDesdeArchivo("metros.txt");
        ArrayList<String> registroValor =cargarDatosDesdeArchivo("valores.txt");

        boolean continuar =true;
        while (continuar) {
            System.out.println("Ingrese el codigo SAP del material: ");
            String codigo = datos.nextLine();
            System.out.println("Ingrese el lote SAP del material: ");
            String lote = datos.nextLine();
            System.out.println("Ingrese la cantidad de laminas rotas: ");
            int laminas = datos.nextInt();
            datos.nextLine();
            System.out.println("Ingrese la planta donde se encontró la merma:");
            String planta = datos.nextLine();
            System.out.println("Ingrese el motivo de la merma:");
            String motivo =datos.nextLine();
            System.out.println("Ingrese el numero de documento material SAP: ");
            String documento=datos.nextLine();
            System.out.println("Fecha de registro de merma: ");
            String fecha =datos.nextLine();
            System.out.println("Usuario que registra la merma: ");
            String usuario =datos.nextLine();
            System.out.println("Ingrese el proveedor del material: ");
            String proveedor= datos.nextLine();
            System.out.println("El centro de costo al que va dirigida la merma:");
            String centro = datos.nextLine();

            System.out.println("Desea guardar los datos (si/guardar)");
            String decision = datos.nextLine().toLowerCase();

            if (decision.equals("si")) {
                registroCodigo.add(codigo);
                registroLote.add(lote);
                registroLaminas.add(String.valueOf(laminas));
                registroPlanta.add(planta);
                registroMotivo.add(motivo);
                registroDocumento.add(documento);
                registroFecha.add(fecha);
                registroUsuario.add(usuario);
                registroProveedor.add(proveedor);
                registroCentro.add(centro);

                guardarDatosEnArchivo(registroCodigo, "codigos.txt");
                guardarDatosEnArchivo(registroLote, "lotes.txt");
                guardarDatosEnArchivo(registroFecha, "fechas.txt");
                guardarDatosEnArchivo(registroUsuario, "usuarios.txt");
                guardarDatosEnArchivo(registroProveedor, "proveedores.txt");
                guardarDatosEnArchivo(registroCentro, "centros.txt");
                guardarDatosEnArchivo(registroDocumento, "documentos.txt");
                guardarDatosEnArchivo(registroLaminas, "laminas.txt");
                guardarDatosEnArchivo(registroMotivo, "motivos.txt");
                guardarDatosEnArchivo(registroPlanta, "plantas.txt");
                guardarDatosEnArchivo(registrom2, "metros.txt");
                guardarDatosEnArchivo(registroValor, "valores.txt");

                System.exit(0);
            }else if(decision.equals("guardar")) {
                continuar = false;
                System.exit(0);

            }else{
                System.out.println("Opcion no valida. Por favor, ingrese ´si´ para almacenar la informacion o ´salir´ para terminar el regsitro");
            }

            //DEVOUCION DE DATOS DEL REGISTRO DE MERMA:
            System.out.println("LOS DATOS REGISTRADOS SON:");
            System.out.println("El codigo registrado fue:"+codigo);
            System.out.println("El lote registrado fue:"+lote);
            System.out.println("Cantidad de laminas rotas:"+laminas);
            double cantidadM2 = calcularM2 (codigoBloque,metrosCuadrados,cantidadLaminas,codigo,laminas);
            System.out.println("La cantidad de merma en m2 es:"+cantidadM2);
            registrom2.add(String.valueOf(cantidadM2));
            double cantidadValor =calcularValor(costoBloque,codigoBloque,codigo,cantidadLaminas,laminas);
            System.out.println("El valor de la mercancia mermada:"+cantidadValor);
            registroValor.add(String.valueOf(cantidadValor));
            System.out.println("La planta donde fue el registro:"+planta);
            System.out.println("El motivo de la merma fue:"+motivo);
            System.out.println("Usuario de registro:"+usuario);
            System.out.println("Fecha de registro:"+fecha);
            System.out.println("Centro de costo:"+centro);
            System.out.println("Proveedor del material:"+proveedor);
            System.out.println("Numero de documento:"+documento);

            //PRUEBA DE DEVOLUCION DE DATOS PARA LOS ARRAYS QUE ALMACENAN LA INFORMACION

            System.out.println("PRUEBA PARA IMPRIMIR EL RESGISTRO:"+registroCodigo);
            System.out.println("PRUEBA PARA IMPRIMIR EL LOTE:"+registroLote);
            System.out.println("PRUEBA PARA IMPRIMIR LAMINAS ROTAS:"+registroLaminas);
            System.out.println("PRUEBA PARA IMPRIMIR MERMA M2:"+registrom2);
            System.out.println("PRUEBA PARA IMPRIMIR VALOR DE MERCANCIA:"+registroValor);
            System.out.println("PRUEBA PARA IMPRIMIR LA PLANTA:"+registroPlanta);
            System.out.println("PRUEBA PARA IMPRIMIR EL MOTIVO:"+registroMotivo);
            System.out.println("PRUEBA PARA IMPRIMIR EL USUARIO:"+registroUsuario);
            System.out.println("PRUEBA PARA IMPRIMIR LA FECHA:"+registroFecha);
            System.out.println("PRUEBA PARA IMPRIMIR EL CENTRO DE COSTO:"+registroCentro);
            System.out.println("PRUEBA PARA IMPRIMIR EL PROVEEDOR :"+registroProveedor);
            System.out.println("PRUEBA PARA IMPRIMIR EL NUMERO DE DOCUMENTO: "+registroDocumento);
        }
    }

    private static double calcularValor(double[] costoBloque, String[] codigoBloque,String codigo,int[]cantidadLaminas,int laminas) {
        double valorDinero=0;
        for(int i=0; i<codigoBloque.length;i++){
            if(codigoBloque[i].equals(codigo)){
                valorDinero= (costoBloque[i]/cantidadLaminas[i])*laminas;
            }
        }
        return  valorDinero;
    }

    private static double calcularM2(String[] codigoBloque,double[] metrosCuadrados,int[]cantidadLaminas,String codigo,int laminas) {
        double valorM2 = 0;
        for(int i=0;i<metrosCuadrados.length;i++){
            if(codigoBloque[i].equals(codigo)){
                valorM2=metrosCuadrados[i]/cantidadLaminas[i]*laminas;
            }
        }
        return  valorM2;
    }

    private static void guardarDatosEnArchivo(ArrayList<String> datos,String archivo) {
        try (BufferedWriter palabra = new BufferedWriter(new FileWriter(archivo))){
            for(int i=0; i<datos.size();i++){
                String dato =datos.get(i);
                palabra.write(dato);
                palabra.newLine();
            }
        }catch (IOException e){
            System.err.println("Error al guardar los datos en el archivo"+e.getMessage());
        }
    }

    private static ArrayList<String> cargarDatosDesdeArchivo(String archivo) {
        ArrayList<String> datos=new ArrayList<>();
        try (BufferedReader palabra = new BufferedReader(new FileReader(archivo))){
            String linea;
            while ((linea=palabra.readLine()) !=null){
                datos.add(linea);
            }
        }catch (IOException e){
            System.err.println("Error al cargar lod datos desde el archivo;"+ e.getMessage());
        }
        return datos;
    }
}
