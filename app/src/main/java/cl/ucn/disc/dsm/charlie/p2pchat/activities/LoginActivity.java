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

  //The ViewModel to ChatUser.
  private ChatUserViewModel mChatUserViewModel;

  // Main parameters to identify the ChatUser.
  private EditText email_login;
  private EditText password_login;
  private Button btn_login;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);

    this.email_login = (EditText) findViewById(R.id.et_e_login_email);
    this.password_login = (EditText) findViewById(R.id.et_p_login_password);

  }

  // Temporary connection (in terms of structure) to change activity to RegisterActivity.
  public void startRegister(View view) {
    Intent intent = new Intent(this, RegisterActivity.class);
    startActivity(intent);
  }

  // Temporary connection (in terms of structure) to change activity to MainActivity.
  public void startConversation(View view) {
    Intent intent = new Intent(this, MainActivity.class);
    startActivity(intent);
  }

  public void verifyAccount(View view, List<ChatUser> usersInLogin) {

    String str_email = email_login.getText().toString();
    String str_pass = password_login.getText().toString();

    for (int i = 0; i < usersInLogin.size(); i++) {
      try{
        if (str_email.equals(usersInLogin.get(i).getEmail()) && str_pass
            .equals(usersInLogin.get(i).getPassword())) {
          Toast.makeText(this , "cuenta verificada!", Toast.LENGTH_SHORT).show();
          startConversation(view);
        } else {
          Toast.makeText(this, "el correo proporcionado o la contrasenia no se reconocen!", Toast.LENGTH_SHORT).show();
        }
      }catch (Exception e){
        log.warn("la cuenta no ha podido ser verificada: {}",e.getMessage());
      }

    }

  }

}



