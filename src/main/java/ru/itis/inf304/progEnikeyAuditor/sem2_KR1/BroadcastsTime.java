package ru.itis.inf304.progEnikeyAuditor.sem2_KR1;

public class BroadcastsTime {
    byte hour;
    byte min;

    public BroadcastsTime(byte hour, byte min) {
        this.hour = hour;
        this.min = min;
    }

    public String toString() {
        doCorrect();
        return "(" + hour + ":" + min + ")";
    }

    public void doCorrect() {
        if (min >= 60 ) {
            hour += min / 60;
            min = (byte)(min % 60);
        }
    }

    boolean after(BroadcastsTime t) {
        if (t.hour < this.hour) {
            return true;
        }

        if (t.hour > this.hour) {
            return false;
        }
        if (t.hour == this.hour) {

            if (t.min < this.min) {
                return true;
            }

            if (t.min > this.min) {
                return false;
            }
        }
        return false; //если время программы == времени сейчас
    }
    boolean befor(BroadcastsTime t) {
        return !this.after(t);
    }
    boolean between(BroadcastsTime t1, BroadcastsTime t2) {
        if (this.after(t1) && this.befor(t2)) {
            return true;
        }
        return false;
    }





    // Метод для преобразования часов в тип byte
    public static byte convertHoursToByte(String time) {
        String[] timeParts = time.split(":");
        byte hours = Byte.parseByte(timeParts[0]);
        return hours;
    }

    // Метод для преобразования минут в тип byte
    public static byte convertMinutesToByte(String time) {
        String[] timeParts = time.split(":");
        byte minutes = Byte.parseByte(timeParts[1]);
        return minutes;
    }

    public boolean equals(BroadcastsTime t) {
        if (this.hour == t.hour && this.min == t.min) {
            return true;
        }
        return false;
    }
}
