package com.example.atividades.atividade09;

public class Item {
	private String name;

	public Item(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name == null || name.isEmpty()) {
			throw new IllegalArgumentException("Name cannot be null or empty");
		}
		this.name = name;
	}
}
