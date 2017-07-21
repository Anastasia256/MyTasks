/*Извлеките ID, имя и фамилию всех банковских сотрудников. Выполните сортировку по фамилии, а затем по имени.*/
SELECT emp_id, fname, lname
FROM
  (SELECT emp_id, fname, lname
   FROM employee
   ORDER BY fname) AS T
ORDER BY lname;