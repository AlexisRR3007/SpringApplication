INSERT INTO TBUILDING(id, name) VALUES(-10,'Fayeul');

INSERT INTO TFLOOR(id,floor_number, target_temperature, building_id) VALUES(-10,1,5,-10);

INSERT INTO TROOM(id, name, floor_id, current_temperature, target_temperature) VALUES(-10, 'Room1', -10, 22.3, 20.0);
INSERT INTO TROOM(id, name, floor_id) VALUES(-9, 'Room2', -10);

INSERT INTO THEATER(id, heater_status, name, power, room_id) VALUES(-10, 'ON', 'Heater1', 2000, -10);
INSERT INTO THEATER(id, heater_status, name, power, room_id) VALUES(-9, 'ON', 'Heater2', null, -10);

INSERT INTO TWINDOW(id, window_status, name, room_id) VALUES(-10, 'CLOSED', 'Window 1', -10);
INSERT INTO TWINDOW(id, window_status, name, room_id) VALUES(-9, 'CLOSED', 'Window 2', -10);
INSERT INTO TWINDOW(id, window_status, name, room_id) VALUES(-8, 'OPEN', 'Window 1', -9);
INSERT INTO TWINDOW(id, window_status, name, room_id) VALUES(-7, 'CLOSED', 'Window 2', -9);