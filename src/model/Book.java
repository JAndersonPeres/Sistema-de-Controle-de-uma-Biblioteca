package model;

public class Book {

    private String id;
    private String title;
    private String author;
    private String publisher;
    private int yearPublication;
    private boolean available;
    private int qtdLoans;

    public Book(String id, String title, String author, String publisher, int yearPublication){
        this.id = id;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.yearPublication = yearPublication;
        this.available = true;
        this.qtdLoans = 0;
    }

    //GETTERS
    public String getId(){ return this.id; }
    public String getTitle(){ return this.title; }
    public String getAuthor(){ return this.author; }
    public String getPublisher(){ return this.publisher; }
    public int getYearPublication(){ return this.yearPublication; }
    public boolean isAvailable(){ return this.available; }
    public int getQtdLoans(){ return this.qtdLoans; }

    public void borrow(){
        this.available = false;
        this.qtdLoans++;
    }

    public void returns(){
        this.available = true;
    }

    @Override
    public String toString(){
        return "ID: " + id + "\nTitle: " + title + "\nAuthor: " + author + "\nPublisher: " + publisher +
                "\nYear of Publication: " + yearPublication + "\nAvailable: " + ((available) ? "Yes" : "No");
    }

}
