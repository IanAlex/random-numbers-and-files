# Generate Random Numbers and Write to File: Description and Assumptions

This console-based (command line) application is written in Java 8 so that it can be run as a Jar generated in Maven

There is logic in the RandomFileWorker class to generate a million random numbers (unordered or ordered).  There is also methodology in public methods (writeUnorderedRandomsToFile() & writeOrderedRandomsToFile()) to write the list of random numbers (ordered or unordered) to a file.   There is also a public method to take an input file of random numbers, order them and write to an output file (the writeRandomsInOrderFromOneFileToAnother() method).

The application runs from a AppDriver.runMenu() whereby the user has console choices to (1) generate a file of a million unordered random numbers (2) generate a file of a million ORDERED random numbers (3) transfer random numbers from one file and order them in a destination file (4) exit the application (application can also be terminated via ctrl-C).

The application assumes that random numbers generated will be unbounded integers and that the files generated will have the random numbers delimited by whitespace (blanks).

The application guards against errors in that if an invalid file name is used then an exception will be thrown and a message outputted.  If transferring from one file to another there is a safeguard against invalid data (i.e. non-integer entries) in the parsing.   If the logic works as intended then a success message is generated.


# Steps to Build and Run the application

(assumes Maven and Java 8 is installed)

(i) download the maven project (assumes Maven is installed on your machine)

(ii) From the source directory (i.e. the folder with the pom.xml file) Build the jar file using on the command line:

   mvn package
   
(iii) Test the application by running the jar file from the command-line:
    java -cp <path-to-target>/random-numbers-and-files-0.0.1-SNAPSHOT.jar AppDriver
    

(iv) test the interactive command-line menu options including situations with invalid file names to make sure errors handled correctly.  Ensure that the files are properly created and view the files to check that a million whitespace-delimited random numbers are created.  In case of menu options "2" and "3" ensure that the random numbers (whitespace-delimited) are in ascending order.

 
