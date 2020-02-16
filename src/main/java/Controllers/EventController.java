package Controllers;

import Handlers.HttpHandler;
import Models.Event;
import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class EventController {
    HttpHandler httpHandler = new HttpHandler();

    // Getting all event and storing as list
    public List<Event> getAllEvents() throws IOException, JSONException, ParseException {
        String url = "https://doggavent.herokuapp.com/api/json/events";
        JSONArray eventResponse = new JSONArray(httpHandler.httpGetConnection(url).toString());

        List<Event> eventList = new ArrayList<Event>();
        for (int i = 0; i < eventResponse.length(); i++) {
            int id = eventResponse.getJSONObject(i).getInt("id");
            String eventTitle = eventResponse.getJSONObject(i).getString("eventTitle");
            String eventContent = eventResponse.getJSONObject(i).getString("eventContent");
            eventList.add(new Event(id,eventTitle,eventContent));
        }
        return eventList;
    }


    //Create Event message (not implemented)
    public void createEvent() throws IOException {
        System.out.println("This feature is not implemented yet");
    }

}
