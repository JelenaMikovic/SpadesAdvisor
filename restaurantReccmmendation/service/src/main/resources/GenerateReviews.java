import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class GenerateReviews {
    public static void generate(Connection conn) throws SQLException {
        try (Statement stmt = conn.createStatement()) {
            int review_count;
            int user_id;
            int restaurant_id = 1;
            int review_id = 1;

            while (restaurant_id <= 40) {
                review_count = (int) (Math.floor(Math.random() * (20 - 6 + 1)) + 6);

                while (review_count > 0) {
                    user_id = (int) (Math.floor(Math.random() * 20) + 4);
                    int rating = (int) (Math.floor(Math.random() * 5) + 1);

                    stmt.executeUpdate("INSERT INTO reviews (user_id, rating) VALUES (" + user_id + ", " + rating + ")");
                    stmt.executeUpdate("INSERT INTO restaurants_reviews (restaurant_id, reviews_id) VALUES (" + restaurant_id + ", " + review_id + ")");

                    review_count--;
                    review_id++;
                }

                restaurant_id++;
            }
        }
    }
}