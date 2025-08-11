package Recommendation.system;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Map;

import org.apache.mahout.cf.taste.recommender.RecommendedItem;

public class GUI {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                Main.initialize();
                Map<Long, String> movieMap = Main.getMovieMap();

                JFrame frame = new JFrame("Movie Recommendation System");
                frame.setSize(600, 400);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());

                JPanel topPanel = new JPanel(new FlowLayout());
                JLabel userLabel = new JLabel("Select User ID:");

                List<String> userIdList = Main.getAllUserIds();
                JComboBox<String> userDropdown = new JComboBox<>(userIdList.toArray(new String[0]));

                JButton recommendButton = new JButton("Get Recommendations");
                topPanel.add(userLabel);
                topPanel.add(userDropdown);
                topPanel.add(recommendButton);

                JTextArea resultArea = new JTextArea(15, 50);
                resultArea.setEditable(false);
                JScrollPane scrollPane = new JScrollPane(resultArea);

                recommendButton.addActionListener(e -> {
                    try {
                        long userId = Long.parseLong((String) userDropdown.getSelectedItem());
                        List<RecommendedItem> recommendations = Main.getRecommendations(userId);

                        resultArea.setText("Recommended Movies for User " + userId + ":\n\n");
                        if (recommendations.isEmpty()) {
                            resultArea.append("No recommendations available.\n");
                        } else {
                            for (RecommendedItem item : recommendations) {
                                String movieName = movieMap.getOrDefault(item.getItemID(), "Movie ID: " + item.getItemID());
                                resultArea.append(movieName + " (Score: " + String.format("%.2f", item.getValue()) + ")\n");
                            }
                        }
                    } catch (Exception ex) {
                        resultArea.setText("Error: " + ex.getMessage());
                        ex.printStackTrace();
                    }
                });

                frame.add(topPanel, BorderLayout.NORTH);
                frame.add(scrollPane, BorderLayout.CENTER);
                frame.setVisible(true);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Initialization failed: " + e.getMessage());
            }
        });
    }
}
