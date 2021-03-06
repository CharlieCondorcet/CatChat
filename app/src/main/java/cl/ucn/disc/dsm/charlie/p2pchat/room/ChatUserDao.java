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

package cl.ucn.disc.dsm.charlie.p2pchat.room;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import cl.ucn.disc.dsm.charlie.p2pchat.entities.ChatUser;
import cl.ucn.disc.dsm.charlie.p2pchat.entities.Message;
import java.util.ArrayList;
import java.util.List;

/**
 * The DAO to ChatUser class.
 *
 * @author Charlie Condorcet.
 */
@Dao
public interface ChatUserDao {

  // Add a new ChatUser.
  @Insert
  void insert(ChatUser chatUser);

  // Delete all Conversations.
  @Query("DELETE FROM chat_user_table")
  void deleteAll();

  // Request all ChatUsers.
  @Query("SELECT * from chat_user_table ORDER BY chat_user ASC")
  List<ChatUser> getAlphabetizedChatUsers();

}
