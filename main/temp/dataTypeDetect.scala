
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

      nrows += 1;

    }//end while

    //determine number of cols
    val getcols = reader.all(1);
    val result = getcols.split(',');
    val ncols = result.length;


   /*create an array for the number of cols*/
    var coltypes = new Array[String](ncols);

    for(row <- 0 to skipHeader.length){

      for(i <- 0 until coltypes.length){

        /*find the type*/
        matchtype = findType(regex, row[i]);

        /*assign the first found type to the coltype*/
        if(i < 1){

          coltypes(i) = matchtype

        }//end if 

        /*if the second type matches, then assign it to the col type*/
        if (i > 1 && coltypes == matchtype) {

          coltypes(i) = matchtype

        }//end if

        else {

          println("Column types are not consistent");

        }//end else 

      }//end for col

    }//end for row

    /*print out the col types*/
    for( i <- 0 until coltypes.length){

      println("Type For col " + i + coltypes[i]);

    }

  }//end guess type for csv


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
