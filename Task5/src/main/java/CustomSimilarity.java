import org.apache.lucene.search.similarities.ClassicSimilarity;

public class CustomSimilarity extends ClassicSimilarity {

    @Override
    public float idf(long docFreq, long docCount) {
        return (float) (Math.log((docCount + 1) / (double) (docFreq + 1)) + 1.0);
    }

    public static void main(String[] args) {
        CustomSimilarity customSimilarity = new CustomSimilarity();
        long docFreq = 5; // пример количества документов, содержащих термин
        long docCount = 10; // пример общего количества документов в коллекции
        float idfValue = customSimilarity.idf(docFreq, docCount);
        System.out.println("Значение IDF: " + idfValue);
    }
}
