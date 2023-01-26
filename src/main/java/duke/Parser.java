package duke;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Parser {
    public static String parseDate(String str) {
        LocalDateTime date = LocalDateTime.parse(str, DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm"));
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MMM dd yyyy HHmm");
        String displayDate = date.format(dateFormat);
        return displayDate;
    }

    public static String retrieveDate(String str) {
        LocalDateTime date = LocalDateTime.parse(str, DateTimeFormatter.ofPattern("MMM dd yyyy HHmm"));
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm");
        String displayDate = date.format(dateFormat);
        return displayDate;
    }

    public static String[] parseTask(String input) {
        String[] splitCommand = input.split(" ", 2);
        String type = splitCommand[0];
        if(type.equals("todo")) {
            return splitCommand;
        } else {
            String[] segments = splitCommand[1].split("/");
            return segments;
        }
    }

    public static int findIndex(String input) {
        String[] splitCommand = input.split(" ", 2);
        int index = Integer.parseInt(splitCommand[1]) - 1;
        return index;
    }
}