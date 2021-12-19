package nl.milanlangeleryoungtravel;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Main
 */
public class Main{

	/**
	 * Start of main program
	 *
	 * @param args possible arguments
	 */
	public static void main(String[] args){
		// create the graph and populate it
		Graph graph = new Graph();
		Feeder feeder = new Feeder();
		feeder.populate(graph);

		// needed for reading input
		Scanner scanner = new Scanner(System.in);
		while(true){
			// print some greetings
			System.out.print("\n\n\n");
			System.out.println("===================================================================================");
			System.out.println("WELKOM BIJ YOUNG TRAVEL NEXT, HOE KUNNEN WE U HELPEN?");
			System.out.println("===================================================================================");
			System.out.println("Waar vandaan wil je vertrekken?");
			// read input and make a Node from it so it can be checked whether this city exists
			String cityFrom = scanner.nextLine();
			cityFrom = capitalize(cityFrom);
			Node from = new Node(cityFrom);
			if(graph.containsKey(from)){
				// when city exists ask the folowup question where to go and check that also
				System.out.println("Waar wil je heen?");

				String cityTo = scanner.nextLine();
				cityTo = capitalize(cityTo);
				Node to = new Node(cityTo);
				if(graph.containsKey(to)){
					// if both cities exist create the navigator and start it
					Navigator navigator = new Navigator(new Node(cityFrom), new Node(cityTo), graph);
					Node endPoint = navigator.determineRoute();

					if(endPoint.getName() != "Timboektoe"){
						// if route is possible print it in readable form
						System.out.print("\nDe reis gaat " + printTime(endPoint.getTotalTime()) + "duren");
						if(endPoint.getRoute().size() > 1){
							System.out.print(" waarvoor je " + (endPoint.getRoute().size() - 1) + " keer moet overstappen\n");
						}
						// next round?
						navigator.printRoute(endPoint.getRoute());
						System.out.println("Druk op enter om een nieuwe route te plannen");
						scanner.nextLine();
						// if route was not possible
					} else{
						System.out.println("Geen route gevonden naar bestemming");
						System.out.println("Druk op enter om het opnieuw te proberen");
						scanner.nextLine();
					}
				} else{
					System.out.println("Geen bestemming gevonden voor route");
					System.out.println("Druk op enter om het opnieuw te proberen");
					scanner.nextLine();
				}

			} else{
				System.out.println("Stad niet gevonden!");
				System.out.println("Druk op enter om het opnieuw te proberen");
				scanner.nextLine();
			}
		}
	}


	/**
	 * convert minutes to hours in a consistently nice way
	 *
	 * @param minutes
	 * @return String of hours and minutes split up
	 */
	public static String printTime(int minutes){
		if(minutes < 60){
			return minutes + (minutes < 2 ? " minuut " : " minuten ");
		}
		if(minutes % 60 == 0){
			return minutes / 60 + " uur ";
		}
		int hours = (int) Math.floor(minutes / 60);
		minutes = minutes % 60;
		return hours + " uur en " + minutes + (minutes < 2 ? " minuut " : " minuten ");
	}

	/**
	 * For lazy and capitalization errors
	 *
	 * @param city
	 * @return String with city name capitalized correctly
	 */
	public static String capitalize(String city){
		if(city == null || city.isEmpty()){
			return city;
		}
		// first lowercase the whole string then right it via regex
		city = city.toLowerCase();
		return Pattern.compile("\\b(.)(.*?)\\b")
				.matcher(city)
				.replaceAll(match -> match.group(1).toUpperCase() + match.group(2));
	}


}
