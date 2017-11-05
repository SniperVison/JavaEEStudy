package com.vison.ognl2struts2;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.util.ValueStack;
import com.vison.bean.User;

//实现驱动模型驱动只需在【赋值前】将接受参数的对象压入栈顶即可
//prepare拦截器的执行顺序要先于params拦截器的
//赋值并压栈这两个操作是要经过struts2中的默认拦截器(“其中有一个params拦截器是进行赋值操作的”)
//但是实现模型驱动的前提是要“在【赋值前】将参数压入栈顶”，所以要在params拦截器前面prepare拦截器中就要进行压栈操作,所以要实现Preparble接口

//Ognl与Struts2的结合
//通过模型驱动获取参数方式一(实现preparble接口):难度大，因为这操作得要对struts2的框架很熟悉
public class ParamToOgnlDemo1Action extends ActionSupport implements Preparable
{
	private User u = new User();

	// 这里是赋值后的，如果在这里进行压栈操作是没有用的，不能通过模型驱动获取参数值
	@Override
	public String execute() throws Exception
	{/*
		// 压入栈顶
		// 1--获取值栈(ValueStack)
		ValueStack vs = ActionContext.getContext().getValueStack();
		// 将u压入栈顶
		vs.push(u);*/
		System.out.println(u);
		return SUCCESS;
	}

	// 这里就是赋值前的操作，在这里进行压栈操作才能通过模型驱动获取参数
	@Override
	public void prepare() throws Exception
	{
		// 压入栈顶
		// 1--获取值栈(ValueStack)
		ValueStack vs = ActionContext.getContext().getValueStack();
		// 将u压入栈顶
		vs.push(u);

	}

}
