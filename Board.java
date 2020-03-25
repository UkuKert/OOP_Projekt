public class Board {
    private Space[][] spaces;

    private Board(Space[][] spaces) {
        this.spaces = spaces;
    }

    public static Board buildEmptyBoard() {
        Space[][] spaces = new Space[3][3];
        for (int i = 0; i < spaces.length; i++) {
            for (int j = 0; j < spaces[i].length; j++) {
                spaces[i][j] = Space.buildEmptySpace();
            }
        }
        return new Board(spaces);
    }

    public Mark getSpaceMark(int spaceNumber) {
        if (spaceNumber <= 3) {
            return this.spaces[0][spaceNumber - 1].getMark();
        } else if (spaceNumber <= 6) {
            return this.spaces[1][spaceNumber - 4].getMark();
        } else {
            return this.spaces[2][spaceNumber - 7].getMark();
        }
    }

    public void setSpaceMark(int spaceNumber, Mark mark) {
        if (spaceNumber <= 3) {
            this.spaces[0][spaceNumber - 1].setMark(mark);
        } else if (spaceNumber <= 6) {
            this.spaces[1][spaceNumber - 4].setMark(mark);
        } else {
            this.spaces[2][spaceNumber - 7].setMark(mark);
        }
    }

    //kontrollib, kas space on tühi
    public boolean checkSpace(int spaceNumber) {
        if (spaceNumber <= 3) {
            return this.spaces[0][spaceNumber - 1].getMark() == Mark.EMPTY;
        } else if (spaceNumber <= 6) {
            return this.spaces[1][spaceNumber - 4].getMark() == Mark.EMPTY;
        } else {
            return this.spaces[2][spaceNumber - 7].getMark() == Mark.EMPTY;
        }
    }

    public boolean hasWon(Mark mark) {
        if (getSpaceMark(1) == mark) {
            if (getSpaceMark(5) == mark) {
                if (getSpaceMark(9) == mark)
                    return true;
            }
            if (getSpaceMark(2) == mark) {
                if (getSpaceMark(3) == mark)
                    return true;
            }
            if (getSpaceMark(4) == mark) {
                if (getSpaceMark(7) == mark)
                    return true;
            }
        }
        if (getSpaceMark(5) == mark) {
            if (getSpaceMark(3) == mark) {
                if (getSpaceMark(7) == mark)
                    return true;
            }
            if (getSpaceMark(4) == mark) {
                if (getSpaceMark(6) == mark)
                    return true;
            }
            if (getSpaceMark(2) == mark) {
                if (getSpaceMark(8) == mark)
                    return true;
            }
        }
        if (getSpaceMark(9) == mark) {
            if (getSpaceMark(7) == mark) {
                if (getSpaceMark(8) == mark)
                    return true;
            }
            if (getSpaceMark(3) == mark) {
                if (getSpaceMark(6) == mark)
                    return true;
            }

        }
        return false;
    }
}
