# Alex Rinker
# A very simple makefile
#

JCC = javac
JFLAGS = -g -d
CLASS_DIR = classes
CLASSES = \
					holdem/Card/Card.java \
					holdem/CommunityCards/CommunityCard.java \
					holdem/Deck/Deck.java \
					holdem/Hand/Hand.java \
					holdem/Score/Score.java \
					holdem/Suits/Suits.java

.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $(CLASS_DIR) $*.java

# 'make' will invoke the first entry here
default: klasses

klasses: $(CLASSES): .java=.class)

clean:
				 $(RM) classes/holdem/*.class
