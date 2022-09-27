import java.util.*;

public class Jukebox5 {
	public static void main(String[] args) {
		new Jukebox5().go();
	}

	public void go() {
		List<SongV3> songList = MockSongs.getSongsV3();
		System.out.println(songList);
		
		TitleCompare titleCompare = new TitleCompare();
		songList.sort(titleCompare);
		System.out.println(songList);

		ArtistCompare artistCompare = new ArtistCompare();
		songList.sort(artistCompare);
		System.out.println(songList);
	}
}

class TitleCompare implements Comparator<SongV3> {
	public int compare(SongV3 one, SongV3 two) {
		return one.getTitle().comparTo(two.getTitle());
	}
}

class ArtistCompare implements Comparator<SongV3> {
	public int compare(SongV3 one, SongV3 two) {
		return one.getArtist().compareTo(two.getArtist());
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

	public static List<SongV3> getSongsV3() {
		List<SongV3> songs = new ArrayList<>();
		songs.add(new SongV3("somersault", "zero 7", 147));
		songs.add(new SongV3("cassidy", "grateful dead", 158));
		songs.add(new SongV3("$10", "hitchhiker", 140));
		songs.add(new SongV3("havana", "cabello", 105));
		songs.add(new SongV3("Cassidy", "grateful dead", 158));
		songs.add(new SongV3("50 Ways", "simon", 102));
		return songs;
	}
}

class SongV3 implements Comparable<SongV3> {
	private String title;
	private String artist;
	private int bpm;

	public int compareTo(SongV3 s) {
		return title.compareTo(s.getTitle());
	}

	SongV3(String title, String artist, int bpm) {
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