package ru.mirea.t27_28;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class BaseClass {

    String address = "http://gitlessons2020.rtuitlab.ru:3000/reflectionTasks";
    Gson g = new GsonBuilder().setPrettyPrinting().create();
    HttpClient hc = HttpClient.newHttpClient();


    @OperatingInterface(name = "sum")
    public void outSumm(WorkingClass workingClass) {
        int s = 0;
        for (int i : workingClass.getNumbers()) {
            s += i;
        }
        System.out.println(s);
    }

    @OperatingInterface(name = "print")
    public void outStrings(WorkingClass workingClass) {
        for (String w : workingClass.getWords()) {
            if (workingClass.getWords().indexOf(w) != workingClass.getWords().size() - 1)
                System.out.print(w + " " + workingClass.getDelimeter() + " ");
            else
                System.out.print(w);
        }
    }

    public List<TaskClass> getAllTasksFromList() {
        List<TaskClass> tasks = null;
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(address))
                .build();
        try {
            HttpResponse<String> response = hc.send(request, HttpResponse.BodyHandlers.ofString());
            tasks = g.fromJson(response.body(), new TypeToken<List<TaskClass>>() {
            }.getType());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return tasks;
    }
}