import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Encryptation {
	private List<String> listWKey = new ArrayList<>(); 
	private List<String> ListOfChar = new ArrayList<>(); 
	private List<String> listaux = new ArrayList<>(); 
	private List<String> list;
	
	public void RecebeList(BufferedReader br) throws IOException {
		
		String line = br.readLine();
		while (line != null) {
			this.listWKey.add(line);
			line = br.readLine();
		}
		this.list = new ArrayList<>(this.listWKey);
	}
	
	public List<String> OrdenaChave(String key) {
		
		int valueOfKey=0;
		
		for(String letra: this.listWKey) {
			if(key.equalsIgnoreCase(letra)) {
				valueOfKey = this.listWKey.indexOf(letra);
			}
		}
		
		for(int x =0; x < valueOfKey; x++) {
			listaux.add(list.get(x));
		}
		list.removeAll(listaux);
		list.addAll(listaux); 
		return list;
	}
	
	public String EncryptyPhrase(String phrase) {
		int aux=0;
		
		String asString;
		
		while (aux < phrase.length()) {
			asString = Character.toString(phrase.charAt(aux));
			this.ListOfChar.add(asString);
			aux++;
		}
		
		String phraseaux="";

		for(String value: this.ListOfChar) {
			for(String letter: this.listWKey) {
				if(value.equalsIgnoreCase(letter)) {
					int index = this.listWKey.indexOf(letter);
					phraseaux = phraseaux + this.list.get(index);
				}
			}
			if(value.equalsIgnoreCase(" ")) {
				phraseaux = phraseaux + " ";
			}
		}
		return phraseaux;
	}
}
