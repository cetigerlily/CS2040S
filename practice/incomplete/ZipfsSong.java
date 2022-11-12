import java.util.*;

public class ZipfsSong {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int numOfSongs = io.getInt();
        int numToChoose = io.getInt();

        ArrayList<Song> songs = new ArrayList<>();
        for(int i = 0; i < numOfSongs; i++) {
            songs.add(new Song(io.getInt(), io.getWord()));
        }

        // sort songs by calculated quality - using zipf's law

        for(int i = 0; i < numToChoose; i++) {
            io.println(songs.get(i));
        }

        io.flush();
        io.close();
    }
}

class Song {
    private int frequency;
    private String name;

    public Song(int frequency, String name) {
        this.frequency = frequency;
        this.name = name;
    }
}
