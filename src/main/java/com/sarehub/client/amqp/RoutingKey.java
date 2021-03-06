package com.sarehub.client.amqp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.StringJoiner;

/**
 * Routing key is string in format: part1[.partN]
 */
public class RoutingKey implements Iterable<String> {

	private List<String> parts;

	public RoutingKey() {
		parts = new ArrayList<String>();
	}

	public RoutingKey(List<String> parts) {
		this.parts = parts;

	}

	public RoutingKey(String[] parts) {
		this(new ArrayList<String>(Arrays.asList(parts)));
	}

	public RoutingKey(String raw) {
		this(raw.split("\\."));
	}

	/**
	 * @param part
	 */
	public RoutingKey addPart(String part) {
		parts.add(part);
		return this;
	}

	/**
	 * @param index
	 */
	public String getPart(int index) {
		return parts.get(index);
	}

	public String[] getParts() {
		return parts.toArray(new String[parts.size()]);
	}

	public boolean isEmpty() {
		return parts.isEmpty();
	}

	@Override
	public Iterator<String> iterator() {
		return parts.iterator();
	}

	@Override
	public String toString() {
		StringJoiner joiner = new StringJoiner(".");
		for (String part : parts) {
			joiner.add(part);
		}

		return joiner.toString();
	}

}
