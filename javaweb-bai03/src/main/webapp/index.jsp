<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<c:import url="/includes/header.jsp" />

    <header>
        <h1>CD list</h1>
    </header>

    <section>
        <table>
            <thead>
                <tr>
                    <th scope="col">Description</th>
                    <th scope="col" class="price">Price</th>
                    <th scope="col" class="action">Action</th>
                </tr>
            </thead>

            <tbody>
                <tr>
                    <td>86 (the band) - True Life Songs and Pictures</td>
                    <td class="price">$14.95</td>
                    <td class="action">
                        <form action="cart" method="post">
                            <input type="hidden" name="action" value="add">
                            <input type="hidden" name="id" value="cd1">
                            <button type="submit">Add to Cart</button>
                        </form>
                    </td>
                </tr>

                <tr>
                    <td>Paddlefoot - The first CD</td>
                    <td class="price">$12.95</td>
                    <td class="action">
                        <form action="cart" method="post">
                            <input type="hidden" name="action" value="add">
                            <input type="hidden" name="id" value="cd2">
                            <button type="submit">Add to Cart</button>
                        </form>
                    </td>
                </tr>

                <tr>
                    <td>Paddlefoot - The second CD</td>
                    <td class="price">$14.95</td>
                    <td class="action">
                        <form action="cart" method="post">
                            <input type="hidden" name="action" value="add">
                            <input type="hidden" name="id" value="cd3">
                            <button type="submit">Add to Cart</button>
                        </form>
                    </td>
                </tr>

                <tr>
                    <td>Joe Rut - Genuine Wood Grained Finish</td>
                    <td class="price">$14.95</td>
                    <td class="action">
                        <form action="cart" method="post">
                            <input type="hidden" name="action" value="add">
                            <input type="hidden" name="id" value="cd4">
                            <button type="submit">Add to Cart</button>
                        </form>
                    </td>
                </tr>
            </tbody>
        </table>
    </section>
</body>
</html>