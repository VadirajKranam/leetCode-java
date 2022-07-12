# Write your MySQL query statement below
select w2.id from Weather w1,Weather w2
where w2.temperature>w1.temperature and TO_DAYS(w2.recordDate)-TO_DAYS(w1.recordDate)=1;