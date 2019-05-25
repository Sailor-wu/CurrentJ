package com.wd.costom;

import com.wd.costom.MyAnnotation.MyAnno;

/**
 * desc 使用自定义注解
 * 
 * @author wu
 * @date Create in 2019/05/25 10:11:53
 *
 */
public class UseAnno {

	/**
	 * desc 验证密码 . 匹配除换行符以外的任意字符
	 * 
	 * \w 匹配字母或数字或下划线或汉字 等价于 '[^A-Za-z0-9_]'。
	 * 
	 * \s 匹配任意的空白符
	 * 
	 * \d 匹配数字
	 * 
	 * \b 匹配单词的开始或结束
	 * 
	 * ^ 匹配字符串的开始
	 * 
	 * $ 匹配字符串的结束
	 * 
	 * @param password
	 * @return
	 */
	@MyAnno(id = "1",description = "密碼必須符合我的正則表達式")
	public boolean validataPass(String password) {
		return (password.matches("\\w*\\d\\w"));
	}
	/**
	 * desc 加密密码
	 * @param password
	 * @return
	 */
	@MyAnno(id ="48")
    public String encryptPassword(String password) {
        return new StringBuilder(password).reverse().toString();
    }
}