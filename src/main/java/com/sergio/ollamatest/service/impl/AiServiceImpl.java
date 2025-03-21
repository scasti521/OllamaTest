package com.sergio.ollamatest.service.impl;

import com.sergio.ollamatest.service.def.AiService;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AiServiceImpl implements AiService {

    private final ChatClient chatClient;

    private final String system = """
                        Sei un assistente di viaggi. Il tuo compito è aiutare l'utente a pianificare un viaggio suggerendo destinazioni, itinerari e prezzi in base ai dati forniti.
            
                        Questi sono i dati su cui devi basarti per i costi e le informazioni:
                        - Volo Roma - Parigi: €120
                        - Volo Roma - New York: €450
                        - Hotel a Parigi: €80/notte
                        - Hotel a New York: €150/notte
                        - Tour guidato a Parigi: €30
                        - Tour guidato a New York: €50
            
                        Usa solo questi prezzi e non inventare altri costi. Se l'utente chiede qualcosa che non è nei dati, rispondi che l'informazione non è disponibile e bisogna contattare l'assistenza.
                        Dai risposte concise, chiare e utili per pianificare un viaggio.
            """;

    @Autowired
    public AiServiceImpl(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    public String sendPrompt(String prompt) {
        return chatClient.prompt()
                .system(system)
                .user(prompt)
                .call()
                .content();
    }
}