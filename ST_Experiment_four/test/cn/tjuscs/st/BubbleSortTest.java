package cn.tjuscs.st;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BubbleSortTest {
	BubbleSort s;

	@Before
	public void setUp() throws Exception {
		s = new BubbleSort();
	}

	@After
	public void tearDown() throws Exception {
		s = null;
	}

	@Test
	public void test(){
		int array[] = new int[]{1,6,2,2,5};
		int result[] = new int[]{1,2,2,5,6};
		assertArrayEquals(result,s.BubbleSort(array));
	}

}
