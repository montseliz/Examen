package examen;

import java.util.ArrayList;

public class Factura {
	
	private int numeroFactura; 
	private String client; 
	private String direccio; 
	private String telefon; 
	private double totalFactura; 
	private ArrayList<Linia_Factura> llistaLiniesFactures = new ArrayList<>();
	
	public Factura (int numeroFactura, String client, String direccio, String telefon) {
		this.numeroFactura = numeroFactura; 
		this.client = client; 
		this.direccio = direccio; 
		this.telefon = telefon;
		this.totalFactura = 0.0d; 
	}

	public int getNumeroFactura() {
		return numeroFactura;
	}

	public void setNumeroFactura(int numeroFactura) {
		this.numeroFactura = numeroFactura;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public String getDireccio() {
		return direccio;
	}

	public void setDireccio(String direccio) {
		this.direccio = direccio;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public double getTotalFactura() {
		return totalFactura;
	}

	public void setTotalFactura(double totalFactura) {
		this.totalFactura = totalFactura;
	}
	
	public ArrayList<Linia_Factura> getLlistaLiniesFactures() {
		return llistaLiniesFactures;
	}

	public void setNovaLiniaFactura(Linia_Factura liniaFactura) {
		this.llistaLiniesFactures.add(liniaFactura); 
	}

	@Override
	public String toString() {
		return "Factura [numeroFactura=" + numeroFactura + ", client=" + client + ", direccio=" + direccio
				+ ", telefon=" + telefon + ", totalFactura=" + totalFactura + ", llistaLiniesFactures="
				+ llistaLiniesFactures + "]";
	}

}

