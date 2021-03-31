import React from "react";
import { Table } from "reactstrap";
function employeeList() {
  const empData = [
    {
      id: 1,
      name: "Alpha",
      job: "Teacher",
    },
    {
      id: 2,
      name: "Bravo",
      job: "Dancer",
    },
    {
      id: 3,
      name: "Charlie",
      job: "Singer",
    },
    {
      id: 4,
      name: "Delta",
      job: "Actor",
    },
  ];

  const empList = empData.map((emp) => {
    return (
      <tbody id="testId">
        <tr>
          <td>{emp.name}</td>
          <td>{emp.job}</td>
        </tr>
      </tbody>
    );
  });
  return (
    <div>
      <Table>
        <thead>
          <tr>
            <th>Name</th>
            <th>Job</th>
          </tr>
        </thead>

        {empList}
      </Table>
    </div>
  );
}

export default employeeList;
