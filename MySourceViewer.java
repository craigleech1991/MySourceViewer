/**
* I declare that this assignment is my own work and that all 
* material previously written or published in any source by any 
* other person has been duly acknowledged in the assignment. I 
* have not submitted this work, or a significant part thereof, 
* previously as part of any academic program. In submitting this 
* assignment I give permission to copy it for assessment purposes 
* only.
* 
* title: MySourcevViewer.java
* description: Retrieves source from URL or I.P. and searches for instances of the given string	   
* 
* @author craigleech
* @version 1.0
* @since 2018-04-09
*/

/**
 * DOCUMENTATION...
 */

/**                                                                               
 *
 *<P> 
 * This program is run via the command prompt. It retrieves source from URL or I.P. and searches
 * for instances of the given search string.
 *</P>
 *<P>
 * This program uses Java(TM) SE Runtime Environment (build 9.0.4+11)
 *</P>
 *                                                                              
 *<DL>
 *<DT> Compiling and running instructions</DT>
 *<DT> Change to the directory containing the source code.</DT>
 *<DD> Compile:    javac MySourceViewer.java</DD>
 *<DD> Run:        java MySourceViewer (URL or I.P.) "search string"</DD>
 *<DD> Document:   javadoc MySourceViewer.java</DD>
 *</DL>
 */

/**                                                                               
 *
 *<P> 
 * public class MySourceViewer {<BR>
 * Private inner class
 *</P>
 *<P>
 * public static void main (String args[]){ <BR>
 * Main method used to execute the program
 *</P>
 */ 

/**
 *
 * <H3>Test Plan</H3>
 *
 *<P>
 * 1. Run the application from command prompt
 * EXPECTED:
 *   Program will search for the given search string
 *	 If found user will be presented with: "Search String" found in line: (print out of entire line)
 *	 If not found nothing will be printed to the console
 *  ACTUAL: Terminal displays as expected
 *</P>
 *<P>
 * 2. Good data cases:
 * EXPECTED:
 *    Run the following test cases by running the program with the following parameters:
 *   1. java MySourceViewer https://stackoverflow.com/questions/ "push({"
 *			Output should be:
 * 			push({ found in line:                     _qevents.push({ qacct: "p-c1rF4kxgLUzNc" });
 *
 *			push({ found in line:                     _comscore.push({ c1: "2", c2: "17440561" });    
 *
 *   
 * ACTUAL:
 *    Results displayed as expected.
 *</P>
 *<P>
 * 3. Bad data cases:
 * EXPECTED:
 *    Run the following test cases by running the program with the following parameters:
 *    1. java MySourceViewer athabascau.ca "push"
 *			output should be:
 *			athabascau.ca is not parseable
 *	  2. java MySourceViewer https://stackoverflow.com/questions/ "blah blah blah"
 *			String not found there will be nothing printed to the terminal
 *  
 *
 * ACTUAL: 
 *    Results displayed as expected.
 *</P>
 */ 

/**
 * CODE...
 */

/** import java packages*/
import java.io.*;
import java.net.*;
/** primary (public) class for MySourceViewer */
public class MySourceViewer {
	/** Main Method*/
	public static void main (String args[]){

		// if the length of args is greater that 0 do
		if(args.length > 0){
			InputStream in = null;
			// try-catch to catch input exceptions
			try{
				//Open the URL for reading
				URL u = new URL(args[0]);
				in = u.openStream();
				// buffer the input to increase performance
				in = new BufferedInputStream(in);
				// chain the InputStream to a InputStreamReader
				InputStreamReader input = new InputStreamReader(in);
				// chain InputStreamReader to BufferedReader
				BufferedReader r = new BufferedReader(input);
				// set key = the search string from agrs[0]
				String key = args[1];
				// String theString = the line of code to be read
				String theString;
				
				/// while the next line is not null do
				while((theString = r.readLine()) != null){
					// if the line contains an instance of key print line
					if(theString.toLowerCase().contains(key.toLowerCase())){
						// print key found in line: "theString" 
						System.out.println(key + " found in line: " + theString);
						System.out.println(" ");
					}
				}// end while
			} //end try

			//catch excpetions
			catch(MalformedURLException ex){
				System.err.println(args[0] + " is not parseable");
			}
			catch(IOException ex){
				System.err.println(args[0]);
			}
			// finally close the input stream
			finally{
				if(in != null){
					try{
						in.close();
					}
					catch(IOException e){
						// ignore
					}
				}
			}
		}
	}
}