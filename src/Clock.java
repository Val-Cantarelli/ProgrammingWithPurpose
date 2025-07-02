public class Clock {
    private int minutes;

    public Clock(int h, int m) {
        initClock(h, m);
    }

    public Clock(String s) {
        if (s.charAt(2) != ':') throw new IllegalArgumentException();
        if (s.length() != 5) throw new IllegalArgumentException();
        int h = 0;
        int m = 0;
        try {
            h = Integer.parseInt(s.substring(0, 2));
            m = Integer.parseInt(s.substring(3, 5));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        initClock(h, m);
    }

    public static void main(String[] args) {
        Clock testArgsInput = new Clock(args[0]);
        Clock time = new Clock(0, 0);
        Clock time2 = new Clock(0, 0);
        Clock copyTime2 = new Clock(time2.toString());

        System.out.println("Time: " + time);
        System.out.println("Time2: " + time2);
        System.out.println("CopyTime2 before '.tic()': " + copyTime2);
        System.out.println("Is " + time + " earlier than " + time2 + " ? " + time.isEarlierThan(time2));
        time2.tic();
        System.out.println("Adding 1 min to " + copyTime2 + " we have: " + time2);
        System.out.println(testArgsInput);
        int delta = 30000;

        Clock copyTime3 = new Clock(time.toString());
        time.toc(delta);
        System.out.println("Adding delta = " + delta + " to " + copyTime3 + " we have: " + time);

    }

    private void initClock(int h, int m) {
        if (h > 23 || h < 0)
            throw new IllegalArgumentException("The hours must be between 0 and 23; And minutes 0 and 59.");
        if (m > 59 || m < 0)
            throw new IllegalArgumentException("The hours must be between 0 and 23; And minutes 0 and 59.");
        this.minutes = h * 60 + m;
    }

    public String toString() {
        int h = (this.minutes / 60) % 24;
        int m = (this.minutes % 60);
        return String.format("%02d:%02d", h, m);
    }

    public boolean isEarlierThan(Clock that) {
        return that.minutes > this.minutes;
    }

    public void tic() {
        this.minutes += 1;
    }

    public void toc(int delta) {
        if (delta < 0) throw new IllegalArgumentException();
        this.minutes += delta;
    }
}