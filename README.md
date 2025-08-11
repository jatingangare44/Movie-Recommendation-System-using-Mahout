# Movie Recommendation System using Apache Mahout

This project is a **Java-based Movie Recommendation System** that uses **Apache Mahout** to generate personalized movie recommendations based on user preferences.  
It includes a **Java Swing GUI** for a simple user interface to view recommendations.

---

## 📌 Features
- **Collaborative Filtering** using Apache Mahout
- **Swing-based GUI** for user-friendly interaction
- Reads data from a dataset file (`dataset.csv`)
- Generates top-N movie recommendations for a given user
- Displays recommendations directly in the GUI

---

## 🛠️ Technologies Used
- **Java (JDK 8+)**
- **Apache Mahout**
- **Swing (Java GUI)**
- **CSV dataset** for movie ratings

---

## 📂 Project Structure
```
Movie-Recommendation-System-using-Mahout/
│
├── src/
│   ├── Main.java        # Main logic for building the recommendation engine
│   ├── GUI.java         # Swing-based graphical user interface
│
├── dataset.csv          # Ratings dataset (userId, movieId, rating)
├── README.md            # Project documentation
└── pom.xml              # Maven dependencies (if using Maven)
```

---

## ⚙️ How It Works
1. **Load Dataset**  
   The program reads a CSV file containing user ratings for movies.
   
2. **Create Data Model**  
   Uses Mahout's `FileDataModel` to structure the dataset.

3. **Build Recommender**  
   Uses a similarity metric (e.g., `PearsonCorrelationSimilarity`) to compare users and generate recommendations.

4. **Display Results**  
   The GUI allows users to enter their `userId` and view movie recommendations instantly.

---

## 🚀 Getting Started

### 1️⃣ Prerequisites
- Install **Java JDK 8+**
- Install **Apache Mahout**  
- Install **Maven** (optional but recommended for dependency management)

### 2️⃣ Clone the Repository
```bash
git clone https://github.com/jatingangare44/Movie-Recommendation-System-using-Mahout.git
cd Movie-Recommendation-System-using-Mahout
```

### 3️⃣ Add Dataset
Place your `dataset.csv` file in the project root directory.  
**Example format:**
```
userId,movieId,rating
1,101,4.0
1,102,3.5
2,101,5.0
...
```

### 4️⃣ Compile and Run
#### Using Command Line:
```bash
javac -cp .:mahout-core-0.9.jar:mahout-math-0.9.jar *.java
java -cp .:mahout-core-0.9.jar:mahout-math-0.9.jar Main
```
#### Using IDE (Eclipse/IntelliJ):
- Import the project
- Add **Mahout** JARs to your build path
- Run `Main.java`

---

## 🖥️ GUI Usage
1. Run `GUI.java`
2. Enter a **User ID**
3. Click **"Get Recommendations"**
4. Recommended movie list will appear in the GUI window

---

## 📸 Screenshot
<img width="879" height="359" alt="image" src="https://github.com/user-attachments/assets/51125309-d108-4e14-80d7-34744014356c" />
<img width="870" height="282" alt="image" src="https://github.com/user-attachments/assets/1acaeff8-ca86-4109-966c-79aa2c645e5a" />



---

## 📜 License
This project is licensed under the MIT License.

---

## 🙌 Author
**Jatin Gangare**  
📧 [your-email@example.com]  
🔗 [GitHub Profile](https://github.com/jatingangare44)
