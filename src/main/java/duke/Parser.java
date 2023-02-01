package duke;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Parser {
    public static String formatDateString(String str) {
        LocalDateTime date = LocalDateTime.parse(str, DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm"));
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MMM dd yyyy HHmm");
        String displayDate = date.format(dateFormat);
        return displayDate;
    }

    /**
     * Changes the format of the date and time for display.
     * @param str String object of the saved date and time.
     * @return String object of the date and time used for display.
     */
    public static String retrieveDate(String str) {
        LocalDateTime date = LocalDateTime.parse(str, DateTimeFormatter.ofPattern("MMM dd yyyy HHmm"));
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm");
        String displayDate = date.format(dateFormat);
        return displayDate;
    }

    public static String[] extractArgsFromInput(String input) {
        String[] splitCommand = input.split(" ", 2);
        String type = splitCommand[0];
        if(type.equals("todo") || type.equals("find")) {
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