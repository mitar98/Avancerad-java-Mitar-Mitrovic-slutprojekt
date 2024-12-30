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
      - mvn spring-boot:run
  
    **3. Starta frontend-applikationen**
      - Öppna ToDoApp.java.
      - Högerklicka på filen och välj Run 'ToDoApp.main()'.
  
 ### **Exempel på API-anrop**

 **Hämta alla uppgifter**
   Metod: GET
   URL: http://localhost:8080/api/tasks
   Exempel på svar: [
    {
        "id": 1,
        "description": "Buy groceries",
        "completed": false
    },
    {
        "id": 2,
        "description": "Clean the house",
        "completed": true
    }
]

