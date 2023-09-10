package lista3.meu;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class IntNoSimples {
	int valor;
	IntNoSimples prox;/*
						 * variável com mesmo nome da classe, onde prox faz referência ao próx elemento
						 * da lista. Java não aceita ponteiros
						 */

	IntNoSimples(int valorNo) {
		valor = valorNo;
		prox = null;
	}
}

class ListaSimplesUtils {
	IntNoSimples primeiro, ultimo;
	int numero_nos;

	ListaSimplesUtils() {
		primeiro = ultimo = null;
	}

	void insereNo_fim(IntNoSimples novoNo) {
		novoNo.prox = null;
		if (primeiro == null)/* nesta condição, é o primeiro elemento a ser inserido */
			primeiro = novoNo;
		if (ultimo != null)
			ultimo.prox = novoNo;
		ultimo = novoNo;
	}

	void insereNo_inicio(IntNoSimples novoNo) {
		if (primeiro != null) {
			novoNo.prox = primeiro;
			primeiro = novoNo; // meu
		} else {
			if (primeiro == null)
				primeiro = novoNo;
			ultimo = novoNo;
		}
	}

	int ContarNos() {
		int tamanho = 0;
		IntNoSimples temp_no = primeiro;
		while (temp_no != null) {
			tamanho++;
			temp_no = temp_no.prox;
		}
		return tamanho;
	}

	void insereNo_posicao(IntNoSimples novoNo, int posicao) {
		IntNoSimples temp_no = primeiro;
		int numero_nos = ContarNos();
		int pos_aux;
		if (posicao == 0) {
			novoNo.prox = primeiro;

			// meu
			if (primeiro == null && ultimo == null) {
				ultimo = novoNo;
			}

			// dele, mas eu tirei:

//			if (primeiro == ultimo) {
//				ultimo = novoNo;
//			}
			primeiro = novoNo;
		} else {
			if (posicao <= numero_nos) {
				pos_aux = 1;
				while (temp_no != null && posicao > pos_aux) {
					temp_no = temp_no.prox;
					pos_aux++;
				}
				novoNo.prox = temp_no.prox;
				temp_no.prox = novoNo;
			} else {
				if (posicao > numero_nos) {
					ultimo.prox = novoNo;
					ultimo = novoNo;
				}
			}
		}
	}

	IntNoSimples buscaNo(int buscaValor) {
		int i = 0;
		IntNoSimples temp_no = primeiro;
		while (temp_no != null) {
			if (temp_no.valor == buscaValor) {
				System.out.println("No " + temp_no.valor + " posicao " + i);
				return temp_no;
			}
			i++;
			temp_no = temp_no.prox;
		}
		return null;
	}

	void excluiNo(int valor) {
		IntNoSimples temp_no = primeiro;
		while (temp_no != null && temp_no.valor != valor) {
			temp_no = temp_no.prox;
		}

		temp_no.prox = temp_no.prox.prox;

		if (ultimo == temp_no.prox)
			ultimo = temp_no;
	}

	void exibeLista() {
		IntNoSimples temp_no = primeiro;
		int i = 0;
		System.out.println(primeiro.valor + "|" + ultimo.valor);
		while (temp_no != null) {
			System.out.println("Valor " + temp_no.valor + "           posicao " + i);
			temp_no = temp_no.prox;
			i++;
		}
	}
}

public class ListaSimples {
	/* Constrói um menu de opções para manipulação da lista */
	public static void escolhas() {
		System.out.print("Escolha a Opcao:");
		System.out.print(" \n1. Inserir Nó no início");
		System.out.print(" \n2. Inserir Nó no fim");
		System.out.print(" \n3. Inserir Nó em uma posicao");
		System.out.print(" \n4. Localizar Nó");
		System.out.print(" \n5. Exibir lista");
		System.out.print(" \n6. Sair");
		System.out.print("\nOpcao :\t ");
	}

	public static void main(String args[]) {
		ListaSimplesUtils Slist = new ListaSimplesUtils(); /* Slist = Simples Lista */
		BufferedReader entrada; // ler a entrada de dados
		entrada = new BufferedReader(new InputStreamReader(System.in));
// InputStreamReader é uma ponte de fluxos de bytes para fluxos de caracteres: ele lê bytes e os 			//decodifica em caracteres usando um especificado charset.
		int i = 0;
		IntNoSimples temp_no; /* cria estrutura IntNoSimples */
		int valor;
		try {
			escolhas();
			char opcao = entrada.readLine().charAt(0); // Método charAt() retorna o caractere especificado a partir de
														// uma string
			while (opcao != '6') {
				switch (opcao) {
				case '1':
					System.out.println("Insere um Nó no inicio da lista");
					System.out.println("Digite um valor");
					valor = Integer.parseInt(entrada.readLine());
					Slist.insereNo_inicio(new IntNoSimples(valor));
					break;
				case '2':
					System.out.println("Insire um Valor no final da lista");
					System.out.println("Digite um valor");
					valor = Integer.parseInt(entrada.readLine());
					Slist.insereNo_fim(new IntNoSimples(valor));
					break;
				case '3':
					System.out.println("Insire um Valor numa dada posicao");
					System.out.println("Digite um valor");
					valor = Integer.parseInt(entrada.readLine());
					System.out.println("Digite a posicao");
					int posicao = Integer.parseInt(entrada.readLine());
					Slist.insereNo_posicao(new IntNoSimples(valor), posicao);
					break;
				case '4':
					System.out.println("Localiza um valor");
					System.out.println("Digite um valor");
					valor = Integer.parseInt(entrada.readLine());
					Slist.buscaNo(valor);
					break;
				case '5':
					System.out.println("Exibe a lista");
					Slist.exibeLista();
					break;
				default:
					System.out.println("Opcao Invalida !");
				}
				System.out.println();
				escolhas();
				opcao = entrada.readLine().charAt(0);
			}
		} catch (Exception erro) {
			System.out.println("Erro de Entrada de Dados");
		}
	}
}
