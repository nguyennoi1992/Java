
package com.webservice.service;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.webservice.bean.Bus;
import com.webservice.bean.BusDetail;
import com.webservice.bean.Customer;
import com.webservice.bean.Employee;
import com.webservice.bean.Kind;
import com.webservice.bean.Logging;
import com.webservice.bean.Payment;
import com.webservice.bean.Usebus;
import com.webservice.bean.User;
import com.webservice.bo.impl.BusBOImpl;
import com.webservice.bo.impl.BusDetailBOImpl;
import com.webservice.bo.impl.CustomerBOImpl;
import com.webservice.bo.impl.EmployeeBOImpl;
import com.webservice.bo.impl.KindBOImpl;
import com.webservice.bo.impl.LoggingBOImpl;
import com.webservice.bo.impl.PaymentBOImpl;
import com.webservice.bo.impl.UsebusBOImpl;
import com.webservice.bo.impl.UserBOImpl;


@Path("WebService")
public class FeedsService {

	@POST
	@Consumes({"application/json"})
	public Response test(@FormParam("abc") String abc, @FormParam("def") String def)
	{

		String feeds = "";
		EmployeeBOImpl cus = new EmployeeBOImpl();
		try {
			List<Employee> list = cus.getAll();
			Gson gson = new Gson();
			if(abc.compareTo("1") == 0 && def.compareTo("1") == 0) {
				feeds = gson.toJson(list);
			} else {
				feeds = abc + def;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Response.status(201).entity(feeds).build();
	}



	@POST
	@Path("/logout_id")
	@Consumes({"application/json"})
	public Response checkLogoutID(@FormParam("id") String id)
	{

		String feeds  = null;
		try 
		{
			User feedData = new User();
			UserBOImpl userBO = new UserBOImpl();
			feedData = userBO.getById(id);


			Gson gson = new Gson();
			if(feedData.getUserNumber().compareTo("") != 0){
				feedData.setSuccess("1");
				System.out.println(gson.toJson(feedData));
				feeds = gson.toJson(feedData);
			} else {
				feedData.setSuccess("0");
				System.out.println(gson.toJson(feedData));
				feeds = gson.toJson(feedData);
			}
			feeds = gson.toJson(feedData);

		} catch (Exception e)
		{
			System.out.println("error");
		}
		return Response.status(201).entity(feeds).build();
	}

	@POST
	@Path("/logout_uname")
	@Consumes({"application/json"})
	public Response checkLogoutUname(@FormParam("username") String username, @FormParam("password") String password)
	{

		String feeds  = null;
		try 
		{
			User feedData = new User();
			UserBOImpl userBO = new UserBOImpl();
			feedData = userBO.getNamePassword(username, setPassword(password));	

			Gson gson = new Gson();
			if(feedData.getUserNumber().compareTo("") != 0){
				feedData.setSuccess("1");
				System.out.println(gson.toJson(feedData));
				feeds = gson.toJson(feedData);
			} else {
				feedData.setSuccess("0");
				System.out.println(gson.toJson(feedData));
				feeds = gson.toJson(feedData);
			}

		} catch (Exception e)
		{
			System.out.println("error");
		}
		return Response.status(201).entity(feeds).build();
	}


	@POST
	@Path("/login_id")
	@Consumes({"application/json"})
	public Response checkLoginID(@FormParam("id") String id)
	{

		String feeds  = null;
		try 
		{
			User feedData = new User();
			UserBOImpl userBO = new UserBOImpl();
			feedData = userBO.getById(id);				


			Gson gson = new Gson();
			if(feedData.getUserNumber().compareTo("") != 0){
				feedData.setSuccess("1");
				System.out.println(gson.toJson(feedData));
				feeds = gson.toJson(feedData);
			} else {
				feedData.setSuccess("0");
				System.out.println(gson.toJson(feedData));
				feeds = gson.toJson(feedData);
			}
			feeds = gson.toJson(feedData);

		} catch (Exception e)
		{
			System.out.println("error");
		}
		return Response.status(201).entity(feeds).build();
	}

	@POST
	@Path("/login_uname")
	@Consumes({"application/json"})
	public Response checkLoginUname(@FormParam("username") String username, @FormParam("password") String password)
	{

		String feeds  = null;
		try 
		{
			User feedData = new User();
			UserBOImpl userBO = new UserBOImpl();
			feedData = userBO.getNamePassword(username, setPassword(password));	

			Gson gson = new Gson();
			if(feedData.getUserNumber().compareTo("") != 0){
				feedData.setSuccess("1");
				System.out.println(gson.toJson(feedData));
				feeds = gson.toJson(feedData);
			} else {
				feedData.setSuccess("0");
				System.out.println(gson.toJson(feedData));
				feeds = gson.toJson(feedData);
			}

		} catch (Exception e)
		{
			System.out.println("error");
		}
		return Response.status(201).entity(feeds).build();
	}

	@POST
	@Path("/customer")
	@Consumes({"application/json"})
	public Response feed(@FormParam("id") String id)
	{

		String feeds  = null;
		try 
		{
			Gson gson = new Gson();

			User user = new User();
			UserBOImpl userBO = new UserBOImpl();
			user = userBO.getById(id);

			if(user.getAccount().compareTo("User") == 0){
				Customer customer = new Customer();
				CustomerBOImpl customerBO = new CustomerBOImpl();
				customer = customerBO.getById(id);
				if(customer.getActived().compareTo("Có") == 0){
					customer.setSuccess("1");
					System.out.println(gson.toJson(customer));
				} else {
					customer.setSuccess("0");
					System.out.println(gson.toJson(customer));
				}
				feeds = gson.toJson(customer);
			} else {
				Employee employee = new Employee();
				EmployeeBOImpl employeeBO = new EmployeeBOImpl();
				employee = employeeBO.getById(id);
				if(employee.getEmployeeNumber().compareTo("") != 0){
					employee.setSuccess("1");
					System.out.println(gson.toJson(employee));
				} else {
					employee.setSuccess("0");
					System.out.println(gson.toJson(employee));
				}
				feeds = gson.toJson(employee);
			}


		} catch (Exception e)
		{
			System.out.println("error");
		}
		return Response.status(201).entity(feeds).build();
	}

	@POST
	@Path("/payment")
	@Consumes({"application/json"})
	public Response Update(@FormParam("date") String date,
			@FormParam("place") String place,
			@FormParam("customerNumber") String customerNumber,
			@FormParam("userNumber") String userNumber,
			@FormParam("numberPlate") String numberPlate){

		String feeds  = null;
		try{
			int result = 0;
			float fee, balance;
			JsonObject json = new JsonObject();

			PaymentBOImpl paymentBO = new PaymentBOImpl();
			CustomerBOImpl customerBO = new CustomerBOImpl();
			KindBOImpl kindBO = new KindBOImpl();
			UsebusBOImpl usebusBO = new UsebusBOImpl();
			BusBOImpl busBO = new BusBOImpl();
			BusDetailBOImpl busDetailBO = new BusDetailBOImpl();

			Payment bean = new Payment();
			Customer customer = new Customer();
			Kind kind = new Kind();
			Usebus usebus = new Usebus();
			Bus bus = new Bus();
			BusDetail busDetail = new BusDetail();

			//bean payment
			bean.setDate(date);
			bean.setPlace(place);
			bean.setCustomerNumber(customerNumber);
			bean.setUserNumber(userNumber);
			bean.setNumberPlate(numberPlate);

			//Customer
			customer = customerBO.getById(bean.getCustomerNumber());

			//kind
			kind = kindBO.getById(customer.getKindNumber());

			//BusDetail
			busDetail = busDetailBO.getById(numberPlate);

			//Bus
			bus = busBO.getById(busDetail.getBusNumber());

			fee = bus.getCost();


			//update balance
			if(kind.getKind().compareTo("Theo ngày") == 0) {
				System.out.println("Truong hop 1");
				//balance
				if(customer.getBalance() > 0) {
					balance = customer.getBalance() - fee;
					System.out.println(customer.getDateOfBirth() + customer.getDateLimit());
					customer.setBalance(balance);
					result = customerBO.update(customer);
				} else {
					result = 0;
				}
			} else if (kind.getKind().compareTo("Theo tháng") == 0
					&& kind.getType().compareTo("Một tuyến") == 0) {
				usebus = usebusBO.getById(bean.getCustomerNumber());
				if(usebus.getBusNumber()
						.compareTo(busDetail.getBusNumber()) != 0) {

					System.out.println("Truong hop 2");
					//balance
					if(customer.getBalance() > 0) {
						balance = customer.getBalance() - fee;
						System.out.println(customer.getDateOfBirth() + customer.getDateLimit());
						customer.setBalance(balance);
						result = customerBO.update(customer);
					} else {
						result = 0;
					}
				}
			} else {
				System.out.println("Truong hop 3");
				if(customer.getBalance() > 0) {
					result = 1;
				} else {
					result = 0;
				}
			}
			if(result == 1){
				paymentBO.addNew(bean);
				json.addProperty("success", "1");
				System.out.println(json);
			} else {
				json.addProperty("success", "0");
				System.out.println(json);					
			}

			feeds = json.toString();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Response.status(201).entity(feeds).build();
	}

	@POST
	@Path("/lock")
	@Consumes({"application/json"})
	public Response lock_id(@FormParam("id") String id, 
			@FormParam("userNumber") String userNumber)
	{

		String feeds  = null;
		try 
		{
			Customer feedData = new Customer();
			CustomerBOImpl customerBO = new CustomerBOImpl();
			feedData = customerBO.getById(id);

			System.out.println("ID2 " + id);
			feedData.setActived("Không");

			int result = 0;
			result = customerBO.update(feedData);

			Gson gson = new Gson();
			if(result  != 0){
				LoggingBOImpl lockBO = new LoggingBOImpl();
				Logging lock = new Logging();

				lock.setUserNumber(userNumber);
				lock.setCustomerNumber(id);
				lock.setDate(now());
				lock.setAction("Khóa tài khoản");

				lockBO.addNew(lock);
				feedData.setSuccess("1");
				System.out.println(gson.toJson(feedData));
				feeds = gson.toJson(feedData);
			} else {
				feedData.setSuccess("0");
				System.out.println(gson.toJson(feedData));
				feeds = gson.toJson(feedData);
			}

		} catch (Exception e)
		{
			System.out.println("error");
		}
		return Response.status(201).entity(feeds).build();
	}

	@POST
	@Path("/history_customer")
	@Consumes({"application/json"})
	public Response history_customer(@FormParam("id") String id)
	{

		String feeds  = null;
		try 
		{
			PaymentBOImpl paymentBO = new PaymentBOImpl();
			List<Payment> list = paymentBO.getAll();
			JsonArray feedData = new  JsonArray();
			JsonObject json = new JsonObject();

			Gson gson = new Gson();
			if(list != null) {
				for(int i = 0; i < list.size(); i++) {
					if(list.get(i).getCustomerNumber().compareTo(id) == 0) {
						feedData.add(gson.toJsonTree(list.get(i)));
						System.out.println(feedData);
					}
				}
				json.addProperty("success", "1");
			} else {
				json.addProperty("success", "0");
			}
			json.addProperty("listpayment", gson.toJson(feedData));
			String str  = gson.toJson(json);

			feeds = str.replace("\\", "")
					.replace("\"[", "[").replace("]\"", "]");

			System.out.println(feeds);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return Response.status(201).entity(feeds).build();
	}

	@POST
	@Path("/history_employee")
	@Consumes({"application/json"})
	public Response history_employee(@FormParam("id") String id)
	{

		String feeds  = null;
		try 
		{
			PaymentBOImpl paymentBO = new PaymentBOImpl();
			List<Payment> list = paymentBO.getAll();
			JsonArray feedData = new  JsonArray();
			JsonObject json = new JsonObject();

			Gson gson = new Gson();
			if(list != null) {
				for(int i = 0; i < list.size(); i++) {
					if(list.get(i).getUserNumber().compareTo(id) == 0) {
						feedData.add(gson.toJsonTree(list.get(i)));
						System.out.println(feedData);
					}
				}
				json.addProperty("success", "1");
			} else {
				json.addProperty("success", "0");
			}
			json.addProperty("listpayment", gson.toJson(feedData));
			String str  = gson.toJson(json);

			feeds = str.replace("\\", "")
					.replace("\"[", "[").replace("]\"", "]");

			System.out.println(feeds);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return Response.status(201).entity(feeds).build();
	}

	public String setPassword(String password) {
		MessageDigest md = null;
		byte[] byteOfPassword = null;
		byte[] digest = null;
		BigInteger bInt = null;

		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		try {
			byteOfPassword = password.getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		digest = md.digest(byteOfPassword);
		//convert from byte to hex string
		bInt = new BigInteger(1, digest);
		return String.format("%0" + (digest.length << 1) + "x", bInt);
	}

	public String now(){
		String DATE_FORMAT_NOW = "yyyy-MM-dd HH:mm:ss";
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
		return sdf.format(cal.getTime());
	}

}
