from pyspark.sql import SparkSession
from pyspark.ml.feature import VectorAssembler, StandardScaler
from pyspark.ml.regression import LinearRegression
from pyspark.ml.evaluation import RegressionEvaluator

# Init SparkSession
spark = SparkSession.builder.appName("HousingPricePrediction").getOrCreate()


# Load data
data = spark.read.csv("housing_prices.csv", header=True, inferSchema=True)


# Create VectorAssembler to create feature vector column
feature_columns = ['squareFootage', 'numRooms', 'location', ...]  # Replace with your feature columns
assembler = VectorAssembler(inputCols=feature_columns, outputCol="features")
data = assembler.transform(data)


# Normalize by Standard Scaler
scaler = StandardScaler(inputCol="features", outputCol="scaledFeatures", withMean=True, withStd=True)
scaler_model = scaler.fit(data)
scaled_data = scaler_model.transform(data)


# Split TRAIN, TEST
train_data, test_data = scaled_data.randomSplit([0.8, 0.2])


#  Create model with scaled feature column
lr = LinearRegression(featuresCol="scaledFeatures", labelCol="price")
model = lr.fit(train_data)


# Predict and evaluate model with test set
predictions = model.transform(test_data)

evaluator = RegressionEvaluator(labelCol="price", predictionCol="prediction", metricName="rmse") # Use RMSE or MAE or R2
rmse = evaluator.evaluate(predictions)
print(f"Root Mean Square Error (RMSE): {rmse}")
