# Ollama Service

Questo progetto è una semplice applicazione Spring Boot che integra Spring AI con Ollama per generare risposte a prompt via API REST.

## 🔧 Funzionalità principali

- API REST `/ai/prompt` per inviare richieste testuali
- Integrazione con Ollama via Spring AI
- Supporto per prompt personalizzati tramite system prompt
- Configurazione personalizzabile in `application.properties`

## 🚀 Requisiti

- Java 17+
- Maven
- Ollama installato e avviato

##Installazione di Ollama
- ollama pull deepseek-r1:1.5b (scarica il modello deepseek-r1:1.5b)
- ollama run deepseek-r1:1.5b  (avvia il modello deepseek-r1:1.5b)


## 📁 Struttura del progetto

```
ollama-service/
├── controller/
│   └── AiController.java       # Espone l'API REST
├── service/
│   └── AiService.java          # Logica del prompt e chiamata a Ollama
├── model/
│   └── MessageRequest.java     # DTO della richiesta
├── resources/
│   └── application.properties         # Configurazione del progetto
```

## 📬 Esempio di richiesta

`POST http://localhost:8080/api/ai/prompt`

```json
{
  "message": "Ciao, ho 500€ di budget. Vorrei prenotare un viaggio, mi dai qualche consiglio?"
}
```# OllamaTest
