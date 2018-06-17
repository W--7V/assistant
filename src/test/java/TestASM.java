import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.MethodNode;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

import util.MyClassLoader;
import util.ResultMsg;

public class TestASM {

	public void createClassWiter(String className) {

		try {
			ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS);
			ClassReader cr = new ClassReader(className);
			// System.out.println(cr.getClassName());
			cr.accept(cw, 0);

			// Opcodes.ACC_PUBLIC+Opcodes.ACC_ABSTRACT+Opcodes.ACC_INTERFACE
			cw.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC, "util/ResultMsg", null,
					Type.getInternalName(Object.class), null);
			cw.visitField(Opcodes.ACC_PUBLIC, "addNAme", "Ljava/lang/String;",
					null, "add");
			// cr.accept(cw, 0);
			FileOutputStream fos = new FileOutputStream("D:/ResultMsg.class");
			fos.write(cw.toByteArray());
			fos.close();
			// MyClassLoader m = new MyClassLoader("D:/ResultMsg.class");
			// try {
			// Class clazz = m.loadClass("util.ResultMsg");
			// Object o = clazz.newInstance();
			// System.out.println(ResultMsg.class.getClassLoader().getClass());
			// System.out.println(clazz.getClassLoader().getClass());
			// } catch (ClassNotFoundException e) {
			// e.printStackTrace();
			// }
			// Object m = new ResultMsg();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		// TestASM t = new TestASM();
		// t.createClassWiter("util.ResultMsg");
		LocalVariableTableParameterNameDiscoverer nameDiscoverer = new LocalVariableTableParameterNameDiscoverer();
		nameDiscoverer.getParameterNames(TestASM.class.getDeclaredMethods()[0]);
		InputStream is = TestASM.class.getResourceAsStream("/"
				+ TestASM.class.getName().replace('.', '/') + ".class");
		try {
			ClassReader cr = new ClassReader(is);
			ClassNode cn = new ClassNode();
			cr.accept(cn, 0);

			List<MethodNode> methods = cn.methods;
			List<String> list = new ArrayList<String>();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
