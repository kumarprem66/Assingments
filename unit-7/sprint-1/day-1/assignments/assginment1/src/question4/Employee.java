package question4;

import javax.lang.model.element.NestingKind;
import java.util.Objects;

public class Employee {

    private int id;
    private String name;
    private double salary;
    private EPFOAccount epfoAccount;

    public Employee(int id, String name, double salary, EPFOAccount epfoAccount) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.epfoAccount = epfoAccount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return
                "EmployeeId: " + id +
                ", Name: " + name  +
                ", Salary: " + salary +
                ", AccountDetails: (Account number: " + epfoAccount.getAccountNumber() + " Balance: "+epfoAccount.getBalance()+"/-)"
                ;
    }
}
