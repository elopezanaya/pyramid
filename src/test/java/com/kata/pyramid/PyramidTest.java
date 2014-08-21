package com.kata.pyramid;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class PyramidTest {

	Pyramid pyramid = new Pyramid();

	@Test
	public void testHappyPath() {

		String text = "abbccc";

		assertTrue(pyramid.isAPyramidWord(text));

	}
	
	
	@Test
	public void testStringUnsorted() {

		String text = "cabccb";

		assertTrue(pyramid.isAPyramidWord(text));

	}
	
	
	@Test
	public void testStringRandomLetters() {

		String text = "mmaaapzzzz";

		assertTrue(pyramid.isAPyramidWord(text));

	}

	private List<String> convertToList(String text) {

		List<String> result = new ArrayList<String>();

		for (Character character : text.toCharArray()) {

			result.add(String.valueOf(character));
		}

		return result;
	}

	@Test
	public void testSorting() {

		String text = "baccbc";

		assertEquals(convertToList("abbccc"),
				pyramid.convertTextToCollectionAndSort(text));

	}

	@Test
	public void testWalkAndcount() {


		List<Integer> expected = new ArrayList<Integer>();

		expected.add(1);
		expected.add(2);
		expected.add(3);

		assertEquals(expected, pyramid.walkAndCount(convertToList("abbccc")));

	}

	@Test
	public void validateGradeOFSeparationmongChars() {

		List<Integer> expected = new ArrayList<Integer>();

		expected.add(1);
		expected.add(2);
		expected.add(3);

		assertTrue(pyramid.containValidGradeOfSeparation(expected));

	}
	
	
	@Test
	public void testNegativeStringRandomLetters() {

		String text = "jkhkhkhyutwpo";

		assertFalse(pyramid.isAPyramidWord(text));

	}

	
	
	@Test
	public void testNegative() {

		String text = "abcdfer";

		assertFalse(pyramid.isAPyramidWord(text));

	}

}
