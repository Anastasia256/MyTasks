/*Напишите запрос к таблице account, возвращающий ID сотрудников, открывших счета
(используйте столбец account.open_emp_id).
Результирующий набор должен включать по одной строке для каждого сотрудника.
 */
SELECT DISTINCT cust_id
FROM
  (SELECT cust_id, account.open_emp_id
   FROM account
   WHERE account.open_emp_id is NOT NULL) a;

