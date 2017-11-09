package com.vison.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

//相当于<bean name="user" class="com.vison.bean.User"/>
@Component("user")

@Service("user") // service层
@Controller("user") // web层
@Repository("user") // dao层

/*结论：上面四个注解作用和效果都是一样的，只不过下面三个给人感觉目的性更加明确*/

/* 指定对象的作用范围，配 置scope属性，相当于<bean name="user" class="com.vison.bean.User"
 scope="singleton"/>*/
// singleton（默认是单例）|prototype（多例原型）|request|session四个属性可选
@Scope(scopeName = "singleton")
public class User
{
	// 通过反射的Field赋值，不过这种方法是破坏封装性，实际上比较常用
	@Value("vison") // 值类型注入，可以放在对应的成员变量上面，这个注解放在对应的Setter方法上面也是可以的（两个位置选一个）
	private String name;
	@Value("22")
	private Integer age;

	// 现要car类书写注解“@Component("user")”，然后使用注解“@Autowired”引入类对象
	// @Autowired // 自动装配
	// 问题：如果匹配多个类型一致的对象，将无法选择具体注入哪一个对象
	// @Qualifier("car2")
	// @Autowired 配合Qualifier("car2")就能自动装配并且准确定位到car2这个对象了

	@Resource(name = "car2") // 推荐使用，手动注入，指定注入哪个名称的对象
	private Car car;

	public Car getCar()
	{
		return car;
	}

	public void setCar(Car car)
	{
		this.car = car;
	}

	public String getName()
	{
		return name;
	}

	// 通过set方法赋值，这种方法是推荐使用，但是不常用
	// @Value("vison") //值类型注入
	public void setName(String name)
	{
		this.name = name;
	}

	public Integer getAge()
	{
		return age;
	}

	public void setAge(Integer age)
	{
		this.age = age;
	}

	@Override
	public String toString()
	{
		return "User [name=" + name + ", age=" + age + ", car=" + car + "]";
	}

	@PostConstruct // 在对象被创建后调用，相当于配置文件中的init-method
	public void init()
	{
		System.out.println("初始化方法！！！");
	}

	@PreDestroy // 在对象销毁之前调用,相当于destroy-method
	public void destroy()
	{
		System.out.println("销毁方法！！！！");
	}

}
