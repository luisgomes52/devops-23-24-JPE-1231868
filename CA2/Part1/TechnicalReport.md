## Overview
The goal of this class assignment was to learn to use gradle in a beginner-friendly way. By completing this assignment, one should be able to create and run tasks through the CI using the gradle wrapper.

## First Steps
1 - Clone https://bitbucket.org/pssmatos/gradle_basic_demo.git and remove the .git file from it<br>
2 - Move the files inside the "gradle_basic_demo" directory to the CA2-part1 directory<br>
3 - Read and follow along the presented ReadMe. The ReadMe will guide you through the process of starting a server and, then, a client.

## Now, onto the tasks
4 - As you may have seen in the previous readme "tutorial", it would be good to have a task to run the server with the gradle wrapper, and thats what we are about to do.<br>
4.1 - Define a task with the 'task' keyword and give it a name like 'runServer'. This name will be used later on the terminal to run the server.<br>
4.2 - Point to the correct filepath in the mainClass attribute<br>
4.3 - change the args to 59001 (or another valid port number).

```
task runServer(type:JavaExec, dependsOn: classes){
    group = "DevOps"
    description = "Launches a chat server that listens to connections on localhost:59001 "

    classpath = sourceSets.main.runtimeClasspath

    mainClass = 'basic_demo.ChatServerApp'

    args '59001'
}
```
4.4 - Now, in the CLI, build the project with "./gradlew build".<br>
4.5 - After that, run the Server with "./gradlew runServer", followed by ./gradlew runClient to run the client (you can run as much clients as you want).<br>
4.6 - The result is a chat room, with as much clients as you want, running in a server (in this case, the localhost, port 59001).

## Test, to check if everything is fine
5 - Adding unit tests.<br>
5.1 - First, add the junit4.12.0 dependency.<br>
5.2 - Then, after updating the project, create the unit test to the App class.<br>
5.3 - After checking that everything is ok, we can now proceed to the following task.

## Two more tasks to consolidate the knowledge
6 - Add another task to build.gradle. The goal of this one is to copy the src contents to a new directory: the backup directory.
```
task backup(type: Copy) {
    from 'src'
    into 'backup'
 }
````
6.1 - After updating the project, run "./gradlew backup" to create a backup directory with all the files in it.<br>
6.2 - Go check it out!<br>
7 - Add another task to build.gradle. The goal of this one is to achive the src contents.
```
  task createZip(type: Zip) {
    from 'src'
    def timestamp = new Date().format('yyyyMMdd-HHmmss')
    archiveFileName = "snapshot.zip-${timestamp}"
    destinationDirectory = file('backup') // should be 'build' which is not tracked to be pushed to GitHub
  }
````
7.1 - To diferentiate between snapshot versions, created a timestamp variable and appended it's current value to the name of the zip file.<br>
7.2 - After updating the project, run "./gradlew createZip" to create a source.zip file.<br>
8. mark the repository with the tag "ca2-part1"