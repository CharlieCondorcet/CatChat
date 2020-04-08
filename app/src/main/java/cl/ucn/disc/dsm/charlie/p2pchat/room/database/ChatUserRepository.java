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
import cl.ucn.disc.dsm.charlie.p2pchat.entities.ChatUser;
import cl.ucn.disc.dsm.charlie.p2pchat.room.ChatUserDao;
import cl.ucn.disc.dsm.charlie.p2pchat.room.ConversationDao;
import cl.ucn.disc.dsm.charlie.p2pchat.room.MessageDao;
import java.util.List;

/**
 * The Repository class to comunicate the DB with ChatUser in the app.
 *
 * @author Charlie Condorcet.
 */
public class ChatUserRepository {

  /**
   * The ChatUserDao.
   */
  private ChatUserDao mChatUserDao;

  /**
   * The List with all ChatUsers.
   */
  private List<ChatUser> mAllChatUsers;

  // The constructor to ChatUserRepository.
  public ChatUserRepository(Application application) {
    ProyectRoomDatabase db = ProyectRoomDatabase.getDatabase(application);
    this.mChatUserDao = (ChatUserDao) db.chatUserDao();
    this.mAllChatUsers = this.mChatUserDao.getAlphabetizedChatUsers();
  }

  // Return the List with all ChatUsers.
  public List<ChatUser> getAllChatUsers() {
    return mAllChatUsers;
  }

  // Apply the insert function to add a ChatUser.
  public void insertChatUser(ChatUser chatUser) {
    ProyectRoomDatabase.databaseWriteExecutor.execute(() -> {
      this.mChatUserDao.insert(chatUser);
    });
  }

}
