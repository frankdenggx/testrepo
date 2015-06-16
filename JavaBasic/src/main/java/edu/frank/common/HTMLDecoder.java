package edu.frank.common;

import org.apache.commons.lang.StringUtils;

public class HTMLDecoder
{
	public static String decode(String str)
	{
		if (str == null) {
			return null;
		}
		if (StringUtils.isBlank(str)) {
			return "";
		}
		//��ȡ�ַ�����������
		String[] tmp = str.split(";&#|&#|;");
		StringBuffer sb = new StringBuffer("");
		//����ÿ��tmp������ÿ���ַ�Ԫ��
		for (int i = 0; i < tmp.length ; i ++ )
		{
			//����Ԫ����5λ���֣�����ת���ɷ���ŷ�ַ�
			if (tmp[i].matches("\\d{5}") )
			{
				sb.append((char)Integer.parseInt(tmp[i]));
			}
			//������ͨ�ַ�
			else
			{
				sb.append(tmp[i]);
			}
		}
		return sb.toString();
	}
}
