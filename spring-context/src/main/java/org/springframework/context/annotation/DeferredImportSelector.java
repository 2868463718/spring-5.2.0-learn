/*
 * Copyright 2002-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.context.annotation;

import java.util.Objects;

import org.springframework.core.type.AnnotationMetadata;
import org.springframework.lang.Nullable;

/**
 * A variation of {@link ImportSelector} that runs after all {@code @Configuration} beans
 * have been processed. This type of selector can be particularly useful when the selected
 * imports are {@code @Conditional}.
 *
 * <p>Implementations can also extend the {@link org.springframework.core.Ordered}
 * interface or use the {@link org.springframework.core.annotation.Order} annotation to
 * indicate a precedence against other {@link DeferredImportSelector DeferredImportSelectors}.
 *
 * <p>Implementations may also provide an {@link #getImportGroup() import group} which
 * can provide additional sorting and filtering logic across different selectors.
 *
 * @author Phillip Webb
 * @author Stephane Nicoll
 * @since 4.0
 */
public interface DeferredImportSelector extends ImportSelector {

	/**
	 * Return a specific import group.
	 * <p>The default implementations return {@code null} for no grouping required.
	 * @return the import group class, or {@code null} if none
	 * @since 5.0
	 */
	@Nullable
	default Class<? extends Group> getImportGroup() {
		return null;
	}


	/**
	 * 用于对来自不同导入选择器的结果进行分组的界面
	 * Interface used to group results from different import selectors.
	 */
	interface Group {

		/**
		 * Process the {@link AnnotationMetadata} of the importing @{@link Configuration}
		 * class using the specified {@link DeferredImportSelector}.
		 * 上面分组完成后spring会调用该方法，循环List里的DeferredImportSelector 类，并循环调用process方法
		 * AnnotationMetadata :当前循环的DeferredImportSelector 的导入配置类（当前@Import注解的类）
		 *
		 *
		 * 具体执行是在process方法里，在他之前的代码中已经将@componentScans、@propertySource、@Bean等注解解析完了, 包括@Import实现ImportBeanDefinitionRegistrar和ImportSelector接口的类
		 */
		void process(AnnotationMetadata metadata, DeferredImportSelector selector);

		/**
		 * Return the {@link Entry entries} of which class(es) should be imported
		 * for this group.
		 * 每个Group只执行一次，返回一个迭代器，spring会使用迭代器的forEach方法进行迭代，
		 * 想要导入spting容器的类要封装成Entry对象，且返回的对象不能为null，会报错（设计问题）
		 */
		Iterable<Entry> selectImports();


		/**
		 * An entry that holds the {@link AnnotationMetadata} of the importing
		 * {@link Configuration} class and the class name to import.
		 */
		class Entry {

			private final AnnotationMetadata metadata;

			private final String importClassName;

			/**
			 * AnnotationMetadata :必须是一个将DeferredImportSelector 导入的配置类，要不会报错，而且不能new
			 * importClassName：需要导入类的类路径名
			 * @param metadata
			 * @param importClassName
			 */
			public Entry(AnnotationMetadata metadata, String importClassName) {
				this.metadata = metadata;
				this.importClassName = importClassName;
			}

			/**
			 * Return the {@link AnnotationMetadata} of the importing
			 * {@link Configuration} class.
			 */
			public AnnotationMetadata getMetadata() {
				return this.metadata;
			}

			/**
			 * Return the fully qualified name of the class to import.
			 */
			public String getImportClassName() {
				return this.importClassName;
			}

			@Override
			public boolean equals(@Nullable Object other) {
				if (this == other) {
					return true;
				}
				if (other == null || getClass() != other.getClass()) {
					return false;
				}
				Entry entry = (Entry) other;
				return (Objects.equals(this.metadata, entry.metadata) &&
						Objects.equals(this.importClassName, entry.importClassName));
			}

			@Override
			public int hashCode() {
				return Objects.hash(this.metadata, this.importClassName);
			}
		}
	}

}
