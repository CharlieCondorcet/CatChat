/*
 * MIT License
 *
 * Copyright (c) 2020 CharlieCondorcet
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package cl.ucn.disc.dsm.charlie.p2pchat.activities;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import cl.ucn.disc.dsm.charlie.p2pchat.R;
import cl.ucn.disc.dsm.charlie.p2pchat.entities.ChatUser;
import cl.ucn.disc.dsm.charlie.p2pchat.room.services.ChatUserViewModel;
import java.util.ArrayList;
import java.util.List;
import javax.xml.transform.Transformer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class LoginActivity extends AppCompatActivity {

  // The logger.
  private static final Logger log = LoggerFactory.getLogger(Transformer.class);

  // Main parameters to identify the ChatUser.
  private EditText email_login;
  private EditText password_login;
  private Button btn_login;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);

    //TODO: Get the total user list from the database.
    //FIX: The ViewModel cannot be called to instantiate the list with all ChatUser.

    this.email_login = (EditText) findViewById(R.id.et_e_login_email);
    this.password_login = (EditText) findViewById(R.id.et_p_login_password);

  }

  // Temporary connection (in terms of structure) to change activity to RegisterActivity.
  public void startRegister(View view) {
    Intent intent = new Intent(this, RegisterActivity.class);

    /*
    String actualEmail;
    String actualPass;

    if(!email_login.getText().toString().isEmpty()){
      actualEmail=email_login.getText().toString();
      actualPass=password_login.getText().toString();
      intent.putExtra("EmailFromLogin",actualEmail);
      intent.putExtra("PassFromLogin",actualPass);
    }
     */

    startActivity(intent);
  }

  // Temporary connection (in terms of structure) to change activity to MainActivity.
  public void startConversation(View view) {

    Intent intent = new Intent(this, MainActivity.class);
    startActivity(intent);
  }

  // Method to verify that the data entered in LoginActivity exist.
  public void verifyAccount(View view, List<ChatUser> usersInLogin) {
    String str_email = email_login.getText().toString();
    String str_pass = password_login.getText().toString();

    int hash_email = str_email.hashCode();
    int hash_pass = str_pass.hashCode();

    for (int i = 0; i < usersInLogin.size(); i++) {
      try {
        // Compare data via hash.
        if (hash_email == (usersInLogin.get(i).getEmail().hashCode()) && hash_pass == (usersInLogin
            .get(i).getPassword().hashCode())) {
          Toast.makeText(this, "Account verified successfully!", Toast.LENGTH_SHORT).show();
          startConversation(view);
        } else {
          Toast.makeText(this, "The email provided or the password is not recognized!",
              Toast.LENGTH_SHORT).show();
        }
      } catch (Exception e) {
        log.warn("The account could not be verified: {}", e.getMessage());
      }
    }
  }


}



