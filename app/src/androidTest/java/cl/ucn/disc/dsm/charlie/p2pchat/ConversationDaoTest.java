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
import cl.ucn.disc.dsm.charlie.p2pchat.entities.Conversation;
import cl.ucn.disc.dsm.charlie.p2pchat.room.ChatUserDao;
import cl.ucn.disc.dsm.charlie.p2pchat.room.ConversationDao;
import cl.ucn.disc.dsm.charlie.p2pchat.room.database.ProyectRoomDatabase;
import java.io.Console;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Charlie Condorcet.
 */
@RunWith(AndroidJUnit4.class)
public class ConversationDaoTest {

  @Rule
  public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

  private ConversationDao mConversationDao;
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
    mConversationDao = mDb.conversationDao();
  }

  @After
  public void closeDb() {
    mDb.close();
  }

  // Test that Conversation can be added to a list in a newly created database.
  @Test
  public void insertAndGetMessage() throws Exception {
    Conversation conversation1 = new Conversation(
        4,
        1);
    mConversationDao.insert(conversation1);

    List<Conversation> allConversations = mConversationDao.getAllConversation();

    // Newly added conversation at the start of the new list.
    assertEquals(allConversations.get(0).getIdConversation(), conversation1.getIdConversation());
  }

  // Test to prove that the recovery of all Conversation is correct.
  @Test
  public void getAllChatUsers() throws Exception {
    Conversation conversation1 = new Conversation(
        4,
        1);
    mConversationDao.insert(conversation1);

    Conversation conversation2 = new Conversation(
        1,
        3);
    mConversationDao.insert(conversation2);

    List<Conversation> allConversations = mConversationDao.getAllConversation();

    // The retrieval of conversation by position is equal to the input of
    // Conversations list in the same position.
    assertEquals(allConversations.get(0).getIdFirstUser(), conversation1.getIdFirstUser());
    assertEquals(allConversations.get(1).getIdSecondUser(), conversation2.getIdSecondUser());
  }

  // Test to test the deletion of all Conversation that are created in the
  // temporary database.
  @Test
  public void deleteAll() throws Exception {
    Conversation conversation1 = new Conversation(
        4,
        1);
    mConversationDao.insert(conversation1);

    Conversation conversation2 = new Conversation(
        1,
        3);
    mConversationDao.insert(conversation2);

    mConversationDao.deleteAll();
    List<Conversation> allConversations = mConversationDao.getAllConversation();

    // it is verified that the list is empty after applying the elimination order.
    assertTrue(allConversations.isEmpty());
  }

}
