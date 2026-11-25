package at.technikum.controller;

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
    @Override
    public void handle(HttpExchange exchange) throws IOException        // exchange = Gespräch mit dem Client; darüber Anfrage lesen und Antwort schicken
    {
        String method = exchange.getRequestMethod();            // Liest, was der Client tun will, zB GET, POST usw.
        String path = exchange.getRequestURI().getPath();     // Liest, wohin die Anfrage geht, zB /api/users/register

        if (method.equals("POST") && path.equals ("/api/users/register"))
        {
            String antwort = "Register aufgerufen";
            exchange.sendResponseHeaders(201, antwort.getBytes().length);   // Code 201 = created; .getBytes() wandelt den Text in Bytes um, weil übers Netzwerk nur Bytes gehen; .length sagt, wieviele Bytes das sind
            exchange.getResponseBody().write(antwort.getBytes());
            exchange.close();
        }
        else if (method.equals("POST") && path.equals("/api/users/login"))
        {
            String antwort = "Login aufgerufen";
            exchange.sendResponseHeaders(200, antwort.getBytes().length);   // 200 = OK
            exchange.getResponseBody().write(antwort.getBytes());
            exchange.close();
        }
        else
        {
            String antwort = "Not found";
            exchange.sendResponseHeaders(404, antwort.getBytes().length);
            exchange.getResponseBody().write(antwort.getBytes());
            exchange.close();
        }
    }
}
