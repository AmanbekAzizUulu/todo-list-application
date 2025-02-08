-- Создаем таблицу-связку user_tasks
CREATE TABLE todo_list_application.user_tasks (
    user_id INT NOT NULL,
    task_id INT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES todo_list_application.users(id) ON DELETE CASCADE,
    FOREIGN KEY (task_id) REFERENCES todo_list_application.tasks(id) ON DELETE CASCADE,
    PRIMARY KEY (user_id, task_id)
);
