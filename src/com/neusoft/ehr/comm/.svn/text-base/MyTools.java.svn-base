package com.neusoft.ehr.comm;

import java.io.UnsupportedEncodingException;
import java.util.Stack;
public class MyTools 
{
	public  static String toChinese(String str)
	{
		if(str==null)
			str="";
		try
		{
			str = new String(str.getBytes("ISO-8859-1"),"UTF-8");
		}
		catch (UnsupportedEncodingException e)
		{
			str = "";
			e.printStackTrace();
		}
		return str;
	}
	public static String intToStr(int num)
	{
		return String.valueOf(num);
	}
	
	
	/*
	 * @huxianzhi
	 *截取第n对括号之间的字符串，n>0为正向，n<0为逆向
	 */
	
	public static String getStrInBrackets(String str,int n){
		if(Math.abs(n)>str.length()/2||n==0)
			return null;
		Stack<Integer> brackets = new Stack<Integer>();
		String sub="";
		if(n>0){
			for(int i=0;i<str.length();i++){
				if(str.charAt(i)=='(' && n==1)
					brackets.push(i);
				if(str.charAt(i)=='('&& n>1)
					n--;
				if(str.charAt(i)==')'){
					if(brackets.size()==1){
						sub = str.substring(brackets.peek()+1, i);
						return sub;
					}
					if(!brackets.isEmpty())
					brackets.pop();
				}
			}
		}else{
			n=-n;
			for(int i=str.length()-1;i>=0;i--){
				if(str.charAt(i)==')' && n==1)
					brackets.push(i);
				if(str.charAt(i)==')'&& n>1)
					n--;
				if(str.charAt(i)=='('){
					if(brackets.size()==1){
						sub = str.substring(i+1, brackets.peek());
						return sub;
					}
					if(!brackets.isEmpty())
						brackets.pop();
				}
			}
		}//else
		return null;
	}
}
