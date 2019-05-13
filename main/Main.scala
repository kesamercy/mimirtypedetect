//create a main function that calls the test cases
object TypeDetect {

  def main(args: Array[String]): Unit = {


    var dataTypes: Seq[String] = Seq();

    //pass an input argument as the csv file to run the datype detect class
    var dataTypesMaps = dataTypeDetect.guesTypesForCSVFile("C:\\\\Users\\\\nm293\\\\IdeaProjects\\\\typeDetect\\\\src\\\\test\\\\scala\\\\test_data\\\\forty_thousand.csv");

    dataTypes = dataTypesMaps.map(_.maxBy(numTypes => numTypes._2)._1)


    //run the test with the profiler
  }//end main
  }//end type detect

