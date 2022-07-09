package app;

import app.services.Play;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PokemonApplication {

    public static void main(String[] args) {
        Play windows = new Play();
        windows.start();
    }
}
