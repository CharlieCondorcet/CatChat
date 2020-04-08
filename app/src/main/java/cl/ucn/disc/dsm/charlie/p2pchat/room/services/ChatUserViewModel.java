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
import androidx.lifecycle.LiveData;
import cl.ucn.disc.dsm.charlie.p2pchat.entities.ChatUser;
import cl.ucn.disc.dsm.charlie.p2pchat.entities.Message;
import cl.ucn.disc.dsm.charlie.p2pchat.room.database.ChatUserRepository;
import cl.ucn.disc.dsm.charlie.p2pchat.room.database.MessageRepository;
import java.util.List;

/**
 * The ChatUserViewModel class to comunicate the UI with the repository.
 *
 * @author Charlie Condorcet.
 */
public class ChatUserViewModel extends AndroidViewModel {

  /**
   * The repository created to get a ChatUser entity.
   */
  private ChatUserRepository chatUserRepository;

  /**
   * All ChatUsers instanced in this ViewModel to send to Activity.
   */
  private List<ChatUser> chatUsers;

  // ViewModel constructor to get the ChatUser entity.
  public ChatUserViewModel(Application application){
    super(application);
    this.chatUserRepository=new ChatUserRepository(application);
    this.chatUsers=this.chatUserRepository.getAllChatUsers();
  }

  //method get from return all ChatUsers in repository.
  public List<ChatUser> getAllChatUsers() { return chatUsers; }

  //add a new ChatUser in the repository.
  public void insert(ChatUser chatUser) { chatUserRepository.insertChatUser(chatUser); }

}
