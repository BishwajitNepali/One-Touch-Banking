package com.example.thangla;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import android.util.Log;

public class WebService {
	// Namespace of the Webservice - It is http://tempuri.org for .NET
	// webservice
	private static String NAMESPACE = "http://tempuri.org/";
	// Webservice URL - It is asmx file location hosted in the server in case of
	// .Net
	// Change the IP address to your machine IP address
	private static String URL = "http://bankingservice.thakurisanjal.org/Consumer.asmx";
	// SOAP Action URI again http://tempuri.org
	private static String SOAP_ACTION = "http://tempuri.org/";

	/*
	 * public static String invokeHelloWorldWS(String name,int seller_pin,String
	 * buyer_acc,int buyer_pin,double total_price, String webMethName) {
	 * 
	 * }
	 */

	public static String invokeHelloWorldWS(String seller_acc, int seller_pin,
			String buyer_acc, int buyer_pin, int total_price, String webMethName) {
		// TODO Auto-generated method stub

		Log.e("Checking Parameters", seller_acc + seller_pin + "" + buyer_acc
				+ buyer_pin + "" + total_price);
		String resTxt = null;
		// Create request
		SoapObject request = new SoapObject(NAMESPACE, webMethName);
		// Property which holds input parameters
		PropertyInfo consumeraccount = new PropertyInfo();
		// Set Name
		consumeraccount.setName("consumeraccount");
		// Set Value
		consumeraccount.setValue(seller_acc);

		// Set dataType
		consumeraccount.setType(String.class);
		// Add the property to request object
		request.addProperty(consumeraccount);

		// Property which holds input parameters
		PropertyInfo consumerpin = new PropertyInfo();
		// Set Name
		consumerpin.setName("consumerpin");
		// Set Value
		consumerpin.setValue(seller_pin);

		// Set dataType
		consumerpin.setType(Integer.class);
		// Add the property to request object
		request.addProperty(consumerpin);

		// Property which holds input parameters
		PropertyInfo accountno = new PropertyInfo();
		accountno.setName("accountno");
		// Set Value
		accountno.setValue(buyer_acc);

		// Set dataType
		accountno.setType(String.class);
		// Add the property to request object
		request.addProperty(accountno);

		// Property which holds input parameters
		PropertyInfo pin = new PropertyInfo();
		pin.setName("pin");
		// Set Value
		pin.setValue(buyer_pin);

		// Set dataType
		pin.setType(Integer.class);
		// Add the property to request object
		request.addProperty(pin);

		// Property which holds input parameters
		PropertyInfo amount = new PropertyInfo();
		amount.setName("amount");
		// Set Value
		amount.setValue(total_price);

		// Set dataType
		amount.setType(Double.class);
		// Add the property to request object
		request.addProperty(amount);
		// Create envelope
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);
		// Set envelope as dotNet
		envelope.dotNet = true;
		// Set output SOAP object
		envelope.setOutputSoapObject(request);
		// Create HTTP call object
		HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);

		try {
			// Invoke web service
			androidHttpTransport.call(SOAP_ACTION + webMethName, envelope);
			// Get the response
			SoapPrimitive response = (SoapPrimitive) envelope.getResponse();
			// Assign it to resTxt variable static variable
			resTxt = response.toString();

		} catch (Exception e) {
			// Print error
			e.printStackTrace();
			// Assign error message to resTxt
			resTxt = "Error occured";
		}
		// Return resTxt to calling object
		return resTxt;
	}

	public static String invokeHelloWorldWSBalance(String account, int pin,
			String action) {
		String resTxt = null;
		// Create request
		SoapObject request = new SoapObject(NAMESPACE, action);
		// Property which holds input parameters
		PropertyInfo consumeraccount = new PropertyInfo();
		// Set Name
		consumeraccount.setName("accountno");
		// Set Value
		consumeraccount.setValue(account);

		// Set dataType
		consumeraccount.setType(String.class);
		// Add the property to request object
		request.addProperty(consumeraccount);

		// Property which holds input parameters
		PropertyInfo consumerpin = new PropertyInfo();
		// Set Name
		consumerpin.setName("pin");
		// Set Value
		consumerpin.setValue(pin);

		// Set dataType
		consumerpin.setType(Integer.class);
		// Add the property to request object
		request.addProperty(consumerpin);

		
		// Create envelope
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);
		// Set envelope as dotNet
		envelope.dotNet = true;
		// Set output SOAP object
		envelope.setOutputSoapObject(request);
		// Create HTTP call object
		HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);

		try {
			// Invoke web service
			androidHttpTransport.call(SOAP_ACTION + action, envelope);
			// Get the response
			SoapPrimitive response = (SoapPrimitive) envelope.getResponse();
			// Assign it to resTxt variable static variable
			resTxt = response.toString();

		} catch (Exception e) {
			// Print error
			e.printStackTrace();
			// Assign error message to resTxt
			resTxt = "Error occured";
		}
		// Return resTxt to calling object
		return resTxt;
	}
}