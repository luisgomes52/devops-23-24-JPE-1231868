# Class Assignment 2

## Intro

First, create a new branch called "tut-basic-gradle":
```bash
git branch tut-basic-gradle
git checkout tut-basic-gradle
```

1. Generate a new gradle spring boot project, using the necessary dependencies (present in the CA2 powerpoint)

2. Open the project in IntelliJ and delete de **src** folder.

3. Copy the **src** folder from Class Assignment 1 Part 1 to the project folder.
4. Copy the **webpack.config.js** and the **package.json** files from Class Assignment 1 Part 1 to the project folder.
5. Delete the **src/main/resources/static/built/** folder.
6. In the **Employee.java** class, change all *javax.persistence* imports to *jakarta.persistence*.

## Lets get to work!
### Part 1: Adding the frontend plugin

1. Open the build.gradle file and add the plugin:
```gradle
 id "org.siouan.frontend-jdk17" version "8.0.0"
```

2. Configure the plugin in the same build.gradle file:
```gradle
 frontend {
nodeVersion = "16.20.2"
assembleScript = "run build"
cleanScript = "run clean"
checkScript = "run check"
}
```

3. Add the dependencies in the package.json file:
```gradle
"scripts": {
"webpack": "webpack",
"build": "npm run webpack",
"check": "echo Checking frontend",
"clean": "echo Cleaning frontend",
"lint": "echo Linting frontend",
"test": "echo Testing frontend"
},
```
4. Add the package manager to the json file, before the scripts section:
```gradle
"packageManager": "npm@9.6.7",
```

5. Compile the project in the terminal:
```bash
./gradlew build
```

### Part 2: Adding the copyJar task


1. Open the build.gradle file and add the task:
```gradle
task copyJar(type: Copy, dependsOn: build) {
	from 'build/libs/'
	into 'dist'
	include '*.jar'
}
```

2. Compile the project in the terminal:
```bash
./gradlew build
```
3. Add all te files to the staging area:
```bash
git add .
```
4. Commit the changes:
```bash
git commit -m "Added the copyJar task"
```
5. Push the changes to the repository:
```bash
git push
```

### Part 3: Add the deleteWebpackFiles task, and the clean command. 

Open the build.gradle file and add the task:

```gradle
task deleteWebpackFiles(type: Delete) {
	delete 'src/main/resources/static/built'
}

```gradle
clean.dependsOn(deleteWebpackFiles)
```

2. Compile the project in the terminal:
```bash
./gradlew build
```
3. Add all te files to the staging area:
```bash
git add .
```
4. Commit the changes:
```bash
git commit -m "Added the deleteWebpackFiles task"
```
5. Push the changes to the repository:
```bash
git push
```
### Part 4: Merging the branches

Merge the branches:

```bash
git checkout main
git merge --no-ff tut-basic-gradle
git push
```

## Alternative (Maven)
Instead of relying on Gradle, we could switch to Maven. Maven serves as a prevalent build automation tool, particularly tailored for Java projects. While akin to Gradle, Maven employs an XML file for delineating the project's configuration and dependencies. Lets try it out!
1. Create a new Maven project in Intellij and do the same process as done in gradle (changing the src, etc).

2. Instead of creating a task (as you've done in gradle), copy the following plugin to the pom.xml file in order to copy the generated jar:

```xml
<plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-resources-plugin</artifactId>
                <version>3.2.0</version>
                <executions>
                    <execution>
                        <id>copy-jar</id>
                        <phase>package</phase>
                        <goals>
                            <goal>copy-resources</goal>
                        </goals>
                        <configuration>
                            <outputDirectory>${project.basedir}/dist</outputDirectory>
                            <resources>
                                <resource>
                                    <directory>${project.build.directory}</directory>
                                    <includes>
                                        <include>*.jar</include>
                                    </includes>
                                </resource>
                            </resources>
                        </configuration>
                    </execution>
                </executions>
            </plugin>
```
3. Add the clean plugin like so:

```xml
<plugin>
                <artifactId>maven-clean-plugin</artifactId>
                <version>3.1.0</version>
                <configuration>
                    <filesets>
                        <fileset>
                            <directory>${project.basedir}/src/main/resources/static/built</directory>
                            <includes>
                                <include>**/*</include>
                            </includes>
                        </fileset>
                    </filesets>
                </configuration>
            </plugin>
```

4. Compile the project by using the following command:
```bash
mvn clean install
```
5. Add all the files to the staging area by using the following command:
```bash
git add .
```
6. Commit the changes by using the following command:
```bash
git commit -m "Added the Maven build automation tool"
```
7. Push the changes to the repository by using the following command:
```bash
git push
```
This alternate method offers a distinct perspective on executing the necessary adjustments for the assignment, showcasing the adaptability inherent in utilizing diverse build automation tools tailored for Java projects.

