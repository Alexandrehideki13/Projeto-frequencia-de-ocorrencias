import java.util.Scanner;

class TrabalhoEdRelatorioFrequencia {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Metodos metodos = new Metodos();

		// loop para receber os n�meros
		for (int i = 0; i < 10; i++) {
			System.out.println("Digite o " + (i + 1) + "� n�mero: ");
			double num = scanner.nextDouble();
			metodos.addLast(num);
		}

		scanner.close();

		// Imprimindo informa��es
		System.out.println("\n\nRELAT�RIO DE FREQU�NCIA");
		System.out.println("==============================================================");
		metodos.ocorrenciasUnicas();
		metodos.frequencia();
		System.out.println("\nLISTA DE N�MEROS: " + metodos.toString());
		System.out.printf("M�DIA: %.2f\n", metodos.media());
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
		livreLista = 0; // a posi��o livre m�xima � 0
		livreOcorrencias = 0;
		posicaoQuantOcorrencia = 0;
	}

	// M�todo para adicionar elementos na lista de n�meros
	public void addLast(double elemento) {
		if (livreLista < max) {
			lista_numeros[livreLista] = elemento;
			livreLista++;
		} else {
			System.out.println("Lista cheia!");
		}
	}

	// M�todo para adicionar elementos na lista de ocorr�ncias
	public void addLastOcorrencias(double elemento) {
		if (livreOcorrencias < max) {
			ocorrencias[livreOcorrencias] = elemento;
			livreOcorrencias++;
		} else {
			System.out.println("Lista cheia!");
		}
	}

	// M�todo para adicionar quantidade de cada ocorr�ncia na lista de quantidade de
	// ocorr�ncias
	public void addQuantOcorrencias(int vezes) {
		quantOcorrencias[posicaoQuantOcorrencia] = vezes;
		posicaoQuantOcorrencia++;
	}

	// M�todo que retorna o �ndice
	public double get(int i) {
		if ((i >= 0) && (i < size())) {
			return lista_numeros[i];
		} else {
			System.out.println("�ndice do vetor n�o encontrado!");
		}
		return 0;
	}

	// M�todo que retorna o tamanho da lista
	public int size() {
		return this.livreLista;
	}

	// M�todo para separar as ocorr�ncias �nicas
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

	// M�todo frequ�ncia
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

	// M�todo toString
	public String toString() {
		StringBuffer sf = new StringBuffer();
		sf.append("[ ");
		for (int i = 0; i < size(); i++) {
			sf.append(lista_numeros[i] + " ");
		}
		sf.append("]");

		return sf.toString();
	}

	// M�todo m�dia
	public double media() {
		double soma = 0;
		for (int i = 0; i < size(); i++) {
			soma += get(i);
		}

		return soma / size();
	}
}