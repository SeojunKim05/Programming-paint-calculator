# 🖌️ PaintShop Calculator

A standalone Java GUI application for estimating the amount and cost of paint needed to cover the **walls and ceiling** of a rectangular room. The program allows users to input room dimensions in feet and inches, then calculates:

- The **total surface area**,
- The **exact gallons of paint required** (to 3 decimal places),
- The **optimal combination of paint container sizes** (minimizing excess and number of containers),
- The **total cost**, and
- An **optional discount**, based on a unique pricing condition.

---

## 🧰 Features

✔️ Intuitive GUI built with Java Swing  
✔️ Unit conversion (feet/inches to inches)  
✔️ Surface area calculation for all walls + ceiling  
✔️ Intelligent container optimization (using largest containers first)  
✔️ Cost breakdown with pricing tiers  
✔️ Conditional discount logic  
✔️ Clean and professional output formatting

---

## 🗂️ Project Structure

programmingProject3/

├── PaintShop.java # Main GUI interface (no logic here)

└── PaintShopCalculator.java # Core logic for calculations and output


- `PaintShop.java`: A complete, pre-built GUI for user interaction. Allows users to input room dimensions and view results. This class uses standard Java Swing components and should not be modified.
- `PaintShopCalculator.java`: Contains all logic for paint estimation, container breakdown, cost calculation, and discount evaluation. This is the core of the application.

---

## 🧮 Paint Logic

- **Paint coverage**: 1 gallon = 25,000 square inches
- **Painted surfaces**: 4 walls + ceiling (floor is excluded)
- **Supported container sizes**:

| Size           | Volume (gal) | Price (USD) |
|----------------|--------------|-------------|
| Five Gallon    | 5.0          | $124.00     |
| One Gallon     | 1.0          | $25.10      |
| Half Gallon    | 0.5          | $13.00      |
| Quart          | 0.25         | $6.70       |
| Pint           | 0.125        | $3.95       |
| Half Pint      | 0.0625       | $2.25       |

The application ensures the smallest number of containers is used by always selecting the **largest available size** first.

---

## 🎁 Discount Logic

If the **cent portion** of the total price is:
- **Odd**, and  
- **Divisible by 5**, but  
- **Not divisible by 10**

Then the customer gets **1 container (the largest available in the current order) for free**, reducing the total price.

---

## 🧪 Example Output

For this job, you need 5.427 gallons of paint.
You will need to purchase:
1 five-gallon container
1 one-quart container
1 one-pint container
1 one-half-pint container

Price without discount:
Your total is $136.90

Because the amount of cents (90c) in the cost
is not odd and divisible by 5, no discount is
applied.

Thank you for your business!


---

## 🚀 How to Run

1. Make sure you have **Java 8+** installed.
2. Clone or download the repository.
3. Compile the files:

```bash
javac programmingProject3/PaintShop.java
Run the program:

PaintShop.java
The GUI window will open. Enter the room dimensions and click Calculate.

```

---

✅ Key Design Principles
No loops or arrays used in logic — the program relies solely on conditionals and arithmetic to encourage clear reasoning.

Readable and grammatically correct output — includes proper use of singular/plural (e.g., "1 pint" vs. "2 pints").

Formatting — gallons to 3 decimal places, price to 2 decimal places.

---

## 🤝 Contact

Got feedback or want to collaborate?

📬 [Open an issue](https://github.com/SeojunKim05/Programming-paint-calculator/issues)  
💼 [LinkedIn](https://www.linkedin.com/in/seojun-kim-089b7b339)  
📫 Email: kseojun05@gmail.com

---
