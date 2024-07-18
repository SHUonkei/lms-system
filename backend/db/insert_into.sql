INSERT INTO students (ID, NAME, EMAIL)
VALUES
  ('9b04277d-9365-4d88-9293-6b0e40608e63', 'root', 'root@example.com'),
  ('qqwcerwd-qcew-4128-3435-13r4ce3546b1', 'student1', 'student1@example.com'),
  ('qtqervtr-q134-1466-3643-qwercwqercb2', 'student2', 'student2@example.com')
  ;

INSERT INTO teachers (ID, NAME, EMAIL)
VALUES
  ('wvertwre-9wer-4qwe-9wer-qwecrqew8e63', 'rootteacher', 'rootteacher@example.com'),
  ('vrtyewqc-qwer-41re-3qwe-13rqwecrqewc', 'teacher1', 'teacher1@example.com'),
  ('qqcwercr-qwer-1qwr-3qwe3-qwercqwercqq', 'teacher2', 'teacher2@example.com')
  ;

INSERT INTO courses (ID, NAME, TEACHER_ID, ROOM)
VALUES
  ('imtyuimt-tmyu-4345-5674-ortbqc0q8370', 'course1', 'wvertwre-9wer-4qwe-9wer-qwecrqew8e63', 'room1'),
  ('etwetvqw-23v4-4qwe-5234-5234v52rtwev', 'course2', 'vrtyewqc-qwer-41re-3qwe-13rqwecrqewc', 'room2'),
  ('2fvgweve-wvre-ewve-4567-236b26234623', 'course3', 'qqcwercr-qwer-1qwr-3qwe3-qwercqwercqq', 'room3'),
  ('234545v2-vwrv-eetw-3568-q3y4b5y345yb', 'course4', 'qqcwercr-qwer-1qwr-3qwe3-qwercqwercqq', 'room4'),
  ('vv23342r-tybe-tttt-1371-aaaaastv34v2', 'course5', 'qqcwercr-qwer-1qwr-3qwe3-qwercqwercqq', 'room5')
  ;

INSERT INTO course_timeslots (COURSE_ID, DAY_OF_WEEK, TIME_PERIOD)
VALUES
  ('imtyuimt-tmyu-4345-5674-ortbqc0q8370', 'Monday', '1'),
  ('imtyuimt-tmyu-4345-5674-ortbqc0q8370', 'Monday', '2'),
  ('etwetvqw-23v4-4qwe-5234-5234v52rtwev', 'Tuesday', '2'),
  ('2fvgweve-wvre-ewve-4567-236b26234623', 'Wednesday', '2'),
  ('234545v2-vwrv-eetw-3568-q3y4b5y345yb', 'Thursday', '2'),
  ('vv23342r-tybe-tttt-1371-aaaaastv34v2', 'Friday', '1')
  ;

INSERT INTO student_courses (STUDENT_ID, COURSE_ID)
VALUES
  ('qqwcerwd-qcew-4128-3435-13r4ce3546b1', 'imtyuimt-tmyu-4345-5674-ortbqc0q8370'),
  ('qqwcerwd-qcew-4128-3435-13r4ce3546b1', 'etwetvqw-23v4-4qwe-5234-5234v52rtwev'),
  ('qtqervtr-q134-1466-3643-qwercwqercb2', 'etwetvqw-23v4-4qwe-5234-5234v52rtwev'),
  ('qtqervtr-q134-1466-3643-qwercwqercb2', '2fvgweve-wvre-ewve-4567-236b26234623'),
  ('qtqervtr-q134-1466-3643-qwercwqercb2', '234545v2-vwrv-eetw-3568-q3y4b5y345yb'),
  ('qtqervtr-q134-1466-3643-qwercwqercb2', 'vv23342r-tybe-tttt-1371-aaaaastv34v2'),
  ('9b04277d-9365-4d88-9293-6b0e40608e63', 'imtyuimt-tmyu-4345-5674-ortbqc0q8370'),
  ('9b04277d-9365-4d88-9293-6b0e40608e63', 'etwetvqw-23v4-4qwe-5234-5234v52rtwev'),
  ('9b04277d-9365-4d88-9293-6b0e40608e63', '2fvgweve-wvre-ewve-4567-236b26234623'),
  ('9b04277d-9365-4d88-9293-6b0e40608e63', '234545v2-vwrv-eetw-3568-q3y4b5y345yb'),
  ('9b04277d-9365-4d88-9293-6b0e40608e63', 'vv23342r-tybe-tttt-1371-aaaaastv34v2')
  ;