<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Pizza World</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<c:if test="${  pizzaSize   != null &&
                pizzaSauce  != null &&
                pizzaCrust  != null &&
                pizzaCheese != null &&
                pizzaToppings == null}">
<h4>Your ${pizzaSize} ${pizzaCrust} ${pizzaSauce} ${pizzaCheese} pizza order has been placed.</h4>
</c:if>
<c:if test="${  pizzaSize    != null &&
                pizzaSauce   != null &&
                pizzaCrust   != null &&
                pizzaCheese  != null &&
                pizzaToppings!= null}">

    <h4 class="text-center">Your ${pizzaSize} ${pizzaCrust} ${pizzaSauce} ${pizzaCheese} pizza with: <c:forEach var="topping" items="${pizzaToppings}"><ul><li class="list-unstyled">${topping}</li></ul></c:forEach>toppings has been placed.</h4>
</c:if>
<form method="post" action="pizza-order" class="container text-center mt-5">
    <div class="row row-cols-2">
        <div class="col">
            <h3 class="mt-2">Pizza Size:</h3>
            <input type="radio" id="small" name="pizzaSize" value="small">
            <label for="small">Small(10")</label><br>
            <input type="radio" id="medium" name="pizzaSize" value="medium">
            <label for="medium">Medium(12")</label><br>
            <input type="radio" id="large" name="pizzaSize" value="large">
            <label for="large">Large(14")</label><br>
            <input type="radio" id="xlarge" name="pizzaSize" value="xlarge">
            <label for="xlarge">X-Large(16")</label>
        </div>

        <div class="col">
            <h3 class="mt-2">Crust:</h3>
            <input type="radio" id="stuffedCrust" name="pizzaCrust" value=" stuffed crust ">
            <label for="stuffedCrust">Stuffed Crust</label><br>
            <input type="radio" id="garlicCrust" name="pizzaCrust" value=" garlic crust ">
            <label for="garlicCrust">Garlic Crust</label><br>
            <input type="radio" id="plainCrust" name="pizzaCrust" value=" plain crust ">
            <label for="plainCrust">Plain Crust</label>
        </div>

        <div class="col">
            <h3 class="mt-2">Sauce:</h3>
            <input type="radio" id="lightMarinara" name="pizzaSauce" value="light marinara">
            <label for="lightMarinara">light marinara</label><br>
            <input type="radio" id="regularMarinara" name="pizzaSauce" value="regular marinara">
            <label for="regularMarinara">regular marinara</label><br>
            <input type="radio" id="extraMarinara" name="pizzaSauce" value="extra marinara">
            <label for="extraMarinara">extra marinara</label>
        </div>

        <div class="col">
            <h3 class="mt-2">Cheese:</h3>
            <input type="radio" id="lightCheese" name="pizzaCheese" value="light cheese">
            <label for="lightCheese">light cheese</label><br>
            <input type="radio" id="regularCheese" name="pizzaCheese" value="regular cheese">
            <label for="regularCheese">regular cheese</label><br>
            <input type="radio" id="extraCheese" name="pizzaCheese" value="extra cheese">
            <label for="extraCheese">extra cheese</label>
        </div>

        <div class="col">
            <h3 class="mt-2">Meat Toppings:</h3>
            <input type="checkbox" id="pepperoniTopping" name="pizzaToppings" value="pepperoni">
            <label for="pepperoniTopping">Pepperoni</label><br>
            <input type="checkbox" id="chickenTopping" name="pizzaToppings" value="chicken">
            <label for="chickenTopping">Chicken</label><br>
            <input type="checkbox" id="sausageTopping" name="pizzaToppings" value="sausage">
            <label for="sausageTopping">Sausage</label>
        </div>

        <div class="col">
            <h3 class="mt-2">Veggie Toppings:</h3>
            <input type="checkbox" id="greenPepperTopping" name="pizzaToppings" value="green pepper">
            <label for="greenPepperTopping">Green pepper</label><br>
            <input type="checkbox" id="redPepperTopping" name="pizzaToppings" value="red pepper">
            <label for="redPepperTopping">Red pepper</label><br>
            <input type="checkbox" id="mushroomTopping" name="pizzaToppings" value="mushroom">
            <label for="mushroomTopping">Mushrooms</label>
        </div>
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>


<!-- bootstrap script-->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>

</body>
</html>
