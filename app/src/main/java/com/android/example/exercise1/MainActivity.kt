package com.android.example.exercise1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.text.DecimalFormat


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        findViewById<Button>(R.id.buttonCalculate).setOnClickListener{
            calFunction()
        }
        findViewById<Button>(R.id.buttonReset).setOnClickListener{
            reset()
    }
}
    private fun calFunction() {

        val carPrice = findViewById<EditText>(R.id.editTextCarPrice)
        val downPayment = findViewById<EditText>(R.id.editTextDownPayment)
        val loanPeriod = findViewById<EditText>(R.id.editTextLoanPeriod)
        val interestRate = findViewById<EditText>(R.id.editTextInterestRate)
        val loan = findViewById<TextView>(R.id.textViewLoan)
        val interest = findViewById<TextView>(R.id.textViewInterest)
        val monthlyRepay = findViewById<TextView>(R.id.textViewMonthlyRepayment)

        val decimalFormat = DecimalFormat("#.00")
        val calLoan = carPrice.text.toString().toDouble() - downPayment.text.toString().toDouble()
        val calInterest = calLoan * (interestRate.text.toString().toDouble() / 100) * loanPeriod.text.toString().toDouble()
        val calRepay = ((calLoan + calInterest) / loanPeriod.text.toString().toDouble() / 12)

        loan.text = (resources.getString(R.string.loan) + " RM " + decimalFormat.format(calLoan))
        interest.text = (resources.getString(R.string.interest) + " RM " + decimalFormat.format(calInterest))
        monthlyRepay.text = (resources.getString(R.string.monthly_repayment) + " RM " + decimalFormat.format(calRepay))
    }

    private fun reset()
    {
        val carPrice = findViewById<EditText>(R.id.editTextCarPrice)
        val downPayment = findViewById<EditText>(R.id.editTextDownPayment)
        val loanPeriod = findViewById<EditText>(R.id.editTextLoanPeriod)
        val interestRate = findViewById<EditText>(R.id.editTextInterestRate)
        val loan = findViewById<TextView>(R.id.textViewLoan)
        val interest = findViewById<TextView>(R.id.textViewInterest)
        val monthlyRepay = findViewById<TextView>(R.id.textViewMonthlyRepayment)

        carPrice.setText("")
        downPayment.setText("")
        loanPeriod.setText("")
        interestRate.setText("")
        loan.text = resources.getString(R.string.loan)
        interest.text = resources.getString(R.string.interest)
        monthlyRepay.text = resources.getString(R.string.monthly_repayment)

        carPrice.requestFocus()
    }
}