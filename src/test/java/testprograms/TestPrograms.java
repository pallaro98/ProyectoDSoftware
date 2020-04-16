package testprograms;

import static org.junit.Assert.assertEquals;

import org.junit.*;

import programs.Program;

	public class TestPrograms {
	Program p;
	
	@Before
	public void setUp() {
		p = new Program();
	}
	
	@Test
	public void testName() {
		p.setName("Prueba");
		assertEquals("Prueba", p.getName());
	}
	
	@Test
	public void testDuration() {
		p.setDuration(2.0);
		assertEquals(2.0, p.getDuration(), 0.1);
	}
	
	@Test
	public void testTiempoVisto() {
		p.setTiempoVisto(1.1);
		assertEquals(1.1, p.getTiempoVisto(), 0.1);
	}
	
	@Test
	public void testCategorybasic() {
		p.setCategorybasic("Adecuado");
		assertEquals("Adecuado", p.getCategorybasic());
	}
	
	@Test
	public void testCategorymedium() {
		p.setCategorymedium("Cultura");
		assertEquals("Cultura", p.getCategorymedium());
	}
	
	@Test
	public void testCategoryadvanced() {
		p.setCategoryadvanced("Drama");
		assertEquals("Drama", p.getCategoryadvanced());
	}
	
	
}
