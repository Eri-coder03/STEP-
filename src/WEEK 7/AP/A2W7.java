import java.util.Arrays;

public class A2W7 {
    static class Playlist {
        private String[] songs;
        private int count;

        Playlist(int size) {
            songs = new String[size];
            count = 0;
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
    }

    public static void main(String[] args) {
        Playlist p = new Playlist(10);

        p.addSong("Song A");
        p.addSong("Song B");

        String[] copy = p.getSongs();

        System.out.println("Songs:");
        for (String song : copy) {
            System.out.println(song);
        }

        copy[0] = "Hacked";

        System.out.println("Original first song = " + p.getSongs()[0]);
        System.out.println("Song count = " + p.getSongCount());
    }
}
