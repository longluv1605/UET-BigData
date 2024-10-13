# I - Setup Spark on Ubuntu (local)

1. Install JDK and set `JAVA_HOME`
2. Install python
    -   `sudo apt install python3-pip`
    -   `pip3 install pyspark findspark --break-system-packages`
3. Download and extract Spark (Note: you are in `~/` directory)
    -   `wget https://dlcdn.apache.org/spark/spark-3.5.3/spark-3.5.3-bin-hadoop3.tgz`
    -   `tar xf spark-3.5.3-bin-hadoop3.tgz`
4. Config environment variables
    --> Add following lines to `~/.bashrc`:
        - `export JAVA_HOME=/usr/lib/jvm/java-8-openjdk-amd64`
        - `export SPARK_HOME=~/spark-3.5.3-bin-hadoop3`
        - `export PATH=$SPARK_HOME/bin:$PATH`
    --> Then run this cmd: `source ~/.bashrc`
