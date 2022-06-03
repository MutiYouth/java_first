package com.weng.controller;

import com.weng.bean.entity.Book;
import com.weng.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@Controller
public class TestSessionController {

	@Autowired
	private BookService bookService;


	/**
	 * 测试session的问题<br/>
	 * REF:
	 * <a href="https://blog.csdn.net/samniwu/article/details/90417160">java中session的用法与原理</a>
	 *
	 * @param response
	 * @param request
	 * @param req_data
	 * @throws IOException
	 */
	@RequestMapping(value = "/test_s_session", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public void test_session(HttpServletResponse response, HttpServletRequest request, String req_data) throws IOException {

		// 创建Session
		// 在程序中第一次调用request.getSession()方法时就会创建一个新的Session，可以用isNew()方法来判断Session是不是新创建的。
		HttpSession session = request.getSession();

		// 判断session是不是新创建的
		String sessionId = session.getId();
		response.setContentType("text/html;charset=UTF-8");  // 这一行要加，不然返回给的前端页面乱码
		PrintWriter out = response.getWriter();
		if (session.isNew()) {
			out.print("session创建成功，session的id是：" + sessionId);
		}
		else {
			out.print("服务器已经存在session，session的id是：" + sessionId);
		}


		out.write("本网站有如下书：<br/>");
		List<Book> book_list = bookService.getList(0, 20);
		Map<String, Book> map_tmp = new LinkedHashMap<String, Book>();
		for (Book book_tmp : book_list) {
			map_tmp.put(String.valueOf(book_tmp.getBookId()), book_tmp);
		}
		Set<Map.Entry<String, Book>> set = map_tmp.entrySet();


		// String url_base = request.getContextPath() + "/test_book_buy;jsessionid=" + session.getId();  // 强制重写
		String url_base = request.getContextPath() + "/test_s_book_buy";
		for (Map.Entry<String, Book> me : set) {
			Book book = me.getValue();
			String url = url_base + "?id=" + book.getBookId();
			// 所以，当浏览器禁用了cookie后，就可以用URL重写这种解决方案解决Session数据共享问题。
			// 而且【response.encodeRedirectURL(url)】和【response.encodeURL(url)】是两个非常智能的方法，当检测到浏览器没有禁用cookie时，那么就不进行URL重写了。
			// response.encodeURL 用于对表单action和超链接的url地址进行重写
			url = response.encodeURL(url);// 将超链接的url地址进行重写
			out.println(book.getName() + "   <a href='" + url + "'>购买</a><br/>");
		}
	}

	@RequestMapping(value = "/test_s_book_buy", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public void test_book_buy(HttpServletResponse response, HttpServletRequest request) throws IOException {
		String id_str = request.getParameter("id");
		Book book = bookService.getById(Long.parseLong(id_str));  // 得到用户想买的书

		HttpSession session = request.getSession();
		List<Book> book_ordered = (List) session.getAttribute("lst_book_car");  // 得到用户用于保存所有书的容器
		if (book_ordered == null) {
			book_ordered = new ArrayList<Book>();
			session.setAttribute("lst_book_car", book_ordered);
		}
		book_ordered.add(book);


		// response. encodeRedirectURL(java.lang.String url)用于对sendRedirect方法后的url地址进行重写
		String url = response.encodeRedirectURL(request.getContextPath() + "/test_s_list_car");
		System.out.println(url);
		response.sendRedirect(url);
	}

	@RequestMapping(value = "/test_s_list_car", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public void test_list_car(HttpServletResponse response, HttpServletRequest request) throws IOException {

		response.setContentType("text/html;charset=UTF-8");  // 这一行要加，不然返回给的前端页面乱码
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		List<Book> book_ordered = (List) session.getAttribute("lst_book_car");
		if (book_ordered == null || book_ordered.size() == 0) {
			out.write("对不起，您还没有购买任何商品!!");
			return;
		}

		// 显示用户买过的商品
		out.write("<h1>您买过如下商品:</h1>");
		for (Book book : book_ordered) {

			out.write("<p style=\"color: gray; line-height:20px;\">" + book.getName() + "</p>");
		}

	}

	@RequestMapping(value = "/test_s_invalidate_session", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public void test_invalidate_session(HttpServletResponse response, HttpServletRequest request) throws IOException {

		HttpSession session = request.getSession();
		// 手工调用session.invalidate方法，摧毁session
		session.invalidate();

		response.setContentType("text/html;charset=UTF-8");  // 这一行要加，不然返回给的前端页面乱码
		PrintWriter out = response.getWriter();
		out.write("<h1>Session 已经被置无效！</h1>");
	}


}
