from pyspark.sql import SparkSession

print('Hellooo')

spark = SparkSession.builder\
        .master("local")\
        .appName("Ubuntu")\
        .config('spark.ui.port', '4090')\
        .getOrCreate()

print(spark.version)
