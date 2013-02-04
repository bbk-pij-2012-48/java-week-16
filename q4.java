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
		
		if(dst.exists()) {
			System.out.println("File " + dst + " already exists. Do you want to continue?");
			String response = System.console().readLine();
			while(!response.equals("y")) {
				if (response.equals("n")) {
					return;
				}
				response = System.console().readLine();
			}
		}
		
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

