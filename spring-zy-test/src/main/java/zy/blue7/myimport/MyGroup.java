package zy.blue7.myimport;

import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.ArrayList;
import java.util.List;

/**
 * @author blue7
 * @create 2021/2/3 10:08
 */
public class MyGroup implements DeferredImportSelector.Group {

	private  AnnotationMetadata metadata;

	@Override
	public void process(AnnotationMetadata metadata, DeferredImportSelector selector) {
		this.metadata=metadata;
	}

	@Override
	public Iterable<Entry> selectImports() {
		Entry entry = new Entry(metadata, "zy.blue7.lookupandreplace.Apple");
		Entry entry2 = new Entry(metadata, "zy.blue7.lookupandreplace.Fruit");
		List<Entry> entries=new ArrayList<>();
		entries.add(entry);
		entries.add(entry2);
		return entries;
	}
}
