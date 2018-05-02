package util;

import java.io.FileInputStream;

public class MyClassLoader extends ClassLoader {
	private String classPath;
	
	public MyClassLoader(){}
	
	public MyClassLoader(String classPath){
		this.classPath = classPath;
	}
	
	public byte[] loadByte() throws Exception{
//		classPath = classPath.replaceAll("\\.", "/");
        FileInputStream fis = new FileInputStream(this.classPath);
        int len = fis.available();
        byte[] data = new byte[len];
        fis.read(data);
        fis.close();
        return data;
	}

	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		try {
			byte[] b = loadByte();
			return super.defineClass(name, b, 0, b.length);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ClassNotFoundException();
		}
	}

}