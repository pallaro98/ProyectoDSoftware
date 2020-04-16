package testlevel;

import org.junit.*;

import static org.mockito.Mockito.*;

import level.FactoryLevel;

public class TestFactoryLevel {
	FactoryLevel fl;
	FactoryLevel mockFactory;


	@Before
	public void setUp() {
	      fl = new FactoryLevel();	      
	      mockFactory = mock(FactoryLevel.class);
	}
	
	@Test
	public void testGetLevelBasic() {
             
        when(mockFactory.getLevel(anyString())).thenCallRealMethod();
        mockFactory.getLevel("Basic");
        verify(mockFactory).getLevel("Basic");
	}
	
	@Test
	public void testGetLevelMedium() {
             
        when(mockFactory.getLevel(anyString())).thenCallRealMethod();
        mockFactory.getLevel("Medium");
        verify(mockFactory).getLevel("Medium");
	}
	
	@Test
	public void testGetLevelAdvanced() {
             
        when(mockFactory.getLevel(anyString())).thenCallRealMethod();
        mockFactory.getLevel("Advanced");
        verify(mockFactory).getLevel("Advanced");
	}
	
	@Test
	public void testGetLevelFail() {
             
        when(mockFactory.getLevel(anyString())).thenCallRealMethod();
        mockFactory.getLevel("abc");
        verify(mockFactory).getLevel("abc");
	}
}
