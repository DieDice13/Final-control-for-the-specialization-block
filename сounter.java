public class сounter {

    public static void main(String[] args) {
        // Используем try-with-resources для автоматического закрытия счетчика
        try (InnerCounter counter = new InnerCounter()) {
            // Увеличиваем счетчик на 1
            counter.add();
            // Выводим текущее значение счетчика
            System.out.println("Количество: " + counter.getCount());
        } catch (Exception e) {
            // Выводим сообщение об ошибке, если что-то пошло не так
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    // Внутренний класс, реализующий AutoCloseable для автоматического закрытия счетчика
    public static class InnerCounter implements AutoCloseable {
        private int count; // Переменная для хранения текущего значения счетчика

        // Конструктор класса, инициализирует счетчик значением 0
        public InnerCounter() {
            this.count = 0;
        }

        // Метод для увеличения значения счетчика на 1
        public void add() {
            count++;
        }

        // Метод для получения текущего значения счетчика
        public int getCount() {
            return count;
        }

        // Метод close() интерфейса AutoCloseable, вызывается при завершении блока try-with-resources
        @Override
        public void close() {
            // Выводим сообщение о закрытии счетчика
            System.out.println("Закрытие счетчика...");
        }
    }

}



