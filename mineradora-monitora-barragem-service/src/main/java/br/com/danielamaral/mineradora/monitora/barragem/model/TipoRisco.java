package br.com.danielamaral.mineradora.monitora.barragem.model;

public enum TipoRisco {
	normal(1), baixo(2), medio(3), alto(4);

	private final int valor;

	TipoRisco(int tipo) {
		valor = tipo;
		}

	public int getValor() {
		return valor;
	}
}
