package model;

import java.time.LocalDate;

public class Loans {

    private String id;
    private Book book;
    private Client client;
    private LocalDate dateLoan;
    private LocalDate dateDeadLine;
    private LocalDate dateReal;
    private LoanStatus status;
    private double fine;

    public Loans(String id, Book book, Client client){
        this.id = id;
        this.book = book;
        this.client = client;
        this.dateLoan = LocalDate.now();
        this.dateDeadLine = this.dateLoan.plusDays(7);
        this.dateReal = null;
        this.status = LoanStatus.ACTIVATE;
        this.fine = 0.0;
    }

    //GETTERS
    public String getId(){ return this.id; }
    public Book getBook(){ return this.book; }
    public Client getClient(){ return this.client; }
    public LocalDate getDateLoan(){ return this.dateLoan; }
    public LocalDate getDateDeadLine(){ return this.dateDeadLine; }
    public LocalDate getDateReal(){ return this.dateReal; }
    public LoanStatus getStatus(){ return this.status; }
    public double getFine(){ return this.fine; }

    public void lateRegistration(double fine){
        this.fine = fine;
        this.status = LoanStatus.LATE;
    }

    public void returnRegistration(LocalDate dateReal, double fine){
        this.fine = fine;
        this.dateReal = dateReal;
        this.status = LoanStatus.RETURNED;
    }

    public boolean isActivate(){ return this.status == LoanStatus.ACTIVATE; }
    public boolean isLate(){ return this.status == LoanStatus.LATE; }
    public boolean isReturned(){ return this.status == LoanStatus.RETURNED; }

    @Override
    public String toString(){
        return "ID: " + id + "\nBook: " + book.getTitle() + "\nClient: " + client.getName() + "\nLoan Date: " + dateLoan
                + "\nDeadline Date: " + dateDeadLine + ((status == LoanStatus.RETURNED) ? ("\nReturn Date: " + dateReal) : "")
                + "\nLoan Status: " + status + "\nFine: $" + String.format("%.2f", fine);
    }

}
