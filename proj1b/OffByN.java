public class OffByN implements CharacterComparator {

    private int offset;

    public OffByN(int n) {
        offset = n;
    }
    public boolean equalChars(char x, char y) {
        return Math.abs(x - y) == offset;
    }
}
