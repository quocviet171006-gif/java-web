<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<c:import url="/includes/header.jsp" />
<c:url var="cartUrl" value="/cart" />
<c:url var="homeUrl" value="/" />

<main class="shop checkout-page">
  <h1>Order Summary</h1>
  <c:choose>

    <c:when test="${cart.count == 0}">
      <p>Your cart is empty.</p>
      <a class="button-link" href="${homeUrl}">Continue Shopping</a>
    </c:when>

    <c:otherwise>
      <table class="invoice-table">
        <thead>
          <tr>
            <th scope="col">Description</th>
            <th scope="col" class="price">Quantity</th>
            <th scope="col" class="price">Unit Price</th>
            <th scope="col" class="price">Amount</th>
          </tr>
        </thead>

        <tbody>
          <c:forEach var="item" items="${cart.items}">
            <tr>
              <td><c:out value="${item.product.description}" /></td>
              <td class="price"><c:out value="${item.quantity}" /></td>
              <td class="price"><c:out value="${item.product.priceCurrencyFormat}" /></td>
              <td class="price"><c:out value="${item.totalCurrencyFormat}" /></td>
            </tr>
          </c:forEach>
        </tbody>

        <tfoot>
          <tr>
            <th colspan="3" scope="row">Total</th>
            <td class="price"><strong><c:out value="${cart.totalCurrencyFormat}" /></strong></td>
          </tr>
        </tfoot>
        
      </table>

      <p class="checkout-actions">
        <a class="button-link" href="${cartUrl}">Back to Cart</a>
        <a class="button-link" href="${homeUrl}">Continue Shopping</a>
      </p>
    </c:otherwise>
    
  </c:choose>
</main>
</body>
</html>