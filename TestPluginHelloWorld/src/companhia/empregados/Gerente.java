package companhia.empregados;

public class Gerente {

	private double soldoBruto;

	public void setSoldoBruto(double soldoBruto) {
		this.soldoBruto = soldoBruto;
		
	}

	public double getSoldoLiquido() {
		return this.soldoBruto * 0.75;
	}

}
