package database.movieUtil;

public class MovieSearched extends MovieToFrontEnd{
    private String MEnglishName;
    private String Mtype;
    private String Mdate;

    public MovieSearched(Movie movie){
        super(movie);
        this.MEnglishName = movie.getMEnglishName();
        this.Mtype = movie.getMtype();
        this.Mdate = movie.getMdate();
    }

    public String getMEnglishName() {
        return MEnglishName;
    }

    public String getMdate() {
        return Mdate;
    }

    public String getMtype() {
        return Mtype;
    }
}
