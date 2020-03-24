public class Player {
    private Board board;
    private Mark mark;
    private int pick;
    private boolean isComputer;
    private String message;

    public Player(Board board, Mark mark, boolean isComputer, String message) {
        this.board = board;
        this.mark = mark;
        this.isComputer = isComputer;
        this.message = message;
    }

    //Tühi konstruktor player1 ja player 2 loomiseks
    public Player() {
    }

    //Objekti Player kloonija
    public void setPlayer(Player player) {
        this.board = player.getBoard();
        this.mark = player.getMark();
        this.isComputer = player.isComputer();
        this.message = player.getMessage();
    }

    public String getMessage() {
        return message;
    }

    public Board getBoard() {
        return board;
    }

    public boolean isComputer() {
        return isComputer;
    }

    public void setPick(int pick) {
        this.pick = pick;
    }

    public int getPick() {
        return pick;
    }

    public Mark getMark() {
        return mark;
    }

    @Override
    public String toString() {
        return "" + mark;
    }

}
