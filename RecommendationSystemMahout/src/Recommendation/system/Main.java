package Recommendation.system;

import java.io.*;
import java.util.*;

import org.apache.mahout.cf.taste.impl.common.LongPrimitiveIterator;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.recommender.*;

public class Main {

    private static DataModel model;
    private static UserBasedRecommender recommender;
    private static Map<Long, String> movieMap = new HashMap<>();

    public static void initialize() throws Exception {
        model = new FileDataModel(new File("data/user_movie_ratings.txt"), "\t");
        loadMovieTitles("data/movies.csv");

        UserSimilarity similarity = new PearsonCorrelationSimilarity(model);
        UserNeighborhood neighborhood = new NearestNUserNeighborhood(3, similarity, model);
        recommender = new GenericUserBasedRecommender(model, neighborhood, similarity);
    }

    public static List<RecommendedItem> getRecommendations(long userId) throws Exception {
        return recommender.recommend(userId, 3);
    }

    public static List<String> getAllUserIds() throws Exception {
        List<String> userIds = new ArrayList<>();
        LongPrimitiveIterator it = model.getUserIDs();
        while (it.hasNext()) {
            userIds.add(String.valueOf(it.nextLong()));
        }
        Collections.sort(userIds);
        return userIds;
    }

    public static Map<Long, String> getMovieMap() {
        return movieMap;
    }

    private static void loadMovieTitles(String path) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(path));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",", 2); // allow movie titles with commas
            if (parts.length == 2) {
                try {
                    long id = Long.parseLong(parts[0].trim());
                    movieMap.put(id, parts[1].trim());
                } catch (NumberFormatException ignored) {}
            }
        }
        reader.close();
    }
}
