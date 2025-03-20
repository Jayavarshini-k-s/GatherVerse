/*$(document).ready(function() {
    $('#admin-btn').click(function() {
        $('#role').val('admin'); // Set the role to 'admin'
        console.log("Role set to admin"); // Debugging line
        window.location.href = `/login/form?role=${selectedRole}`;
        //$('#login-form').show(); // Show the login form
    });

    $('#student-btn').click(function() {
        $('#role').val('student'); // Set the role to 'student'
        console.log("Role set to student"); // Debugging line
        $('#login-form').show(); // Show the login form
    });
});*/

$(document).ready(function() {
        $('.role-btn').click(function() {
            const selectedRole = $(this).data('role');
            // Redirect to login form with role as a query parameter
            window.location.href = `/login/form?role=${selectedRole}`;
        });
    });