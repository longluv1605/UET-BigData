# cd /home/hadoop/Capstone_Project
# find . -name "*.avsc" -exec rm {} \;
# find . -name "*.java" -exec rm {} \;

rm -r /home/hadoop/Capstone_Project
mkdir -p /home/hadoop/Capstone_Project

# rm -r /home/hadoop/Capstone_Project/Capstone_Outputs
mkdir -p /home/hadoop/Capstone_Project/Capstone_Outputs
mkdir -p /home/hadoop/Capstone_Project/Capstone_Inputs
cp -r /home/hadoop/Documents/UET-BigData/Lab10/Capstone_Inputs/* /home/hadoop/Capstone_Project/Capstone_Inputs

cd /home/hadoop/Capstone_Project

mysql -u hive -p000000 -D capstone_proj -e 'source Capstone_Inputs/CreateMySQLTables.sql' > /home/hadoop/Capstone_Project/Capstone_Outputs/Cap_MySQLTables.txt

hdfs dfs -rm -r /user/hive/warehouse/Capstone
hdfs dfs -mkdir -p /user/hive/warehouse/Capstone

sqoop import-all-tables --connect jdbc:mysql://localhost:3306/capstone_proj --username hive --password 000000 --compression-codec=snappy --as-avrodatafile --warehouse-dir=/user/hive/warehouse/Capstone --m 1 --exclude-tables AUX_TABLE

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

hive --service metastore &
hive --service hiveserver2 &
hive -f Capstone_Inputs/HiveDB.hql > /home/hadoop/Capstone_Project/Capstone_Outputs/Cap_HiveDB.txt

impala-shell -i localhost -f Capstone_Inputs/EDA.sql > /home/hadoop/Capstone_Project/Capstone_Outputs/Cap_ImpalaAnalysis.txt

hive -f Capstone_Inputs/HiveTables.sql > /home/hadoop/Capstone_Project/Capstone_Outputs/Cap_HiveTables.txt

spark-submit Capstone_Inputs/capstone.py > /home/hadoop/Capstone_Project/Capstone_Outputs/Cap_SparkSQL_EDA_ML.txt

hdfs dfs -copyToLocal /user/hive/random_forest.model /home/hive/Capstone_Outputs/
zip -r /home/hadoop/Capstone_Project/Capstone_Outputs/random_forest.model.zip /home/hadoop/Capstone_Project/Capstone_Outputs/random_forest.model
rm -r /home/hadoop/Capstone_Project/Capstone_Outputs/random_forest.model

hdfs dfs -copyToLocal /user/hive/logistic_regression.model /home/hadoop/Capstone_Project/Capstone_Outputs/
zip -r /home/hadoop/Capstone_Project/Capstone_Outputs/logistic_regression.model.zip /home/hadoop/Capstone_Project/Capstone_Outputs/logistic_regression.model
rm -r /home/hadoop/Capstone_Project/Capstone_Outputs/logistic_regression.model
