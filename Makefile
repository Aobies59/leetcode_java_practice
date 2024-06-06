# Variables
JAVAC = javac
SRCDIR = $(dir $(lastword $(MAKEFILE_LIST)))
BINDIR = $(SRCDIR)
SOURCES = $(wildcard $(SRCDIR)/*.java)
CLASSES = $(SOURCES:$(SRCDIR)/%.java=$(BINDIR)/%.class)

# Default target
all:
	@clear
	@make -s clean
	@make -s compile
	@echo "Compiled all .java files"

compile: $(CLASSES)

# Rule to compile .java files to .class files
$(BINDIR)/%.class: $(SRCDIR)/%.java | $(BINDIR)
	$(JAVAC) -d $(BINDIR) $<

# Create the bin directory if it doesn't exist
$(BINDIR):
	mkdir -p $(BINDIR)

# Clean up .class files
clean:
	@rm -rf $(BINDIR)/*.class
