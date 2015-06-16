package edu.frank.office.excel;

import java.io.File;
import java.io.FileFilter;
import java.util.Locale;

public class BackupFileFilter implements FileFilter {

	private final String[] fileExt;

	public BackupFileFilter(String... extensions) {
		fileExt = new String[extensions.length];
		for (int i = 0; i < extensions.length; i++) {
			fileExt[i] = extensions[i].toLowerCase(Locale.ENGLISH);
		}
	}

	public boolean accept(File pathname) {
		if (pathname != null) {
			if (pathname.isDirectory()) {
				return false;
			}
			String fileName = pathname.getName();
			int i = fileName.lastIndexOf('.');
			if ((i > 0) && (i < fileName.length() - 1)) {
				String desiredExtension = fileName.substring(i + 1).toLowerCase(Locale.ENGLISH);
				for (String ext : fileExt) {
					if (desiredExtension.equals(ext)) {
						return true;
					}
				}
			}
		}
		return false;
	}

}
