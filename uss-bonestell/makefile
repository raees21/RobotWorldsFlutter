all: clean compile test package
patch: mvnpatch compile test package
minor: mvnminor compile test package
major: mvnmajor compile test package
releasepatch: mvnreleasepatch compile test package
releaseminor: mvnreleaseminor compile test package
releassemajor: mvnreleasemajor compile test package
release: clean mvnreleasemajor compile test verify package
reset: mvnreset

compile:
		mvn compile
verify:
		mvn verify
test:
		mvn test
package:
		mvn package
clean: 
		mvn clean
mvnpatch:
		mvn validate -DbumpPatch -N
mvnminor:
		mvn validate -DbumpMinor -N
mvnmajor:
		mvn validate -DbumpMajor -N
job:
		mvn validate -DbumpPatchrelease -N
mvnreleaseminor:
		mvn validate -DbumpMinorrelease -N
mvnreleasemajor:
		mvn validate -DbumpMajorrelease -N
mvnreset:
		mvn versions:set -DnewVersion=0.0.0-SNAPSHOT
acceptance:
		mvn package
		java -jar lib/ServerSideApplication-1.0.0-jar-with-dependencies.jar &
		mvn verify
		kill %1
