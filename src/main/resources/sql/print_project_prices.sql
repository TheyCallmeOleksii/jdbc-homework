SELECT CONCAT('Project ', project.ID) AS NAME,
       (SUM(worker.SALARY) * DATEDIFF(MONTH, project.START_DATE, project.FINISH_DATE)) AS PRICE
FROM project
         JOIN project_worker ON project.ID = project_worker.PROJECT_ID
         JOIN worker ON project_worker.WORKER_ID = worker.ID
GROUP BY project.ID, project.START_DATE, project.FINISH_DATE
ORDER BY PRICE DESC;