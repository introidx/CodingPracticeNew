package interview;

/**
 * Created by PRAKASH RANJAN on 09-02-2023
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SongSelector {

    private List<String> songs;
    private List<String> playedSongs;
    private Random rand;

    public SongSelector(List<String> songs) {
        this.songs = songs;
        this.playedSongs = new ArrayList<>();
        this.rand = new Random();
    }

    public String select() {
        if (songs.isEmpty()) {
            return null;
        }

        int index = rand.nextInt(songs.size());
        String song = songs.get(index);
        songs.remove(index);
        playedSongs.add(song);
        return song;
    }

    public void reset() {
        songs.addAll(playedSongs);
        playedSongs.clear();
    }

    public static void main(String[] args) {
        List<String> songs = List.of("Song 1", "Song 2", "Song 3", "Song 4");
        SongSelector selector = new SongSelector(songs);

        for (int i = 0; i < songs.size(); i++) {
            System.out.println(selector.select());
        }
    }
}

