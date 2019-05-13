
import java.io.File

import com.github.tototoshi.csv.CSVReader

import scala.util.matching.Regex
import scala.util.matching.Regex.MatchIterator

object dataTypeDetect {

  //regex to check data types
  var chekXpression: Map[String,Regex] = Map(

    "Integer"    -> "^[0-9]+$".r,
    "Float"      -> "^[-+]?([0-9]+(\\.[0-9]+)?|\\.[0-9]+)$".r,
    "Date"       -> """^(0?[1-9]|1[012])[- \/.](0?[1-9]|[12][0-9]|3[01])[- \/.](19|20)\d\d$""".r,
    "Boolean"    -> "^([Vv]+(erdade(iro)?)?|[Ff]+(als[eo])?|[Tt]+(rue)?|0|[\\+\\-]?1)$".r,
    "TimeStamp"  -> "^([0-1][0-9]|[2][0-3]):([0-5][0-9])$".r,

    //define to return the string incase the type is not matched to the regex
  )


  def guesTypesForCSVFile(filename: String) : Seq[Map[String, Int]]  = {
    val reader = CSVReader.open(new File(filename))

    //read all lines
    val allLines = reader.all()

    //skip the first line of the csv which is the header
    val skipHeader = allLines.drop(1)

    

    /*determine the number of rows*/
    val source = skipHeader;
    var nrows = 0
     while (source.hasNext) {  
      nrows += 1 
    }//end while

    //determine number of cols
    val getcols = reader.all(1);
    val result = getcols.split(',');
    val ncols = result.length;


    /*read the data into 2d array then access it in row form*/
    val rows = Array.ofDim[String](nrows, ncols)
    var count = 0
    for (eachrow <- rows) {

        /*it is going through each col now*/

        val currenttype = findType(regex, data)

        /*write a function that reads the data differently from hoe its being read
        the data should be read ine ach row and return the type depending on each row */

        /*read the first 20*/

        /*guess the next */

      for (eachcol <- 1 to cols ){



      }//end for in each col
    }
    bufferedSource.close

    //determine the type in each row 

    //based on the type, increment the count for the type found 

    //at the end of the col, return the type with the highest count 

    //go to the next element in the row and repeat 




    //read the data by the coloumn
    val columnarData = skipHeader.foldLeft(Seq[Seq[String]]())((init, currentRow) => {

      init match {
        case Seq() => currentRow.map(cell => Seq(cell))
        case nonEmptySeq => (currentRow.zipWithIndex).map(cellidx => nonEmptySeq(cellidx._2) :+ cellidx._1)
        case _ => init
      }

    })
    columnarData.map(column => dataTypeDetect.findAllTypes(column) )
  }

  //method to determine / guess the dataType of a string
  def guessType(data:Seq[String]): String = data { //return the label

    // use find all to return the values for the data types
    val checkTypes = findAllTypes(data) //- this should retunr a collection of data sets
    
    // determine the max of the dataTypes and return the dataType of the highest probability.
    val finalType:(String, Int) = checkTypes.maxBy(numTypes => numTypes._2)

    return finalType._1

  }// end guess

  //method to find all data types

  def findAllTypes(data: Seq[String]): Map[String, Int] = {

    (for( (typeName:String, regex:Regex) <- chekXpression ) yield{

      //instead of print, return the values
      val count = findType(regex, data)

      //assigned the return values to variable names
      var dataType = typeName;
      var numType = count;

      (dataType,numType)
     }).toMap

  }// end def

  //method to determine one data type 
  def findType (regularXp: Regex , data: Seq[String]): Int = {

    data.map(el =>
      if(regularXp.findFirstIn(el) != None){ 1 }
      else { 0 }
    ).sum

  }

}// end dataTypeDetect


//function to determine the freq of rows to read - what do you think?
