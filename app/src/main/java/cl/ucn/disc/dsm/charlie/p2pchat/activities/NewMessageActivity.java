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
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import cl.ucn.disc.dsm.charlie.p2pchat.R;

public class NewMessageActivity extends AppCompatActivity {

  public static final String EXTRA_REPLY = "com.example.android.messagelistsql.REPLY";

  private EditText mEditMessageView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_new_message);

    mEditMessageView = findViewById(R.id.edit_message);

    final Button button = findViewById(R.id.button_save);
    button.setOnClickListener(new View.OnClickListener() {
      public void onClick(View view) {
        Intent replyIntent = new Intent();
        if (TextUtils.isEmpty(mEditMessageView.getText())) {
          setResult(RESULT_CANCELED, replyIntent);
        } else {
          String message = mEditMessageView.getText().toString();
          replyIntent.putExtra(EXTRA_REPLY, message);
          setResult(RESULT_OK, replyIntent);
        }
        finish();
      }
    });
  }

  public void backToConversation(View view){
    Intent intent=new Intent(this, MainActivity.class);
    startActivity(intent);
  }

}
