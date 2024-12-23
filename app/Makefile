run-dist: # запуск исполняемого файла
	./app/build/install/app/bin/app filepath1.json filepath2.json

lint:
	@./gradlew checkstyleMain checkstyleTest

test:
	@./gradlew test

build:
	@./gradlew clean build

report:
	./gradlew jacocoTestReport

.PHONY: build