export RUN_PATH=$(cd "$(dirname "$0")"; pwd)
java  -Dfile.encoding=UTF-8 -jar $RUN_PATH/lib/fitnesse-standalone.jar -d $RUN_PATH -p 8081
