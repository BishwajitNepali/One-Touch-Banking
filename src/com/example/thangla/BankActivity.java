package com.example.thangla;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class BankActivity extends Activity implements View.OnClickListener {
	Button balance, transfer, pin;
	String acc;
	String pin_code;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_transaction);
		balance = (Button) findViewById(R.id.btn_transfer);
		transfer = (Button) findViewById(R.id.btn_transfer);
		pin = (Button) findViewById(R.id.btn_pin_change);
		acc = getIntent().getStringExtra("ACCOUNT_NUMBER");
		pin_code = getIntent().getStringExtra("PIN");
		
		Log.e("Check in Balance Check", "Acc"+acc+"pin"+pin_code+"");
		balance.setOnClickListener(this);
		transfer.setOnClickListener(this);
		pin.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

		switch (v.getId()) {

		case R.id.btn_balance:
			Intent intent = new Intent(BankActivity.this, BalanceCheck.class);
			intent.putExtra("ACCOUNT_NUMBER", acc);
			intent.putExtra("PIN", pin_code);
			startActivity(intent);

			// startActivity(new Intent(this,BankActivity.class));
			break;

		case R.id.btn_transfer:
			Intent intent2 = new Intent(BankActivity.this, Transfer.class);
			intent2.putExtra("ACCOUNT_NUMBER", acc);
			intent2.putExtra("PIN", pin_code);
			startActivity(intent2);
			break;

		case R.id.btn_pin_change:
			Intent intent3 = new Intent(BankActivity.this, PinChange.class);
			intent3.putExtra("ACCOUNT_NUMBER", acc);
			intent3.putExtra("PIN", pin_code);
			startActivity(intent3);
			break;

		}

	}
}
