package Controllers;

import Models.Event;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainController {
    EventController eventController = new EventController();
    Scanner scanner = new Scanner(System.in);
    Boolean isRunning;

    // Starting run loop
    public void run() throws IOException, ParseException {
        isRunning = true;
        while (isRunning){
            WelcomeMessage();
            Chooises();
        }
    }

    //Printing welcome message
    public void WelcomeMessage(){
        hash();
        System.out.println("Hello and welcome to doggavent terminal.");
        System.out.println("Press 1 to list all events");
        System.out.println("Press 2 to create new event");
        hash();
    }

    // Giving user chooises
    public void Chooises() throws IOException, ParseException {

        switch (scanner.nextInt()){
            case 1:
                    getEventsChooice();
                break;
            case 2:
                eventController.createEvent();
                break;
        }
    }
    Boolean eventIsrunning;

    // getting events on user input
    public void getEventsChooice() throws IOException, ParseException {
        eventIsrunning = true;
        List<Integer> integerList = new ArrayList<Integer>();

        while (eventIsrunning){
            for (Event e: eventController.getAllEvents()) {
                System.out.println("id: " + e.getId() + " Title: " + e.getEventTitle());
                dashes();
                integerList.add(e.getId());
            }
            getEventById(integerList);
        }
    }

    // getting event on user input
    public void getEventById(List<Integer> integerList) throws IOException, ParseException {
        int currentInt;
        currentInt = scanner.nextInt();
        if (integerList.contains(currentInt)){
            for (Event e : eventController.getAllEvents()) {
                if (e.getId() == currentInt){
                    System.out.println();
                    slashes();
                    System.out.println(e.getEventTitle());
                    System.out.println(e.getEventContent());
                    slashes();
                    System.out.println();
                    eventIsrunning = false;
                }
            }
        }
    }


    //Styling
    public void dashes(){
        System.out.println("------------------------------------------------------------------------------------------------------------------");
    }

    public void slashes(){
        System.out.println("///////////////////////////////////////////////////////////////////////////////////////////////////////////////////");
    }

    public void hash(){
        System.out.println("####################################################################################################################");
    }
}
