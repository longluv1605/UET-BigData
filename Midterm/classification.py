from pyspark.sql import SparkSession
from pyspark.ml.feature import VectorAssembler, StandardScaler, StringIndexer, OneHotEncoder
from pyspark.ml.classification import RandomForestClassifier
from pyspark.ml.evaluation import MulticlassClassificationEvaluator
from pyspark.ml import Pipeline

# 1. Khởi tạo SparkSession
spark = SparkSession.builder \
    .appName("Classification Example") \
    .getOrCreate()

# 2. Đọc dữ liệu từ CSV
data_path = "path/to/your/data.csv"
data = spark.read.csv(data_path, header=True, inferSchema=True)

# Hiển thị một vài dòng dữ liệu
data.show(5)

# 3. Chuẩn bị dữ liệu
# Giả sử dữ liệu có cột đặc trưng là 'feature1', 'feature2', 'feature3' và nhãn là 'label'

# Chuyển đổi cột nhãn thành chỉ số (index)
label_indexer = StringIndexer(inputCol="label", outputCol="indexedLabel")

# Sử dụng VectorAssembler để gộp các cột đặc trưng
feature_columns = [col for col in data.columns if col != "label"]
vector_assembler = VectorAssembler(inputCols=feature_columns, outputCol="unscaledFeatures")

# Chuẩn hóa dữ liệu với StandardScaler
scaler = StandardScaler(inputCol="unscaledFeatures", outputCol="scaledFeatures", withMean=True, withStd=True)

# 4. Chia dữ liệu thành tập huấn luyện và kiểm tra
train_data, test_data = data.randomSplit([0.8, 0.2], seed=42)

# 5. Lựa chọn mô hình và huấn luyện
rf_classifier = RandomForestClassifier(featuresCol="scaledFeatures", labelCol="indexedLabel")

# Tạo pipeline
pipeline = Pipeline(stages=[label_indexer, vector_assembler, scaler, rf_classifier])

# Huấn luyện mô hình
model = pipeline.fit(train_data)

# 6. Đánh giá mô hình
predictions = model.transform(test_data)
predictions.select("label", "indexedLabel", "prediction", "probability").show(5)

# Đánh giá kết quả với độ chính xác
evaluator = MulticlassClassificationEvaluator(labelCol="indexedLabel", predictionCol="prediction", metricName="accuracy")
accuracy = evaluator.evaluate(predictions)
print(f"Accuracy: {accuracy:.4f}")

# Dừng SparkSession
spark.stop()
