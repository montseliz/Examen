package examen;

public class Linia_Factura {
	
	private int numeroFactura;
	private int numeroLinia; 
	private String nomProducte; 
	private String descripcio; 
	private int quantitat; 
	private double preuProducte; 
	
	public Linia_Factura() {
	}
	
	public Linia_Factura(int numeroFactura, int numeroLinia, String nomProducte, String descripcio, int quantitat, double preuProducte) {
		this.numeroFactura = numeroFactura;
		this.numeroLinia = numeroLinia; 
		this.nomProducte = nomProducte; 
		this.descripcio = descripcio; 
		this.quantitat = quantitat; 
		this.preuProducte = preuProducte; 
	}
	
	public int getNumeroFactura() {
		return numeroFactura;
	}
	
	public void setNumeroFactura(int numeroFactura) {
		this.numeroFactura = numeroFactura;
	}

	public int getNumeroLinia() {
		return numeroLinia;
	}

	public void setNumeroLinia(int numeroLinia) {
		this.numeroLinia = numeroLinia;
	}

	public String getNomProducte() {
		return nomProducte;
	}

	public void setNomProducte(String nomProducte) {
		this.nomProducte = nomProducte;
	}

	public String getDescripcio() {
		return descripcio;
	}

	public void setDescripcio(String descripcio) {
		this.descripcio = descripcio;
	}

	public int getQuantitat() {
		return quantitat;
	}

	public void setQuantitat(int quantitat) {
		this.quantitat = quantitat;
	}

	public double getPreuProducte() {
		return preuProducte;
	}

	public void setPreuProducte(double preuProducte) {
		this.preuProducte = preuProducte;
	}

	@Override
	public String toString() {
		return "Linia_Factura [numeroLinia=" + numeroLinia + ", numeroFactura=" + numeroFactura + ", nomProducte="
				+ nomProducte + ", descripcio=" + descripcio + ", quantitat=" + quantitat + ", preuProducte="
				+ preuProducte + "]";
	}
	
}
