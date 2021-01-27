package Assignment3;

import java.util.*;

class MovieDetails {

	private String movieName;
	private String actor;
	private String actress;
	private String genre;

	public MovieDetails(String movieName, String actor, String actress, String genre) {
		this.movieName = movieName;
		this.actor = actor;
		this.actress = actress;
		this.genre = genre;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getActor() {
		return actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	public String getActress() {
		return actress;
	}

	public void setActress(String actress) {
		this.actress = actress;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	@Override
	public int hashCode() {
		return Objects.hash(actor, actress, genre, movieName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MovieDetails other = (MovieDetails) obj;
		return Objects.equals(actor, other.actor) && Objects.equals(actress, other.actress)
				&& Objects.equals(genre, other.genre) && Objects.equals(movieName, other.movieName);
	}
	
	

}

class TheSort implements Comparator<MovieDetails> {

	String sortBy = "";

	public TheSort(String sortBy) {
		this.sortBy = sortBy;
	}

	@Override
	public int compare(MovieDetails m1, MovieDetails m2) {
		MovieDetails s1 = (MovieDetails) m1;
		MovieDetails s2 = (MovieDetails) m2;
		if (this.sortBy.equals("movieName")) {
			return s1.getMovieName().compareTo(s2.getMovieName());
		}
		if (this.sortBy.equals("actor")) {
			return s1.getActor().compareTo(s2.getActor());
		}
		if (this.sortBy.equals("actress")) {
			return s1.getActress().compareTo(s2.getActress());
		}
		return s1.getGenre().compareTo(s2.getGenre());
	}
}

public class Assignment3Q10 {
	public static void main(String[] args) {

		MovieDetails movie1 = new MovieDetails("Interstellar", "Matthew McConaughey", "Jessica Chastain", "Sci-Fi");
		MovieDetails movie2 = new MovieDetails("Endgame", "Robert Doweny Jr.", "Scarlett Johansson", "Action");
		MovieDetails movie3 = new MovieDetails("Big Hero 6", "Hiro", "GoGo Tomago", "Animated");
		MovieDetails movie4 = new MovieDetails("10", "Vikram", "Sam", "Action");
		

		Assignment3Q10 assign = new Assignment3Q10();
		
		
		assign.addMovie(movie1);
		assign.addMovie(movie2);
		assign.addMovie(movie3);
		assign.addMovie(movie4);
		
		sort(mDetails, sortAccordingly("movieName"));
		
		printSortedMovieList(mDetails);
		

		System.out.println(assign.find_movie_By_mov_Name("10"));

		System.out.println(assign.find_movie_By_Genre("Action"));
		
		

	}

	public static ArrayList<MovieDetails> mDetails = new ArrayList<>();

	public static void sort(ArrayList<MovieDetails> movieDetails, Comparator<MovieDetails> movieDetailsComparator) {
		Collections.sort(movieDetails, movieDetailsComparator);
	}

	public static void printSortedMovieList(ArrayList<MovieDetails> movieDetails) {
		for (MovieDetails m : movieDetails) {
			System.out.println(m.getMovieName());
		}

	}

	public void addMovie(MovieDetails movie) {
		mDetails.add(movie);
	}

	public void removeMovies(String movieName) {
		MovieDetails x = null;
		for (MovieDetails m : mDetails) {
			if (m.getMovieName().equals(movieName)) {

				x = m;
				break;
			}
		}
		mDetails.remove(x);
	}

	public void removeAllMovies(List<MovieDetails> movies) {
		mDetails.removeAll(movies);
	}

	public MovieDetails find_movie_By_mov_Name(String movieName) {

		for (MovieDetails m : mDetails) {
			if (m.getMovieName().equals(movieName)) {
				return m;
			}
		}
		return null;
	}

	public List<MovieDetails> find_movie_By_Genre(String genre) {
		List<MovieDetails> mGenre = new ArrayList<>();

		for (MovieDetails m : mDetails) {
			if (m.getGenre().equals(genre)) {
				mGenre.add(m);
			}
		}
		return mGenre;
	}

	public static Comparator<MovieDetails> sortAccordingly(String sortBy) {
		Comparator<MovieDetails> mD = (Comparator<MovieDetails>) new TheSort(sortBy);
		return mD;
	}
}
