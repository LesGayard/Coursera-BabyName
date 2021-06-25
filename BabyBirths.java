
/**
 * Décrivez votre classe Part1 ici.
 *
 * @author (Leslie Gayard)
 * @version (Le 26 mars 2019)
 */

import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class BabyBirths {

//method print information about births    
    public void printNames(){
//create a file resource
        FileResource fr = new FileResource();
        
        for(CSVRecord rec : fr.getCSVParser(false)){
//there is no header row = fr.getCSVParser(false) 
            int numBorn = Integer.parseInt(rec.get(2));
            
            if(numBorn <= 100){
                
                System.out.println("Names " + rec.get(0) + " Gender " + rec.get(1) + " Numb Born " + rec.get(2) );
                                
            }
            
        }
    
    }
    
// method total births
    public void totalBirths(FileResource fr){
        
            int totalBirths = 0;
            int totalBoys = 0;
            int totalGirls = 0;
            
            String totalBornNames = null;
            int totalNames = 0;
            
            String totalBoysNames = null;
            String totalGirlsNames = null;
            int countBoy = 0;
            int countGirl = 0;
            
            for(CSVRecord rec : fr.getCSVParser(false)){
                String bornNames = rec.get(0);
                System.out.println("All of the newborn names = " + bornNames);
                
                
                
                 
                
                if(rec.get(1).equals("M")){
                    totalBoysNames  = rec.get(0);
                    //System.out.println("the boys names = " + totalBoysNames);
                    countBoy ++;
                    //System.out.print("Number of boys names = " + countBoy);
                }
                else{
                    totalGirlsNames = rec.get(0) ;
                    //System.out.print("All the girls names = " + totalGirlsNames);
                    countGirl ++;
                    //System.out.println("Number of girls names = " + countGirl);
                    
                }
                
                totalNames = countBoy + countGirl;
                //System.out.println(totalNames);
                
                int numBorn = Integer.parseInt(rec.get(2));
                totalBirths += numBorn;
                
                if(rec.get(1).equals("M")){
                    totalBoys += numBorn;
                }
                else{
                    totalGirls += numBorn;
                }
                
                
            
            }
    
            //System.out.println("Total of births = " + totalBirths);
            //System.out.println("Total of girls births = " + totalGirls);
            //System.out.println("Total of boys births = " + totalBoys);
            
            //System.out.println("Total of newborn names = " + totalNames);
            System.out.println("Total of boys names = " + countBoy);
            System.out.println("Total of girls names = " + countGirl);
    }
    
//totalBirths test method
    public void testTotalBirths(){
        FileResource fr = new FileResource();
        totalBirths(fr);
    
    } 
    
//Write the method named getRank that has three parameters: 
//an integer named year, a string named name, and a string named gender (F for female and M for male).
    public int getRank(int year, String name, String gender){
// This method returns the rank of the name in the file for the given gender,
// where rank 1 is the name with the largest number of births

            FileResource fr = new FileResource();
            
            String currentGender = null;
            String currentName = null;
            int countCurrentNames = 0;
            
          
            int countRank = -1;
            int tempRank = 0;
            
            System.out.println("Input " + name + " Input " + year + " Input " + gender);
            
            for(CSVRecord rec : fr.getCSVParser(false)){
                currentGender = rec.get(1);
                currentName = rec.get(0);
                //System.out.println(" Current genders are before the if statement  " + currentGender);
                    if(currentGender.equals(gender)   ){
                        currentName = rec.get(0);
                         tempRank ++;
                        if(currentName.equals(name)){
                        
                             System.out.println(" for name = " + name + " rank = " + tempRank);
                             countRank = tempRank;
                             return countRank;
                        }
                        //System.out.println(" Name = " + currentName + " rank = " + countRank);
                       
                        
                    
                    }
                    
                    
                  
                    
                
                //System.out.println(" variable test  naissance " + currentNumberOfBirths + " nom de " + currentName + " countBirths " + countBirths);
                
                
                //If the name is not in the file, then -1 is returned
                
            
            
            
            }
   
    return countRank;
    } 
// test method getRank (int year, String name, String gender)
    public void testGetRank(){
       
    int test = getRank(1971, "Frank", "M");
    System.out.println(test);
    
    }
    
//Write the method named getName that has three parameters: 
//an integer named year, an integer named rank, and a string named gender (F for female and M for male). 
//This method returns the name of the person in the file at this rank, 
//for the given gender, where rank 1 is the name with the largest number of births. 
//If the rank does not exist in the file, then “NO NAME” is returned.
    public String getName(int year, int rank, String gender){
        
        String name = null;
        System.out.println("input gender " + gender + " input rank " + rank);
        FileResource fr = new FileResource();
        int countRank = 0;
        String result = null;
        
        for(CSVRecord rec : fr.getCSVParser(false)){
            String currentGender = rec.get(1);
            System.out.println("CSV Gender = " + currentGender);
            
            if(currentGender.equals(gender)){
                //System.out.println("now in the loop get the birthrank !!");
                String currentNumberBirths = rec.get(2);
                countRank ++;
                System.out.println ("number of births = " + currentNumberBirths + "count Rank of births " + countRank);
                String currentName = rec.get(0);
                System.out.println("CSV NAmes = " + currentName);
                if(countRank == rank){
                    
                    System.out.println("for the count rank " + rank + " is the name " + currentName );
                    result = currentName;
                    System.out.println(result);
                }
                
            }
        }
    System.out.println(result);    
    return result;
    }
// the getName test method    
    public void testGetName(){
        String test = getName(1982, 450, "M");
    }
    
//What would your name be if you were born in a different year? 
//Write the void method named whatIsNameInYear that has four parameters: 
//a string name, an integer named year representing the year that name was born,
// an integer named newYear and a string named gender (F for female and M for male).  
    public String whatIsNameInYear(String name, int year, int newYear, String gender){
//This method determines what name would have been named if they were born in a different year,
// based on the same popularity. That is, you should determine the rank of name in the year they were born,
// and then print the name born in newYear that is at the same rank and same gender.  
            String result = null;
            System.out.println("Input name =  " + name + " Input year = " + year + " Input new year = " + newYear);
            String currentName = null;
            String currentNameNewYear = null;
            int countRank = 0;
            int countNewYearRank = 0;
            
            DirectoryResource dr = new DirectoryResource();
            for( File f : dr.selectedFiles()){
            
                FileResource fr = new FileResource(f);
                FileResource frr = new FileResource();
                for(CSVRecord rec : fr.getCSVParser(false)){
                    
                    currentName = rec.get(0);
                    //System.out.println("CSV Name = " + currentName);
                    countRank ++;
                    //System.out.println ("Year " + year + " CSV Name = " + currentName + " Rank is = " + countRank);
                    //System.out.println ("InputYear " + year + " Input Name = " + name + " Rank is = " + countRank);
                    
                    if(currentName.equals(name)){
                        
                        for(CSVRecord record : frr.getCSVParser(false)){
                            currentNameNewYear = record.get(0);
                           // System.out.println("new year = " + newYear + " names are = "+ currentNameNewYear);
                            countNewYearRank ++;
                            //System.out.println ("Year " + newYear + " CSV Name = " + currentNameNewYear + " Rank is = " + countNewYearRank);
                            
                            if(countRank == countNewYearRank){
                            System.out.println( "Input Name = " + name + " born in = " + year + " shoul be = " + currentNameNewYear + " in = " + newYear);
                            }
                        }
                    
                    }
                }
                
            }
            
    return result;        
    } 
//the test whatIsNameInYear method    
    public void testWhatIsNameInYear(){
    String test = whatIsNameInYear("Owen", 1974, 2014, "M");
    }
    
//Write the method yearOfHighestRank that has two parameters: a string name, and a string named gender (F for female and M for male). 
//This method selects a range of files to process and returns an integer, the year with the highest rank for the name and gender.
// If the name and gender are not in any of the selected files, it should return -1 
 public int yearOfHighestRank(String name, String gender) {
        long highestRank = 0;
        int yearOfHighestRank = -1;
        String fileName = "";
        DirectoryResource dr = new DirectoryResource();

        // Iterate through all files
        for(File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            CSVParser parser = fr.getCSVParser(false);

            // Iterate through all records in file
            for(CSVRecord record : parser) {
                String currName = record.get(0);
                String currGender = record.get(1);

                if(currName.equals(name) && currGender.equals(gender)) {
                    long currRank = record.getRecordNumber();

                    if(highestRank == 0) {
                        highestRank = currRank;
                        fileName = f.getName();
                    } 
                    else {
                        if(highestRank > currRank) {
                            highestRank = currRank;
                            fileName = f.getName();
                        }
                    }
                }
            }
        }

        // Remove all non-numeric characters from the filename
        fileName = fileName.replaceAll("[^\\d]", "");

        // Convert String fileName to Integer
        yearOfHighestRank = Integer.parseInt(fileName);

        return yearOfHighestRank;
    }
  
    
//test method for yearOfHighestRank
    public void testYearOfHighestRank(){
    int test = yearOfHighestRank("Mich", "M");
    System.out.println(test);
    } 
    
//Write the method getAverageRank that has two parameters: a string name, and a string named gender (F for female and M for male) 
    public double getAverageRank(String name, String gender){
// This method selects a range of files to process and returns a double representing the average rank of the name and gender over the selected files.     
                System.out.println("input name = " + name + " input gender = " + gender);
                
                String currentName = null;
                String currentGender = null;
                
                double rank = 0.0;
                
                double rankTemp = 0.0;
                
                double sumRank = 0.0;
                
                int howMany = 0;
                double average = 0.0;
                DirectoryResource dr = new DirectoryResource();
                for(File f : dr.selectedFiles()){
                    FileResource fr = new FileResource(f);
                    for(CSVRecord record : fr.getCSVParser(false)){
                            currentGender = record.get(1);
                       
                           if( currentGender.equals(gender)){
                            currentName = record.get(0);
                            rank ++;
                            
                                if(currentName.equals(name)){
                                howMany ++; 
                                
                                
                                System.out.println("for name = " + currentName + " gender = " + currentGender  + " rank = " + rank);
                                rankTemp = rank;
                                
                                
 
                                System.out.println("number of names = " + howMany + " rank to keep outside the loop = " + rankTemp);
                                
                                
                                }
                            
                            }
                           
                             
                    }
                        if(howMany >0){
                        sumRank += rankTemp ;
                        System.out.println("test sum = " + sumRank);
                        }
                    rank = 0.0;
                    
                    
                    
                    
                    
                    //System.out.println("rank temp = " + rankTemp);
                    
                    //System.out.println("sum rank = " + sumRank);
                    average = sumRank / howMany;
                    System.out.println("the average of rank = " + average);
                }
                 
		double result = 0.0;
	return result;
    } 
    
//test method getAverageRank
    public void testGetAverageRank(){
    
    double test = getAverageRank("Robert", "M");
    } 
//Write the method getTotalBirthsRankedHigher that has three parameters:
// an integer named year, a string named name, and a string named gender (F for female and M for male).
    public int getTotalBirthsRankedHigher(int year, String name, String gender){
//This method returns an integer, 
//the total number of births of those names with the same gender and same year who are ranked higher than name.    
        System.out.println("input year = " + year + " input name = " + name + " input gender = " + gender);
        
        int result = 0;
        String currentName = null;
        String currentGender = null;
        int currentBirthNumber = 0;
        int birthNumber = 0;
        int totalBirths = 0;
        
        
        FileResource fr = new FileResource();
        for(CSVRecord record : fr.getCSVParser(false)){
            
            currentGender = record.get(1);
            if(currentGender.equals(gender)){
            
            currentName = record.get(0);
            birthNumber = Integer.parseInt(record.get(2));
            //System.out.println("names = " + currentName + " nb births = " + birthNumber);
            
             if(currentName.equals(name)){
                    System.out.println("name =" + currentName + " gender = " + currentGender   );
                    
                    currentBirthNumber = Integer.parseInt(record.get(2));
                    System.out.println(" for current name =" + currentName + "  current gender = " + currentGender + " nb births = " + currentBirthNumber);
                    
                    
                    
                    
                    
              }
            if(currentBirthNumber < birthNumber){
                        totalBirths += birthNumber;
                        System.out.println(" test sum = "+ totalBirths);
                        result = totalBirths;
                    }    
            
            
            
            }
               
            System.out.println("sum of higher rank = " + result);    
        }

   
    return result;
    } 
//test method getTotalBirthsRankedHigher
    public void testGetTotalBirthsRankedHigher(){
    
    int test = getTotalBirthsRankedHigher(1990, "Drew", "M");
    }   
    
    
}
