object prac  {

	def main(arg: Array[String]) = {

		var a = 0;

		for(a <- 1 to 10 ){

			println("this is the day the Lord has made");

		}

        // The string we want to split.
        val line = "brick,cement,concrete"

        // Split on each comma.
        val result = line.split(',')

        // Array length.
        println(result.length)

        // Print all elements in array.
        for (v <- result) {
            println(v)
        }

		/*//declare an array in scala 

		var labnames = Array("Carl", "Mercy", "Will", "Darshana", "Mike");

		for( x <- 0 to (labnames.length - 1)){

			println(x);
		}


		//test how to read data from a csv using the method that has been shown on the website 

		val bufferedSource = io.Source.fromFile("C:\\\\Users\\\\nm293\\\\IdeaProjects\\\\typeDetect\\\\src\\\\test\\\\scala\\\\test_data\\\\onethousand.csv")
        for (line <- bufferedSource.getLines.drop(990)) {

            val cols = line.split(",").map(_.trim)
            // do whatever you want with the columns here
            
            println(s"${cols(0)}|${cols(1)}|${cols(2)}|${cols(3)}")
    }
    bufferedSource.close*/

		
	}// end main
	
}//end obj