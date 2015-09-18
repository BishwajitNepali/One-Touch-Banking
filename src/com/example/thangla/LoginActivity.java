package com.example.thangla;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends Activity implements View.OnClickListener {
	Button user;
	String account_number, pin_code;
	EditText account, pin;

	/*
	 * public static final String MyPREFERENCES = "MyPrefs"; public static final
	 * String Account = "account"; public static final String Pin = "pin";
	 * SharedPreferences sharedpreferences;
	 */

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		// sharedpreferences =
		// getSharedPreferences(MyPREFERENCES,Context.MODE_PRIVATE);
		account = (EditText) findViewById(R.id.accountnumber);
		pin = (EditText) findViewById(R.id.pin);
		user = (Button) findViewById(R.id.userloginbtn);
		user.setOnClickListener(this);

	}

	@Override
	
	public void onClick(View v) {
		// TODO Auto-generated method stub

		String account_number = account.getText().toString();
		String pin_code = pin.getText().toString();
		int pinn_code=Integer.parseInt(pin_code);
		
		
		Account a=new Account();
		a.setAccount_number(account_number);
		a.setPin(pinn_code);

		/*
		 * SharedPreferences.Editor editor = sharedpreferences.edit();
		 * 
		 * editor.putString(Account, account_number); editor.putString(Pin,
		 * pin_code); editor.commit();
		 */

		Intent intent = new Intent(LoginActivity.this, BankActivity.class);
		intent.putExtra("ACCOUNT_NUMBER", account_number);
		intent.putExtra("PIN", pin_code);
		startActivity(intent);

		startActivity(intent);

	}

}
