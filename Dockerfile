FROM jenkins/jenkins:lts

# Switch to root user to install additional software
USER root

## Install dependencies
#RUN apt-get update && \
#    apt-get install -y wget gnupg2 && \
#    rm -rf /var/lib/apt/lists/* \


# Install necessary packages
RUN apt-get update && apt-get install -y \
    curl \
    gnupg2 \
    wget \
    software-properties-common \
    lsb-release

# Install Java 21
RUN wget -qO - https://download.oracle.com/java/21/latest/jdk-21_linux-x64_bin.tar.gz | tar -xz -C /usr/local && \
    ln -s /usr/local/jdk-21/bin/java /usr/local/bin/java

# Install Maven 4.0.0
RUN wget https://dlcdn.apache.org/maven/maven-4/4.0.0-beta-3/binaries/apache-maven-4.0.0-beta-3-bin.tar.gz -P /tmp && \
    tar xf /tmp/apache-maven-4.0.0-beta-3-bin.tar.gz -C /opt && \
    ln -s /opt/apache-maven-4.0.0-beta-3/bin/mvn /usr/local/bin/mvn
## Add Docker’s official GPG key
#RUN mkdir -p /etc/apt/keyrings && \
#    curl -fsSL https://download.docker.com/linux/debian/gpg | gpg --dearmor -o /etc/apt/keyrings/docker.gpg
#
## Set up the Docker repository
#RUN echo "deb [arch=$(dpkg --print-architecture) signed-by=/etc/apt/keyrings/docker.gpg] https://download.docker.com/linux/debian bookworm stable" | tee /etc/apt/sources.list.d/docker.list > /dev/null
#
## Update package lists and install Docker CLI
#RUN apt-get update && \
#    apt-get install -y docker-ce docker-ce-cli containerd.io docker-compose-plugin && \
#    rm -rf /var/lib/apt/lists/*


# Install Docker
RUN mkdir -p /etc/apt/keyrings && \
    curl -fsSL https://download.docker.com/linux/debian/gpg | gpg --dearmor -o /etc/apt/keyrings/docker.gpg && \
    echo "deb [arch=amd64 signed-by=/etc/apt/keyrings/docker.gpg] https://download.docker.com/linux/debian $(lsb_release -cs) stable" > /etc/apt/sources.list.d/docker.list && \
    apt-get update && \
    apt-get install -y docker-ce docker-ce-cli containerd.io


# Installer Docker Compose
RUN curl -L "https://github.com/docker/compose/releases/download/1.29.2/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose && \
    chmod +x /usr/local/bin/docker-compose

# Install kubectl
RUN curl -LO "https://dl.k8s.io/release/$(curl -L -s https://dl.k8s.io/release/stable.txt)/bin/linux/amd64/kubectl" && \
    install -o root -g root -m 0755 kubectl /usr/local/bin/kubectl && \
    rm kubectl


# Set environment variables
ENV JAVA_HOME=/usr/local/jdk-21.0.4
ENV MAVEN_HOME=/opt/apache-maven-4.0.0-beta-3
ENV PATH=$JAVA_HOME/bin:$MAVEN_HOME/bin:$PATH
# Switch back to Jenkins user
USER jenkins
# Add Docker group to Jenkins user
#RUN usermod -aG docker jenkins

# Install Jenkins plugins
#RUN /usr/local/bin/install-plugins.sh pipeline-maven docker-workflow