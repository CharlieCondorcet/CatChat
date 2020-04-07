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

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

import android.content.Context;
import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import cl.ucn.disc.dsm.charlie.p2pchat.entities.ChatUser;
import cl.ucn.disc.dsm.charlie.p2pchat.entities.Message;
import cl.ucn.disc.dsm.charlie.p2pchat.room.ChatUserDao;
import cl.ucn.disc.dsm.charlie.p2pchat.room.MessageDao;
import cl.ucn.disc.dsm.charlie.p2pchat.room.database.ProyectRoomDatabase;
import java.util.Date;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Test of {@link cl.ucn.disc.dsm.charlie.p2pchat.room.ChatUserDao}.
 *
 * @author Charlie Condorcet.
 */
@RunWith(AndroidJUnit4.class)
public class ChatUserDaoTest {

  @Rule
  public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

  private ChatUserDao mChatUserDao;
  private ProyectRoomDatabase mDb;

  @Before
  public void createDb() {
    Context context = ApplicationProvider.getApplicationContext();
    // Using an in-memory database because the information stored here
    // disappears when the process is killed.
    mDb = Room.inMemoryDatabaseBuilder(context, ProyectRoomDatabase.class)
        // Allowing main thread queries, just for testing.
        .allowMainThreadQueries()
        .build();
    mChatUserDao = mDb.chatUserDao();
  }

  @After
  public void closeDb() {
    mDb.close();
  }

  // Test that chatUsers can be added to a list in a newly created database.
  @Test
  public void insertAndGetMessage() throws Exception {
    ChatUser user1 = new ChatUser(
        "Goya",
        "Francisco@Goya.com",
        "ElAquelarre1798");
    mChatUserDao.insert(user1);

    List<ChatUser> allChatUsers = mChatUserDao.getAlphabetizedChatUsers();

    // Newly added message at the start of the new list.
    assertEquals(allChatUsers.get(0).getEmail(), user1.getEmail());
  }

  // Test to prove that the recovery of all ChatUsers is correct.
  @Test
  public void getAllChatUsers() throws Exception {
    ChatUser user1 = new ChatUser(
        "Camila",
        "novacunes@tuhijo.cl",
        "HolaHola123");
    mChatUserDao.insert(user1);

    ChatUser user2 = new ChatUser(
        "Michael",
        "notengocorreo@gmail.com",
        "987654321abC");
    mChatUserDao.insert(user2);

    List<ChatUser> allChatUsers = mChatUserDao.getAlphabetizedChatUsers();

    // The retrieval of messages by position is equal to the input of ChatUsers
    // in the same position.
    assertEquals(allChatUsers.get(0).getEmail(), user1.getEmail());
    assertEquals(allChatUsers.get(1).getEmail(), user2.getEmail());
  }

  // Test to test the deletion of all ChatUsers that are created in the
  // temporary database.
  @Test
  public void deleteAll() throws Exception {
    ChatUser user1 = new ChatUser(
        "Camila",
        "novacunes@tuhijo.cl",
        "HolaHola123");
    mChatUserDao.insert(user1);

    ChatUser user2 = new ChatUser(
        "Michael",
        "notengocorreo@gmail.com",
        "987654321abC");
    mChatUserDao.insert(user2);

    mChatUserDao.deleteAll();
    List<ChatUser> allChatUsers = mChatUserDao.getAlphabetizedChatUsers();

    // it is verified that the list is empty after applying the elimination order.
    assertTrue(allChatUsers.isEmpty());
  }
}
