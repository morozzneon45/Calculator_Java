import java.util.Scanner;

public class StringCalculator {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in); //вводим переменную сканера
        System.out.print("Введите операцию: ");
        String input = scanner.nextLine(); //вводимый в консоль текст
        input = input.replace("\"", ""); //убираем кавычки
        char oper; //объявление символа (оператор)
        String[] part; //объявление массива

        if (input.contains(" + ")) { //разделение строки посредством операторов
            part = input.split(" \\+ ");
            oper = '+';
        } else if (input.contains(" - ")) {
            part = input.split(" - ");
            oper = '-';
        } else if (input.contains(" * ")) {
            part = input.split(" \\* ");
            oper = '*';
        } else if (input.contains(" / ")) {
            part = input.split(" / ");
            oper = '/';
        } else {
            throw new Exception(); //некорректный оператор
        }
        int multiplier = 0; //число-множитель
        if (oper == '*') {
            multiplier = Multiplier(part);
        }

        if (oper == '*' || oper == '/') {
            if (part[0].matches("[0-9]*")) { //выбрасывание исключения, если в начале строки стоит число
                throw new Exception();
            }
        }

        if (oper == '*' || oper == '/') {
            if (part[1].contains("\"")) throw new Exception(); //исключение, если *,/ на строку
        }

        if (oper == '*' || oper == '/') {
            if (part[0].length() > 10 || part[1].length() > 10) {
                throw new Exception(); //исключение, если строка > 10
            }
        }
        Calculate(oper, part, multiplier);

    }

    private static void Calculate(char oper, String[] part, int multiplier) { //операторы и действия
        if (oper == '+') { //сочетание
            SystemOut(part[0] + part[1]);
        } else if (oper == '*') { //умножение
            String result = part[0].repeat(multiplier);
            SystemOut(result);
        } else if (oper == '-') { //вычитание
            int index = part[0].indexOf(part[1]);
            if (index == -1) {
                SystemOut(part[0]);
            } else {
                String result = part[0].substring(0, index);
                result += part[0].substring(index + part[1].length());
                SystemOut(result);
            }
        } else if (oper == '/') { //деление
            int newLen = part[0].length() / Integer.parseInt(part[1]);
            String result = part[0].substring(0, newLen);
            SystemOut(result);
        }
    }

    private static int Multiplier(String[] part) throws Exception { //деление и умножение
        int multiplier = 1; //множитель
        try {
            multiplier = Integer.parseInt(part[1]);
            if (multiplier < 1 || multiplier > 10) { //исключение, если число > 10
                throw new Exception();
            }

        } catch (NumberFormatException e) { //исключение, если слово > 10
            if (part[0].length() > 10 || part[1].length() > 10) {
                throw new Exception();
            }
        }
        return multiplier;
    }

    static void SystemOut (String result){
            if (result.length() > 40) { //длина итоговой строки - не более 40 символов
                System.out.println("\"" + result.substring(0, 40) + "\"" + "...");
            } else {
                System.out.println("\"" + result + "\"");
            }
        }
    }


