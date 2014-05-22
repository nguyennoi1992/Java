package com.management.bo.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.management.bean.User;
import com.management.bo.UserBO;
import com.management.dao.impl.UserDAOImpl;
import com.management.utils.CheckEmail;
import com.management.utils.ProjectConstants;

public class UserBOImpl implements UserBO, ProjectConstants{
	private UserDAOImpl dao = new UserDAOImpl();

	public UserDAOImpl getDao() {
		return dao;
	}

	public void setDao(UserDAOImpl dao) {
		this.dao = dao;
	}

	@Override
	public List<User> getAll() throws Exception {
		// TODO Auto-generated method stub
		List<User> list = new ArrayList<User>();
		List<User> l = dao.getAll();
		for(int i = 0; i < l.size(); i++) {
			list.add(new User(l.get(i).getUserNumber(),
					l.get(i).getUsername(),
					l.get(i).getPassword(),
					l.get(i).getEmail(),
					l.get(i).getAccount()));
		}
		return list;
	}

	@Override
	public User getById(String id) throws Exception {
		// TODO Auto-generated method stub
		List<User> list = dao.getAll();
		User user = new User();
		for(User u: list){
			if(u.getUserNumber().toString().compareTo(id) == 0){
				user = u;
			}
		}
		return user;
	}

	@Override
	public User getByNamePassword(String name, String password) throws Exception {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		List <User> list = dao.getAll();
		User user = new User();
		for(User u: list){
			if(u.getUsername().toString().compareTo(name) == 0 &&
					u.getPassword().toString().compareTo(password) == 0){
				user = u;
			}
		}
		return user;
	}


	@Override
	public int addNew(User entity) throws Exception {
		// TODO Auto-generated method stub
		int result = 0;
		result = dao.addNew(entity);
		return result;
	}

	@Override
	public int update(User entity) throws Exception {
		// TODO Auto-generated method stub
		int result = 0;
		result = dao.update(entity);
		return result;
	}

	@Override
	public int delete(User entity) throws Exception {
		// TODO Auto-generated method stub
		int result = 0;
		result = dao.delete(entity);
		return result;
	}

	@Override
	public boolean checkExistUser(User entity) throws Exception {
		// TODO Auto-generated method stub
		String username = entity.getUsername();
		String password = entity.getPassword();
		
		boolean ans = false;
		List<User> list = dao.getAll();
		for(User u: list){
			if(u.getUsername().toString().compareTo(username) == 0
					&& u.getPassword().toString().compareTo(password) == 0) {
				ans = true;
			}
		}
		return ans;
	}

	@Override
	public String validate(User entity) throws Exception {
		// TODO Auto-generated method stub
		String username = entity.getUsername();
		String password = entity.getPassword();
		//empty field
		if (username.equals(""))
			return "empty_user";
		if (password.equals(""))
			return "empty_password";

		//contain illegal characters
		if (CheckEmail.invalid(username))
			return "invalid_username";
		else 
			return "success";
	}

	@Override
	public String validateEmail(User entity) throws Exception {
		// TODO Auto-generated method stub
		String email = entity.getEmail();
		return CheckEmail.validateEmail(email);    	
	}

	@Override
	public boolean sendEmail(String username, String email) throws Exception {
		// TODO Auto-generated method stub
		boolean bool = false;
		List<User> list = dao.getAll();
		User user = new User();
		for(User u: list){
			if(u.getUsername().toString().compareTo(username) == 0
					&& u.getEmail().toString().compareTo(email) == 0){
				user = u;
			}
		}
		if(user != null) {
			final String sendname = "abc40197@gmail.com";
			final String password = "daica@123";
			String str = "";
			for (int i = 0; i < 6; i++) {
				int index = (int) Math.random()*52;
				str += STATIC_STRING[index];
			}

			Properties props = new Properties();
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.port", "587");

			Session session = Session.getInstance(props,
					new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(sendname, password);
				}
			});

			try {

				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress("abc40197@gmail.com"));
				message.setRecipients(Message.RecipientType.TO,
						InternetAddress.parse(email));
				message.setSubject("Khôi phục mật khẩu");
				message.setText("Dear " + username + ","
						+ "\n\n Chúng tôi nhận được yêu cầu khôi phục mật khẩu của bạn"
						+ "\n\n Đây là mật khẩu mới: " + str
						+ "\n\n Cảm ơn bạn đã sử dụng dịch vụ!"
						+ "\n\n Nếu có thắc mắc vui lòng liên hệ theo hotline: (+84) 0985482948"
						+ "\n\n hoặc theo email: abc40197@gmail.com");

				Transport.send(message);
				System.out.println("Gửi mail thành công!" + str);
				user.setPassword(str);
				System.out.println(user.getUserNumber());
				dao.update(user);
				bool = true;

			} catch (MessagingException e) {
				throw new RuntimeException(e);
			}

		}
		return bool;
	}


}
