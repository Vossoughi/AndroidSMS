// Author: Kaveh Vossoughi
// Date  : 12/12/16
// Homework assignment : Quiz 2
// Objective: This Activity is in charge of sending SMS.
//******************************************************************
package vossoughi.smssender;

import android.app.Activity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.*;

public class SmsSenderActivity extends Activity
{
   EditText rec, msg;
   //****************************onCreate()****************************
   @Override
   protected void onCreate(Bundle savedInstanceState)
   {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_sms_sender);

      rec = (EditText) findViewById(R.id.editText);
      msg = (EditText) findViewById(R.id.editText2);
   }
   //****************************sendSMS()****************************
   public void sendSMS(String address, String message) throws IllegalArgumentException
   {
      SmsManager sm = SmsManager.getDefault();
      sm.sendTextMessage(address, null, message, null, null);
   }
   //**************************buttonListener()**************************
   public void buttonListener(View v)
   {
      String recipient = rec.getText().toString();
      String message = msg.getText().toString();
      sendSMS(recipient, message);
   }
}