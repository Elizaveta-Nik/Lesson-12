package DocumentValidator;

import java.util.HashSet;
import java.util.Scanner;

public class DocumentValidator {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        HashSet<String> documentNumbers = new HashSet<>();

        System.out.println("Номер документа должен иметь длину 15 символов и начинаться с последовательности `docnum` или `kontract` (далее любая последовательность букв/цифр)."
                + "\n*Для завершения ввода номеров следует ввести 0*");

        while (true) {
            String documentNumber = scanner.nextLine();//kontract1111111
            if (documentNumber.equals("0"))
                break;
            if (documentNumbers.add(documentNumber)) {
                System.out.println(documentNumber + " - " + validateDocumentNumber(documentNumber));//Номер документа + выводим результат валидации
            } else {
                System.out.println(documentNumber + " - Данный документ был введен ранее");
            }
        }
        scanner.close();
    }

    public static String validateDocumentNumber(String documentNumber) {
        if (documentNumber.length() != 15) {
            return "Документ не валиден: длина должна быть 15";
        }
        if (!documentNumber.startsWith("docnum") && !documentNumber.startsWith("kontract")) {
            return "Документ не валиден: должен начинаться 'docnum' или 'kontract'";
        }
        if (documentNumber.contains(" ")) {
            return "Документ не валиден: содержит пробелы";
        }
        return "Валиден";// Если все проверки пройдены, номер валиден
    }
}