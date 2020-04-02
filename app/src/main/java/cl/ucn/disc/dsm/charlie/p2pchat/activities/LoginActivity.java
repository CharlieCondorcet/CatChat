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
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import cl.ucn.disc.dsm.charlie.p2pchat.R;
import cl.ucn.disc.dsm.charlie.p2pchat.entities.ChatUser;
import cl.ucn.disc.dsm.charlie.p2pchat.room.database.ChatUserRepository;
import cl.ucn.disc.dsm.charlie.p2pchat.room.services.ChatUserViewModel;
import cl.ucn.disc.dsm.charlie.p2pchat.room.services.MessageViewModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


public class LoginActivity extends AppCompatActivity {

  private ChatUserViewModel chatUserViewModel;
  private EditText email;
  private EditText password;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);

    this.chatUserViewModel = new ViewModelProvider(this).get(ChatUserViewModel.class);

    this.email = (EditText) findViewById(R.id.et_e_email);
    this.password = (EditText) findViewById(R.id.et_p_password);
  }

  public void verifyAccount(View view) {
    String str_email = this.email.getText().toString();
    String str_pass = this.password.getText().toString();

    List<ChatUser> users = this.chatUserViewModel.getAllChatUsers();

    for (int i = 0; i < users.size(); i++) {
      try{
        if (str_email.equals(users.get(i).getEmail()) && str_pass
            .equals(users.get(i).getPassword())) {
          Toast.makeText(this, "cuenta verificada!", Toast.LENGTH_SHORT).show();
          Intent intent = new Intent(this, MainActivity.class);
          startActivity(intent);
        } else {
          Toast.makeText(this, "el correo proporcionado o la contrasenia no se reconocen!",
              Toast.LENGTH_SHORT).show();
        }
      }catch (Exception e){
        System.console().printf("error: "+e);
      }

    }


  }

}



