package cl.ucn.disc.dsm.charlie.p2pchat;

import java.time.LocalDateTime;

public class Message {

    private final int Id_Mess;
    private final String Text;
    private final LocalDateTime Created;
    private final String Latitude;
    private final String Longitude;
    private final int Error;

    public Message(int id_Mess, String text, LocalDateTime created, String latitude,
        String longitude, int error) {
        Id_Mess = id_Mess;
        Text = text;
        Created = created;
        Latitude = latitude;
        Longitude = longitude;
        Error = error;
    }

    public int getId_Mess() {
        return Id_Mess;
    }

    public String getText() {
        return Text;
    }

    public LocalDateTime getCreated() {
        return Created;
    }

    public String getLatitude() {
        return Latitude;
    }

    public String getLongitude() {
        return Longitude;
    }

    public int getError() {
        return Error;
    }
}
