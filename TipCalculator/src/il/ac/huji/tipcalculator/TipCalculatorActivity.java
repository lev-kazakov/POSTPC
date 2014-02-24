package il.ac.huji.tipcalculator;

import java.text.DecimalFormat;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class TipCalculatorActivity extends Activity {

	public static final double TIP_PERCENT = 0.12;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    /** Called when the user clicks the Calculate button */
    public void calcTip(View view) {
         EditText billAmount = (EditText) findViewById(R.id.edtBillAmount);
         TextView tipResult = (TextView) findViewById(R.id.txtTipResult);
         
         double bill;
         try {
        	 bill = Double.parseDouble(billAmount.getText().toString());
         } catch (NumberFormatException e) {
        	 bill = 0;
         }
         
         double tip = bill*TIP_PERCENT;
         
         String format = "#.##";
         
         if( ((CheckBox) findViewById(R.id.chkRound)).isChecked() ) {
        	 	format = "#";
         }
         
         DecimalFormat df = new DecimalFormat(format);
         
         tipResult.setText("Tip: $" + df.format(tip));
    }
    
}