package examen;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Metodes {

	private static Scanner input = new Scanner (System.in); 
	private static ArrayList<Factura> llistaFactures = new ArrayList<>();
	
	public static int inputInt(String pregunta) {
		boolean incorrecte = true; 
		int numero = 0; 
		
		do {
			System.out.println(pregunta); 
			try { 
				numero = input.nextInt();   
				incorrecte = false; 
				System.out.println("La teva resposta ha quedat ben registrada.\r\n"); 
			} catch (InputMismatchException e) {
				System.out.println("Error, introdueix només caracters numèrics.\r\n"); 
			} 
			input.nextLine(); 
		} while (incorrecte); 
		
		return numero; 
	}
	
	public static String inputString(String pregunta) {
		boolean incorrecte = true; 
		String text = "";  
		
		do {
			System.out.println(pregunta); 
			try { 
				text = input.nextLine(); 
				incorrecte = false; 
				System.out.println("La teva resposta ha quedat ben registrada.\r\n");
			} catch (Exception e) { 
				System.out.println("Error, introdueix una resposta vàlida.\r\n"); 
			} 
		} while (incorrecte); 
		
		return text;  
	}
	
	public static void crearFactura(int numeroFactura, String client, String direccio, String telefon) {
		Factura factura = new Factura(numeroFactura, client, direccio, telefon);
		boolean found = false; 
		int i = 0; 
		
		if (llistaFactures.size() == 0) {
			llistaFactures.add(factura);
			// 	System.out.println(llistaFactures);
			System.out.println("La factura s'ha creat correctament.\r\n");
			
		} else {
			while (i < llistaFactures.size() && !found) {
				if (llistaFactures.get(i).getNumeroFactura() == factura.getNumeroFactura()) {
					found = true;
					//	System.out.println(llistaFactures);
					System.out.println("Error. Ja existeix una factura amb la mateixa numeració.\r\n");
				}
				i++;
			}
			if (!found) {
				llistaFactures.add(factura);
				//	System.out.println(llistaFactures);
				System.out.println("La factura s'ha creat de manera correcte.\r\n");
			}
		}
	}
	
	public static double inputDouble(String pregunta) {
		boolean incorrecte = true; 
		double valor = 0.0d; 
		
		do {
			System.out.println(pregunta); 
			try { 
				valor = input.nextDouble();   
				incorrecte = false; 
				System.out.println("La teva resposta ha quedat ben registrada.\r\n"); 
			} catch (InputMismatchException e) { 
				System.out.println("Error de format, introdueix els decimals amb una coma.\r\n"); 
			} 
			input.nextLine(); 
		} while (incorrecte); 
		return valor; 
	}
	
	public static void crearLiniaFactura(int numeroLinia, int numeroFactura, String nomProducte, String descripcio, int quantitat, double preuProducte) {
		Linia_Factura liniaFactura = new Linia_Factura(numeroLinia, numeroFactura, nomProducte, descripcio, quantitat, preuProducte); 
		boolean found = false; 
		int i = 0; 
		
		if (llistaFactures.size() == 0) {
			System.out.println("Error. Primer has de crear una factura.\r\n");
		} else {
			while (i < llistaFactures.size() && !found) {
				if (llistaFactures.get(i).getNumeroFactura() == liniaFactura.getNumeroFactura()) {
					found = true;
					llistaFactures.get(i).setNovaLiniaFactura(liniaFactura);
					System.out.println("S'ha trobat la factura que has indicat i s'ha creat la línia.\r\n");
					//	System.out.println(llistaFactures.get(i).getLlistaLiniesFactures());
				}
				i++;
			}
			if (!found) {	
				System.out.println("Error. No s'ha trobat el número de factura que has indicat. Primer has de crear la factura.\r\n");
			}
		}
	}
	
	public static void totalimportFactura(int numeroFactura) { 
		boolean found = false; 
		int i = 0; 
		double total = 0.0d; 
		
		if (llistaFactures.size() == 0) {
			System.out.println("Error. Primer has de crear una factura.\r\n");
		} else {
			while (i < llistaFactures.size() && !found) {
				if (llistaFactures.get(i).getNumeroFactura() == numeroFactura) {
					found = true;
					System.out.println("S'ha trobat la factura que has indicat.\r\n");
					for (int z = 0; z < llistaFactures.get(i).getLlistaLiniesFactures().size(); z++) {
						total += llistaFactures.get(i).getLlistaLiniesFactures().get(z).getQuantitat() * llistaFactures.get(i).getLlistaLiniesFactures().get(z).getPreuProducte(); 
					}
					System.out.println("L'import total de la factura indicada és: " + total + "\r\n");
				 }
			i++;
			}
			if (!found) {
				System.out.println("Error. No s'ha trobat la factura indicada.\r\n");
			} 
		}
	}
	
	public static void totalFactures() {   
		double total = 0.0d; 
		
		if (llistaFactures.size() == 0) {
			System.out.println("Error. Primer has de crear una factura.\r\n");
		} else {
			for (int i = 0; i < llistaFactures.size(); i++) {
				for (int z = 0; z < llistaFactures.get(i).getLlistaLiniesFactures().size(); z++) {
					total += llistaFactures.get(i).getLlistaLiniesFactures().get(z).getQuantitat() * llistaFactures.get(i).getLlistaLiniesFactures().get(z).getPreuProducte(); 
				}
			}
			System.out.println("L'import total de les factures de l'empresa és: " + total + "\r\n");
		}
	}
	
	public static void numeroFacturesClient(String client) throws CustomizedException {
		int total = 0; 
		
		if (llistaFactures.size() == 0) {
			System.out.println("Error. Primer has de crear una factura.\r\n");
		} else {
			total = llistaFactures.stream()
						.filter(c -> c.getClient().equalsIgnoreCase(client))
						.mapToInt(i -> 1).sum(); 
		}
		
		if (total == 0) {
			throw new CustomizedException ("El client no té factures.\r\n"); 
		}
		
		System.out.println("El número de factures del client indicat és: " + total + "\r\n");	
	}
			
	public static void forEach(String client) {  
		long valor = 0; 
		
		if (llistaFactures.size() == 0) {
			System.out.println("Error. Primer has de crear una factura.\r\n");
		} else {
			valor = llistaFactures.stream()
						.filter(c -> c.getClient().equalsIgnoreCase(client))
						.count(); 
			if (valor == 0) {
				System.out.println("El client no existeix.\r\n");
			} else {
				llistaFactures.stream()
					.filter(c -> c.getClient().equalsIgnoreCase(client))
					.forEach(System.out::println);
				System.out.println("");
			}
		}
	}
	
	public static void mostrarFacturesProducte(String nomProducte) {  // PER FER
		long valor = 0; 
		
		if (llistaFactures.size() == 0) {
			System.out.println("Error. Primer has de crear una factura.\r\n");
		} else {
			valor = llistaFactures.stream()
						.filter(s -> s.getLlistaLiniesFactures().stream()
						.anyMatch(p -> p.getNomProducte().equalsIgnoreCase(nomProducte)))
						.count();
			if (valor == 0) {
				System.out.println("El producte que has introduït no existeix.\r\n");
			} else {
				llistaFactures.stream()
					.filter(s -> s.getLlistaLiniesFactures().stream()
					.anyMatch(p -> p.getNomProducte().equalsIgnoreCase(nomProducte)))
					.forEach(System.out::println); 
				System.out.println("");
			}
		}
	}
	
	@Deprecated
	public static void eliminarFactura(int numeroFactura) {
		boolean found = false; 
		int i = 0; 
		
		if (llistaFactures.size() == 0) {
			System.out.println("Error. Primer has de crear una factura.\r\n");
		} else {
			while (i < llistaFactures.size() && !found) {
				if (llistaFactures.get(i).getNumeroFactura() == numeroFactura) {
					found = true;
					llistaFactures.remove(i); 
					System.out.println("S'ha trobat la factura que has indicat i s'ha eliminat.\r\n");
				}
				i++; 
			}
			if (!found) {
				System.out.println("Error. No s'ha trobat la factura indicada.\r\n");
			} 
		}
	}
	
	public static void crearFitxerFactura() {
		FileWriter fw = null; 
		BufferedWriter bw = null; 
		File file = new File("src\\fitxerFactura.csv"); 
		
		if (llistaFactures.size() == 0) {
			System.out.println("Error. Primer has de crear una factura.\r\n");
		} else {
			try {
				fw = new FileWriter (file); 
				if (!file.exists()) {
					file.createNewFile(); 
				}  
				bw = new BufferedWriter (fw); 
				
				for (Factura factura : llistaFactures) {
					bw.write(factura.toString() + ", "); 
					bw.newLine();
				}
				System.out.println("Arxiu guardat correctament.\r\n");
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if((null != bw) && (null != fw)) {
						bw.close();
						fw.close();
					}
				} catch (Exception e) {
					e.printStackTrace(); 
				}
			}
		}
	}
	
	public static void crearFitxerLiniesFactura() {
		FileWriter fw = null; 
		BufferedWriter bw = null; 
		File file = new File("src\\fitxerLiniesFactura.csv"); 
		
		if (llistaFactures.size() == 0) {
			System.out.println("Error. Primer has de crear una factura.\r\n");
		} else {
			try {
				fw = new FileWriter (file); 
				if (!file.exists()) {
					file.createNewFile(); 
				}  
				bw = new BufferedWriter (fw);
				
				for (Factura factura : llistaFactures) {
					for (Linia_Factura liniaFactura : factura.getLlistaLiniesFactures()) {
						bw.write(liniaFactura.toString() + ", "); 
					} 
					bw.newLine();
				} 
				System.out.println("Arxiu guardat correctament.\r\n");
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if((null != bw) && (null != fw)) {
						bw.close();
						fw.close();
					}
				} catch (Exception e) {
					e.printStackTrace(); 
				}
			}
		}
				
	}
			
}
	

	
	
	
	
	
	

