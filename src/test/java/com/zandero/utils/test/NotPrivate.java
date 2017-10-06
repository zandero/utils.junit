package com.zandero.utils.test;

public final class NotPrivate {

	public NotPrivate(String value, int count) {

		a = value;
		b = count;
	}

	public String a;

	public int b;

	private int hidden;

	public int getHidden() {
		return hidden;
	}

	protected int notShown;

	public Long someValue;
}

