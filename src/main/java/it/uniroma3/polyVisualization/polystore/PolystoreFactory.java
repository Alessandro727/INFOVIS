package it.uniroma3.polyVisualization.polystore;

import it.uniroma3.polystoreMain.Polystore;

public class PolystoreFactory {

	private static Polystore ISTANCE = null;

	public static Polystore getOrCreate() {
		if(ISTANCE == null)
			ISTANCE = new Polystore();
		return ISTANCE;
	}
}