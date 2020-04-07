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

package cl.ucn.disc.dsm.charlie.p2pchat.room.services;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import cl.ucn.disc.dsm.charlie.p2pchat.entities.ChatUser;
import cl.ucn.disc.dsm.charlie.p2pchat.entities.Conversation;
import cl.ucn.disc.dsm.charlie.p2pchat.room.database.ChatUserRepository;
import cl.ucn.disc.dsm.charlie.p2pchat.room.database.ConversationRepository;
import java.util.List;

/**
 * @author Charlie Condorcet.
 */
public class ConversationViewModel extends AndroidViewModel {

  /**
   * The repository created to get a Conversation entity.
   */
  private ConversationRepository conversationRepository;

  /**
   * All Conversations instanced in this ViewModel to send to Activity.
   */
  private List<Conversation> conversations;

  // ViewModel constructor to get the Conversation entity.
  ConversationViewModel(Application application){
    super(application);
    this.conversationRepository=new ConversationRepository(application);
    this.conversations=this.conversationRepository.getAllConversations();
  }

  //method get from return all Conversations in repository.
  public List<Conversation> getAllConversation() { return this.conversations; }

  //add a new Conversation in the repository.
  public void insert(Conversation conversation) { this.conversationRepository.insertConversation(conversation); }

}
