// Author: Kaveh Vossoughi
// Date  : 12/12/16
// Homework assignment : Quiz 2
// Objective: This class receive SMSes through Android
// Broadcast Receiver and takes their message bodies and
// the addresses from them. It modifies the appropriate
// field in SmsListener Activity directly.
//******************************************************************
package vossoughi.smsreceiver;

import android.content.*;
import android.os.Bundle;
import android.telephony.SmsMessage;

public class SmsListener extends BroadcastReceiver
{
   //****************************onReceive()****************************
   @Override
   public void onReceive(Context context, Intent intent)
   {
      Bundle bundle = intent.getExtras();

      if (bundle != null)
      {
         Object[] pdus = (Object[]) bundle.get("pdus");

         for (int i = 0; i < pdus.length; i++)
         {
            SmsMessage sms = SmsMessage.createFromPdu((byte[]) pdus[i]);
            String senderNumber = sms.getDisplayOriginatingAddress();

            String message = sms.getDisplayMessageBody();
            SmsReceiverActivity.addressField.setText(senderNumber);
            SmsReceiverActivity.messageField.setText(message);
         }
      }
   }
}