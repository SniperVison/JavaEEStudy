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

//�൱��<bean name="user" class="com.vison.bean.User"/>
@Component("user")

@Service("user") // service��
@Controller("user") // web��
@Repository("user") // dao��

/*���ۣ������ĸ�ע�����ú�Ч������һ���ģ�ֻ���������������˸о�Ŀ���Ը�����ȷ*/

/* ָ����������÷�Χ���� ��scope���ԣ��൱��<bean name="user" class="com.vison.bean.User"
 scope="singleton"/>*/
// singleton��Ĭ���ǵ�����|prototype������ԭ�ͣ�|request|session�ĸ����Կ�ѡ
@Scope(scopeName = "singleton")
public class User
{
	// ͨ�������Field��ֵ���������ַ������ƻ���װ�ԣ�ʵ���ϱȽϳ���
	@Value("vison") // ֵ����ע�룬���Է��ڶ�Ӧ�ĳ�Ա�������棬���ע����ڶ�Ӧ��Setter��������Ҳ�ǿ��Եģ�����λ��ѡһ����
	private String name;
	@Value("22")
	private Integer age;

	// ��Ҫcar����дע�⡰@Component("user")����Ȼ��ʹ��ע�⡰@Autowired�����������
	// @Autowired // �Զ�װ��
	// ���⣺���ƥ��������һ�µĶ��󣬽��޷�ѡ�����ע����һ������
	// @Qualifier("car2")
	// @Autowired ���Qualifier("car2")�����Զ�װ�䲢��׼ȷ��λ��car2���������

	@Resource(name = "car2") // �Ƽ�ʹ�ã��ֶ�ע�룬ָ��ע���ĸ����ƵĶ���
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

	// ͨ��set������ֵ�����ַ������Ƽ�ʹ�ã����ǲ�����
	// @Value("vison") //ֵ����ע��
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

	@PostConstruct // �ڶ��󱻴�������ã��൱�������ļ��е�init-method
	public void init()
	{
		System.out.println("��ʼ������������");
	}

	@PreDestroy // �ڶ�������֮ǰ����,�൱��destroy-method
	public void destroy()
	{
		System.out.println("���ٷ�����������");
	}

}
