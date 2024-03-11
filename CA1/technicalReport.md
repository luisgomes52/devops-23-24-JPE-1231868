# Technical Report for CA1

## Introduction

As requested, here is a technical report for the Class Assignment nº1, following a "tutorial" style.

The report shows all the commands used to complete the assignment, starting in the creation of a repository, going through the commits related to the assignment and ending with an alternative solution to Git.

## Tutorial

### Step 1: Create a local repository and adding a .gitignore file

```bash
mkdir devOpsRepository
cd devOpsRepository
git init
touch .gitignore
```

(The .gitignore file content can be copied from the Internet)

### Step 2: Create a gitHub repository

This step can easily be completed in the gitHub website, it's pretty intuitive.

### Step 3: Connecting the local repository to the remote

```bash  
cd devOpsRepository
git remote add origin <repositoryLink>
```

### Step 4: Copying the code of the Tutorial React.js and Spring Data REST Application into a new folder named CA1.

```bash
cd devOpsRepository
mkdir CA1
cd CA1
git clone https://github.com/spring-guides/tut-react-and-spring-data-rest
````

### Step 5: Add the changes, first commit and push 
```bash
git add .
git commit -m "First commit"
git push
````

### Step 6: Tagging the initial version as v1.1.0 and pushing the tag to the server.
```bash
git tag -a v1.0.0 -m "First commit version"
git push origin v1.0.0
````

### Step 7: Adding jobYears field to Employee, as well as the tests.

### Step 8: Commit and push the new feature, and tagging the repository as v1.2.0.
```bash
git add .
git commit -m "Added jobYears field to Employee entity."
git push
git tag -a v1.2.0 -m "JobYears included version"
git push origin v1.2.0
````

### Step 9: Tag ca1-part1 to complete part 1.
```bash
git tag -a ca1-part1 -m "Part 1 completed"
git push origin ca1-part1
````

### Step 10: Create a new branch to implement a new feature consisting in adding an email field.
```bash
git branch email-field 
git checkout email-field
```

### Step 11: Commit and push the changes, as well as the new tag.
```bash
# add the email field to Employee in the code
git add .
git commit -m "Added email field to Employee."
git push origin email-field
git checkout main
git merge email-field
git push origin main
git tag v1.3.0
git push origin v1.3.0
```
### Step 12: Create a new branch to add a feature that checks if the email is valid (must have a @)
```bash
git branch fix-invalid-email
git checkout fix-invalid-email
```
### Step 13: Commit and push the changes, as well as the new tag.
```bash
# add the validation of emails 
git add .
git commit -m "Added email validation"
git push origin fix-invalid-email
git checkout main
git merge fix-invalid-email
git push origin main
git tag v1.3.1
git push origin v1.3.1
```
#### Step 14: Tag ca1-part2 to complete part 2.

```bash
git tag ca1-part2
git push origin ca1-part2
```
## Some notes about the assignment

There was a minor mistake, I´ve forgot to add the issues # to the commits.
That would associate each commit with the respective issue and it could also close it, by using the keywords.




## Alternative Version Control Solution: Mercurial SCM

Mercurial is also a distributed version control system that enables developers to track and manage changes to their codebase, however I can spot some differences:

Git boasts a powerful and flexible branching model with lightweight branches, rebasing, and various merge strategies. It is generally considered faster, especially with large repositories.

On the other hand, Mercurial utilizes a simpler, flat, unified storage model and offers a more straightforward branching model, supporting named branches and bookmarks. While perceived as more user-friendly, Mercurial may be slower in certain scenarios.

## Applying Mercurial to the Assignment Goals

### Step 1 - Repository Initialization and first commit.

```bash
hg init
echo "# repository-name" >> README.md
hg add README.md
hg commit -m "first commit"
```

### Step 2 - Push.
```bash
hg push -b branch_name
```
### Step 3 - Creating and listing tags.
```bash
hg tag -m "Version 1.0.0" v1.0.0
hg tags
```
### Step 4 - Creating a branch, switching to it and commiting changes to it.
```bash
hg branch feature_branch
hg commit -m "Implemented new feature"
hg update branch_name
```
### Step 5 - Finalizing with Tags.
```bash
hg tag -m "Version 1.1.0" v1.1.0
hg push --tags
```
With the commands presented above, it would be possible to complete the assignment successfully, which leads me to conclude that Mercurial is viable alternative to Git.

