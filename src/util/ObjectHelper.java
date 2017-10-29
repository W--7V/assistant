package util;

import java.util.Collection;
import java.util.Map;

public class ObjectHelper {
	@SuppressWarnings("rawtypes")
	public static boolean isEmpty(Object obj) {
		if (obj == null) {
			return true;
		}
		if ((obj instanceof Map)) {
			return ((Map) obj).entrySet().isEmpty();
		}
		
		if ((obj instanceof Collection)) {
			return ((Collection) obj).isEmpty();
		}
		
		if ((obj instanceof String)) {
			return ((String) obj).equalsIgnoreCase("null") | ((String) obj).trim().isEmpty();
		}
		
		if ((obj instanceof StringBuffer)) {
			return ((StringBuffer) obj).length() == 0;
		}
		
		if (obj.getClass().isArray()) {
			try {
				Object[] a = (Object[]) obj;
				
				boolean b = true;
				for (Object o : a) {
					b &= isEmpty(o);
					if (!b) {
						break;
					}
				}
				return b;
			} catch (ClassCastException e) {
			}
		}
		return false;
	}
	
	public static boolean isNotEmpty(Object obj){
		return !isEmpty(obj);
	}
}
