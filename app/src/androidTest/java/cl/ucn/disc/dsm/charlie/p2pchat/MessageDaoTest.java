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
import androidx.room.RoomDatabase;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import cl.ucn.disc.dsm.charlie.p2pchat.entities.Message;
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
 * Test of {@link cl.ucn.disc.dsm.charlie.p2pchat.room.MessageDao}.
 *
 * @author Charlie Condorcet.
 */
@RunWith(AndroidJUnit4.class)
public class MessageDaoTest {

  @Rule
  public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

  private MessageDao mMessageDao;
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
    mMessageDao = mDb.messageDao();
  }

  @After
  public void closeDb() {
    mDb.close();
  }

  // Test that messages can be added to a list in a newly created database.
  @Test
  public void insertAndGetMessage() throws Exception {
    Date date=new Date();
    Message message = new Message(
        "A new message inserted to Test",
        date);
    mMessageDao.insert(message);
    List<Message> allMessages = LiveDataTestUtil.
        getValue(mMessageDao.getAlphabetizedMessages());

    // Newly added message at the start of the new list.
    assertEquals(allMessages.get(0).getText(), message.getText());
  }

  // Test to prove that the recovery of all Messages is correct.
  @Test
  public void getAllMessages() throws Exception {
    Date date=new Date();
    Message message1 = new Message(
        "first time trying to return all messages",
        date);
    mMessageDao.insert(message1);

    date=new Date();
    Message message2 = new Message(
        "second time trying to return all messages",
        date);
    mMessageDao.insert(message2);

    List<Message> allMessages = LiveDataTestUtil.
        getValue(mMessageDao.getAlphabetizedMessages());

    // The retrieval of messages by position is equal to the input of messages
    // in the same position.
    assertEquals(allMessages.get(0).getText(), message1.getText());
    assertEquals(allMessages.get(1).getText(), message2.getText());
  }

  // Test to test the deletion of all Messages that are created in the
  // temporary database.
  @Test
  public void deleteAll() throws Exception {
    Date date=new Date();
    Message message1 = new Message(
        "first time trying to delete all messages",
        date);
    mMessageDao.insert(message1);

    date=new Date();
    Message message2 = new Message(
        "second time trying to delete all messages",
        date);
    mMessageDao.insert(message2);
    mMessageDao.deleteAll();
    List<Message> allMessages = LiveDataTestUtil.
        getValue(mMessageDao.getAlphabetizedMessages());

    // it is verified that the list is empty after applying the elimination order.
    assertTrue(allMessages.isEmpty());
  }
}