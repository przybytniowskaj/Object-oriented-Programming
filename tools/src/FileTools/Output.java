package FileTools;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Output {
	
	public static ObjectOutputStream objectOutputStream(String fileName) throws IOException{
		return new ObjectOutputStream(
				new FileOutputStream(fileName));
	}
	
	public static PrintWriter createAppender(String fileName, Charset charset) throws IOException
	{
		return new PrintWriter(
				new BufferedWriter(
						new FileWriter(fileName, charset, true)));
	}
	
	

	public static String makeLine(List<Object> objects, String delimiter) {
		StringBuilder stringBuilder = new StringBuilder();
		Iterator<Object> iterator = objects.iterator();
		stringBuilder.append(iterator.next());
		while (iterator.hasNext()) {
			stringBuilder.append(delimiter).append(iterator.next());
		}
		return stringBuilder.toString();
	}
	
	public static <K, V> void writeMapToFile(Map<K, V> map, PrintWriter printWriter) throws IOException {
		writeMapToFile(map, printWriter, ": ");
	}
	
	public static <K, V> void writeMapToFile(Map<K, V> map, PrintWriter printWriter, String delimiter) throws IOException {
		Set<Entry<K, V>> entries = map.entrySet();
		Iterator<Entry<K, V>> iterator = entries.iterator();
			while (iterator.hasNext()) {
				Entry<K, V> entry = iterator.next();
				String line = Output.makeLine(List.of(entry.getKey(), entry.getValue()), delimiter);
				printWriter.write(line);
				if (printWriter.checkError())
					throw new IOException();
			}
	}
	
	public static <T> void writeCollectionToFile(Collection<T> collection, PrintWriter printWriter)
	throws IOException {
		
		for (T element: collection)
		{
			printWriter.write(element.toString() + System.lineSeparator());
			if (printWriter.checkError())
				throw new IOException();
		}
	}

}
