public class Space {
    private Mark mark;

    private Space() {
        this.mark = Mark.EMPTY;
    }

    // sama mis boardiga, aga kuna me alati tekitame tühja väärtusega välja siis selle nimega meetod on loetavam kui
    // konstruktor.
    public static Space buildEmptySpace() {
        return new Space();
    }

    public Mark getMark() {
        return mark;
    }

    public void setMark(Mark mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return String.valueOf(mark);
    }

}