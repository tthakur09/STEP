import java.util.Arrays;

public class q2{

    private final String[] songs;
    private int count;
    public q2(int maxSize) {
        this.songs = new String[maxSize];
        this.count = 0;
    }


    public void addSong(String song) {
        if (count < songs.length) {
            songs[count] = song;
            count++;
        }
    }


    public String[] getSongs() {
        return Arrays.copyOf(songs, count);
    }


    public int getSongCount() {
        return count;
    }


    public static void main(String[] args) {
        q2 p = new q2(10);
        p.addSong("Song A");
        p.addSong("Song B");


        String[] copy = p.getSongs();
        copy[0] = "Hacked";


        System.out.println("Modified copy[0]: " + copy[0]);
        System.out.println("Actual playlist[0]: " + p.getSongs()[0]);
        System.out.println("Total songs: " + p.getSongCount());
    }
}
