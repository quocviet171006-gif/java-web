<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Survey submitted</title>
    <link rel="stylesheet" href="styles/main.css">
</head>

<body>
    <main>
        <img src="images/murach_logo.png" alt="Murach logo" class="logo">
        <h1>Thank you for completing the survey</h1>
        <p>Here is the information you submitted:</p>

        <section>
            <h2>Your information:</h2>

            <p class="result-row"><strong>First Name:</strong><span>${user.firstName}</span></p>
            <p class="result-row"><strong>Last Name:</strong><span>${user.lastName}</span></p>
            <p class="result-row"><strong>Email:</strong><span>${user.email}</span></p>
            <p class="result-row"><strong>Date of Birth:</strong><span>${user.birthDate}</span></p>
        </section>

        <section>
            <h2>Survey Results:</h2>
            <p><strong>How you heard about us:</strong> ${survey.source}</p>
            <p><strong>Would you like to receive announcements about new CDs and special offers?</strong>
                ${survey.announcements ? 'Yes' : 'No'}</p>
            <p><strong>Would you like information about new products?</strong>
                ${survey.newProducts ? 'Yes' : 'No'}</p>
            <p><strong>Please contact me by:</strong> ${survey.contactMethodsDisplay}</p>
        </section>

        <p><a href="index.html">Return to the survey</a></p>
    </main>
</body>
</html>