# Preparation for the Exam

## Kubernetes Failure Handling

- K8s keeps a desired state definition
- along with a current state definition
- control loops observe current state and controller manager watches over any mismatch
- controler manager intervenes when mismatch is detected.
- In the case of a pod failure, we have a mismatch between desired and current pod replicas as stated in the deployment file
=> Therefore a new pod as to be created to get back to the desired state.
- In the case of a node failure, new pods are created on the now smaller cluster
- In the case the old node "comes back", no rebalancing is done as desired state is matched.

---

## Exam Sample Questions

### Distributed Systems Fundamentals

1. Definition and Motivation
Define a distributed system.
Explain two main motivations for building distributed systems instead of centralized systems.

1. Characteristics and Challenges
List and briefly explain three fundamental characteristics of distributed systems (e.g. scalability, fault tolerance).
Then explain two major challenges commonly faced in distributed systems.

### Cloud Computing Concepts

1. Cloud Computing Definition
Define cloud computing.
Explain how it differs from traditional on-premise infrastructure.

2. Cloud Characteristics
Explain four essential characteristics of cloud computing as defined by common industry standards

3. Cloud Service Models (4 points)
Briefly describe the following service models and give one real-world example for each:
IaaS
PaaS
SaaS

### Cloud-Native Development & Spring Boot

1. Cloud-Native Principles
What does cloud-native development mean?
Explain three principles that distinguish cloud-native applications from traditional monolithic applications.

2. Stateless Services
Why is statelessness important in cloud-native and distributed systems?
Explain how stateless services improve scalability and resilience.

### 12-Factor Apps & DevOps Mindset

1. What are 12-factor apps?
Explain three factors and why each is important for cloud-native applications (one code base, external config, logging, admin process)

2. DevOps Mindset
Explain the DevOps mindset.
Discuss how DevOps changes the relationship between development and operations, and mention two benefits for organizations adopting DevOps.

### Containerisation & Kubernetes

1. Containerisation
Explain containerisation and how it differs from virtual machines.
Mention three advantages of using containers for distributed systems.

2. Containerisation
A Spring Boot application needs to be containerised
    - Describe the main steps to containerise a Spring Boot application using Docker
    - Explain what should be included in a Dockerfile and why
    - Explain two common mistakes when building container images for production

3. Code – Dockerfile Analysis
Consider the following Dockerfile used to containerise a Spring Boot application:

```Dockerfile
FROM openjdk
COPY target/app.jar /app.jar
EXPOSE 8080
CMD ["java", "-jar", "/app.jar"]
```

with

```bash
docker build -e=BACKEND_URL=xyz .
```

- Explain the purpose of each instruction in this Dockerfile.
- Identify two improvements that should be made (in file or when building, in use)

### Kubernetes Core Concepts

1. Briefly explain the role of the following Kubernetes components:
    - Pod
    - Deployment
    - Service: ClusterIP,NodePort, LoadBalancer
    - Namespace
    - Jobs/CronJobs

2. Scaling with Kubernetes
Explain how Kubernetes supports horizontal scaling and self-healing of applications.

### CI/CD and Helm

1. CI/CD Pipelines
Explain what CI/CD means.
Describe the typical stages of a CI/CD pipeline for a cloud-native Spring Boot application.

2. Helm
What is Helm and why is it used in Kubernetes environments?
Explain the purpose of a Helm chart.

3. Production Incident Analysis
A Spring Boot application deployed on Kubernetes is frequently crashing in production.
    - How Kubernetes reacts to this situation
    - How CI/CD and monitoring could help prevent this issue

### CI/CD Pipeline Definition

Consider the following simplified CI/CD pipeline (e.g. GitHub Actions / GitLab CI)

```yaml
build:
  script:
    - mvn clean package

test:
  script:
    - mvn test

deploy:
  script:
    - docker build -t demo-app .
    - docker push demo-app
````

- Explain what each pipeline stage does.
- Identify two missing or problematic aspects or improvements of this pipeline
- Explain how this pipeline could be extended to deploy the application to Kubernetes (using Helm )

Example:

````yaml
deployTok8s:
    scripts:
    - kubectl apply -f k8s/. .
    - helm package & helm publish
    - helm install ./helm
```
