package cn.jhc.reflection;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value=Parameterized.class)
public class GenericReflectionTest {
	
	private String cname;
	
	@Parameters
	public static Collection<String[]> getParameters(){
		return Arrays.asList(new String[][] {
				{"cn.jhc.reflection.GenericReflectionTest"},
				{"java.util.ArrayList"}
		});
	}

	@Test
	public void testPrintClass(){
		//print generic info for class and public methods
		try {
			Class cl = Class.forName(cname);
			GenericReflection.printClass(cl);
			for(Method m : cl.getDeclaredMethods()) {
				GenericReflection.printMethod(m);
			}
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public GenericReflectionTest(String cname) {
		this.cname = cname;
	}

}
