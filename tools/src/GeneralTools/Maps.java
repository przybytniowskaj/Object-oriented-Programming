package GeneralTools;

import java.util.Collection;
import java.util.Map;

public class Maps {
	
public static <K, T, C  extends Collection<T>> boolean addToCollectionOnKey(Map<K, C> map, K key, T newElement, C newCollection) {
		
		if (!newCollection.isEmpty())
			throw new IllegalArgumentException();
		if (map.containsKey(key))
		{
			map.get(key).add(newElement);
			return true;
		}
		else {
			newCollection.add(newElement);
			map.put(key, newCollection);
			return false;
		}
	}

//	public static <K, T, C extends Collection<T>> boolean addToCollectionOnKey(Map<K, C> map, K key, T newElement, Class<C> clazz) {
//		
//		if (map.containsKey(key))
//		{
//			map.get(key).add(newElement);
//			return true;
//		}
//		else {
//			C newCollection;
//			try {
//				newCollection = clazz.getDeclaredConstructor().newInstance();
//			} catch (Exception e) {
//				e.printStackTrace();
//				throw new RuntimeException(e);
//			}
//			map.put(key, newCollection);
//			map.get(key).add(newElement);
//			return false;
//		}
//	}
//Class<ArrayList<Person>> c = (Class<ArrayList<Person>>)(Class<?>)(ArrayList.class);
	

}
