# Avancerad-java-Mitar-Mitrovic-slutprojekt

# To-Do List Application

## **Projektets mål och funktionalitet**

To-Do List Application är en enkel applikation för att hantera uppgifter. Applikationen är uppdelad i två separata delar:

1. **Backend**: En REST API-server byggd med Spring Boot som hanterar uppgifterna.
2. **Frontend**: En JavaFX-applikation som fungerar som användargränssnitt och kommunicerar med backend-servern.

### **Funktionalitet**
- **Visa alla uppgifter**: Se en lista över alla sparade uppgifter.
- **Lägg till en uppgift**: Skapa nya uppgifter.
- **Redigera en uppgift**: Uppdatera beskrivning eller status för befintliga uppgifter.
- **Ta bort en uppgift**: Radera uppgifter.

---

## **Instruktioner för att starta applikationen**

### **Krav**
- **Java Development Kit (JDK)** version 17 eller senare.
- **Maven** installerat för att bygga och hantera beroenden.
- **IntelliJ IDEA** (eller valfri IDE).

### **1. Starta backend-servern**
1. Navigera till backend-projektmappen:

    **2. Starta backend-servern**
      - **mvn spring-boot:run
  
    **3. Starta frontend-applikationen**
      - **Öppna ToDoApp.java.
      - **Högerklicka på filen och välj Run 'ToDoApp.main()'.
  
 ### **Exempel på API-anrop**

 **Hämta alla uppgifter**
   - **Metod: GET
   - **URL: http://localhost:8080/api/tasks.
   - **Exempel på svar:  
   {
      "id": 1,
      "description": "Buy groceries",
      "completed": false
   },
   {
      "id": 2,
      "description": "Clean the house",
      "completed" true
   }
   
**Skapa en ny uppgift**
   - **Metod: POST
   - **URL: http://localhost:8080/api/tasks
   - **Body
{
   "description": "Finish homework",
   "completed": False
}

- **Exempel på svar:
  {
      "id": 3,
      "description": "Finish homework",
      "completed": false
  }

**Uppdatera en uppgift**
   - **Metod: PUT
   - **URL: http://localhost:8080/api/tasks/{id}
   - **Body:
{
    "description": "Finish groceries and fruits",
      "completed": true
  }

- **Exempel på svar:
{  
   "id": 1,
   "description": "Finish groceries and fruits",
   "completed": true
}

**Ta bort en uppgift**
   - **Metod: DELETE
   - **URL: http://localhost:8080/api/tasks/{id}
   - **Exempel på svar: HTTP 204 No Content

**Felsökning**
   - **Om backend-servern inte startar:
Kontrollera om port 8080 används av ett annat program.
Se backend-loggarna för eventuella felmeddelanden.
   - **Om frontend-applikationen inte visar uppgifter:
Kontrollera att backend-servern är igång.
Kontrollera ApiService-klassen för korrekt URL till backend.
css
Kopiera kod
