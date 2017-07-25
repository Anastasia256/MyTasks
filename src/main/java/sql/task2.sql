/*Извлеките ID счета, ID клиента и доступный остаток всех счетов,
имеющих статус 'ACTIVE' (активный) и доступный остаток более 2500 долларов.
 */

SELECT account_id, cust_id, avail_balance
FROM account
WHERE status = 'ACTIVE' AND  avail_balance > 2500;