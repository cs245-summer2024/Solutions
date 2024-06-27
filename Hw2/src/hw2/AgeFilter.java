package hw2;

public class AgeFilter implements PlayerFilter {
    private int ageCutoff;

    public AgeFilter(int ageThreshold) {
        ageCutoff = ageThreshold;
    }
    public boolean filter(FantasyPlayer p) {
        return p.age >= ageCutoff;
    }
}
