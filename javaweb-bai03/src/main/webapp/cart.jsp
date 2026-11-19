<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<c:import url="/includes/header.jsp" />
<c:url var="homeUrl" value="/" />
<c:url var="checkoutUrl" value="/checkout" />

<main class="shop cart">
    <h1>Your cart</h1>
    <table>
      <thead>
        <tr>
          <th scope="col">Quantity</th>
          <th scope="col">Description</th>
          <th scope="col" class="price">Price</th>
          <th scope="col" class="price">Amount</th>
          <th scope="col" class="action"></th>
        </tr>
      </thead>

      <tbody>
        <c:forEach var="item" items="${cart.items}">
        <tr>
          <td><form action="cart" method="post">
            <input type="hidden" name="action" value="update"><input type="hidden" name="id" value="${item.product.code}">
            <input class="quantity" type="number" name="quantity" min="1" value="${item.quantity}" aria-label="Quantity for ${item.product.description}">
            <button type="submit">Update</button>
          </form>
          </td>

          <td><c:out value="${item.product.description}" /></td>
          <td class="price"><c:out value="${item.product.priceCurrencyFormat}" /></td>
          <td class="price"><c:out value="${item.totalCurrencyFormat}" /></td>

          <td class="action">
            <form action="cart" method="post">
            <input type="hidden" name="action" value="remove"><input type="hidden" name="id" value="${item.product.code}">
            <button type="submit">Remove Item</button>
            </form>
          </td>
        </tr>

        </c:forEach>
        <c:if test="${cart.count == 0}"><tr><td colspan="5">Your cart is empty.</td></tr></c:if>
      </tbody>
    </table>

    <p><strong>To change the quantity,</strong> enter the new quantity and click on the Update button.</p>
    <section class="checkout">
      <p class="cart-actions"><a class="button-link" href="${homeUrl}">Continue Shopping</a>
      <a class="button-link" href="${checkoutUrl}">Checkout</a></p>
    </section>
  </main>
</body>
</html>