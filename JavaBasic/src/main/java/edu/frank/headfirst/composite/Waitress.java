package edu.frank.headfirst.composite;

public class Waitress {
	public static void main(String[] args) {
		Component editMenu = new SubComponent("Edit", "edit operation");
		Component fileMenu = new SubComponent("File", "file operation");
		Component allMenu = new SubComponent("All", "all operation");
		
		allMenu.add(editMenu);
		allMenu.add(fileMenu);
		
		editMenu.add(new Item("Copy", "copy conent"));
		editMenu.add(new Item("Paste", "paste conent"));
		
		fileMenu.add(new Item("Save", "save file" ));
		fileMenu.add(new Item("Save As", "save as another file"));
		
		allMenu.print();
	}
}
