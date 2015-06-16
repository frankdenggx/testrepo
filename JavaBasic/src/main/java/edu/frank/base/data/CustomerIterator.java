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
 *  : <CustomerIterator.java>
 *  : 1.0
 * <...>
 *
 *  : <Frank Deng Email:<a href="mailto:yoyudneghihi@gmail.com">Frank Deng</a>>
 *  : <2011-9-30 12:13:13>
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
 * <2011-9-30 12:13:13> <p>
 * <> <p>
 *
 * @Since JavaBasic 1.0.0.0
 * @Version JavaBasic 1.0.0.0
 */
public class CustomerIterator implements Iterator<AbstractBaseInfo> {

	CustomerInfo[] customerInfoArray;
	int position = 0;

	/* (non-Javadoc)
	 * @see java.util.Iterator#hasNext()
	 */
	@Override
	public boolean hasNext() {
		if (this.position >= this.customerInfoArray.length || this.customerInfoArray[this.position] == null) {
			return false;
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see java.util.Iterator#next()
	 */
	@Override
	public CustomerInfo next() {
		CustomerInfo customerInfo = this.customerInfoArray[this.position];
		this.position += 1;
		return customerInfo;
	}

	/* (non-Javadoc)
	 * @see java.util.Iterator#remove()
	 */
	@Override
	public void remove() {
		if (this.position <= 0) {
			throw new IllegalStateException("You can't remove an item utill you've done at least on next()");
		}
		if (this.customerInfoArray[this.position - 1] != null) {
			for (int i = this.position - 1; i < (this.customerInfoArray.length - 1); i++) {
				this.customerInfoArray[i] = this.customerInfoArray[i + 1];
			}
			this.customerInfoArray[this.customerInfoArray.length - 1] = null;
		}
	}

}