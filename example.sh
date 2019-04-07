#!/bin/sh

mvn clean package && java -jar target/cvgen.jar -p photo.jpg -l en example-cv.json example-cv.pdf
