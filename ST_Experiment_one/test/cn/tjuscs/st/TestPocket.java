package cn.tjuscs.st;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestPocket {

	pocket pocket = null;
	int input = 0;
	boolean flag = true;
	
	public TestPocket(int input, boolean flag) {
		// TODO Auto-generated constructor stub
		this.flag = flag;
		this.input = input;
	}
	
	@Before
	public void setUp() {
		// TODO Auto-generated constructor stub
		pocket = new pocket();
	}
	
	
	@Parameters
	public static Collection<Object[]> getData(){
		
		return Arrays.asList(new Object[][]{
			{0,true},
			{10,true},{20,true},{30,true},{23,true},{38,true},{58,true},{90,true},{93,true},
			{69,false},{79,false},{84,false},{89,false},{100,false},
			{-1,false}
			});
	}
	
	@Test
	public void test() {
		assertEquals(flag, pocket.take(input));
	} 
}