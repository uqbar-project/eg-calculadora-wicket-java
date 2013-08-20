package uqbar.calculadora.domain;

import java.io.Serializable;

import org.uqbar.commons.model.UserException;

/**
 * La calculadora que divide
 */
public class CalculadoraDivision implements Serializable {
	private double dividendo;
	private double divisor;
	private double resultado;
	
	public void dividir() {
		validarDivisor(this.divisor);
		this.resultado = this.dividendo / this.divisor;
	}

	public void validarDivisor(Double unDivisor) {
		if (unDivisor == 0) {
			throw new UserException("No se puede dividir por cero!");
		}
	}

	public double getDividendo() {
		return this.dividendo;
	}

	public double getDivisor() {
		return this.divisor;
	}

	public void setDividendo(double sumando1) {
		if (sumando1 == -1) {
			throw new UserException("No se puede user el -1!");
		}
		this.dividendo = sumando1;
	}

	public void setDivisor(double divisor) {
		validarDivisor(divisor);
		this.divisor = divisor;
	}

	public double getResultado() {
		return this.resultado;
	}

}
