package test;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;

public class TestJdbc {
	@Resource(name = "jdbcTemplate")
	protected JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		TestJdbc t = new TestJdbc();
		System.out.println(t.jdbcTemplate);
	}

}
