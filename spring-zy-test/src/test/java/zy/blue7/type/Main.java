package zy.blue7.type;

/**
 * @author blue7
 * @create 2021/1/27 10:28
 */

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Type是Java 编程语言中所有类型的公共高级接口（官方解释），也就是Java中所有类型的“爹”；其中，“所有类型”的描述尤为值得关注。它并不是我们平常工作中经常使用的 int、String、List、Map等数据类型，而是从Java语言角度来说，对基本类型、引用类型向上的抽象；
 * <p>
 * Type体系中类型的包括：Class类型(原始类型，基本类型)、参数化类型(ParameterizedType)、数组类型(GenericArrayType)、类型变量(TypeVariable);
 * <p>
 * 原始类型，不仅仅包含我们平常所指的类，还包括枚举、数组、注解等；
 * <p>
 * 基本类型，也就是我们所说的java的基本类型，即int,float,double等
 * <p>
 * 参数化类型，就是我们平常所用到的泛型List<String>、Map<String,Integer>这种；
 * <p>
 * 类型变量，就是我们在定义泛型时使用到的T,U,K这些，例如Person<T extends Human>，这里的T就是类型变量
 * <p>
 * 数组类型，并不是我们工作中所使用的数组String[] 、byte[]，而是参数化类型或者类型变量的数据，即T[] ，或者List<String>[];
 */

/**
 * https://cloud.tencent.com/developer/article/1656249 博客地址
 */
public class Main extends OwnerTypeDemo<String> {

	/**
	 * Type体系的出现主要是为了解决泛型的一系列问题。
	 *
	 * 接口定义
	 * public interface Type {
	 *    // 返回这个类型的名称
	 *     default String getTypeName() {
	 *         return toString();
	 *     }
	 * }
	 * 可以看到Type接口内只定义了一个方法，这个方法会返回该类型的名称
	 *
	 */

	/**
	 * ParameterizedType
	 * 参数化类型，也就是我们所说的泛型。像List就是一个参数化类型，但是List并不是，因为没有使用泛型。
	 */

	/**
	 * public interface ParameterizedType extends Type {
	 * // 对于一个参数化类型而言，必定是带有泛型的，所有这里是为了获取到其中的泛型的具体类型，也就是<>中的内容
	 * // 返回一个数组是因为，有时候会定义多个泛型，比如Map<String,String>
	 * Type[] getActualTypeArguments();
	 * <p>
	 * // 获取原始类型，这里不带泛型，就是class
	 * Type getRawType();
	 * <p>
	 * // 获取这个类所在类的类型，这里可能比较拗口，举个例子，假如当前这个ParameterizedType的类型为
	 * // O<T>.I<U>，那么调用这个方法所返回的就是一个O<T>类型
	 * Type getOwnerType();
	 * }
	 */


	private List<String> stringList;

	private Map<String, String> stringStringMap;

	private Map.Entry<String, ?> entry;

	private OwnerTypeDemo<String>.Test<String> testOwnerType;

	private List list;

	private Map map;

	public void test(List<String> stringList, List list) {

	}

	public static void main(String[] args) {
		Class<Main> mainClass = Main.class;
		Field[] fields = mainClass.getDeclaredFields();
		for (Field field : fields) {
			/**
			 * 返回字段的类型 TYPE
			 */
			Type genericType = field.getGenericType();
			/**
			 * 调用type顶级接口的唯一方法，获取type类型
			 */
			String typeName = genericType.getTypeName();
			String name = field.getName();
			if (genericType instanceof ParameterizedType) {
				System.out.println(name + "是一个参数化类型,类型名称为：" + typeName);
				/**
				 * 强制转换成参数化类型
				 */
				ParameterizedType parameterizedType = (ParameterizedType) genericType;
				/**
				 * 获取参数化类型中的泛型的具体类型，也是一个type
				 */
				Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
				System.out.println(name + "的actualTypeArguments：" + Arrays.toString(actualTypeArguments));
				/**
				 * 获取这个类所在类的类型，这里可能比较拗口，举个例子，假如当前这个ParameterizedType的类型为 O<T>.I<U>，那么调用这个方法所返回的就是一个O<T>类型
				 */
				Type ownerType = parameterizedType.getOwnerType();
				System.out.println(name + "的ownerType：" + ownerType);

				/**
				 * 获取原始类型，这里不带泛型，就是class
				 */
				Type rawType = parameterizedType.getRawType();
				System.out.println(name + "的rawType：" + rawType);
			} else {
				System.out.println(name + "不是一个参数化类型,类型名称为：" + typeName);
			}
		}
		System.out.println("===================开始测试方法中的参数=========================");
		Method[] declaredMethods = mainClass.getDeclaredMethods();
		for (Method declaredMethod : declaredMethods) {
			String methodName = declaredMethod.getName();
			Type[] genericParameterTypes = declaredMethod.getGenericParameterTypes();
			for (int i = 0; i < genericParameterTypes.length; i++) {
				Type parameterType = genericParameterTypes[i];
				String typeName = parameterType.getTypeName();
				System.out.println("打印" + methodName + "方法的参数，" + "第" + (i + 1) + "个参数为：" + parameterType);
				if (parameterType instanceof ParameterizedType) {
					System.out.println("第" + (i + 1) + "个参数是一个参数化类型, 类型名称为 ： " + typeName);
				} else {
					System.out.println("第" + (i + 1) + "个参数不是一个参数化类型, 类型名称为 ： " + typeName);
				}
			}
		}
		System.out.println("===================开始测试父类中的泛型=========================");
		// 获取带有泛型的父类
		Type genericSuperclass = mainClass.getGenericSuperclass();
		if (genericSuperclass instanceof ParameterizedType) {
			System.out.println("父类是一个参数化类型，类型名称为：" + genericSuperclass.getTypeName());
		}

	}
}

class OwnerTypeDemo<T> {
	class Test<T> {

	}
}