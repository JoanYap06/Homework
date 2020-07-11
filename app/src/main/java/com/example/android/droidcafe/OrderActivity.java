/*
 * Copyright (C) 2018 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.droidcafe;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * This activity shows the order chosen.  The order is sent as data
 * with the intent to launch this activity.
 */
public class OrderActivity extends AppCompatActivity {
    ArrayList<String> selection = new ArrayList<String>();
    TextView final_text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        final_text = (TextView) findViewById(R.id.final_result);
        final_text.setEnabled(false);

        // Get the intent and its data.
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView = findViewById(R.id.order_textview);
        textView.setText(message);

    }

    public void onCheckBoxClicked(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        switch (view.getId()) {

            case R.id.ch1:

                if (checked) {
                    selection.add("Chocolate syrup");
                }
                else{
                    selection.remove("Chocolate syrup");
                }
                break;

            case R.id.ch2:

                if (checked) {
                    selection.add("Sprinkles");
                }
                else{
                    selection.remove("Sprinkles");
                }
                break;

            case R.id.ch3:

                if (checked) {
                    selection.add("Crushed nuts");
                }
                else{
                    selection.remove("Crushed nuts");
                }
                break;

            case R.id.ch4:

                if (checked) {
                    selection.add("Orio cookies crumbles");
                }
                else{
                    selection.remove("Orio cookies crumbles");
                }
                break;

            case R.id.ch5:

                if (checked) {
                    selection.add("Cherries");
                }
                else{
                    selection.remove("Cherries");
                }
                break;

        }
    }

    public void onButtonClicked(View view) {
        String Toast_button = "Toppings:";

        for (String Selections : selection)
        {

            Toast_button = Toast_button + Selections;

        }
        final_text.setText(Toast_button);
        final_text.setEnabled(true);
    }




    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
    }


    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked.
        switch (view.getId()) {
            case R.id.sameday:
                if (checked)
                    // Same day service
                    displayToast(getString(R.string.same_day_text));
                break;
            case R.id.nextday:
                if (checked)
                    // Next day delivery
                    displayToast(getString(R.string.next_day_text));
                break;
            case R.id.pickup:
                if (checked)
                    // Pick up
                    displayToast(getString(R.string.pick_up_text));
                break;
            default:
                // Do nothing.
                break;
        }
    }

}

