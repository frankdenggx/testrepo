package edu.frank.base;

import java.util.ListResourceBundle;

public class MesgResource_zh_CN extends ListResourceBundle {
	private final Object myData[][] = {
			{"msg", "你妹的！{0}，\u767b\u5f55\u65f6\u95f4{1}"}	
	};
	@Override
	protected Object[][] getContents() {
		return myData;
	}

}
