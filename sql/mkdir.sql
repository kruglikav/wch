CREATE OR REPLACE DIRECTORY dmpdir AS '&DIR_PATH';
GRANT READ,WRITE ON DIRECTORY dmpdir TO system;
exit