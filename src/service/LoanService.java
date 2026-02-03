package service;

import exceptions.*;
import model.*;
import util.IdGenerator;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class LoanService {

    private static final int MAX_LOAN = 5;
    private static final double FINE_PER_DAY = 1.5;

    private final BookService bookService;
    private final ClientService clientService;
    private final List<Loans> loans;

    public LoanService(BookService bookService, ClientService clientService, List<Loans> loans){
        this.bookService = bookService;
        this.clientService = clientService;
        this.loans = loans;
    }

    public void registerLoan(String idBook, String cpfClient){
        Book book;
        Client client;
        try{
            book = bookService.searchById(idBook);
            client = clientService.searchByCpf(cpfClient);
        } catch (NoBooksFoundException e) {
            throw new InvalidLoanException("INVALID BOOK.");
        } catch (NoClientFoundException e) {
            throw new InvalidLoanException("INVALID CLIENT.");
        }
        if(client.getQtdLoansNow() >= MAX_LOAN) throw new MaxLoanReachedException("MAXIMUM LOANS PER CLIENT REACHED.");
        if(!book.isAvailable()) throw new BookNotAvailableException("BOOK NOT AVAILABLE IN THE MOMENT.");
        client.borrow();
        book.borrow();
        loans.add(new Loans(IdGenerator.generateID(), book, client));
    }
    public void registerReturn(String idLoan){
        Loans loan;
        try {
            loan = searchById(idLoan);
        } catch (NoLoanFoundException e) {
            throw new NoIdLoanRegisterException("ID NOT REGISTER.");
        }
        if(!loan.isReturned()) throw new LoanAlreadyReturnedException("LOAN ALREADY RETURNED.");
        loan.returnRegistration(LocalDate.now(), calculateFine(loan));
        loan.getBook().returns();
        loan.getClient().returns();
    }
    public Loans searchById(String idLoan){
        Loans filter = this.loans.stream().filter(loans1 -> loans1.getId().equals(idLoan)).findFirst().orElse(null);
        if(filter == null) throw new NoLoanFoundException("NO LOAN FOUND.");
        return filter;
    }
    private double calculateFine(Loans loan){
        if(!loan.isLate()) return 0.0;
        long daysLate = ChronoUnit.DAYS.between(loan.getDateDeadLine(), LocalDate.now());
        return daysLate * FINE_PER_DAY;
    }

}
