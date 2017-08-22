// Author: Kaveh Vossoughi
// Date  : 12/12/16
// Homework assignment : Quiz 2
// Objective: This Activity reads the message and the sender
// of SMS received by SmsListener class and display them on
// the appropriate TextView on the layout.
//******************************************************************

package vossoughi.smsreceiver;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class SmsReceiverActivity extends Activity
{
   static TextView addressField, messageField;
   //****************************onCreate()****************************
   @Override
   protected void onCreate(Bundle savedInstanceState)
   {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_sms_receiver);
      addressField = (TextView) findViewById(R.id.editText);
      messageField = (TextView) findViewById(R.id.editText2);

      Bundle extras = getIntent().getExtras();
      if (extras != null)
      {
         String address = extras.getString("address");
         String message = extras.getString("message");
      }
   }
}