
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * When list of employee relationship {(A, B), (B, C), ….. } is given, find number of reporting people for each employee.

-------C
---B-------D
-L---R

then, C has 4, B has 2, and (D,L,R) will have one.
연관 문제로, Manager를 어떻게 찾냐고 물어봄
Answer) getManager() != null 이면 manager를 찾는 것은 쉽고, getManager() == null 이면 CEO를 찾을 수 있다고 대답하였음, 그러면 CEO가 둘인, 즉 getManager() == null인 경우가 2개 이상 나오면 어떻게 하냐고 물어서 그럴때는 exception 날린다고 하니 대충 받아들이는 눈치였음

 * @author youngjucho
 */
public class GetReportingNumber {

    public static Map<Employee, Integer> findReportingNumber(List<Pair<String, String>> infos) {
        Map<String, Employee> empById = new HashMap<>();
        for (Pair<String, String> info : infos) {
            String empId = info.getFirst();
            String mgrId = info.getSecond();
            Employee emp = empById.getOrDefault(empId, new Employee(empId));
            Employee manager = empById.getOrDefault(mgrId, new Employee(mgrId));
            empById.put(emp, emp.setManagerId(mgrId));
            empById.put(manager, manager.addMember(emp));
        }
        return empById.values().stream().collect(Collectors.toMap(
                (Employee e) -> e,
                Employee:getReportingNums
    

    ));
}


public class Employee {

        private final String id;
        private final List<Employee> teams;

        @Nullable private String managerId;
        // 처음에 이 값을 저장을 안 하고 매번 계산하는 걸로 하였음 그러면 findReportingNumber()가 N^2가 나옴
        private @Nullable Integer reportingNumber;

        public Employee(String id) {
            this.id = id;
            teams = new ArrayList<>();
        }

        public Employee setManagerId(String mgrId) {
            managerId = mgrId;
        }

        public Employee addMember(Employee emp) {
            teams.add(emp);
            return this;
        }

        public Integer getReportingNums() {
            return reportingNumber != null
                    ? reportingNumber : reportingNumber = getReportingNums(getTeams());
        }

        private static int getReportingNums(List<Employee> teams) {
            int total = 0;
            for (Employee emp : teams) {
                total += 1;
                total += getReportingNums(emp.getTeams());
            }
        }

        public getTeams() {
            return teams;
        }
    }
}
