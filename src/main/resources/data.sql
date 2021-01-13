INSERT INTO TBUILDING(id, name) VALUES(-10,'Fayeul');
INSERT INTO TBUILDING(id, name) VALUES(-9,'Mines');
INSERT INTO TBUILDING(id, name) VALUES(-8,'CHU');

INSERT INTO TFLOOR(id,floor_number, target_temperature, building_id) VALUES(-10,1,25,-10);
INSERT INTO TFLOOR(id,floor_number, target_temperature, building_id) VALUES(-9,2,20,-10);
INSERT INTO TFLOOR(id,floor_number, target_temperature, building_id) VALUES(-8,3,15,-10);

INSERT INTO TFLOOR(id,floor_number, target_temperature, building_id) VALUES(-7,1,20,-9);
INSERT INTO TFLOOR(id,floor_number, target_temperature, building_id) VALUES(-6,2,15,-9);
INSERT INTO TFLOOR(id,floor_number, target_temperature, building_id) VALUES(-5,3,10,-9);

INSERT INTO TFLOOR(id,floor_number, target_temperature, building_id) VALUES(-4,1,25,-8);
INSERT INTO TFLOOR(id,floor_number, target_temperature, building_id) VALUES(-3,2,20,-8);


INSERT INTO TROOM(id, name, floor_id, current_temperature, target_temperature) VALUES(-10, 'Room1', -10, 22.3, 20.0);
INSERT INTO TROOM(id, name, floor_id) VALUES(-9, 'Room2', -10);
INSERT INTO TROOM(id, name, floor_id, current_temperature, target_temperature) VALUES(-8, 'Room3', -9, 22.3, 20.0);
INSERT INTO TROOM(id, name, floor_id, current_temperature, target_temperature) VALUES(-7, 'Room4', -9, 25.3, 20.0);
INSERT INTO TROOM(id, name, floor_id, current_temperature, target_temperature) VALUES(-6, 'Room5', -8, 26.3, 20.0);
INSERT INTO TROOM(id, name, floor_id, current_temperature, target_temperature) VALUES(-5, 'Room6', -7, 21.3, 20.0);
INSERT INTO TROOM(id, name, floor_id, current_temperature, target_temperature) VALUES(-4, 'Room7', -6, 28.3, 20.0);
INSERT INTO TROOM(id, name, floor_id, current_temperature, target_temperature) VALUES(-3, 'Room8', -5, 21.3, 20.0);
INSERT INTO TROOM(id, name, floor_id, current_temperature, target_temperature) VALUES(-2, 'Room9', -5, 20.3, 20.0);
INSERT INTO TROOM(id, name, floor_id, current_temperature, target_temperature) VALUES(-1, 'Room10', -4, 20.3, 20.0);
INSERT INTO TROOM(id, name, floor_id, current_temperature, target_temperature) VALUES(0, 'Room11', -3, 20.3, 20.0);
INSERT INTO TROOM(id, name, floor_id, current_temperature, target_temperature) VALUES(1, 'Room12', -3, 20.3, 20.0);

INSERT INTO THEATER(id, heater_status, name, power, room_id) VALUES(-10, 'ON', 'Heater1', 2000, -10);
INSERT INTO THEATER(id, heater_status, name, power, room_id) VALUES(-9, 'ON', 'Heater2', null, -10);
INSERT INTO THEATER(id, heater_status, name, power, room_id) VALUES(-8, 'ON', 'Heater3', 1000, -9);
INSERT INTO THEATER(id, heater_status, name, power, room_id) VALUES(-7, 'ON', 'Heater4', null, -8);
INSERT INTO THEATER(id, heater_status, name, power, room_id) VALUES(-6, 'OFF', 'Heater5', 500, -7);
INSERT INTO THEATER(id, heater_status, name, power, room_id) VALUES(-5, 'OFF', 'Heater6', null, -10);
INSERT INTO THEATER(id, heater_status, name, power, room_id) VALUES(-4, 'OFF', 'Heater7', 200, -9);
INSERT INTO THEATER(id, heater_status, name, power, room_id) VALUES(-3, 'OFF', 'Heater8', null, -6);
INSERT INTO THEATER(id, heater_status, name, power, room_id) VALUES(-2, 'ON', 'Heater9', null, -6);
INSERT INTO THEATER(id, heater_status, name, power, room_id) VALUES(-1, 'OFF', 'Heater10', null, -6);

INSERT INTO TWINDOW(id, window_status, name, room_id) VALUES(-10, 'CLOSED', 'Window1', -10);
INSERT INTO TWINDOW(id, window_status, name, room_id) VALUES(-9, 'CLOSED', 'Window2', -10);
INSERT INTO TWINDOW(id, window_status, name, room_id) VALUES(-8, 'OPEN', 'Window3', -9);
INSERT INTO TWINDOW(id, window_status, name, room_id) VALUES(-7, 'CLOSED', 'Window4', -7);
INSERT INTO TWINDOW(id, window_status, name, room_id) VALUES(-6, 'CLOSED', 'Window5', -9);
INSERT INTO TWINDOW(id, window_status, name, room_id) VALUES(-5, 'OPEN', 'Window6', -6);
INSERT INTO TWINDOW(id, window_status, name, room_id) VALUES(-4, 'OPEN', 'Window7', -7);
INSERT INTO TWINDOW(id, window_status, name, room_id) VALUES(-3, 'CLOSED', 'Window8', -8);
INSERT INTO TWINDOW(id, window_status, name, room_id) VALUES(-2, 'OPEN', 'Window9', -10);
INSERT INTO TWINDOW(id, window_status, name, room_id) VALUES(-1, 'CLOSED', 'Window10', -8);

