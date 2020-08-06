package com.file.reader;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(PrintWordOccurance.class)
//@PrepareForTest(fullyQualifiedNames = "com.baeldung.powermockito.introduction.*")
//@PrepareForTest({PrintWordOccurance.class})
public class PrintWordOccuranceTest {
	  
	
  @Before
  public void setUp() {
	  PowerMockito.mockStatic(PrintWordOccurance.class);
  }

  @Test
  public void testFileInList() {
	  String fileName = "d:/test.txt";
	  List<String> list = new ArrayList<>();
	  PowerMockito.when(PrintWordOccurance.readFileInList(fileName)).thenReturn(list);
	  assertEquals("Testing the testFileInList method",list,PrintWordOccurance.readFileInList(fileName));
  }
  
  @Test(expected = NoSuchFileException.class)
  public void testFileExceptionCase() throws IOException {
	  String fileName = "d:/test1.txt";
	  Files.readAllLines(Paths.get(fileName));
  }
  
  //Mocking Constructors and Final Methods
  @Test
  public void testFinalOrConstructor() throws Exception {
	  PrintWordOccurance mock = PowerMockito.mock(PrintWordOccurance.class);
	  PowerMockito.whenNew(PrintWordOccurance.class).withNoArguments().thenReturn(mock);
	  PrintWordOccurance collaborator = new PrintWordOccurance();
	  PowerMockito.verifyNew(PrintWordOccurance.class).withNoArguments();
	  PowerMockito.when(collaborator.helloMethod()).thenReturn("Hello");
	  String welcome = collaborator.helloMethod();
	  Mockito.verify(collaborator).helloMethod();
	  assertEquals("Hello", welcome);

  }
  
  //Mocking Static Methods
  @Test
  public void testStaticMethods() {
	  
	when(PrintWordOccurance.firstMethod(Mockito.anyString())).thenReturn("firstMethod");
	when(PrintWordOccurance.secondMethod()).thenReturn("secondMethod");
	String firstWelcome = PrintWordOccurance.firstMethod("Whoever");
	
	assertEquals("firstMethod", firstWelcome);
  }
  
  @Test(expected = RuntimeException.class)
  public void testThirdMethod() {
	  doThrow(new RuntimeException()).when(PrintWordOccurance.class);
	  PrintWordOccurance.thirdMethod();
  }
  
}
