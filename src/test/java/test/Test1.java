package test;

import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jt.sys.mapper.SysMenuMapper;

public class Test1 {
	private AbstractApplicationContext ac = null;
	@Before
	public void init() {
		ac = new ClassPathXmlApplicationContext("spring-mvc.xml");
	}
	@Test
	public void test1() {
		SysMenuMapper sys = ac.getBean("sysMenuMapper",SysMenuMapper.class);
		List<Map<String,Object>> list = sys.findObjects();
		for(Map<String,Object> map:list) {
			System.out.println(map);
		}
	}
	@After
	public void destory() {
		ac.close();
	}
}
