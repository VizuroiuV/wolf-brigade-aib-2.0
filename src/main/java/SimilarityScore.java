import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import org.deeplearning4j.models.embeddings.loader.WordVectorSerializer;
import org.deeplearning4j.models.word2vec.Word2Vec;
import org.deeplearning4j.text.tokenization.tokenizerfactory.DefaultTokenizerFactory;
import org.deeplearning4j.text.tokenization.tokenizerfactory.TokenizerFactory;

import java.io.File;
import java.util.Properties;
import java.util.stream.Collectors;

public class SimilarityScore {

    private static Word2Vec word2VecModel;
    public static void main(String[] args) {

    }

    public SimilarityScore(){
        File modelFile = new File("GoogleNews-vectors-negative300.bin"); // Provide the correct path to your model file

        // Initialize the Word2Vec model by loading a pre-trained model
        word2VecModel = WordVectorSerializer.readWord2VecModel(modelFile);
    }
    public double similarityScore(String actualAnswer, String expectedAnswer){
        Properties props = new Properties();
        props.setProperty("annotators", "tokenize,ssplit,pos,lemma");
        StanfordCoreNLP pipeline = new StanfordCoreNLP(props);

        // Input texts
        //String text1 = "The hardest natural substance on Earth is diamond. Its hardness is due to the strong covalent bonds between carbon atoms in its crystal lattice structure. On the Mohs scale of mineral hardness, which ranges from 1 (talc) to 10 (diamond), diamond ranks as a 10, making it the hardest known natural material.";
        //String text2 = "The hardest natural substance on Earth is diamond. Diamonds are composed of carbon atoms arranged in a specific crystal structure called a diamond cubic, which gives them their exceptional hardness and strength. On the Mohs scale of mineral hardness, diamond is rated as a 10, which is the highest rating. This extreme hardness makes diamonds highly valued for both their aesthetic beauty in jewelry and their industrial applications, such as in cutting tools and abrasives.";

        // Preprocess texts
        String preprocessedText1 = preprocessText(actualAnswer, pipeline);
        String preprocessedText2 = preprocessText(expectedAnswer, pipeline);

        // Generate embeddings (dummy embeddings in this example)
        double[] embedding1 = generateEmbedding(preprocessedText1);
        double[] embedding2 = generateEmbedding(preprocessedText2);

        // Compute similarity
        double similarity = computeCosineSimilarity(embedding1, embedding2);
        System.out.println("Cosine Similarity: " + similarity);
        return similarity;
    }

    private static String preprocessText(String text, StanfordCoreNLP pipeline) {
        CoreDocument document = new CoreDocument(text);
        pipeline.annotate(document);

        return document.tokens().stream()
                .map(CoreLabel::lemma) // Get the lemma of each token
                .collect(Collectors.joining(" "));
    }

    private static double[] generateEmbedding(String text) {
        // Tokenize and get word vectors
        TokenizerFactory tokenizerFactory = new DefaultTokenizerFactory();
        String[] tokens = tokenizerFactory.create(text).getTokens().toArray(new String[0]);

        double[] sum = new double[word2VecModel.getWordVector(word2VecModel.vocab().wordAtIndex(0)).length];
        int count = 0;

        for (String token : tokens) {
            if (word2VecModel.hasWord(token)) {
                double[] vector = word2VecModel.getWordVector(token);
                for (int i = 0; i < vector.length; i++) {
                    sum[i] += vector[i];
                }
                count++;
            }
        }

        // Average word vectors to get sentence embedding
        if (count > 0) {
            for (int i = 0; i < sum.length; i++) {
                sum[i] /= count;
            }
        }

        return sum;
    }
    //
    public static double computeCosineSimilarity(double[] vectorA, double[] vectorB) {
        double dotProduct = 0.0;
        double normA = 0.0;
        double normB = 0.0;

        for (int i = 0; i < vectorA.length; i++) {
            dotProduct += vectorA[i] * vectorB[i];
            normA += Math.pow(vectorA[i], 2);
            normB += Math.pow(vectorB[i], 2);
        }

        return dotProduct / (Math.sqrt(normA) * Math.sqrt(normB));
    }
}