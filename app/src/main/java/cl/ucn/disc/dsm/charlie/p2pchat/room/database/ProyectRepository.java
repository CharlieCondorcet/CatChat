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

package cl.ucn.disc.dsm.charlie.p2pchat.room.database;

import android.app.Application;
import androidx.lifecycle.LiveData;
import cl.ucn.disc.dsm.charlie.p2pchat.entities.ChatUser;
import cl.ucn.disc.dsm.charlie.p2pchat.entities.Conversation;
import cl.ucn.disc.dsm.charlie.p2pchat.entities.Message;
import cl.ucn.disc.dsm.charlie.p2pchat.room.ChatUserDao;
import cl.ucn.disc.dsm.charlie.p2pchat.room.ConversationDao;
import cl.ucn.disc.dsm.charlie.p2pchat.room.MessageDao;
import java.util.List;
import javax.xml.transform.Transformer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Repository class to comunicate the DB with the application interface.
 *
 * @author Charlie Condorcet.
 */
public class ProyectRepository {

  /**
   * The MessagenDao.
   */
  private MessageDao mMessagedDao;

  /**
   * The List LiveDAta with all Messages.
   */
  private LiveData<List<Message>> mAllMessages;

  /**
   * The ChatUserDao.
   */
  private ChatUserDao mChatUserDao;

  /**
   * The List with all ChatUsers.
   */
  private List<ChatUser> mAllChatUsers;

  /**
   * The ConversationDao.
   */
  private ConversationDao mConversation;

  /**
   * The List with all Conversation.
   */
  private List<Conversation> mAllConversations;

  /**
   * The logger.
   */
  private static final Logger log = LoggerFactory.getLogger(Transformer.class);

  // Note that in order to unit test the WordRepository, you have to remove the Application
  // dependency. This adds complexity and much more code, and this sample is not about testing.
  // See the BasicSample in the android-architecture-components repository at
  // https://github.com/googlesamples
  public ProyectRepository(Application application) {
    ProyectRoomDatabase db = ProyectRoomDatabase.getDatabase(application);
    this.mMessagedDao = (MessageDao) db.messageDao();

    //FIXME: mAllChatUsers and mAllConversations cannot be inicialized.
    try {
      this.mAllMessages = this.mMessagedDao.getAlphabetizedMessages();
      this.mAllChatUsers = this.mChatUserDao.getAlphabetizedChatUsers();
      this.mAllConversations = this.mConversation.getAllConversation();

      log.info("All parameter of Repository initialized correctly!");
    } catch (NullPointerException e) {
      log.warn("Method getAll% return Null values, uninitialized parameters: {}",e);
    }
  }

  // Room executes all queries on a separate thread.
  // Observed LiveData will notify the observer when the data has changed.
  public LiveData<List<Message>> getmAllMessages() {
    return this.mAllMessages;
  }

  //Return the List with all ChatUsers.
  public List<ChatUser> getAllChatUsers() {
    return mAllChatUsers;
  }

  //Return the List with all Conversations.
  public List<Conversation> getAllConversations() {
    return mAllConversations;
  }


  // You must call this on a non-UI thread or your app will throw an exception. Room ensures
  // that you're not doing any long running operations on the main thread, blocking the UI.
  public void insertMessage(Message message) {
    ProyectRoomDatabase.databaseWriteExecutor.execute(() -> {
      this.mMessagedDao.insert(message);
    });
  }

  //Apply the insert function to add a ChatUser.
  public void insertChatUser(ChatUser chatUser) {
    ProyectRoomDatabase.databaseWriteExecutor.execute(() -> {
      this.mChatUserDao.insert(chatUser);
    });
  }

  //Apply the insert function to add a Conversation.
  public void insertConversation(Conversation conversation) {
    ProyectRoomDatabase.databaseWriteExecutor.execute(() -> {
      this.mConversation.insert(conversation);
    });
  }

}
