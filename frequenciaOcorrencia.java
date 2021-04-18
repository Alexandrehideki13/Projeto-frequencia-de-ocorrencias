import java.util.Scanner;

class FrequenciaOcorrencia {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Metodos metodos = new Metodos();

		// loop para receber os números
		for (int i = 0; i < 10; i++) {
			System.out.println("Digite o " + (i + 1) + "º número: ");
			double num = scanner.nextDouble();
			metodos.addLast(num);
		}

		scanner.close();

		// Imprimindo informações
		System.out.println("\n\nRELATÓRIO DE FREQUÊNCIA");
		System.out.println("==============================================================");
		metodos.ocorrenciasUnicas();
		metodos.frequencia();
		System.out.println("\nLISTA DE NÚMEROS: " + metodos.toString());
		System.out.printf("MÉDIA: %.2f\n", metodos.media());
		System.out.println("==============================================================");

	}
}

class Metodos {
	Scanner scanner = new Scanner(System.in);
	private int max;
	public int livreLista;
	public int livreOcorrencias;
	public int posicaoQuantOcorrencia = 0;
	double[] lista_numeros;
	double[] ocorrencias;
	int[] quantOcorrencias;

	public Metodos() { // construtor vazio
		max = 10;
		lista_numeros = new double[max];
		ocorrencias = new double[max];
		quantOcorrencias = new int[max];
		livreLista = 0; // a posição livre máxima é 0
		livreOcorrencias = 0;
		posicaoQuantOcorrencia = 0;
	}

	// Método para adicionar elementos na lista de números
	public void addLast(double elemento) {
		if (livreLista < max) {
			lista_numeros[livreLista] = elemento;
			livreLista++;
		} else {
			System.out.println("Lista cheia!");
		}
	}

	// Método para adicionar elementos na lista de ocorrências
	public void addLastOcorrencias(double elemento) {
		if (livreOcorrencias < max) {
			ocorrencias[livreOcorrencias] = elemento;
			livreOcorrencias++;
		} else {
			System.out.println("Lista cheia!");
		}
	}

	// Método para adicionar quantidade de cada ocorrência na lista de quantidade de
	// ocorrências
	public void addQuantOcorrencias(int vezes) {
		quantOcorrencias[posicaoQuantOcorrencia] = vezes;
		posicaoQuantOcorrencia++;
	}

	// Método que retorna o índice
	public double get(int i) {
		if ((i >= 0) && (i < size())) {
			return lista_numeros[i];
		} else {
			System.out.println("Índice do vetor não encontrado!");
		}
		return 0;
	}

	// Método que retorna o tamanho da lista
	public int size() {
		return this.livreLista;
	}

	// Método para separar as ocorrências únicas
	public void ocorrenciasUnicas() {
		for (int i = 0; i < 10; i++) {
			double numero = get(i);
			for (int j = 0; j < 10; j++) {
				double numero2 = get(j);
				if (numero == numero2) {
					for (int z = 0; z < ocorrencias.length; z++) {
						if (numero == ocorrencias[z]) {
							break;
						} else if (z == (ocorrencias.length - 1)) {
							addLastOcorrencias(numero);
						}
					}
				}
			}
		}
	}

	// Método frequência
	public void frequencia() {
		int vezes = 0;
		for (int i = 0; i < livreOcorrencias; i++) {
			double num1 = ocorrencias[i];
			for (int j = 0; j < livreLista; j++) {
				double num2 = lista_numeros[j];
				if (num1 == num2) {
					vezes += 1;
				}
			}
			if (vezes == 1) {
				System.out.println(num1 + " - " + vezes + " VEZ.");
			} else {
				System.out.println(num1 + " - " + vezes + " VEZES.");
			}
			addQuantOcorrencias(vezes);
			vezes = 0;
		}
	}

	// Método toString
	public String toString() {
		StringBuffer sf = new StringBuffer();
		sf.append("[ ");
		for (int i = 0; i < size(); i++) {
			sf.append(lista_numeros[i] + " ");
		}
		sf.append("]");

		return sf.toString();
	}

	// Método média
	public double media() {
		double soma = 0;
		for (int i = 0; i < size(); i++) {
			soma += get(i);
		}

		return soma / size();
	}
}
