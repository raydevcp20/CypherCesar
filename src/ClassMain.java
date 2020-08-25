import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ClassMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Encryptation ec = new Encryptation();
		String path = "C:\\oi.txt";
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
		
			ec.RecebeList(br);
			System.out.print("Digite a chave (letra):");
			String key = sc.nextLine();
			ec.OrdenaChave(key);
			
			System.out.println("Digite a frase a qual deseja criptografar: ");
			String phrase =  sc.nextLine();
			
			String phraseaux = ec.EncryptyPhrase(phrase);
			
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
