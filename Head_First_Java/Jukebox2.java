import java.util.*;

public class Jukebox2 {
	public static void main(String[] args) {
		new Jukebox2().go();
	}

	public void go() {
		List<SongV2> songList = MockSongs.getSongsV2();
		System.out.println(songList);
		Collections.sort(songList); // won't work, need a method from Comparator
		System.out.println(songList);
	}
}

// standin for I/O code

class MockSongs {
	public static List<String> getSongStrings() {
		List<String> songs = new ArrayList<>();
		songs.add("somersault");
		songs.add("cassidy");
		songs.add("$10");
		songs.add("havana");
		songs.add("Cassidy");
		songs.add("50 Ways");
		return songs;
	}

	public static List<SongV2> getSongsV2() {
		List<SongV2> songs = new ArrayList<>();
		songs.add(new SongV2("somersault", "zero 7", 147));
		songs.add(new SongV2("cassidy", "grateful dead", 158));
		songs.add(new SongV2("$10", "hitchhiker", 140));
		songs.add(new SongV2("havana", "cabello", 105));
		songs.add(new SongV2("Cassidy", "grateful dead", 158));
		songs.add(new SongV2("50 Ways", "simon", 102));
		return songs;
	}
}

class SongV2 {
	private String title;
	private String artist;
	private int bpm;

	SongV2(String title, String artist, int bpm) {
		this.title = title;
		this.artist = artist;
		this.bpm = bpm;
	}

	public String getTitle() {
		return title;
	}

	public String getArtist() {
		return artist;
	}

	public int getBpm() {
		return bpm;
	}

	public String toString() { // overriding toString() so printing a list of song objects will call this
								// method
		return title;
	}
}