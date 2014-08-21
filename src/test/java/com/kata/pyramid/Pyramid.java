package com.kata.pyramid;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

public class Pyramid {

	Logger logger = Logger.getLogger(getClass());

	public boolean isAPyramidWord(final String text) {

		if (StringUtils.isNotEmpty(text)) {

			List<String> elements;
			List<Integer> incidences;

			elements = convertTextToCollectionAndSort(text);

			incidences = walkAndCount(elements);

			return containValidGradeOfSeparation(incidences);
		}

		return false;
	}

	public List<String> convertTextToCollectionAndSort(final String text) {

		List<String> sortingText = new ArrayList<String>();

		for (char character : text.toCharArray()) {

			sortingText.add(String.valueOf(character));
		}

		Collections.sort(sortingText);

		return sortingText;
	}

	public List<Integer> walkAndCount(final List<String> convertToList) {

		String actual = null;

		int count = 0;
		int limitOfArray = convertToList.size() - 1;
		List<Integer> results = new ArrayList<Integer>();

		String item;
		for (int index = 0; index < convertToList.size(); index++) {

			item = convertToList.get(index);

			if (StringUtils.isEmpty(actual)) {

				actual = item;
			}

			if (actual.equals(item)) {

				count++;

				
				if (index == limitOfArray) {
					results.add(count);

				}
			} else {

				results.add(count);
				actual = item;
				count = 1;

			}

		}

		return results;
	}

	public boolean containValidGradeOfSeparation(List<Integer> elements) {

		Collections.sort(elements);

		int elementOne = 0;
		int elementTwo = 0;
		int limitOfArray = elements.size() - 1;

		for (int index = 0; index < elements.size(); index++) {

			if ((index < limitOfArray)) {

				elementOne = elements.get(index);
				elementTwo = elements.get(index + 1);

				if (elementTwo - elementOne != 1)
					return false;

			}

		}

		return true;
	}

}
