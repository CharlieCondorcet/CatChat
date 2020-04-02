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
import cl.ucn.disc.dsm.charlie.p2pchat.entities.Conversation;
import cl.ucn.disc.dsm.charlie.p2pchat.entities.Message;
import cl.ucn.disc.dsm.charlie.p2pchat.room.database.ProyectRepository;
import java.util.List;

/**
 * the MessageViewModel class to comunicate the UI with the repository.
 *
 * @author Charlie Condorcet.
 */
public class ProyectViewModel extends AndroidViewModel {

  /**
   * Unique repository of the proyect to create and get entities.
   */
  private final ProyectRepository mRepository;

  /**
   * All Messages instanced in this ModelView to send to Activity.
   */
  private LiveData<List<Message>> mAllMessages;

  /**
   * All ChatUsers instanced in this ModelView to send to Activity.
   */
  private List<ChatUser> mAllChatUsers;

  /**
   * All Conversations instanced in this ModelView to send to Activity.
   */
  private List<Conversation> mAllConversations;


  //ChatDisc ViewModel constructor to get all entities added.
  public ProyectViewModel(Application application) {
    super(application);
    mRepository = new ProyectRepository(application);
    this.mAllMessages = mRepository.getmAllMessages();
    this.mAllChatUsers = mRepository.getAllChatUsers();
    this.mAllConversations = mRepository.getAllConversations();
  }

  //method get from return all Messages in repository.
  public LiveData<List<Message>> getAllMessages() { return mAllMessages; }

  //method get from return all ChatUsers in repository.
  public List<ChatUser> getAllChatUsers() { return this.mAllChatUsers; }

  //method get from return all Conversations in repository.
  public List<Conversation> getmAllConversations() { return mAllConversations; }

  //add a new Message in the repository.
  public void insertMessage(Message message) { mRepository.insertMessage(message); }

  //add a new ChatUser in the repository.
  public void insertChatUser(ChatUser chatUser) { mRepository.insertChatUser(chatUser); }

  //add a new Message in the repository.
  public void inserConversation(Conversation conversation) { mRepository.insertConversation(conversation);}
}
