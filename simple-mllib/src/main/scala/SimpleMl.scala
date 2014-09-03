import org.apache.spark.mllib.clustering.KMeans
import org.apache.spark.mllib.linalg.{Vector, Vectors}
import org.apache.spark.SparkContext


object SimpleMl {
  def main(args: Array[String]) {
    val sc = new SparkContext("local", "Simple Ml", "/Users/apple/Desktop/github/spark")
    // Load and parse the data
    val data = sc.textFile("/Users/apple/Desktop/github/demoproject/data/kmeans_data.txt")
    val parsedData = data.map(_.split(' ').map(_.toDouble))
    val vector = parsedData.map(x => Vectors.dense(x))

    // Cluster the data into two classes using KMeans
    val numIterations = 20
    val numClusters = 2
    val clusters = KMeans.train(vector, numClusters, numIterations)

    // Evaluate clustering by computing Within Set Sum of Squared Errors
    val WSSSE = clusters.computeCost(vector)
    println("Within Set Sum of Squared Errors = " + WSSSE)

  }
}
