package prediction.itemrecommender;

import java.util.List;
import java.io.File;
import java.io.IOException;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.common.LongPrimitiveIterator;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.recommender.GenericItemBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.LogLikelihoodSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.similarity.ItemSimilarity;

public class SongRecommend {

	public static void main(String[] args) throws IOException, TasteException {
		DataModel dm = new FileDataModel(new File("data/song_data_long1.csv"));
		
		ItemSimilarity sim = new LogLikelihoodSimilarity(dm);
		
		GenericItemBasedRecommender recommender = new GenericItemBasedRecommender(dm, sim);
		
		int x=1;
		for(LongPrimitiveIterator items = dm.getItemIDs(); items.hasNext();){
			long itemID = items.nextLong();
			List<RecommendedItem>recommendations = recommender.mostSimilarItems(itemID, 5);
			
			for(RecommendedItem recommendation : recommendations) {
				System.out.println(itemID + "," + recommendation.getItemID() + "," + recommendation.getValue());
				}
			x++;
			if(x>10) System.exit(1);
		}
		
	}

}
