package big_work.big_work.Pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private Integer EmployeeId;
    private String Name;
    private String DepartmentId;
    private String DepartmentName;

}
