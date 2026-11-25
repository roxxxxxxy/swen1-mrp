package at.technikum;

import at.technikum.controller.UserController;
import at.technikum.model.User;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;

// ROUTING
public class Main
{

    // IOException = Fehler bei Ein-/Ausgabe (Netzwerk, Dateien, Ports), zB wenn Port 8080 schon belegt ist.
    // Java zwingt einen hier zu entscheiden: abfangen (try/catch) oder weiterreichen (throws)
    // Hier: weiterreichen, weil das Programm ohne Server eh nix tun kann; -> es bricht dann mit Fehlermeldung ab, weil es in main niemanden darüber mehr gibt

    static void main() throws IOException
    {
        // 1. Server auf Port 8080 erstellen
        // Erstellt einen Server, der auf Port 8080 auf meinem Rechner hört. Die 0 am Ende ist eine Einstellung für die Warteschlange, 0 heißt einfach Standard.
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

        // 2. Festlegen: Anfragen an /hello beantwortet dieser Code
        // Sagt dem Server praktisch: "Wenn jemand /hello aufruft, für den Code in { } aus."
        // exchange ist die Anfrage samt Antwort, also das eine Gespräch mit dem Browser.
        server.createContext("/hello", exchange ->
        {
            String antwort = "Hallo vom MRP-Server!";

            // Statuscode 200 = OK, plus Länge der Antwort, die gleich kommt.
            // Browser will wissen, wie viel noch kommt
            exchange.sendResponseHeaders(200, antwort.getBytes().length);

            // Schickt den eigentlichen Text
            // getBytes() macht aus dem Text Bytes, weil übers Netzwerk nur Bytes gehen
            exchange.getResponseBody().write(antwort.getBytes());

            // Anfrage abschließen; fertisch
            exchange.close();
        });

        // Alle Anfragen, deren Pfad mit /api/users beginnt, gehen an den UserController. Mit new UserController erzeugt man dafür ein Objekt der Klasse
        server.createContext("/api/users", new UserController());

        // 3. Server starten
        server.start();
        System.out.println("Server läuft auf http://localhost:8080");
    }
}
