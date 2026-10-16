package ca.gbc.comp3074.madubuchi_ihechu.paycalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Inputs and buttons
        val etHours = findViewById<EditText>(R.id.etHours)
        val etRate = findViewById<EditText>(R.id.etRate)
        val etTaxRate = findViewById<EditText>(R.id.etTaxRate)
        val btnCalculate = findViewById<Button>(R.id.btnCalculate)
        val btnAbout = findViewById<Button>(R.id.btnAbout)

        // Outputs
        val tvPay = findViewById<TextView>(R.id.tvPay)
        val tvOvertimePay = findViewById<TextView>(R.id.tvOvertimePay)
        val tvTotalPay = findViewById<TextView>(R.id.tvTotalPay)
        val tvTax = findViewById<TextView>(R.id.tvTax)

        btnCalculate.setOnClickListener {
            val hours = etHours.text.toString().toDoubleOrNull()
            val rate = etRate.text.toString().toDoubleOrNull()
            val taxRate = etTaxRate.text.toString().toDoubleOrNull()

            if (hours == null || rate == null || taxRate == null) {
                Toast.makeText(this, "Please enter valid numbers in all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Calculate pay and overtime pay
            val pay: Double
            val overtimePay: Double

            if (hours <= 40) {
                pay = hours * rate
                overtimePay = 0.0
            } else {
                pay = 40 * rate
                overtimePay = (hours - 40) * rate * 1.5
            }

            // Calculate total pay and tax
            val totalPay = pay + overtimePay
            val tax = pay * taxRate

            // Display the results
            tvPay.text = "Pay: $%.2f".format(pay)
            tvOvertimePay.text = "Overtime Pay: $%.2f".format(overtimePay)
            tvTotalPay.text = "Total Pay: $%.2f".format(totalPay)
            tvTax.text = "Tax: $%.2f".format(tax)
        }

        // Open the About screen
        btnAbout.setOnClickListener {
            val intent = Intent(this, AboutActivity::class.java)
            startActivity(intent)
        }
    }
}