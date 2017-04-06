--liquibase formatted sql

--changeset kospiotr:0.0.1-001
INSERT INTO user (id, username, password, status) VALUES (-1, 'guest', NULL, 1);
INSERT INTO user (id, username, password, status)
VALUES (1, 'admin', '$2a$10$xuMVY3TqYIoZ6mk7/BYHVeAbhBUrWMrbzMltBnHEMRs3rtxK4sLli', 1);
INSERT INTO user (id, username, password, status)
VALUES (2, 'kospiotr', '$2a$10$J7WWu1wqmeCnP8cmxLh/8epUlG6OGkupsB8h3VprkmOOlgHTxGjaW', 1);

INSERT INTO permission (id, name) VALUES (-1, 'TDB.homepage.read');
INSERT INTO permission (id, name) VALUES (1, 'TDB.admin.read');
INSERT INTO permission (id, name) VALUES (2, 'TDB.department.read');
INSERT INTO permission (id, name) VALUES (3, 'TDB.department.insert');
INSERT INTO permission (id, name) VALUES (4, 'TDB.department.update');
INSERT INTO permission (id, name) VALUES (5, 'TDB.department.approve');
INSERT INTO permission (id, name) VALUES (6, 'TDB.department.delete');
INSERT INTO permission (id, name) VALUES (7, 'TDB.departmentunit.read');
INSERT INTO permission (id, name) VALUES (8, 'TDB.departmentunit.insert');
INSERT INTO permission (id, name) VALUES (9, 'TDB.departmentunit.update');
INSERT INTO permission (id, name) VALUES (10, 'TDB.departmentunit.approve');
INSERT INTO permission (id, name) VALUES (11, 'TDB.departmentunit.delete');
INSERT INTO permission (id, name) VALUES (12, 'TDB.instrument.read');
INSERT INTO permission (id, name) VALUES (13, 'TDB.instrument.insert');
INSERT INTO permission (id, name) VALUES (14, 'TDB.instrument.update');
INSERT INTO permission (id, name) VALUES (15, 'TDB.instrument.approve');
INSERT INTO permission (id, name) VALUES (16, 'TDB.instrument.delete');
INSERT INTO user_group (id, name) VALUES (-1, 'anybody');
INSERT INTO user_group (id, name) VALUES (-2, 'anonymous');
INSERT INTO user_group (id, name) VALUES (-3, 'user');
INSERT INTO user_group (id, name) VALUES (1, 'administrator');
INSERT INTO user_group (id, name) VALUES (2, 'entrepreneur');
INSERT INTO user_group (id, name) VALUES (3, 'scientist');
INSERT INTO user_group (id, name) VALUES (4, 'approver');
INSERT INTO user_group (id, name) VALUES (5, 'moderator');

INSERT INTO user_permission (user_id, permission_id) VALUES (1, 1); --admin to admin panel
INSERT INTO user_group_user (user_id, user_group_id) VALUES (1, 1); --admin to administrator

INSERT INTO user_group_permission (user_group_id, permission_id) VALUES (-1, -1); -- anybody to homepage read
INSERT INTO user_group_permission (user_group_id, permission_id) VALUES (-1, 2); -- anybody to department read
INSERT INTO user_group_permission (user_group_id, permission_id) VALUES (-1, 7); -- anybody to departmentUnit read
INSERT INTO user_group_permission (user_group_id, permission_id) VALUES (-1, 12); -- anybody to instrument read
INSERT INTO user_group_permission (user_group_id, permission_id) VALUES (1, 3);
INSERT INTO user_group_permission (user_group_id, permission_id) VALUES (1, 4);
INSERT INTO user_group_permission (user_group_id, permission_id) VALUES (1, 5);
INSERT INTO user_group_permission (user_group_id, permission_id) VALUES (1, 6);
INSERT INTO user_group_permission (user_group_id, permission_id) VALUES (1, 8);
INSERT INTO user_group_permission (user_group_id, permission_id) VALUES (1, 9);
INSERT INTO user_group_permission (user_group_id, permission_id) VALUES (1, 10);
INSERT INTO user_group_permission (user_group_id, permission_id) VALUES (1, 11);
INSERT INTO user_group_permission (user_group_id, permission_id) VALUES (1, 13);
INSERT INTO user_group_permission (user_group_id, permission_id) VALUES (1, 14);
INSERT INTO user_group_permission (user_group_id, permission_id) VALUES (1, 15);
INSERT INTO user_group_permission (user_group_id, permission_id) VALUES (1, 16);