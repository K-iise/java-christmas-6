package christmas.domain;

public class Event {

    private final int weekdayDiscount;
    private final int weekendDiscount;
    private final int christmasDiscount;
    private final int specialDiscount;
    private final boolean flag;

    public Event(int weekdayDiscount, int weekendDiscount, int christmasDiscount, int specialDiscount, boolean flag) {
        this.weekdayDiscount = weekdayDiscount;
        this.weekendDiscount = weekendDiscount;
        this.christmasDiscount = christmasDiscount;
        this.specialDiscount = specialDiscount;
        this.flag = flag;
    }

    public int getWeekdayDiscount() {
        return weekdayDiscount;
    }

    public int getWeekendDiscount() {
        return weekendDiscount;
    }

    public int getChristmasDiscount() {
        return christmasDiscount;
    }

    public int getSpecialDiscount() {
        return specialDiscount;
    }

    public boolean isFlag() {
        return flag;
    }
}
