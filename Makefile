# Makefile for compiling and running Java programs
JAVAC := javac
JAVA := java
SRC_DIR := src
BUILD_DIR := build
LIB_DIR := lib
JUNIT_JAR := $(LIB_DIR)/junit-platform-console-standalone-1.9.3.jar

.PHONY: all build build-all clean run run-all

all: build-all

# Compile a single class from src/ using CLASS variable (no .java suffix)
build:
	@mkdir -p $(BUILD_DIR)
	$(JAVAC) $(SRC_DIR)/*.java -d $(BUILD_DIR)

build-all:
	@mkdir -p $(BUILD_DIR)
	@$(JAVAC) $(SRC_DIR)/*.java -d $(BUILD_DIR)

clean:
	@rm -rf $(BUILD_DIR)/*

# Run a single class (use fully-qualified name if packages are used)
run: build
	$(JAVA) -cp $(BUILD_DIR) $(CLASS)

run-all: build-all
	@echo "Compiled classes in $(BUILD_DIR). To run a specific class: make CLASS=ClassName run"

# Test targets (vanilla Java, no Maven/Gradle). Requires $(JUNIT_JAR) to exist in $(LIB_DIR).
.PHONY: test test-run

# Compile sources and tests. Test classes will be placed in $(BUILD_DIR).
test: | $(BUILD_DIR)
	@echo "Compiling sources..."
	$(JAVAC) $(SRC_DIR)/*.java -d $(BUILD_DIR)
	@echo "Compiling tests..."
	$(JAVAC) -cp "$(JUNIT_JAR):$(BUILD_DIR)" test/*.java -d $(BUILD_DIR)

# Run tests using the JUnit Platform Console standalone jar. Scans $(BUILD_DIR) for tests.
test-run: test
	@if [ -f "$(JUNIT_JAR)" ]; then \
		$(JAVA) -jar $(JUNIT_JAR) --class-path $(BUILD_DIR) --scan-class-path; \
	else \
		echo "JUnit jar not found at $(JUNIT_JAR). Please download it to $(LIB_DIR)."; exit 1; \
	fi
