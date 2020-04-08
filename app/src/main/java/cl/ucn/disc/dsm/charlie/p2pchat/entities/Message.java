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
import androidx.room.TypeConverters;
import cl.ucn.disc.dsm.charlie.p2pchat.DateConverter;
import java.util.Date;



/**
 * The Message class like a Entity.
 *
 * @author Charlie Condorcet.
 */
@Entity(tableName = "message_table")
public class Message {

  //TODO: match the primary keys to each other to follow the class diagram.
  /**
   * The IdMessage.
   */
  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name="message")
  private int IdMessage;

  /**
   * The Text.
   */
  private String Text;

  /**
   * The Creation date.
   */
  //Fixed: bug to parse the date to sql format in room with TypeConverter class.
  @TypeConverters(DateConverter.class)
  private Date Created;

  /**
   * The Constructor.
   *
   * @param IdMessage.
   * @param Text.
   * @param Created.
   */
  public Message( String Text, Date Created) {
    this.Text = Text;
    this.Created = Created;
  }

  /**
   * @return The IdMessage.
   */
  public int getIdMessage() {
    return IdMessage;
  }

  /**
   * @return The Text.
   */
  public String getText() {
    return Text;
  }

  /**
   * @return The Created.
   */
  public Date getCreated() {
    return Created;
  }

  /**
   * @param idMessage.
   */
  public void setIdMessage(int idMessage) {
    IdMessage = idMessage;
  }

  /**
   * @param text.
   */
  public void setText(String text) {
    Text = text;
  }

  /**
   * @param created.
   */
  public void setCreated(Date created) {
    Created = created;
  }

}
