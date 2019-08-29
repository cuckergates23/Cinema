package app.dto;

public class TicketDTO {
    private int userId;
    private int sessionId;
    private int rowNumber;
    private int placeNumber;
    private int price;

    public TicketDTO(int userId,int sessionId,String placeInStringFormat,int price){
        this.userId=userId;
        this.sessionId = sessionId;
        setPlaceAndRow(placeInStringFormat);
        this.price=price;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    public int getRowNumber() {
        return rowNumber;
    }


    public int getPlaceNumber() {
        return placeNumber;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setPlaceAndRow(String placeInStringFormat){
        String[] place=placeInStringFormat.split("/");
        this.rowNumber=Integer.valueOf(place[0]);
        this.placeNumber=Integer.valueOf(place[1]);
    }
}
