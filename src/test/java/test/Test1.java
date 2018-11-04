package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jt.sys.entity.SysMenu;
import com.jt.sys.service.SysMenuService;

public class Test1 {
	private AbstractApplicationContext ac = null;
	@Before
	public void init() {
		ac = new ClassPathXmlApplicationContext("spring-mvc.xml");
	}
	@Test
	public void test1() {
		SysMenuService service  = ac.getBean("sysMenuService",SysMenuService.class);
		SysMenu s = new SysMenu();
		s.setName("删除");
		s = service.saveObject(s);
		System.out.println(s);
	}
	@After
	public void destory() {
		ac.close();
	}
}
