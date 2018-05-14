# BiubiuTube

- [BiubiuTube](#biubiutube)
    - [Hierarchical Object Model](#hierarchical-object-model)
    - [Naming Convention](#naming-convention)
        - [Package and Class](#package-and-class)
            - [Example](#example)
        - [UI Elements](#ui-elements)
            - [Example](#example)

## Hierarchical Object Model
![](https://bytebucket.org/zhongjiehe/aed_assignments/raw/33ebf8b7559e97c8d22b5bcf46cffa65aaa9e632/FinalProject/Documents/Hierarchical%20Object%20Model.png?token=748c1f09976231be1fdd67fa5a7c5fa6eaa7cd74)

## Naming Convention
### Package and Class
To avoid naming conflicts between package and class, use `lower camel case` or `lower case abbreviation` for any packages and `upper camel case` for classes.  
#### Example
- package
    - `biz`
    - `ui`
    - `topBar`
- class
    - `Business`
    - `AdDepartment`

### UI Elements
Elements that might be accessed manually in `.java` should have a abbreviation prefix.

#### Example
| class        | prefix | example     |
|--------------|--------|-------------|
| JLabel       | lbl    | lblTitle    |
| JButton      | btn    | btnAdd      |
| JTable       | tbl    | tblOrder    |
| JTextField   | txt    | txtUsername |
| JPassword    | txt    | txtPassword |
| JComboBox    | cb     | cbState     |
| JCheckBox    | ck     | ckEnabled   |
| JRadioButton | rb     | rbMale      |

## Explanation
The original goal was to create an application that extends from both bilibili and youtube.However, our professor told us that our project need to have social responsibility. So we changed our program and let it take more social responsibilities by importing the non-profit department.
