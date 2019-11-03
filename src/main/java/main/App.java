package main;

import options.Options;

public class App {
    private Options options;
    
    public App() {
        this.options = new Options();
        options.getDataFromDatabase();
    }
	
	public static void main(String[] args) {
	    App app = new App();
	    
	    while(!app.options.endProgram()) {
            app.options.showMenu();
            app.options.make();
        }
	}
}
