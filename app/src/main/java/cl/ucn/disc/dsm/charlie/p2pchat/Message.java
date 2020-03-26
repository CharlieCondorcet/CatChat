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

import androidx.room.Entity;
import java.time.LocalDateTime;

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
  private final int IdMessage;

  /**
   * The Text.
   */
  private final String Text;

  /**
   * The Created.
   */
  private final LocalDateTime Created;

  /**
   * The Latitude.
   */
  private final String Latitude;

  /**
   * The Longitude.
   */
  private final String Longitude;

  /**
   * The ErrorData.
   */
  private final int ErrorData;

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
  public Message(int id_Message, String text, LocalDateTime created, String latitude,
      String longitude, int errorData) {
    IdMessage = id_Message;
    Text = text;
    Created = created;
    Latitude = latitude;
    Longitude = longitude;
    ErrorData = errorData;
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
  public LocalDateTime getCreated() {
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
  public int getErrorData() {
    return ErrorData;
  }

}
