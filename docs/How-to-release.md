# How to Release

1. Increase version (semantic versioning)
   - Increase version in pom.xml
   - Increase version in ProjectInfo class.

2. Run maven package (this creates a .jar file in target folder)
    - `mvn package`
      - The jar file will be named after the artifict-id and version.
      - Example: `noits-random-thing-picker-0.0.1`

3. Create release on GitHub
   - Make a new release on GitHub once it has been pushed.
   - Make human friendly change log
   - Add .jar file + dependency-tree (with `mvn dependency:tree`) in a text file.