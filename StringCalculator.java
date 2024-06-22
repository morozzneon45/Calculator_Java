import java.util.Scanner;
import java.util.regex.Pattern;

public class StringCalculator {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in); //вводим переменную сканера
        System.out.print("Введите операцию: ");
        String input = scanner.nextLine(); //вводимый в консоль текст
        char operator; //вводим переменную символов (операторы)
        String string[] = input.split(" "); //Создаем массив, деление строки на слова через пробел
        if (input.contains("+")) { //Находим в строке опер.знаки
            operator = '+';
        } else if (input.contains("-")) {
            operator = '-';
        } else if (input.contains("*")) {
            operator = '*';
        } else if (input.contains("/")) {
            operator = '/';
        } else {
            throw new Exception(); //выбрасываем исключение в случае отсутствия оператора
        }
        if (operator == '+') { //сложение элементов строки
            PrintResult(string[0] + string[2]);
        } else if (operator == '*') { //умножение элементов строки
            int integer = Integer.parseInt(string[2]); //перевод в значение int
            String result1 = "";
            for (int i = 0; i <= integer; i++) {
                result1 += string[0];
            }
            PrintResult(result1);
        } else if (operator == '-') { //вычитание элементов строки
            int index = string[0].indexOf(string[2]);
            if (index == -1) {
                PrintResult(string[0]); //в случае, если вычитаемых символов нет в заданной строке
            }
        } else if (operator == '/') { //оператор деления
            int integer = Integer.parseInt(string[2]);
            String result2 = string[0].substring(0, integer);
            PrintResult(result2.substring(0, 40) + "...");
        }
        if (string[0].length() > 10 || string[2].length() > 10) { //Длина вводимых данных не более 10
            throw new Exception(); //пробрасывание исключения
        }
        if (operator == '+' || operator == '-') { //выбрасывание исключения, если в начале строки стоит число
            if (string[0].matches("[0-9]*")) {
                throw new Exception();
            }
        }
        if (operator == '*' || operator == '/') { //исключение при вводе цифры до 1 или после 10
            int integer2 = Integer.parseInt(string[2]);
            if (integer2 <= 0 | integer2 > 10) {
                throw new Exception();
            }
            if (operator == '*' || operator == '/') { //исключение при отсутствии числа (*,/)
                if (string[2].matches("(?<=\s|^)[a-zA-Z]*(?=[.,;:]?\s|$)"));
                {
                    throw new Exception();
            }
            }
        }
        for (int i = 0; i < string.length; i++) {
            string[i] = string[i].replace("\"", "");
        }
    }
    static void PrintResult(String text) { //класс итогового текста
        if (text.length() > 40) //длина - не более 40 символов
            System.out.println(text.substring(0, 40) + "..." + " ");
        else{
            System.out.println(text);
        }
    }
}


