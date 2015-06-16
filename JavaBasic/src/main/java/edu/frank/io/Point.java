/**
 *
 */
package edu.frank.io;

/**
 * @author yoyudenghihi
 *
 */
public class Point {

	private final int nPointX;
	private final int nPointY;

	/**
	 *
	 */
	public Point(int m_nPointX, int m_nPointY) {

		nPointX = m_nPointX;
		nPointY = m_nPointY;
	}


	/**
	 * @return the nPointX
	 */
	public int getnPointX() {

		return nPointX;
	}


	/**
	 * @return the nPointY
	 */
	public int getnPointY() {

		return nPointY;
	}

	@Override
	public boolean equals(Object m_objectPoint){
		boolean result = false;
		if (m_objectPoint instanceof Point){
			Point m_classPoint  = (Point) m_objectPoint;
			result = (m_classPoint.canEqual(this) && getnPointX() ==
				m_classPoint.getnPointX() && getnPointY() ==
					m_classPoint.getnPointY());
		}
		return result;
	}

	@Override
	public int hashCode(){
		System.out.println(getnPointX());
		System.out.println(getnPointY());
		return (41 * (41 * getnPointX()) + getnPointY());
	}

	public boolean canEqual(Object m_objectPoint){
		return (m_objectPoint instanceof Point);
	}


}
