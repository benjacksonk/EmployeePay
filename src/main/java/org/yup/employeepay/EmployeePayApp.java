package org.yup.employeepay;

import java.io.*;

public class EmployeePayApp {

    public static void main(String[] args) {

        try {

            FileReader employeesFileReader = new FileReader("employees.csv");
            BufferedReader employeeFileReaderButBetter = new BufferedReader(employeesFileReader);

            FileWriter payFileWriter = new FileWriter("employeesGrossPay.txt");
            BufferedWriter payFileWriterButBetter = new BufferedWriter(payFileWriter);

            // read the first line and forget about it, cuz it's just a header row and nobody cares
            employeeFileReaderButBetter.readLine();

            // while( read the next line, and if it is NOT null... do stuff )
            String line;
            payFileWriterButBetter.write("[\n");
            for(boolean firstEmployee = true; (line = employeeFileReaderButBetter.readLine()) != null; ) {

                // split the line into separate strings based on '|'
                String[] linePieces = line.split("\\|");

                // parse the strings to make useful variables
                int id = Integer.parseInt(linePieces[0]);
                String name = linePieces[1];
                float hoursWorked = Float.parseFloat(linePieces[2]);
                float payRate = Float.parseFloat(linePieces[3]);

                Employee newEmployee = new Employee(id, name, hoursWorked, payRate);
//                payFileReaderButBetter.write(newEmployee.payPeriodInfo());

                if (firstEmployee) {
                    firstEmployee = false;
                } else {
                    payFileWriterButBetter.write(",\n");
                }

                payFileWriterButBetter.write(
                        String.format(
                                "   { \"id\" : %d, \"name\" : %s, \"grossPay\" : %.2f }",
                                newEmployee.getEmployeeID(),
                                newEmployee.getName(),
                                newEmployee.calculateGrossPay()
                        )
                );

            }
            payFileWriterButBetter.write("\n]");

            payFileWriterButBetter.close();
            payFileWriter.close();

            employeeFileReaderButBetter.close();
            employeesFileReader.close();

        } catch (IOException e) {

            System.out.println("Sorry but we couldn't find that file on the computer");
            e.printStackTrace();

        }

    }

}
