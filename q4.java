import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.FileNotFoundException;

public class q4 {
	
	public static void main(String[] args) {
		File src = new File(args[0]);
		File dst = new File(args[1]);
		
		// test if dst exists here - if it does, program should ask whether or not to continue
		
		BufferedReader in = null;
		
		try {
			in = new BufferedReader(new FileReader(src));
			
			PrintWriter out = null;					
			try {
				out = new PrintWriter(dst);
				String line;
				while((line = in.readLine()) != null) {
					out.write(line + "\n");
				}
			} catch(FileNotFoundException ex) {
				System.out.println("Error - file " + dst + " could not be written");
			} catch(IOException ex) {
				ex.printStackTrace();
			} finally {
				out.close();
			}
		} catch(FileNotFoundException ex) {
			System.out.println("Error - file " + src + " not found");
		} finally {
			try {
				if(in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}
		
