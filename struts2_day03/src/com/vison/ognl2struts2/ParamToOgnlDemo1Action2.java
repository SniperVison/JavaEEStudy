package com.vison.ognl2struts2;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;
import com.vison.bean.User;

//实现驱动模型驱动只需在【赋值前】将接受参数的对象压入栈顶即可

//Ognl与Struts2的结合
//通过模型驱动获取参数方式二(实现ModelDriven接口):相对方式一，简单很多，但是原理是一样的
public class ParamToOgnlDemo1Action2 extends ActionSupport implements ModelDriven<User>
{
	private User u = new User();

	@Override
	public String execute() throws Exception
	{
		// 压入栈顶
		// 1--获取值栈(ValueStack)
		ValueStack vs = ActionContext.getContext().getValueStack();
		// 将u压入栈顶
		vs.push(u);
		System.out.println(u);
		return SUCCESS;
	}

	@Override
	public User getModel()
	{
		return u;
	}

}
