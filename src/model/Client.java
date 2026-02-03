package model;

public class Client {

    private String id;
    private String name;
    private String cpf;
    private String address;
    private String phone;
    private String email;
    private int qtdLoans;
    private int qtdLoansNow;

    public Client(String id, String name, String cpf, String address, String phone, String email){
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.qtdLoans = 0;
        this.qtdLoansNow = 0;
    }

    //GETTERS
    public String getId(){ return this.id; }
    public String getName(){ return this.name; }
    public String getCpf(){ return this.cpf; }
    public String getAddress(){ return this.address; }
    public String getPhone(){ return this.phone; }
    public String getEmail(){ return this.email; }
    public int getQtdLoans(){ return this.qtdLoans; }
    public int getQtdLoansNow(){ return this.qtdLoansNow; }

    public void borrow(){
        this.qtdLoansNow++;
        this.qtdLoans++;
    }

    public void returns(){
        this.qtdLoansNow--;
    }

    @Override
    public String toString(){
        return "ID: " + id + "\nName: " + name + "\nCPF: " +
                String.format("***.%s%s%s.%s%s%s-**", cpf.charAt(3), cpf.charAt(4), cpf.charAt(5), cpf.charAt(6),
                        cpf.charAt(7), cpf.charAt(8)) + "\nAddress: " + address + "\nPhone: " + phone + "\nEmail: "
                + email + "\nLoans Activated: " + qtdLoansNow;
    }

}
