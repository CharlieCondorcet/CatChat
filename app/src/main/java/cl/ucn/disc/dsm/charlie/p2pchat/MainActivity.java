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

package cl.ucn.disc.dsm.charlie.p2pchat;

import android.app.Activity;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import javax.annotation.meta.When;

/**
 * The principal Activity.
 *
 * @author Charlie Condorcet.
 */
public class MainActivity extends AppCompatActivity {

  private MessageViewModel mMessageViewModel;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    //Show the data in the recycler view.
    RecyclerView recyclerView = findViewById(R.id.recyclerview);
    final MessageListAdapter adapter = new MessageListAdapter(this);
    recyclerView.setAdapter(adapter);
    recyclerView.setLayoutManager(new LinearLayoutManager(this));

    //When your Activity first starts, the ViewModelProviders will create the ViewModel
    mMessageViewModel = new ViewModelProvider(this).get(MessageViewModel.class);

    // add an observer for the LiveData returned by getAlphabetizedMessages().
    //The onChanged() method fires when the observed data changes and the activity is in the foreground.
    mMessageViewModel.getAllMessages().observe(this, new Observer<List<Message>>() {
      @Override
      public void onChanged(@Nullable final List<Message> messages) {
        // Update the cached copy of the words in the adapter.
        adapter.setMessages(messages);
      }
    });

  }
}


