package nl.milanlangeleryoungtravel;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Graph graph = new Graph();
        Feeder feeder = new Feeder();
        feeder.populate(graph);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n\n===================================================================================");
            System.out.println("===================================================================================");
            System.out.println("Waar vandaan?");
            String cityFrom = scanner.nextLine();
            Node from = new Node(cityFrom);
            if (graph.containsKey(from)) {
                System.out.println("Waar wil je heen?");
                String cityTo = scanner.nextLine();
                if (!cityTo.isEmpty() && graph.containsKey(new Node(cityTo))) {
                    Navigator navigator = new Navigator(new Node(cityFrom), new Node(cityTo), graph);
                    Node endPoint = navigator.determineRoute();
                    if (endPoint.getName() != "Timboektoe") {
                        System.out.print("\nDe reis gaat " + printTime(endPoint.getTotalTime()) + "duren");
                        if( endPoint.getRoute().size() > 1 ){
                            System.out.print(" waarvoor je " + (endPoint.getRoute().size()-1) + " keer moet overstappen\n");
                        }
                        navigator.printRoute(endPoint.getRoute());
                    } else {
                        System.out.println("Geen route gevonden naar bestemming");
                    }
                }

            } else {
                System.out.println("Geen bestemming gevonden voor route");
            }
        }

    }

    public static String printTime(int minutes){
        if( minutes < 60 ){
            return minutes + ( minutes < 2 ? " minuut " : " minuten ");
        }
        if(minutes % 60 == 0){
            return minutes / 60 + " uur ";
        }
        int hours = (int) Math.floor(minutes / 60 );
        minutes = minutes % 60;
        return hours + " uur en " + minutes + (minutes < 2 ? " minuut " : " minuten ");
    }


}
