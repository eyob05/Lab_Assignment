/**
 * mybooksmgmtwebapp.js
 */
"use strict";

// IIFE - Immediate-Invoked Function Expression - Module Pattern
(function() {
    
    function getStudents() {
        fetch("http://localhost:8080/eregistrar/get/students")
            .then((response) => {
                if (response.ok) {
                    return response.json();
                } else {
                    console.log({ status: response.status, statusText: response.statusText });
                    return Promise.reject({ status: response.status, statusText: response.statusText });
                }
            })
            .then(students=> {
                let content = "";
                students.forEach((student, i) => {
                    if(student!=null){
                    content += `
                            <tr>
                                <th scope="row">${i + 1}.</th>
                                <td>${student.studentNumber}</td>
                                <td>${student.firstName}</td>
                                <td>${student.middleName}</td>
                                <td>${student.lastName}</td>
                                 <td>${student.cgpa}</td>
                                <td>${student.isInternational}</td>
                                 <td>${student.enrollmentDate}</td>
                    
                            
                        </tr>`;}
                        else{
                            const errorMsg = "<tr><td align='center' colspan='3'><p style='color: black;'>We are sorry. The eRegistrar WebAPI is unavailable. Please try again later</p></td></tr>";
                        }
                });
                document.querySelector("#tbodyStudentList").innerHTML = content;
            })
            .catch(err => {
                console.log(err);
                const errorMsg = "<tr><td align='center' colspan='3'><p style='color: red;'>We are sorry. The eRegistrar WebAPI is unavailable. Please try again later</p></td></tr>";
                document.querySelector("#tbodyStudentList").innerHTML = errorMsg;
            })
    }
    getStudents();

})();