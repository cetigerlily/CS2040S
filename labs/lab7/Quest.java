public class Quest implements Comparable<Quest> {
    private long energy;
    private long gold;
    private long id;

    public Quest(long energy, long gold, long id) {
        this.energy = energy;
        this.gold = gold;
        this.id = id;
    }

    public long getEnergy() {
        return this.energy;
    }

    public long getGold() {
        return this.gold;
    }

    public long getID() {
        return this.id;
    }

    @Override
    public int compareTo(Quest other) { // 0 = if they're equal, neg: this < other, pos: this > other
        long energyResult = this.getEnergy() - other.getEnergy();
        long goldResult = this.getGold() - other.getGold();
        long idResult = this.getID() - other.getID();


        if(energyResult != 0) {
            return (energyResult > 0) ? 1 : -1;
        } else { // equal energy results, compare the gold result
            if(goldResult != 0) {
                return (goldResult > 0) ? 1 : -1;
            } else { // equal gold results too, compare the id
                if(idResult != 0) {
                    return (idResult > 0) ? 1 : -1;
                } else {
                    return 0;
                }
            }
        }
    }
}
