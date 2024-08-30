FROM dorowu/ubuntu-desktop-lxde-vnc
 
WORKDIR /
 
RUN mkdir -p aibattleground
 
RUN sudo apt install wget
RUN wget https://download.oracle.com/java/17/latest/jdk-17_linux-x64_bin.deb -O jdk-17.deb
RUN sudo dpkg -i jdk-17.deb
RUN wget https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb
RUN sudo dpkg -i google-chrome-stable_current_amd64.deb
RUN sudo apt --fix-broken install


COPY ./target/BATTLE-1.0-SNAPSHOT-jar-with-dependencies.jar /aibattleground
COPY ./src/main/resources/run.sh /aibattleground
COPY ./chromedriver128 /aibattleground

RUN chmod +x /aibattleground/run.sh
#RUN crontab -e
#RUN ln -s /etc/init.d/run.sh /etc/rc.d/

#ENTRYPONT ["/aibattleground/run.sh"]