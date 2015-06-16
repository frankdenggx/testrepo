/*
 * 
 * Copyright (c) 2011 - HOZDO Logistics Co.,Ltd All Right Reserved.
 *  HOTEL1802 STUDIO 
 *
 * 
 * 
 *
 */

/**
 *  : <HOTEL1802 STUDIO>
 * JDK  : <1.6.10>
 *  : <JavaBasic>
 *
 *  : <edu.frank.base.data>
 *  : <CustomerCollection.java>
 *  : 1.0
 * <...>
 *
 *  : <Frank Deng Email:<a href="mailto:yoyudneghihi@gmail.com">Frank Deng</a>>
 *  : <2011-9-29 11:54:03>
 *  :
 * <>				<>					<>
 *
 */
package edu.frank.base.data;

import java.util.Iterator;


/**
 * <p>
 * 	<>
 * </p>
 *
 * @author &lt Frank Deng Email:<a href="mailto:yoyudneghihi@gmail.com?subject=Java Program Communication">Frank Deng</a> &gt
 * <p>
 *
 * 	Frank Deng <p>
 * <2011-9-29 11:54:03> <p>
 * <> <p>
 *
 * @Since JavaBasic 1.0.0.0
 * @Version JavaBasic 1.0.0.0
 */
public class CustomerCollection extends AbstractBaseCollection {
	AbstractBaseCollection collecton;
	int size = 0;
	Iterator<AbstractBaseInfo> iterator;
	/**
	 * <...>
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	private static final long serialVersionUID = 7185498690003191983L;

	public CustomerCollection() {
	}

	public CustomerCollection(AbstractBaseCollection collection) {
		this.collecton = collection;
	}

	/* (non-Javadoc)
	 * @see java.util.AbstractCollection#add(java.lang.Object)
	 */
	@Override
	public boolean add(AbstractBaseInfo e) {
		if (this.collecton == null) {
			this.collecton = new CustomerCollection();
		}
		this.size++;
		return this.collecton.add(e);
	}

	/* (non-Javadoc)
	 * @see java.util.AbstractCollection#iterator()
	 */
	@Override
	public Iterator<AbstractBaseInfo> iterator() {
		this.iterator = new CustomerIterator();
		return this.iterator;
	}

	/* (non-Javadoc)
	 * @see java.util.AbstractCollection#size()
	 */
	@Override
	public int size() {
		while (this.iterator.hasNext()) {
			this.size++;
		}
		return this.size;
	}
}