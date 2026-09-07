// =========================
// ADD EMPLOYEE FORM
// =========================

const addEmployeeBtn =
    document.getElementById("addEmployeeBtn");

const employeeForm =
    document.getElementById("employeeForm");

const cancelBtn =
    document.getElementById("cancelBtn");


// Show Add Employee Form

addEmployeeBtn.addEventListener("click", function () {

    employeeForm.style.display = "block";

});


// Hide Add Employee Form

cancelBtn.addEventListener("click", function () {

    employeeForm.style.display = "none";

});


// =========================
// ADD EMPLOYEE
// =========================

const addEmployeeForm =
    document.getElementById("addEmployeeForm");


addEmployeeForm.addEventListener("submit", function (event) {

    event.preventDefault();

    const employee = {

        name: document.getElementById("name").value,

        email: document.getElementById("email").value,

        department: document.getElementById("department").value,

        salary: parseFloat(
            document.getElementById("salary").value
        ),

        phone: document.getElementById("phone").value
    };


    fetch("http://localhost:8081/api/employees", {

        method: "POST",

        headers: {
            "Content-Type": "application/json"
        },

        body: JSON.stringify(employee)

    })

    .then(response => {

        if (!response.ok) {

            throw new Error("Failed to add employee");

        }

        return response.json();

    })

    .then(data => {

        alert("Employee added successfully!");

        addEmployeeForm.reset();

        employeeForm.style.display = "none";

        loadEmployees();

    })

    .catch(error => {

        console.error("Error:", error);

        alert("Failed to add employee!");

    });

});


// =========================
// EDIT EMPLOYEE FORM
// =========================

const editEmployeeForm =
    document.getElementById("editEmployeeForm");

const cancelEditBtn =
    document.getElementById("cancelEditBtn");


// Hide Edit Form

cancelEditBtn.addEventListener("click", function () {

    editEmployeeForm.style.display = "none";

});


// =========================
// EDIT EMPLOYEE
// =========================

 function editEmployee(id) {

    fetch("http://localhost:8081/api/employees/" + id)

        .then(response => {

            if (!response.ok) {
                throw new Error("Failed to load employee");
            }

            return response.json();

        })

        .then(employee => {

            editEmployeeForm.style.display = "block";

            document.getElementById("editId").value =
                employee.employee;

            document.getElementById("editName").value =
                employee.name;

            document.getElementById("editEmail").value =
                employee.email;

            document.getElementById("editDepartment").value =
                employee.department;

            document.getElementById("editSalary").value =
                employee.salary;

            document.getElementById("editPhone").value =
                employee.phone;

        })

        .catch(error => {

            console.error("Error:", error);

            alert("Failed to load employee.");

        });
}

// =========================
// UPDATE EMPLOYEE
// =========================

const updateEmployeeForm =
    document.getElementById("updateEmployeeForm");


updateEmployeeForm.addEventListener("submit", function (event) {

    event.preventDefault();


    const employee = {

        employee: parseInt(
            document.getElementById("editId").value
        ),

        name:
            document.getElementById("editName").value,

        email:
            document.getElementById("editEmail").value,

        department:
            document.getElementById("editDepartment").value,

        salary: parseFloat(
            document.getElementById("editSalary").value
        ),

        phone:
            document.getElementById("editPhone").value
    };


    fetch("http://localhost:8081/api/employees", {

        method: "PUT",

        headers: {
            "Content-Type": "application/json"
        },

        body: JSON.stringify(employee)

    })

    .then(response => {

        if (!response.ok) {

            throw new Error("Failed to update employee");

        }

        return response.json();

    })

    .then(data => {

        alert("Employee updated successfully!");

        editEmployeeForm.style.display = "none";

        loadEmployees();

    })

    .catch(error => {

        console.error("Error:", error);

        alert("Failed to update employee!");

    });

});


// =========================
// DELETE EMPLOYEE
// =========================

function deleteEmployee(id) {

    const confirmDelete = confirm(
        "Are you sure you want to delete Employee ID " + id + "?"
    );

    if (!confirmDelete) {
        return;
    }

    fetch("http://localhost:8081/api/employees/" + id, {
        method: "DELETE"
    })
    .then(response => {

        if (!response.ok) {
            throw new Error("Failed to delete employee");
        }

        return response.text();
    })
    .then(data => {

        alert("Employee deleted successfully!");

        loadEmployees();

    })
    .catch(error => {

        console.error("Error:", error);

        alert("Failed to delete employee.");

    });
}


// =========================
// LOAD EMPLOYEES FROM API
// =========================

function loadEmployees() {

    fetch("http://localhost:8081/api/employees")

        .then(response => {

            if (!response.ok) {

                throw new Error(
                    "Failed to load employees"
                );

            }

            return response.json();

        })

        .then(employees => {


            // =========================
            // TOTAL EMPLOYEES
            // =========================

            document.getElementById(
                "totalEmployees"
            ).textContent = employees.length;


            // =========================
            // TOTAL DEPARTMENTS
            // =========================

            const departments = new Set(

                employees.map(
                    employee => employee.department
                )

            );


            document.getElementById(
                "totalDepartments"
            ).textContent = departments.size;


            // =========================
            // EMPLOYEE TABLE
            // =========================

            const tableBody =
                document.getElementById(
                    "employeeTableBody"
                );


            tableBody.innerHTML = "";


            employees.forEach(employee => {

                const row =
                    document.createElement("tr");


                row.innerHTML = `

                    <td>
                        ${employee.employee}
                    </td>

                    <td>
                        ${employee.name}
                    </td>

                    <td>
                        ${employee.email}
                    </td>

                    <td>
                        ${employee.department}
                    </td>

                    <td>
                        ₹${employee.salary}
                    </td>

                    <td>
                        ${employee.phone}
                    </td>

                    <td>

                        <button
                            class="edit-btn"
                            onclick="editEmployee(
                                ${employee.employee}
                            )">

                            Edit

                        </button>


                        <button
                            class="delete-btn"
                            onclick="deleteEmployee(
                                ${employee.employee}
                            )">

                            Delete

                        </button>

                    </td>

                `;


                tableBody.appendChild(row);

            });

        })


        .catch(error => {

            console.error(
                "Error loading employees:",
                error
            );

        });

}


// =========================
// LOAD EMPLOYEES WHEN PAGE OPENS
// =========================

loadEmployees();