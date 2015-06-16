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
 *  : <AbstractBaseInfo.java>
 *  : 1.0
 * <>
 *
 *  : <Frank Deng Email:<a href="mailto:yoyudneghihi@gmail.com">Frank Deng</a>>
 *  : <2011-9-26 11:51:06>
 *  :
 * <>				<>					<>
 * Frank Deng			2011-09-26					
 *
 */
package edu.frank.base.data;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

/**
 * <p>
 * 	<>
 * </p>
 *
 * @author &lt Frank Deng Email:<a href="mailto:yoyudneghihi@gmail.com?subject=Java Program Communication">Frank Deng</a> &gt
 * <p>
 *
 * 	Frank Deng <p>
 * <2011-9-26 11:51:06> <p>
 * <> <p>
 *
 * @Since JavaBasic 1.0.0.0
 * @Version JavaBasic 1.0.0.0
 */
public abstract class AbstractBaseInfo implements Serializable,
		Comparable<AbstractBaseInfo> {

	/**
	 * <ID>
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	private static final long serialVersionUID = -7428293650166407511L;

	/**
	 * <SEQ>
	 *
	 * @Since JavaBasic 1.0.0.0
	 */
	private int seq;

	/**
	 * <FID>
	 *
	 * @Since JavaBasic 1.0.0.0
	 */
	private String fid;

	/**
	 * <>
	 *
	 * @Since JavaBasic 1.0.0.0
	 */
	private int no;

	/**
	 * <>
	 *
	 * @Since JavaBasic 1.0.0.0
	 */
	private String name;

	/**
	 * <>
	 *
	 * @Since JavaBasic 1.0.0.0
	 */
	private Date createTime;

	/**
	 * <>
	 *
	 * @Since JavaBasic 1.0.0.0
	 */
	private String description;

	/**
	 *
	 * <  <code>AbstractBaseInfo</code> >
	 *
	 * @author &lt Frank Deng Email:<a href="mailto:yoyudneghihi@gmail.com?subject=Java Program Communication">Frank Deng</a> &gt
	 * <p>
	 *
	 * Frank Deng	<p>
	 * <2011-9-26 11:51:07> 		<p>
	 * <> 			<p>
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	public AbstractBaseInfo(int seq, String fid, int no, String name,
			Date createTime, String description) {
		this.seq = seq;
		this.fid = fid;
		this.no = no;
		this.name = name;
		this.createTime = createTime;
		this.description = description;
	}

	/**
	 * @return the seq
	 */
	public int getSeq() {
		return this.seq;
	}

	/**
	 * @return the fid
	 */
	public String getFid() {
		return this.fid;
	}

	/**
	 * @return the no
	 */
	public int getNo() {
		return this.no;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * @return the createTime
	 */
	public Date getCreateTime() {
		return this.createTime;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return this.description;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == null || ! (obj instanceof AbstractBaseInfo )) {
			return false;
		}
		AbstractBaseInfo baseInfo = (AbstractBaseInfo) obj;
		String fid = baseInfo.getFid();
		int no = baseInfo.getNo();
		String name = baseInfo.getName();
		if (no == getNo()) {
			if (!StringUtils.isBlank(name)
					&& !StringUtils.isBlank(getName())
					&& !StringUtils.isBlank(fid)
					&& !StringUtils.isBlank(getFid())) {
				return name.equalsIgnoreCase(getName()) && fid.equalsIgnoreCase(getFid());
			}
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		if (!StringUtils.isBlank(getName())
				&& !StringUtils.isBlank(getFid())
				&& getCreateTime() != null) {
			return getSeq() + getFid().hashCode() + getNo()
					+ getName().hashCode()
					+ getCreateTime().hashCode();
		}
		if (!StringUtils.isBlank(getFid())) {
			return getSeq() + getNo() * 39 + getFid().hashCode();
		}
		return getSeq() + getNo();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(AbstractBaseInfo o) {
		AbstractBaseInfo baseInfo = (AbstractBaseInfo) o;
		String name = baseInfo.getName();
		if (!StringUtils.isBlank(name)
				&& !StringUtils.isBlank(getName())) {
			return name.compareTo(getName());
		}
		return 0;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.getClass().getName() + "=[FID=" + this.fid + ", number=" + this.no
				+ ", name=" + this.name + ", createTime=" + this.createTime + "]";
	}

}