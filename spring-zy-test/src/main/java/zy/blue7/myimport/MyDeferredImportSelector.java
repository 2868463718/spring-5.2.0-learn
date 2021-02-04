package zy.blue7.myimport;

import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author blue7
 * @create 2021/2/3 9:38
 */
public class MyDeferredImportSelector implements DeferredImportSelector {

	/**
	 * 在这个DeferredImportSelector延迟接口的实现类中  ---> 这个方法 并不会被调用，
	 * @param importingClassMetadata
	 * @return
	 */
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
		return new String[]{"zy.blue7.lookupandreplace.Fruit"};
	}


	//todo  要实现添加类，需要在group中添加
	/**
	 * 要使用DeferredImportSelector 就要实现下面的getImportGroup方法，并要写一个实现Group接口的 类，该方法返回一个Class，
	 * 表示当前DeferredImportSelector 属于哪个组的，spring会生成唯一的Group，并将返回值为该Group的DeferredImportSelector 放入一个List里
	 *
	 * 通过调用MyGroup 类中 public Iterable<Entry> selectImports() 方法导入需要导入的类
	 *
	 * @return
	 */
	@Override
	public Class<? extends Group> getImportGroup() {
		return MyGroup.class;
	}
}
