import java.util.Random;
import java.util.Scanner;

public class Jogo {

	Apostador apostador;
	int[] numeroAposta = new int[5];
	int[] estrelaAposta = new int[2];
	int[] numeros = new int[5];
	int[] estrelas = new int[2];
	int numeroComp = 0, starComp = 0;
	String nome;

	Random r = new Random();
	Scanner s = new Scanner(System.in);

	public Jogo() {

		System.out.println("**************************************");
		System.out.println("*            EUROMILHÕES             *");
		System.out.println("**************************************\n");

		System.out.println("Introduza o seu nome:");

		nome = s.nextLine();

		apostador = new Apostador(nome);

		// Introdução da aposta
		System.out.println("\n" + apostador.getNome()
				+ ", introduza os 5 números entre 1 e 50 em que quer apostar (prima Enter para confirmar cada número): ");

		for (int i = 0; i < 5; i++) {
			int num = s.nextInt();
			if (num >= 1 && num <= 50) {
				numeroAposta[i] = num;
			} else {
				System.out.println("Esse número é inválido. Por favor, escolhe um número entre 1 e 50.");
				i--;
			}
			for (int j = 0; j < i; j++) {
				if (numeroAposta[i] == numeroAposta[j]) {
					System.out.println(
							"Esse número já foi introduzido anteriormente. Por favor, escolhe um número entre 1 e 50.");
					i--;
					break;
				}
			}
		}

		System.out.println(
				"\nAgora introduza as 2 estrelas entre 1 e 12 que quer apostar (prima Enter para confirmar cada uma das estrelas): ");

		for (int i = 0; i < 2; i++) {
			int star = s.nextInt();
			if (star >= 1 && star <= 12) {
				estrelaAposta[i] = star;
			} else {
				System.out.println("Essa estrela é inválida. Por favor, escolhe uma estrela entre 1 e 12.");
				i--;
			}
			for (int j = 0; j < i; j++) {
				if (estrelaAposta[i] == estrelaAposta[j]) {
					System.out.println(
							"Essa estrela já foi introduzida anteriormente. Por favor, escolhe uma estrela entre 1 e 12.");
					i--;
					break;
				}
			}
		}

		// Gerador de números e estrelas aleatórios
		for (int i = 0; i < 5; i++) {
			numeros[i] = r.nextInt(50) + 1;
			for (int j = 0; j < i; j++) {
				if (numeros[i] == numeros[j]) {
					i--;
					break;
				}
			}
		}

		for (int i = 0; i < 2; i++) {
			estrelas[i] = r.nextInt(12) + 1;
			for (int j = 0; j < i; j++) {
				if (estrelas[i] == estrelas[j]) {
					i--;
					break;
				}
			}
		}

		System.out.println("\nOs números desta noite são: ");
		for (int i = 0; i < 5; i++) {
			try { // função retirada do projeto de seleção do dia de entrega
					// para dar um delay entre numeros gerados
				Thread.sleep(new Random().nextInt(2000) + 500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(numeros[i]);
		}
		try {
			Thread.sleep(new Random().nextInt(2000) + 500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("\n");

		System.out.println("E as estrelas desta noite são: ");
		for (int i = 0; i < 2; i++) {
			try {
				Thread.sleep(new Random().nextInt(2000) + 500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(estrelas[i]);
		}
		try {
			Thread.sleep(new Random().nextInt(2000) + 500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// comparador dos números e estrelas apostadas com as geradas
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (numeros[j] == numeroAposta[i]) {
					numeroComp++;
				}
			}
		}
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				if (estrelas[j] == estrelaAposta[i]) {
					starComp++;
				}
			}
		}

		System.out.println("\nVocê acertou em " + numeroComp + " números e em " + starComp + " estrelas.");

		// Distribuição dos Prémios
		if (numeroComp == 2 && starComp == 0) {
			System.out.println("\nParabéns! Você ficou com o 13º prémio! ↖(^o^)↗");
		} else if (numeroComp == 2 && starComp == 1) {
			System.out.println("\nParabéns! Você ficou com o 12º prémio! ↖(^o^)↗");
		} else if (numeroComp == 1 && starComp == 2) {
			System.out.println("\nParabéns! Você ficou com o 11º prémio! ↖(^o^)↗");
		} else if (numeroComp == 3 && starComp == 0) {
			System.out.println("\nParabéns! Você ficou com o 10º prémio! ↖(^o^)↗");
		} else if (numeroComp == 3 && starComp == 1) {
			System.out.println("\nParabéns! Você ficou com o 9º prémio! ↖(^o^)↗");
		} else if (numeroComp == 2 && starComp == 2) {
			System.out.println("\nParabéns! Você ficou com o 8º prémio! ↖(^o^)↗");
		} else if (numeroComp == 3 && starComp == 2) {
			System.out.println("\nParabéns! Você ficou com o 7º prémio! ↖(^o^)↗");
		} else if (numeroComp == 4 && starComp == 0) {
			System.out.println("\nParabéns! Você ficou com o 6º prémio! ↖(^o^)↗");
		} else if (numeroComp == 4 && starComp == 1) {
			System.out.println("\nParabéns! Você ficou com o 5º prémio! ↖(^o^)↗");
		} else if (numeroComp == 4 && starComp == 2) {
			System.out.println("\nParabéns! Você ficou com o 4º prémio! ↖(^o^)↗");
		} else if (numeroComp == 5 && starComp == 0) {
			System.out.println("\nParabéns! Você ficou com o 3º prémio! ↖(^o^)↗");
		} else if (numeroComp == 5 && starComp == 1) {
			System.out.println("\nParabéns! Você ficou com o 2º prémio! ↖(^o^)↗");
		} else if (numeroComp == 5 && starComp == 2) {
			System.out.println("\nParabéns! Você ficou com o 1º prémio! ↖(^o^)↗");
		} else {
			System.out.println("\nNão conseguio o suficiente para ganhar um prémio. Mais sorte para a próxima. ('⌒')");
		}

	}
}
