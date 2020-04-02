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

package cl.ucn.disc.dsm.charlie.p2pchat.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * The User class.
 *
 * @author Charlie Condorcet.
 */
@Entity(tableName = "chat_user_table")
public class ChatUser {

  /**
   * The Name.
   */
  private String Name;

  /**
   * The Id.
   */
  @PrimaryKey
  @NonNull
  @ColumnInfo(name = "chat_user")
  private int Id;

  /**
   * The Email.
   */
  private String Email;

  /**
   * The Password.
   */
  private String Password;

  /**
   * The Constructor.
   *
   * @param Name.
   * @param Id.
   * @param Email.
   * @param Password.
   */
  public ChatUser(String Name, int Id, String Email, String Password) {
    this.Name = Name;
    this.Id = Id;
    this.Email = Email;
    this.Password = Password;
  }

  /**
   * @return The Name.
   */
  public String getName() {
    return Name;
  }

  /**
   * @return The Id.
   */
  public int getId() {
    return Id;
  }

  /**
   * @return The Email.
   */
  public String getEmail() {
    return Email;
  }

  /**
   * @return The Password.
   */
  public String getPassword() {
    return Password;
  }

  /**
   * @param name.
   */
  public void setName(String name) { Name = name; }

  /**
   * @param id.
   */
  public void setId(int id) { Id = id; }

  /**
   * @param email.
   */
  public void setEmail(String email) { Email = email; }

  /**
   * @param password.
   */
  public void setPassword(String password) { Password = password; }

}
