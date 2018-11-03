package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jt.sys.mapper.SysConfigMapper;

public class Test1 {
	private AbstractApplicationContext ac = null;
	@Before
	public void init() {
		ac = new ClassPathXmlApplicationContext("spring-mvc.xml");
	}
	@Test
	public void test1() {
		SysConfigMapper mapper = ac.getBean("sysConfigMapper",SysConfigMapper.class);
		Integer rows = mapper.deleteObjects();
		System.out.println("rows:"+rows);
		System.out.println("删除成功！");
	}
	@After
	public void destory() {
		ac.close();
	}
}
