# Final project for "Metodologie di Programmazione" course a.a. 2018/19

Small web server in which Javascript code is transpiled from Java using [JSweet](https://github.com/cincheo/jsweet).
Server runs on Apache Tomcat.

## Quickstart
**Prerequirements:**
- Apache Tomcat [zip](https://tomcat.apache.org/download-90.cgi) (v 9.0.60)
- Eclipse IDE + [Eclipse Web Developer Tools](https://marketplace.eclipse.org/content/eclipse-web-developer-tools-0) (v 3.25)

**Steps:**
1. Clone repository on desktop `git clone https://github.com/valerio-pescatori/metodologie_Pescatori.1807838`
3. Import project into Eclipse IDe (both "fabbricasemantica" and "Servers" folders)
4. Window --> Preferences --> Server --> Runtime Environments --> Add...
5. Select **Apache Tomcat v9.0**
6. **Window--> Show View --> Servers** to activate Servers tab
7. Right click in "Servers" tab then --> New --> Server
8. Select **Tomcat v9.0 Server**
9. Add **fabbricasemantica**
10. Start the server (Ctrl+Alt+R)
11. Visit `localhost:8080/fabbricasemantica/` to access web pages
