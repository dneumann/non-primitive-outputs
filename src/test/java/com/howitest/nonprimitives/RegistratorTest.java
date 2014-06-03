package com.howitest.nonprimitives;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

public class RegistratorTest {

	private DatabaseWriter writerMock;
	private Registrator registratorSut;
	
	@Before
	public void beforeEachTest() {
		writerMock = mock(DatabaseWriter.class);
		registratorSut = new Registrator();
		registratorSut.setDatabaseWriter(writerMock);
	}
	
	@Test
	public void shouldSaveProperParameters() {
		ArgumentCaptor<Parameters> captor 
				= ArgumentCaptor.forClass(Parameters.class);
		registratorSut.registerRootUser("safepassword");
		
		verify(writerMock).writeUserInfo(captor.capture());
		Parameters capturedParams = captor.getValue();
		
		assertEquals("root", capturedParams.username);
		assertEquals("safepassword", capturedParams.password);
	}

}
