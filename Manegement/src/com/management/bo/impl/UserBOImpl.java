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

import com.management.bo.UserBO;
import com.management.dao.impl.UserDAOImpl;
import com.management.model.User;
import com.management.utils.CheckEmail;
import com.management.utils.ProjectConstants;

public class UserBOImpl implements UserBO, ProjectConstants{
	private UserDAOImpl dao = new UserDAOImpl();

	public List<User> getAll() throws Exception {
		List<User> list = new ArrayList<User>();
		List<User> l = dao.getAll();
		for(int i = 0; i < l.size(); i++) {
			list.add(new User(l.get(i).getUserNumber(),
					l.get(i).getUsername(),
					l.get(i).getPassword(),
					l.get(i).getEmail(),
					l.get(i).getBusNumber()));
		}
		return list;
	}

	public User getById(String id) throws Exception {
		User u = new User();
		u = dao.getById(id);
		return u;
	}

	public User getByNamePassword(String name, String password) throws Exception {
		User u = new User();
		u = dao.getByNamePassword(name, password);
		return u;
	}


	public void addNew(User entity) throws Exception {
		dao.addNew(entity);
	}

	public void update(User entity) throws Exception {
		dao.update(entity);
	}

	public void delete(User entity) throws Exception {
		dao.delete(entity);
	}
	public boolean checkExistUser(User entity) throws Exception {
		boolean ans = false;
		ans = dao.checkExistUser(entity);
		return ans;
	}

	public String validate(User entity) throws Exception {
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
	public String validateEmail(User entity) throws Exception {
		String email = entity.getEmail();
		return CheckEmail.validateEmail(email);    	
	}
	public boolean sendEmail(String username, String email) throws Exception {
		boolean bool = false;
		User user = new User();
		user = dao.getByNameEmail(username, email);
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
