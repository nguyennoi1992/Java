package com.webservice.service;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.webservice.bo.impl.CustomerBOImpl;
import com.webservice.bo.impl.PaymentBOImpl;
import com.webservice.bo.impl.UserBOImpl;
import com.webservice.model.Customer;
import com.webservice.model.Payment;
import com.webservice.model.User;


@Path("WebService")
public class FeedsService {

	@POST
	@Consumes({"application/json"})
	public Response test(@FormParam("abc") String abc, @FormParam("def") String def)
	{

		String feeds = "";
		CustomerBOImpl cus = new CustomerBOImpl();
		try {
			List<Customer> list = cus.getAll();
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
	public Response feed(@FormParam("id") String id, @FormParam("bus") String bus)
	{

		String feeds  = null;
		try 
		{
			Customer feedData = new Customer();
			CustomerBOImpl customerBO = new CustomerBOImpl();
			feedData = customerBO.getById(id);

			Gson gson = new Gson();
			if((feedData.getBusNumber().toString().compareTo("All") == 0 ||feedData.getBusNumber().compareTo(bus) == 0)
					&& feedData.getActived().toString().compareTo("Có") == 0){
				feedData.setSuccess("1");
				System.out.println(gson.toJson(feedData));
			} else {
				feedData.setSuccess("0");
				System.out.println(gson.toJson(feedData));
			}
			feeds = gson.toJson(feedData);

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
			@FormParam("busNumber") String busNumber){

		String feeds  = null;
		try{
			PaymentBOImpl paymentBO = new PaymentBOImpl();
			int result = 0;
			Payment bean = new Payment();
			bean.setDate(date);
			bean.setPlace(place);
			bean.setCustomerNumber(customerNumber);
			bean.setBusNumber(busNumber);
			result = paymentBO.addNew(bean);
			JsonObject json = new JsonObject();
			if(result == 1){
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
	public Response lock_id(@FormParam("id") String id)
	{

		String feeds  = null;
		try 
		{
			Customer feedData = new Customer();
			CustomerBOImpl customerBO = new CustomerBOImpl();
			feedData = customerBO.getById(id);

			feedData.setActived("Không");

			int result = 0;
			customerBO.update(feedData);

			Gson gson = new Gson();
			if(result  != 0){
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
	@Path("/history")
	@Consumes({"application/json"})
	public Response history_id(@FormParam("id") String id)
	{

		String feeds  = null;
		try 
		{
			PaymentBOImpl paymentBO = new PaymentBOImpl();
			List<Payment> list = null;
			JsonArray feedData = new  JsonArray();
			JsonObject json = new JsonObject();

			list = paymentBO.getAll();

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
			System.out.println("error");
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

}
