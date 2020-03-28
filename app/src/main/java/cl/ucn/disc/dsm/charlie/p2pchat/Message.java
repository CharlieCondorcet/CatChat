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

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Dao;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import java.sql.DatabaseMetaData;
import java.time.LocalDateTime;
import java.util.Date;



/**
 * The Message class like a Entity.
 *
 * @author Charlie Condorcet.
 */
@Entity(tableName = "message_table")
public class Message {

  /**
   * The IdMessage.
   */
  @PrimaryKey
  @NonNull
  @ColumnInfo(name="message")
  private int IdMessage;

  /**
   * The Text.
   */
  private String Text;

  /**
   * The Created.
   */
  private Date Created;

  /**
   * The Latitude.
   */
  private String Latitude;

  /**
   * The Longitude.
   */
  private String Longitude;

  /**
   * The ErrorData.
   */
  private int ErrorData;

  /**
   * The Constructor.
   *
   * @param IdMessage.
   * @param Text.
   * @param Created.
   * @param Latitude.
   * @param Longitude.
   * @param ErrorData.
   */
  public Message(int IdMessage, String Text, Date Created, String Latitude,
      String Longitude, int ErrorData) {
    this.IdMessage = IdMessage;
    this.Text = Text;
    this.Created = Created;
    this.Latitude = Latitude;
    this.Longitude = Longitude;
    this.ErrorData = ErrorData;
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
   * @return The Latitude.
   */
  public String getLatitude() {
    return Latitude;
  }

  /**
   * @return The Longitude.
   */
  public String getLongitude() {
    return Longitude;
  }

  /**
   * @return The ErrorData.
   */
  public int getErrorData() { return ErrorData; }


  public void setIdMessage(int idMessage) {
    IdMessage = idMessage;
  }

  public void setText(String text) {
    Text = text;
  }

  public void setCreated(Date created) {
    Created = created;
  }

  public void setLatitude(String latitude) {
    Latitude = latitude;
  }

  public void setLongitude(String longitude) {
    Longitude = longitude;
  }

  public void setErrorData(int errorData) {
    ErrorData = errorData;
  }
}
