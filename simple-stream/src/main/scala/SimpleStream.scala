import org.apache.spark.streaming.{Seconds, StreamingContext}
import StreamingContext._


object SimpleStream{
  
  def main(args:Array[String]){
        val ssc = new StreamingContext("local[2]", "Streaming Job",Seconds(10), 
               "/Users/apple/Desktop/Workshop_9thAug/spark")
        val lines=ssc.socketTextStream("localhost", 9213)
		// Split the lines into words, count them, and print some of the counts on the master
		val words = lines.flatMap(_.split(" "))
		val wordCounts = words.map(x => (x, 1)).reduceByKey(_ + _)
		wordCounts.print()

        ssc.start()
   }
}
