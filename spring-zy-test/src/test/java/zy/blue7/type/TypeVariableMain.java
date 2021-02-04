package zy.blue7.type;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author blue7
 * @create 2021/1/27 10:51
 */
public class TypeVariableMain<T, K extends @TypeAnnotation Integer & Type> {

	/**
	 * TypeVariable
	 * 简介
	 *
	 * 类型变量，或者也可以叫泛型变量。具体就是指我们在申明泛型时定义的T,K,U这种变量。在之前的例子中，SpecialDemo<T extends Type>，T就是一个类型变量。
	 */

	/**
	 * 接口定义
	 * public interface TypeVariable<D extends GenericDeclaration> extends Type, AnnotatedElement {
	 *     // 获取泛型的边界
	 *     Type[] getBounds();
	 *  // 获取申明所在的具体对象
	 *     D getGenericDeclaration();
	 *  // 获取具体类型变量的名称
	 *     String getName();
	 *  // 获取类型变量边界上添加的注解
	 *     AnnotatedType[] getAnnotatedBounds();
	 * }
	 */

	/**
	 * 可以看到，TypeVariable本身也使用了泛型，并且泛型的上界为GenericDeclaration。
	 * 在了解TypeVariable之前，有必要先对GenericDeclaration做一个简单的说明。
	 * GenericDeclaration这个接口主要限定了哪些地方可以定义TypeVariable，换言之，
	 * 也就是定义了哪些地方可以申明泛型。这个接口只有3个实现类（忽略Executable抽象类）。如下:
	 * Method,Class,Constructor
	 *
	 */


	/**
	 * 从这里我们也能看到，我们只能在方法（包括普通方法跟构造方法）以及类上申明泛型。
	 *
	 * 这里需要对接口定义的方法做进一步的说明：
	 *
	 *     getBounds()会返回泛型的边界，但是这里的边界跟我们在参数化类型中定义的边界不同，这里的边界只有上界。即我们不通通过super关键字来申明一个泛型，例如下面这种：
	 *
	 * class A<T super classA>{}
	 *
	 * 在申明泛型时，我们要明确一点，申明是为了使用，而在上面的例子中，我们不能使用T来干任何事情，因为我们不能确定T中的任何方法（只能确定它是一个Object，但是这没有任何意义）。所以对于泛型变量来说，只存在上界，也就是只能使用extends关键字进行申明
	 *
	 *     getGenericDeclaration()，返回泛型申明时所在的类或者方法
	 *     返回泛型变量的名称，也就是我们定义泛型时采用的T,K,U这一类的名称
	 *     getAnnotatedBounds()，此方法返回一个AnnotatedType类型的数组，获取的是我们在类型变量的上界。不同于getBounds()方法的是，这个方法可以获取到边界上添加的注解
	 */


	public <U extends Long, V> void testTypeVariable(Map<U, V> map) {

	}

	public static void main(String[] args) {
		Class<TypeVariableMain> typeVariableMainClass = TypeVariableMain.class;
		TypeVariable<Class<TypeVariableMain>>[] typeParameters = typeVariableMainClass.getTypeParameters();
		for (int i = 0; i < typeParameters.length; i++) {
			TypeVariable<Class<TypeVariableMain>> typeParameter = typeParameters[i];
			Type[] bounds = typeParameter.getBounds();
			String name = typeParameter.getName();
			AnnotatedType[] annotatedBounds = typeParameter.getAnnotatedBounds();
			Class<TypeVariableMain> genericDeclaration = typeParameter.getGenericDeclaration();
			System.out.println("第" + (i + 1) + "个类型变量的名称为：" + name);
			System.out.println("通过getBounds方法获取到，第" + (i + 1) + "个类型变量的边界为：" + Arrays.toString(bounds));
			System.out.println("第" + (i + 1) + "个类型变量的申明的位置为：" + genericDeclaration);
			System.out.println("通过getAnnotatedBounds方法获取到，第" + (i + 1) + "个类型变量的边界为："
					+ Arrays.stream(annotatedBounds).map(AnnotatedType::getType).collect(Collectors.toList()));
			for (AnnotatedType annotatedType : annotatedBounds) {
				Annotation[] annotations = annotatedType.getAnnotations();
				if (annotations.length > 0) {
					System.out.println("第" + (i + 1) + "个类型变量的上界上添加了注解，注解为" + annotations[0]);
				}
			}
		}
		System.out.println("===================基于方法获取类型变量====================");
		Method[] declaredMethods = typeVariableMainClass.getDeclaredMethods();
		for (Method declaredMethod : declaredMethods) {
			String methodName = declaredMethod.getName();
			if (methodName.equals("main")) {
				// 为了方便，直接排除main函数了
				continue;
			}
			TypeVariable<Method>[] typeVariables = declaredMethod.getTypeParameters();
			int i = 1;
			for (TypeVariable<Method> typeVariable : typeVariables) {
				System.out.println("方法：\"" + methodName + "\"的第" + (i++) + "个类型变量为" + typeVariable.getName());
			}
		}
	}
}