package FileTools;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.nio.Buffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class Input {

	public static BufferedReader bufferedReader(String fileName, Charset charset){
		try{BufferedReader in = new BufferedReader(
				new InputStreamReader(
						new FileInputStream(fileName)));}
		catch (FileNotFoundException e )
		return in;
	}
	
	public static ObjectInputStream objectInputStream(String fileName) 
			throws FileNotFoundException, IOException {
		
		return new ObjectInputStream(
				new FileInputStream(fileName));
	}
	
	public static ArrayList<String> linesToArrayList (String fileName, Charset charset)
			throws FileNotFoundException, IOException
	{
		ArrayList<String> result = new ArrayList<String>();
		linesToList(result, fileName, charset);
		return result;
	}
	
	public static void linesToList (List <String> list, String fileName, Charset charset)
	{
		BufferedReader in = bufferedReader(fileName, charset);
		try {
					String line;
					while ((line = in.readLine()) != null)
					{
//						if (!line.matches("\s*")) {
						list.add(line);
//						}
					}
					in.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
	}
	
//	private static void readFromFile(String fileName, Charset charset)
//	{
//		try {
//			BufferedReader in = createBufferedReader(fileName, charset);
//					String line;
//					while ((line = in.readLine()) != null)
//					{
//						if (!line.matches("\s*")) {
//							System.out.println(line);
//						}
//					}
//					in.close();
//			}
//		catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
//		catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
}
