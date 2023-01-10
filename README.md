# Supermarket pricer kata
The problem domain is pricing a basket of goods at supermarkets. Some
things have simple prices: this can of beans costs $0.65. Other things
have more complex prices. For example:
- three for a dollar (so what’s the price if I buy 4, or 5?)
- $1.99/pound (so what does 4 ounces cost?)
- buy two, get one free (so does the third item have a price?)

The goal of the exercise is to implement pricing code that can handle different scenarios, such as the following:
- All the items in the basket do not benefit from promotion (basic total price)
- Some items benefit from **the package promotion** such as "three items for a dollar".
- **Weighted items** benefit from promotion based on weight such as "2 pounds for one dollar" and taking into account all possible conversions (Gram, Ounce, Pound, Kilogram)
- Some items benefit from **the offer promotion** such as "buy 2 get 1 free".
- Items in the basket benefit from different types of promotion **the package promotion**, promotion based on weight and **the offer promotion**

We have as inputs three csv files: 
- **promotions.csv**: contains promotions data: name, type(package or offer), price, quantity, quantity offered, unit and weight
- **items.csv**: contains product data: name, price, promotion name, weight and unit
- **basket.csv**: contains basket data: item name, bought quantity and bought unit
