package ru.mirea.t27_28;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        BaseClass baseClass = new BaseClass();
        Class<? extends BaseClass> baseClassClass = baseClass.getClass();

        List<Method> methodList = Arrays.stream(baseClassClass.getDeclaredMethods())
                .filter(a -> Arrays.stream(a.getAnnotations())
                        .anyMatch(b -> b instanceof OperatingInterface)).collect(Collectors.toList());

        List<TaskClass> tasks = baseClass.getAllTasksFromList();
        OperatingInterface operatingInterface;

        for (TaskClass task : tasks) {
            for (Method method : methodList) {

                operatingInterface = method.getAnnotation(OperatingInterface.class);
                if (task.getType().equals(operatingInterface.name())) {
                    try {
                        method.invoke(baseClass, task.getData());
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}