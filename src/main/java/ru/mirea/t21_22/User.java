package ru.mirea.t21_22;

public class User {
    public StringBuilder onJsonFileChange() {
        StringBuilder sb = new StringBuilder();
        sb.append("1.Изменить локальный файл\n");
        sb.append("2.Изменить данные на сервере\n");
        sb.append("3.Выйти\n");
        sb.append("Выберите действие: ");
        return sb;
    }

    public StringBuilder onLocalFileChange() {
        StringBuilder sb = new StringBuilder();
        sb.append("Обработка локального файла\n");
        sb.append("Выберите\n");
        sb.append(onUserChange());
        return sb;
    }

    public StringBuilder onServerChange() {
        StringBuilder sb = new StringBuilder();
        sb.append("Обработка данных на сервере\n");
        sb.append("Выберите\n");
        sb.append(onUserChange());
        return sb;
    }

    private StringBuilder onUserChange() {
        StringBuilder sb = new StringBuilder();
        sb.append("1.Получить список всех объектов\n");
        sb.append("2.Получить объект\n");
        sb.append("3.Добавить объект\n");
        sb.append("4.Изменить объект\n");
        sb.append("5.Удалить объект\n");
        sb.append("6.Выйти\n");
        sb.append("Выберите действие: ");
        return sb;
    }

    public StringBuilder onGettingAllItems() {
        StringBuilder sb = new StringBuilder();
        sb.append("Список всех объектов\n");
        return sb;
    }

    public StringBuilder onGettingOneItem() {
        StringBuilder sb = new StringBuilder();
        sb.append("Введите id: ");
        return sb;
    }

    public StringBuilder onAddItem() {
        StringBuilder sb = new StringBuilder();
        sb.append("Введите данные объекта: ");
        return sb;
    }

    public StringBuilder onEditingItem() {
        StringBuilder sb = new StringBuilder();
        sb.append("Введите id объекта и измененный объект: ");
        return sb;
    }

    public StringBuilder onDeletingFile() {
        StringBuilder sb = new StringBuilder();
        sb.append("Введите id объекта, который хотите удалить: ");
        return sb;
    }

    public StringBuilder onErrorMessage() {
        StringBuilder sb = new StringBuilder();
        sb.append("Ошибка!");
        return sb;
    }

    public StringBuilder onNotFounded() {
        StringBuilder sb = new StringBuilder();
        sb.append("Объекта с таким id не найдено!");
        return sb;
    }

    public StringBuilder onAddError() {
        StringBuilder sb = new StringBuilder();
        sb.append("Объект не добавлен!");
        return sb;
    }

    public StringBuilder onEditingError() {
        StringBuilder sb = new StringBuilder();
        sb.append("Объект не был изменен!");
        return sb;
    }

    public StringBuilder onDeleteingError() {
        StringBuilder sb = new StringBuilder();
        sb.append("Объект не был удален!");
        return sb;
    }

    public StringBuilder onExiting() {
        StringBuilder sb = new StringBuilder();
        sb.append("Вы вышли!");
        return sb;
    }

    public StringBuilder onAddingSucceed() {
        StringBuilder sb = new StringBuilder();
        sb.append("Объект успешно добавлен!");
        return sb;
    }

    public StringBuilder onEditingSucceed() {
        StringBuilder sb = new StringBuilder();
        sb.append("Объект был успешно изменен!");
        return sb;
    }

    public StringBuilder onDeleteSucceed() {
        StringBuilder sb = new StringBuilder();
        sb.append("Объект был успешно удален!");
        return sb;
    }

}