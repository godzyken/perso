/* Question 1 */
select first_name, last_name
	from employees;
	
/* Question 2 */
select *
	from employees
	where hire_date > '1999-08-01';
	
/* Question 3 */
select *
	from dept_emp
		union
select *
	from dept_manager;

/* Question 4 */
select *
	from employees join salaries
	on salaries.emp_no = 499902;
	
/* Question 5:  Je ne vois pas comment faire, tu sais m'expliquer? */

/* Question 6 */
select last_name, count(*) AS 'count(*)'
	from employees
	where last_name = 'Gewali'
	group by last_name;
	
	/* Merci pour votre correction! */
