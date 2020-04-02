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
import cl.ucn.disc.dsm.charlie.p2pchat.room.database.ProyectRepository;
import java.util.List;

/**
 * the MessageViewModel class to comunicate the UI with the repository.
 *
 * @author Charlie Condorcet.
 */
public class ProyectViewModel extends AndroidViewModel {

  //the instance of ProtectRepository.
  private ProyectRepository mRepository;

  //atribute with all Messages of this ViewModel.
  private LiveData<List<Message>> mAllMessages;

  //atribute with all CharUsers of this ViewModel.
  private List<ChatUser> mAllChatUser;

  public ProyectViewModel(Application application) {
    super(application);
    mRepository = new ProyectRepository(application);
    mAllMessages = mRepository.getmAllMessages();
    mAllChatUser = mRepository.getmAllChatUser();
  }


  public LiveData<List<Message>> getAllMessages() {
    return mAllMessages;
  }

  public  List<ChatUser> getmAllChatUser() { return mAllChatUser; }

  //insert into repository a message object.
  public void insert(Message message) {
    mRepository.insert(message);
  }

  //insert into repository a chatuser object.
  public void insert(ChatUser chatUser) { mRepository.insert(chatUser);}

}
