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
import cl.ucn.disc.dsm.charlie.p2pchat.entities.Conversation;
import cl.ucn.disc.dsm.charlie.p2pchat.room.ChatUserDao;
import cl.ucn.disc.dsm.charlie.p2pchat.room.ConversationDao;
import cl.ucn.disc.dsm.charlie.p2pchat.room.MessageDao;
import java.util.List;

/**
 * The Repository class to comunicate the DB with Conversation in the app.
 *
 * @author Charlie Condorcet.
 */
public class ConversationRepository {

  /**
   * The ConversationDao.
   */
  private ConversationDao mConversationDao;

  /**
   * The List with all Conversation.
   */
  private List<Conversation> mAllConversations;

  // The constructor to ConversationRepository.
  public ConversationRepository(Application application) {
    ProyectRoomDatabase db = ProyectRoomDatabase.getDatabase(application);
    this.mConversationDao = (ConversationDao) db.conversationDao();

    this.mAllConversations = this.mConversationDao.getAllConversation();

  }

  // Return the List with all Conversations.
  public List<Conversation> getAllConversations() {
    return mAllConversations;
  }


  // Apply the insert function to add a Conversation.
  public void insertConversation(Conversation conversation) {
    ProyectRoomDatabase.databaseWriteExecutor.execute(() -> {
      this.mConversationDao.insert(conversation);
    });
  }
}
