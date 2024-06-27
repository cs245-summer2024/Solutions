package hw2;

public class PositionFilter implements PlayerFilter{
    String position;
    public PositionFilter(String position) {
        this.position = position;
    }

    public boolean filter(FantasyPlayer p) {
        return p.position.equals(position);
    }
}
