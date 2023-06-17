
import java.util.LinkedList;
import java.util.Queue;

    class WeekDay {
        private String day;
        private String date;

        public WeekDay(String day, String date) {
            this.day = day;
            this.date = date;
        }

        public String getDay() {
            return day;
        }

        public String getDate() {
            return date;
        }
    }

    class Week {
        private Queue<WeekDay> days;

        public Week() {
            days = new LinkedList<>();
        }

        public void addDay(WeekDay day) {
            days.add(day);
        }

        public void displayCalendar() {
            for (WeekDay day : days) {
                System.out.println(day.getDay() + " " + day.getDate());
            }
        }
    }

    public class Calendar {
        public static void main(String[] args) {

            WeekDay day1 = new WeekDay("S", "1");
            WeekDay day2 = new WeekDay("M", "2");
            WeekDay day3 = new WeekDay("T", "3");
            WeekDay day4 = new WeekDay("W", "4");
            WeekDay day5 = new WeekDay("Th", "5");
            WeekDay day6 = new WeekDay("F", "6");
            WeekDay day7 = new WeekDay("S", "7");


            Week week = new Week();


            week.addDay(day1);
            week.addDay(day2);
            week.addDay(day3);
            week.addDay(day4);
            week.addDay(day5);
            week.addDay(day6);
            week.addDay(day7);


            week.displayCalendar();
        }
    }

