/*
 * 
 * Copyright (c) 2011 - HOZDO Logistics Co.,Ltd All Right Reserved.
 * 
 *
 * 
 * 
 *
 */

/**
 *  : <>
 * EAS : <7.0>
 *  : <HOZDoEAS7.0>
 *
 *  : <com.kingdee.eas.hozdo.common.excel>
 *  : <FileNameExtensionFilter.java>
 *  : 1.0
 * 
 *
 *  : < Email:<a href="mailto:Guanxiong Deng@hozdo.com">Guanxiong Deng@hozdo.com</a>>
 * : <2011-6-22 04:14:22>
 *
 *
 */
package edu.frank.base.data.excel;
import java.io.File;
import java.util.Locale;

import javax.swing.filechooser.FileFilter;

/**
 * An implementation of {@code FileFilter} that filters using a
 * specified set of extensions. The extension for a file is the
 * portion of the file name after the last ".". Files whose name does
 * not contain a "." have no file name extension. File name extension
 * comparisons are case insensitive.
 * <p>
 * The following example creates a
 * {@code FileNameExtensionFilter} that will show {@code jpg} files:
 * <pre>
 * FileFilter filter = new FileNameExtensionFilter("JPEG file", "jpg", "jpeg");
 * JFileChooser fileChooser = ...;
 * fileChooser.addChoosableFileFilter(filter);
 * </pre>
 *
 * @see FileFilter
 * @see javax.swing.JFileChooser#setFileFilter
 * @see javax.swing.JFileChooser#addChoosableFileFilter
 * @see javax.swing.JFileChooser#getFileFilter
 *
 * @version %I% %G%
 * @since 1.6
 */
public final class FileNameExtensionFilter extends FileFilter {
    // Description of this filter.
    private final String description;
    // Known extensions.
    private final String[] extensions;
    // Cached ext
    private final String[] lowerCaseExtensions;

    /**
     * Creates a {@code FileNameExtensionFilter} with the specified
     * description and file name extensions. The returned {@code
     * FileNameExtensionFilter} will accept all directories and any
     * file with a file name extension contained in {@code extensions}.
     *
     * @param description textual description for the filter, may be
     *                    {@code null}
     * @param extensions the accepted file name extensions
     * @throws IllegalArgumentException if extensions is {@code null}, empty,
     *         contains {@code null}, or contains an empty string
     * @see #accept
     */
    public FileNameExtensionFilter(String description, String... extensions) {
        if ((extensions == null) || (extensions.length == 0)) {
            throw new IllegalArgumentException(
                    "Extensions must be non-null and not empty");
        }
        this.description = description;
        this.extensions = new String[extensions.length];
        this.lowerCaseExtensions = new String[extensions.length];
        for (int i = 0; i < extensions.length; i++) {
            if ((extensions[i] == null) || (extensions[i].length() == 0)) {
                throw new IllegalArgumentException(
                    "Each extension must be non-null and not empty");
            }
            this.extensions[i] = extensions[i];
            this.lowerCaseExtensions[i] = extensions[i].toLowerCase(Locale.ENGLISH);
        }
    }

    /**
     * Tests the specified file, returning true if the file is
     * accepted, false otherwise. True is returned if the extension
     * matches one of the file name extensions of this {@code
     * FileFilter}, or the file is a directory.
     *
     * @param f the {@code File} to test
     * @return true if the file is to be accepted, false otherwise
     */
    @Override
	public boolean accept(File f) {
        if (f != null) {
            if (f.isDirectory()) {
                return true;
            }
            // NOTE: we tested implementations using Maps, binary search
            // on a sorted list and this implementation. All implementations
            // provided roughly the same speed, most likely because of
            // overhead associated with java.io.File. Therefor we've stuck
            // with the simple lightweight approach.
            String fileName = f.getName();
	    int i = fileName.lastIndexOf('.');
	    if ((i > 0) && (i < fileName.length() - 1)) {
                String desiredExtension = fileName.substring(i+1).
                        toLowerCase(Locale.ENGLISH);
                for (String extension : this.lowerCaseExtensions) {
                    if (desiredExtension.equals(extension)) {
                        return true;
                    }
                }
	    }
        }
        return false;
    }

    /**
     * The description of this filter. For example: "JPG and GIF Images."
     *
     * @return the description of this filter
     */
    @Override
	public String getDescription() {
        return this.description;
    }

    /**
     * Returns the set of file name extensions files are tested against.
     *
     * @return the set of file name extensions files are tested against
     */
    public String[] getExtensions() {
        String[] result = new String[this.extensions.length];
        System.arraycopy(this.extensions, 0, result, 0, this.extensions.length);
        return result;
    }

    /**
     * Returns a string representation of the {@code FileNameExtensionFilter}.
     * This method is intended to be used for debugging purposes,
     * and the content and format of the returned string may vary
     * between implementations.
     *
     * @return a string representation of this {@code FileNameExtensionFilter}
     */
    @Override
	public String toString() {
        return super.toString() + "[description=" + getDescription() +
            " extensions=" + java.util.Arrays.asList(getExtensions()) + "]";
    }
}