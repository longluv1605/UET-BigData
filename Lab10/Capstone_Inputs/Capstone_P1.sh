# Command block 1
rm -r /home/hadoop/Capstone_Project
mkdir -p /home/hadoop/Capstone_Project

mkdir -p /home/hadoop/Capstone_Project/Capstone_Outputs
mkdir -p /home/hadoop/Capstone_Project/Capstone_Inputs
cp -r /home/hadoop/Documents/UET-BigData/Lab10/Capstone_Inputs/* /home/hadoop/Capstone_Project/Capstone_Inputs

cd /home/hadoop/Capstone_Project

echo "\n---------- DONE COMMAND BLOCK 1 --------------\n"

# Command block 2
mysql -u hive -p000000 -D hive -e 'source Capstone_Inputs/CreateMySQLTables.sql' > /home/hadoop/Capstone_Project/Capstone_Outputs/Cap_MySQLTables.txt

echo "\n---------- DONE COMMAND BLOCK 2 --------------\n"

# Command block 3
hdfs dfs -rm -r /user/hive/warehouse/Capstone
hdfs dfs -mkdir -p /user/hive/warehouse/Capstone

echo "\n---------- DONE COMMAND BLOCK 3 --------------\n"

# Command block 4
sqoop import-all-tables --connect jdbc:mysql://localhost:3306/capstone_proj --username hive --password 000000 --compression-codec=snappy --as-avrodatafile --warehouse-dir=/user/hive/warehouse/Capstone --m 1 --exclude-tables AUX_TABLE

echo "\n---------- DONE COMMAND BLOCK 4 --------------\n"

# Command block 5
hdfs dfs -rm -r /user/hive/avsc
hdfs dfs -mkdir -p /user/hive/avsc
hdfs dfs -put  departments.avsc /user/hive/avsc/departments.avsc
hdfs dfs -put  titles.avsc /user/hive/avsc/titles.avsc
hdfs dfs -put  employees.avsc /user/hive/avsc/employees.avsc
hdfs dfs -put  dept_manager.avsc /user/hive/avsc/dept_manager.avsc
hdfs dfs -put  dept_emp.avsc /user/hive/avsc/dept_emp.avsc
hdfs dfs -put  salaries.avsc /user/hive/avsc/salaries.avsc
hadoop fs -chmod +rwx /user/hive/avsc/*
hadoop fs -chmod +rwx /user/hive/warehouse/Capstone/*

echo "\n---------- DONE COMMAND BLOCK 5 --------------\n"

# Command block 6
lsof -t -i:9083 | xargs -r kill -9
hive --service metastore &
hive --service hiveserver2 &
hive -f Capstone_Inputs/HiveDB.hql > /home/hadoop/Capstone_Project/Capstone_Outputs/Cap_HiveDB.txt

echo "\n---------- DONE COMMAND BLOCK 6 --------------\n"

# Command block 7
impala-shell -i localhost -f Capstone_Inputs/EDA.sql > /home/hadoop/Capstone_Project/Capstone_Outputs/Cap_ImpalaAnalysis.txt

echo "\n---------- DONE COMMAND BLOCK 7 --------------\n"

# Command block 8
hive -f Capstone_Inputs/HiveTables.sql > /home/hadoop/Capstone_Project/Capstone_Outputs/Cap_HiveTables.txt

echo "\n---------- DONE COMMAND BLOCK 8 --------------\n"

# Command block 9
spark-submit Capstone_Inputs/capstone.py > /home/hadoop/Capstone_Project/Capstone_Outputs/Cap_SparkSQL_EDA_ML.txt

echo "\n---------- DONE COMMAND BLOCK 9 --------------\n"

# Command block 10
hdfs dfs -copyToLocal /user/hive/random_forest.model /home/hadoop/Capstone_Project/Capstone_Outputs/
zip -r /home/hadoop/Capstone_Project/Capstone_Outputs/random_forest.model.zip /home/hadoop/Capstone_Project/Capstone_Outputs/random_forest.model
rm -r /home/hadoop/Capstone_Project/Capstone_Outputs/random_forest.model

hdfs dfs -copyToLocal /user/hive/logistic_regression.model /home/hadoop/Capstone_Project/Capstone_Outputs/
zip -r /home/hadoop/Capstone_Project/Capstone_Outputs/logistic_regression.model.zip /home/hadoop/Capstone_Project/Capstone_Outputs/logistic_regression.model
rm -r /home/hadoop/Capstone_Project/Capstone_Outputs/logistic_regression.model

echo "\n---------- DONE COMMAND BLOCK 10 --------------\n"
echo "\n===================== FINISHED =======================\n"
