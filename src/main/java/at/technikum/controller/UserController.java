package at.technikum.controller;

import at.technikum.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.IOException;

// UserController ist nur der "Empfang", gibt nur an die Serviceschicht weiter.
// Nimmt alle HTTP-Anfragen an, die mit Usern zutun haben (registrieren, login);
// schaut sich an, welche HTTP-Methode (GET, POST, ...); welcher PFad (/api/users/...)
// -> emtscheidet danach, was passieren soll und schickt Antwort mit Statuscode zurück

// "implements HttpHandler": Art Vertrag mit dem Java-HttpServer.
// Interface = Vertrag. Server kennt meine Klasse nicht, nur "HttpHandler", und ruft bei jeder Anfrage handle(exchange) auf.
// Deshalb MUSS es diese Methode geben, wenn sie fehlt, kompiliert das Programm nicht.

// Kurz: Die Klasse hier erfüllt den "Vertrag" HttpHandler. Dadurch kann der Server sie benutzen.
public class UserController implements HttpHandler
{
    // JSON in den Controller einlesen: ObjectMapper für JSON zu Java-Objekten
    private final ObjectMapper mapper = new ObjectMapper();     // final: das Feld wird einmal gesetzt und nie mehr geändert

    @Override
    public void handle(HttpExchange exchange) throws IOException        // exchange = Gespräch mit dem Client; darüber Anfrage lesen und Antwort schicken
    {
        String method = exchange.getRequestMethod();            // Liest, was der Client tun will, zB GET, POST usw.
        String path = exchange.getRequestURI().getPath();     // Liest, wohin die Anfrage geht, zB /api/users/register

        if (method.equals("POST") && path.equals ("/api/users/register"))
        {
            // JSON-Body auslesen
            // ; den Body der Anfrage bekommt man mit exchange.getRequestBody(). Der Mapper macht daraus dann das Objekt
            User user = mapper.readValue(exchange.getRequestBody(), User.class);

            sendResponse(exchange, 201, "User " + user.getUsername() + " registriert");
        }
        else if (method.equals("POST") && path.equals("/api/users/login"))
        {
            sendResponse(exchange, 200, "Login aufgerufen");
        }
        else
        {
            sendResponse(exchange, 404, "Not found");
        }
    }

    private void sendResponse(HttpExchange exchange, int statusCode, String text) throws IOException        // private, weil nur der UserController selber die Methode braucht
    {
        String antwort = text;
        exchange.sendResponseHeaders(statusCode, antwort.getBytes().length);
        exchange.getResponseBody().write(antwort.getBytes());
        exchange.close();
    }
}
