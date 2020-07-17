package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

public class Program {
  public static void main(String[] args) {

    Locale.setDefault(Locale.US);
    Scanner sc = new Scanner(System.in);

    List<TaxPayer> list = new ArrayList<TaxPayer>();

    System.out.print("Enter the number of taxpayers: ");
    int numberOfTaxpayers = sc.nextInt();

    for (int i = 1; i <= numberOfTaxpayers; i++) {
      System.out.println("Taxpayer #" + i + " data: ");
      System.out.print("Individual or Company (i/c)? ");
      char taxPayerType = sc.next().charAt(0);

      System.out.print("Name: ");
      String name = sc.next();

      System.out.print("Anual income: ");
      double anualIncome = sc.nextDouble();

      if (taxPayerType == 'i') {
        System.out.print("Health expenditures: ");
        double healthExpenditures = sc.nextDouble();
        list.add(new Individual(name, anualIncome, healthExpenditures));
      } else {
        System.out.print("Number of employees: ");
        Integer numberOfEmployees = sc.nextInt();
        list.add(new Company(name, anualIncome, numberOfEmployees));
      }
    }

    System.out.println();
    System.out.println("TAXES PAID: ");
    for (TaxPayer taxPayer : list) {
      System.out.println(
        taxPayer.getName()
        + ": $ "
        + String.format("%.2f", taxPayer.tax())
      );
    }

    double sum = 0.0;
    for (TaxPayer taxPayer : list) {
      sum += taxPayer.tax();
    }

    System.out.println("TOTAL TAXES: $ " + String.format("%.2f", sum));

    sc.close();
  }
}