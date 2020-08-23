import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClassMain {

	public static void main(String[] args) {
		List<String> listWKey = new ArrayList<>(); //lista em ordem alfabetica certa
		List<String> ListOfChar = new ArrayList<>(); //lista de vetor da frase
		List<String> listaux = new ArrayList<>(); //lista auxiliar de vetor para virar o vetor da cifra
		Scanner sc = new Scanner(System.in);
		
		String path = "C:\\oi.txt";
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			
			//primeiro criar duas listas, a sem chave e a lista que irá ser chaveada
		
			String line = br.readLine();
			while (line != null) {
				listWKey.add(line);
				line = br.readLine();
			}
			
			List<String> list = new ArrayList<>(listWKey); //lista de vetor para virar o vetor da cifra
			
			//segundo tenho que saber qual é o valor correspondente a minha chave na lista sem chave
			System.out.print("Digite a chave (letra):");
			String key = sc.nextLine();
			int valueOfKey=0;
			
			for(String letra: listWKey) {
				if(key.equalsIgnoreCase(letra)) {
					valueOfKey = listWKey.indexOf(letra);
				}
			}
			
			// cortar a cadeia de letras do inicio ate a minha chave
			
			for(int x =0; x < valueOfKey; x++) {
				listaux.add(list.get(x));
			}
			list.removeAll(listaux);
			list.addAll(listaux); //lista ja com a chave
			
			
			//ver qual valor de cada letra da sua frase pra poder trocar
			
			System.out.println("Digite a frase a qual deseja criptogarfar: ");
			String phrase =  sc.nextLine();
			int aux=0;
			
			String asString;
			
			while (aux < phrase.length()) {
				asString = Character.toString(phrase.charAt(aux));
				ListOfChar.add(asString);
				aux++;
			}
			//trocar cada letra da sua frase com a letra correspondente ao indice do alfabeto da lista "list"
			
			String phraseaux="";

			for(String value: ListOfChar) {
				for(String letter: listWKey) {
					if(value.equalsIgnoreCase(letter)) {
						int index = listWKey.indexOf(letter);
						phraseaux = phraseaux + list.get(index);
					}
				}
				if(value.equalsIgnoreCase(" ")) {
					phraseaux = phraseaux + " ";
				}
			}
			
			System.out.println("Frase Original: "+ phrase);
			System.out.println("Chave: " + key);
			System.out.println("Frase com a cifra de Cesar: " + phraseaux);
			
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}finally {
			sc.close();
		}
	}
}
