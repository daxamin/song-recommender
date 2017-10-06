package prediction.convert;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SongDataConvert {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader("data/kaggle_visible_evaluation_triplets.txt"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("data/song_data.csv"));
		
		String line;
		while((line = br.readLine()) != null){
			String[] values = line.split("\\t", -1);
			bw.write(values[0] + "," + values[1] + "," + values[2] + "\n");	
		}
		
		br.close();
		bw.close();
		
	}

}
