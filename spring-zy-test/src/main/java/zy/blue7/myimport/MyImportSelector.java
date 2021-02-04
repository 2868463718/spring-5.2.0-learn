package zy.blue7.myimport;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author blue7
 * @create 2021/2/3 9:06
 * 要使用@import注解引入
 */
public class MyImportSelector implements ImportSelector {
	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {

		/**
		 * 这个注解元数据，是标有@Import注解并且该注解中引入本类 的类上面的注解的元数据信息，在这里是AppConfig类上的注解元数据信息
		 */
		AnnotationMetadata metadata=importingClassMetadata;
		System.out.println(metadata.getAnnotationTypes());
		/**
		 * 传入需要导入spring容器的类的全类名，这样的操作类似于@commpent注解，也会被加载到容器
		 */
		return new String[]{"zy.blue7.lookupandreplace.Fruit","zy.blue7.lookupandreplace.Apple"};
	}
}
