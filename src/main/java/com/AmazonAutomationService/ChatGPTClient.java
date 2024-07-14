package com.AmazonAutomationService;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import okhttp3.*;

import java.io.IOException;
import java.util.List;

public class ChatGPTClient {
    private static final String API_URL = "https://api.openai.com/v1/chat/completions";
    private static final String API_KEY = System.getenv("OPENAI_API_KEY");
    private OkHttpClient client;
    private Gson gson;

    public ChatGPTClient() {
        client = new OkHttpClient();
        gson = new Gson();

        // Debugging line to verify API key
        if (API_KEY == null || API_KEY.isEmpty()) {
            System.out.println("API_KEY environment variable is not set.");
            throw new IllegalStateException("API key not found. Please set the OPENAI_API_KEY environment variable.");
        } else {
            System.out.println("API Key: " + API_KEY); // This should print the API key
        }
    }

    public String getChatGPTResponse(List<String> productList, String category) throws IOException {
        String prompt = String.format("List of %s on Amazon:\n%s", category, String.join("\n", productList));
        String requestBodyJson = gson.toJson(new ChatGPTRequestBody(prompt));

        RequestBody body = RequestBody.create(requestBodyJson, MediaType.get("application/json; charset=utf-8"));
        Request request = new Request.Builder()
                .url(API_URL)
                .post(body)
                .addHeader("Authorization", "Bearer " + API_KEY)
                .build();

        Response response = client.newCall(request).execute();
        if (!response.isSuccessful()) {
            throw new IOException("Unexpected code " + response);
        }
        return response.body().string();
    }

    private static class ChatGPTRequestBody {
        @SerializedName("model")
        private final String model;
        @SerializedName("messages")
        private final Message[] messages;
        @SerializedName("max_tokens")
        private final int maxTokens;

        public ChatGPTRequestBody(String prompt) {
            this.model = "gpt-3.5-turbo"; // Use the available model
            this.messages = new Message[]{new Message("user", prompt)};
            this.maxTokens = 100;
        }

        private static class Message {
            @SerializedName("role")
            private final String role;
            @SerializedName("content")
            private final String content;

            public Message(String role, String content) {
                this.role = role;
                this.content = content;
            }
        }
    }
}
