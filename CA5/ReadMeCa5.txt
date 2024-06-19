# Class Assigment 5

## Introduction

This technical report outlines the procedures and steps taken to complete Class Assignment 5 of the DevOps class from the "Switch - Curso de Especialização em Desenvolvimento de Software".

The main goal of this assignment was to acquire hands-on experience with Jenkins by developing a basic pipeline for the "gradle basic demo" project, which already exists in the repository. The pipeline aimed to automate several phases of the development process, including code checkout, assembly, testing, and artifact archiving.

The pipeline was set up with a relative path to the Jenkinsfile in the Script Path field, for example, 'ca2/part1/gradle-basic-demo/Jenkinsfile'. The stages specified in the Part 1 pipeline include:

1. Checkout: This stage checks out the code from the repository.
2. Assemble: This stage compiles and produces the archive files with the application, without executing the tests.
3. Test: This stage executes the Unit Tests and publishes the Test results in Jenkins.
4. Archive: This stage archives the generated files in Jenkins.

The second part of the assignment required creating a new pipeline for the "springbootapp" project. This pipeline was intended to automate various stages of the development process. The stages defined in the Part 2 pipeline were:

1. Checkout: This stage checks out the code from the repository.
2. Assemble: This stage compiles and produces the archive files with the application, without executing the tests.
3. Test: This stage executes the Unit Tests and publishes the Test results in Jenkins.
4. Javadoc: This stage generates the Javadoc of the project and publishes it in Jenkins.
5. Archive: This stage archives the generated files in Jenkins.
6. Publish Image: This stage generates a Docker image with Tomcat and the war file and publishes it in Docker Hub.

This report offers a comprehensive overview of the steps undertaken to complete the assignment, detailing the commands executed, the issues faced, and the solutions applied. The tutorial section includes a step-by-step guide to the assignment tasks.

## Prerequisites

- **Operating System**: Windows 10 or later.
- **Java**: You need to have Java installed on your machine. The version used for this project is Java 11. You can download it from the [official Oracle website](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html).
- **Gradle**: This project uses Gradle for build automation. Make sure you have Gradle installed or use the Gradle Wrapper included in the project. The version used for this project is Gradle 8.6. You can download it from the [official Gradle website](https://gradle.org/releases/).
- **Docker**: Docker is used for creating and managing the Docker images for the project. Make sure you have Docker installed on your machine. You can download it from the [official Docker website](https://www.docker.com/products/docker-desktop).
- **Jenkins**: Jenkins is used for continuous integration and continuous delivery. Make sure you have Jenkins installed on your machine. The version used for this project is the latest available at the time of writing. You can download it from the [official Jenkins website](https://www.jenkins.io/download/).
- **GitHub Account**: You need a GitHub account to clone the repository and push changes. If you don't have one, you can create it on the [GitHub website](https://github.com/join).
- **Docker Hub Account**: You need a Docker Hub account to push Docker images. If you don't have one, you can create it on the [Docker Hub website](https://hub.docker.com/signup).

## Lets start with the tutorial!

## Configure Jenkins
Install Jenkins for Windows from the official Jenkins website.

1. Open a terminal in the directory where the Jenkins war file is present and run the following command:

```bash
java -jar jenkins.war --httpPort=8095
```

2. Access Jenkins at http://localhost:8095.

3. Configure the account and password.

4. Install the suggested plugins.

## Plugins to be installed:

- Docker API Plugin
- Docker Commons Plugin
- Docker Plugin
- Docker Pipeline
- HTML Publisher Plugin
- Pipeline

## Credentials

## Part 1

1. Create a Jenkinsfile in the CA5/Part1 folder with the following content:

```groovy
pipeline {
    agent any

    environment {
        REPO_URL = 'https://github.com/luisgomes52/devops-23-24-JPE-1231868.git'
    }

    stages {
        stage('Checkout') {
            steps {
                echo 'Checking out the code...'
                git url: "${REPO_URL}", branch: 'main'
            }
        }

        stage('Assemble') {
            steps {
                dir('CA2/Part1') {
                    echo 'Assembling the application...'
                    bat 'gradlew.bat assemble'
                }
            }
        }

        stage('Test') {
            steps {
                dir('CA2/Part1') {
                    echo 'Running unit tests...'
                    bat 'gradlew.bat test'
                    junit 'build/test-results/test/*.xml'
                }
            }
        }

        stage('Archive') {
            steps {
                dir('CA2/Part1') {
                    echo 'Archiving artifacts...'
                    archiveArtifacts artifacts: 'build/libs/*.jar', fingerprint: true
                }
            }
        }
    }
}
```

2. Commit the Jenkinsfile to the repository.

3. Create a new item.

4. Click in "Build Now".

5. Check the results of the pipeline.

## Part 2

1. Create a Jenkinsfile in the CA5/Part2 folder with the following content:

```groovy
pipeline {
    agent any

    environment {
        DOCKER_CREDENTIALS_ID = '87c7e2b4-2f04-4796-9f65-b82ae898e22b'
        DOCKER_IMAGE = 'luisgomees/springbootapp'
        DOCKER_TAG = "${env.BUILD_ID}"
    }

    stages {
        stage('Checkout') {
            steps {
                echo 'Checking out the code...'
                git url: 'https://github.com/luisgomes52/devops-23-24-JPE-1231868.git'
            }
        }

        stage('Set Permissions') {
            steps {
                dir('CA2/Part2/') {
                    echo 'Setting executable permissions on gradlew...'
                    bat 'gradlew.bat'
                }
            }
        }

        stage('Assemble') {
            steps {
                dir('CA2/Part2/') {
                    echo 'Assembling the application...'
                    bat './gradlew.bat assemble'
                }
            }
        }

        stage('Test') {
            steps {
                dir('CA2/Part2/') {
                    echo 'Running unit tests...'
                    bat './gradlew.bat test'
                }
            }
        }

        stage('Javadoc') {
            steps {
                dir('CA2/Part2/') {
                    echo 'Generating Javadoc...'
                    bat './gradlew.bat javadoc'
                    publishHTML(target: [
                        allowMissing: false,
                        alwaysLinkToLastBuild: false,
                        keepAll: true,
                        reportDir: 'build/docs/javadoc',
                        reportFiles: 'index.html',
                        reportName: 'Javadoc'
                    ])
                }
            }
        }

        stage('Archive') {
            steps {
                dir('CA2/Part2/') {
                    echo 'Archiving artifacts...'
                    archiveArtifacts artifacts: 'build/libs/*.jar', fingerprint: true
                }
            }
        }

        stage('Create Dockerfile') {
            steps {
                dir('CA2/Part2/') {
                    script {
                        def dockerfileContent = """
                        FROM openjdk:11-jre-slim
                        WORKDIR /app
                        COPY build/libs/*.jar app.jar
                        EXPOSE 8080
                        ENTRYPOINT ["java", "-jar", "app.jar"]
                        """
                        writeFile file: 'Dockerfile', text: dockerfileContent
                    }
                }
            }
        }

        stage('Publish Image') {
            steps {
                script {
                    echo 'Building and publishing Docker image...'
                    docker.withRegistry('https://index.docker.io/v1/', "${DOCKER_CREDENTIALS_ID}") {
                        dir('CA2/Part2/') {
                            def customImage = docker.build("${DOCKER_IMAGE}:${DOCKER_TAG}")
                            customImage.push()
                            customImage.push('latest')
                        }
                    }
                }
            }
        }
    }
}
```

The same 4 steps as usual:

2. Commit the Jenkinsfile to the repository.

3. Create a new item.

4. Click in "Build Now".

5. Check the results of the pipeline.

## Final Remarks
This report outlines the setup process for Jenkins pipelines designed to automate a project utilizing Java, Spring Boot, Gradle, Docker, and Jenkins. The pipelines were engineered to streamline key stages of the development lifecycle, including code checkout, assembly, testing, artifact archiving, and Docker image publication to Docker Hub.

Throughout the setup process, I encountered challenges that were overcome by ensuring the correct versions of Gradle Wrapper were downloaded and Jenkins configurations were updated accordingly. These adjustments were pivotal in achieving the smooth execution of the Jenkins pipelines.

In conclusion, the successful establishment of these Jenkins pipelines marks a significant advancement in automating and enhancing the efficiency of our development workflows. By automating repetitive tasks and integrating essential tools, we have fostered greater productivity and operational efficiency within the project, although im still having some troubles with the DockerImage which I hope I will soon find answers to.

