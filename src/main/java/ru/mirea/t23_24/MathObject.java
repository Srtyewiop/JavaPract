package ru.mirea.t23_24;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.*;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MathObject {
    HttpClient httpClient = HttpClient.newHttpClient();
    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    File file = new File("src\\main\\java\\ru\\mirea\\t23_24\\db.json");
    FileWriter fileWriter;
    FileReader fileReader;
    JsonReader jsonReader;

    String UserName = "Andrei Lyakhov";
    String tasksAddress = "http://80.87.199.76:3000/tasks";
    String resultAddress = "http://80.87.199.76:3000/reports";

    List<Integer> tasksToWrite = new ArrayList<>();
    List<JsonObject> tasksJson = new ArrayList<>();




    public MathObject() {
        try {
            fileWriter = new FileWriter(file, true);
            fileReader = new FileReader(file);
            jsonReader = new JsonReader(fileReader);
            if (fileReader.read() == -1) {
                fileWriter.write("[]");
                fileWriter.flush();
            }
        } catch (IOException err) {
            err.printStackTrace();
        }

    }

    public List<Integer> getSavedJsonInfo() {
        String text;
        StringBuilder stringBuilder = new StringBuilder();
        ArrayList<Integer> items = new ArrayList<>();
        Type collectionType = new TypeToken<Collection<Integer>>() {
        }.getType();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            text = reader.readLine();
            while (text != null) {
                stringBuilder.append(text + "\n");
                text = reader.readLine();
            }
            items = gson.fromJson(stringBuilder.toString(), collectionType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return items;
    }

    public void readTasks() {
        tasksJson.clear();
        HttpRequest request = HttpRequest.newBuilder().GET().uri(URI.create(tasksAddress)).build();
        HttpResponse<String> response = null;
        try {
            response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
        JsonArray task = gson.fromJson(response.body(), JsonArray.class);
        for (JsonElement je : task) {
            tasksJson.add(je.getAsJsonObject());
        }

    }

    public void performUndoneMath() {

        for (JsonObject task : tasksJson) {
            if (!getSavedJsonInfo().contains(task.get("id").getAsInt())) {
                System.out.println(task.get("taskDescription") + " done");
                double result = mathFunction(task.get("expression").getAsString());
                System.out.println(result);
                sendReport(task.get("id").getAsInt(), result);
                tasksToWrite.add(task.get("id").getAsInt());
            } else {
                System.out.println("Skipped task "+task.get("id").getAsInt() + " as done");
            }
        }
        try (FileWriter writer = new FileWriter("src\\main\\java\\ru\\mirea\\t23_24\\db.json")) {
            writer.write(gson.toJson(tasksToWrite));
            writer.flush();
        } catch (IOException err) {
            err.printStackTrace();
        }
    }

    public double mathFunction(String taskInfo) {
        taskInfo = taskInfo.replace(" ", "");
        String splitReg = "(?<=\\d)(?=\\D)|(?<=\\D)(?=\\D)|(?<=\\d\\D)(?=\\d)";
        String[] split = taskInfo.split(splitReg);
        switch (split[1]) {
            case "/":
                return Math.round((double) Integer.parseInt(split[0]) / (double) Integer.parseInt(split[2])*100.0) / 100.0;
            case "*":
                return Integer.parseInt(split[0]) * Integer.parseInt(split[2]);
            case "+":
                return Integer.parseInt(split[0]) + Integer.parseInt(split[2]);
            case "-":
                return Integer.parseInt(split[0]) - Integer.parseInt(split[2]);

        }
        return -9999999;
    }

    public void sendReport(int taskId, double res) {

        HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(gson.toJson(new Sender(0, taskId, UserName, res))))
                .uri(URI.create(resultAddress))
                .setHeader("Content-Type", "application/json")
                .build();
        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
        } catch (IOException | InterruptedException err) {
            err.printStackTrace();
        }
    }


}

