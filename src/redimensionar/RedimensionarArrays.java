package redimensionar;
//comentario de prueba hecho desde gitHub
import paquete_Scanner.PedirDatos;
import java.util.Arrays;
import java.util.Scanner;
public class RedimensionarArrays 
{
	static Scanner sc = new Scanner(System.in);
	static String asignaturas[] = new String [0];
	public static void main(String[] args) 
	{

		
		int eleccion;
		do
		{
			eleccion = menu();
			
			switch(eleccion)
			{
			case 1:
				altaElemento();
				
				break;
				
			case 2:
				borrarElemento2();
				break;
				
			case 3: 
				mostrarElementos();
				break;
				
			default: System.out.println("Error, introduce un numero entre 1 y 3");
			}
			
			
			
		}while(eleccion!=3);
		
		
	}
	
	
	
	public static void mostrarElementos() {
		Arrays.sort(asignaturas);
		System.out.println(Arrays.toString(asignaturas));
	}
	
	
	public static int menu() {
		int eleccion;
		System.out.println("Menú");
		System.out.println("1-Insertar");
		System.out.println("2-Borrar");
		System.out.println("3-Salir");
		eleccion = sc.nextInt();
		return eleccion;
	}
	
	
	public static void altaElemento() 
	{
		System.out.println("Dime el modulo a insertar");
		String nuevoModulo = sc.next();
		Arrays.sort(asignaturas);
		
		if(Arrays.binarySearch(asignaturas, nuevoModulo) < 0)
		{
			String asignaturasTemp[] = new String[asignaturas.length +1];
			
			System.arraycopy(asignaturas, 0, asignaturasTemp, 0, asignaturas.length);
			
			asignaturasTemp[asignaturasTemp.length -1] = nuevoModulo;
			
			asignaturas = asignaturasTemp;
		}
		else
		{
			System.out.println("el modulo ya está en el array");
		}
	}
	
	
	public static void borrarElemento() 
	{
		System.out.println("Dime el modulo a eliminar");
		String moduloBorrado = sc.next();
		String asignaturasTemp[] = new String[asignaturas.length - 1];
		Arrays.sort(asignaturas);
		int posicion = Arrays.binarySearch(asignaturas, moduloBorrado);
		System.arraycopy(asignaturas, 0, asignaturasTemp, 0, posicion );
		
		System.arraycopy(asignaturas, posicion + 1, asignaturasTemp, posicion , asignaturasTemp.length - posicion);
		
		asignaturas = asignaturasTemp;
	}

	public static void borrarElemento2()
	{
		System.out.println("Dime el modulo a eliminar");
		String moduloBorrado = sc.next();
		String asignaturasTemp[] = new String[asignaturas.length - 1];
		Arrays.sort(asignaturas);
		int i;
		
		
	for(i=0; i< asignaturas.length; i++)
	{
		if(!moduloBorrado.equals(asignaturas[i]))
		{
			asignaturasTemp[i] = asignaturas[i];
		}
		else
		{
			if(moduloBorrado.equals(asignaturas[i]))
			{
				
				for(int e = i ; e< asignaturas.length; e++)
				{
					asignaturasTemp[(i -1)] = asignaturas[i];
				}
				asignaturas = asignaturasTemp;
			}
			else
			{
				System.out.println("El array está lleno");
			}
			
			
		}
		
		
	}
	
	
	}
}
