SELECT * FROM ssafydb.sellings;
use ssafydb;
select * from employees2 ;
with selling_count as (
	select e.id, count(e.id) as count, e.name from employees2 e
    join sellings s on e.id = s.employee_id
    group by e.id, e.name
    order by count desc
)
-- select * from employees2;
-- select * from employees2 join sellings on employees2.id = sellings.employee_id;
-- select * from selling_count order by count desc;

select ec.count, ec.name
from selling_count ec
where ec.count = (select max(count) from selling_count)
union all
select ec.count,
case 
	when count(ec.count)-1 =0 then ec.name
    else concat(ec.name, ' and ', count(ec.count)-1, ' other') 
end as description
from selling_count ec
group by ec.count
having ec.count < (select max(count) from selling_count);
-- order by ec.count;
