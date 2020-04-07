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
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import cl.ucn.disc.dsm.charlie.p2pchat.R;
import java.util.EmptyStackException;

public class RegisterActivity extends AppCompatActivity {

  // Main parameters to add a new ChatUser.
  private EditText name_register;
  private EditText email_register;
  private EditText password_register;
  private EditText pass_confirm_register;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_registry);

    //TODO: the email and password can be getted by loginActivity.
    // Change the opcion to recept this parameters.
    this.name_register = (EditText) findViewById(R.id.txt_pt_register_user_name);
    this.email_register = (EditText) findViewById(R.id.txt_em_register_email);
    this.password_register = (EditText) findViewById(R.id.txt_p_register_pass);
    this.pass_confirm_register = (EditText) findViewById(R.id.txt_p_register_pass_confirm);

  }

  // Temporary connection (in terms of structure) to change activity to LoginActivity.
  public void BackToLogin(View view) {
    Intent intent = new Intent(this, LoginActivity.class);
    startActivity(intent);
  }

}