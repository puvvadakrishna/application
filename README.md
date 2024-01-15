# app

Oracle docker installations steps

1. docker pull truevoly/oracle-12c

2. docker run -d -p 8085:8080 -p 1521:1521 -v D:/oracle/oradata:/u01/app/oracle truevoly/oracle-12c