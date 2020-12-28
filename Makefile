build:
	javac src/com/rekaerst/*.java -d build
run: build
	java -cp build com.rekaerst.App
