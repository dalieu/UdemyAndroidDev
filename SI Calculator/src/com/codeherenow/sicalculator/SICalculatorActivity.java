/*
 * Copyright (C) 2013 Code Here Now - A subsidiary of Mobs & Geeks
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file 
 * except in compliance with the License. You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the 
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, 
 * either express or implied. See the License for the specific language governing permissions and 
 * limitations under the License.
 */
package com.codeherenow.sicalculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.SeekBar;

public class SICalculatorActivity extends Activity implements SeekBar.OnSeekBarChangeListener, OnClickListener {
	
	// add private member vars
	private EditText editTextPrincipal;
	private EditText editTextInterestRate;
	private TextView textYears;
	private SeekBar seekBarYears;
	private TextView editTextMultiResult;
	private Button buttonCalculate;
	
	private String textPrincipal;
	private String textInterest;
	private String textResult;
	
	private double principal;
	private double interest;
	private int years;
	private double result;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sicalculator);
		
		// create member vars
		// TBD: I wonder if there's a way to make it so that when you select
		//		an edit text, it clears the previous text for you?
		// Done: Used android:hint in layout.xml
		editTextPrincipal = (EditText) this.findViewById(R.id.editTextPrincipal);
		editTextInterestRate = (EditText) this.findViewById(R.id.editTextInterestRate);
		textYears = (TextView) this.findViewById(R.id.textYears);
		seekBarYears = (SeekBar) this.findViewById(R.id.seekBarYears);
		editTextMultiResult = (TextView) this.findViewById(R.id.editTextMultiResult);
		buttonCalculate = (Button) this.findViewById(R.id.buttonCalculate);
		
		// add handlers
		this.seekBarYears.setOnSeekBarChangeListener(this);
		this.buttonCalculate.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		textPrincipal = this.editTextPrincipal.getText().toString();
		textInterest = this.editTextInterestRate.getText().toString();
		
		principal = Double.parseDouble(textPrincipal);
		interest = Double.parseDouble(textInterest);
		
		result = principal * (interest/100) * years;
		
		textResult = Double.toString(result); 
				
		editTextMultiResult.setText(textResult);
	}

	@Override
	public void onProgressChanged(SeekBar seekBar, int progress,
			boolean fromUser) {
		// TODO Auto-generated method stub		
		
		textYears.setText(progress +" Years");
	}

	@Override
	public void onStartTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStopTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub
		years = seekBar.getProgress();
	}

}
