#!/bin/bash
bin=`dirname $0;pwd`
#当前目录的路径
app_home=`cd $bin;cd ..;pwd`
echo $app_home
#第一个参数
param=$1
#以当前脚本的名字为工程名，获取方式为$0
app_name=`echo $0 | awk -F. '{print $1}'`
#echo  $app_name
app_name_jar=$app_name'.jar'
echo  the jar name is  : $app_name_jar



#====================
#获取当前运行的进行pid
#====================
app_pid=`ps -ef | grep  $app_name_jar | grep -v grep  | awk '{print $2}'`
#echo $app_pid


#==================
#打印帮助信息
#=================
#kill -9 $app_pid
info(){
	echo "please input like : sh $app_name.sh start | stop | status"
	exit 1
}

#=====================
#启动项目
#=====================
startproj(){
	if [ ! -n $app_pid ];then
		echo "$app_name is running! $app_pid"
	else
                echo "nohup java -jar $app_name_jar --spring.config.location=config/application.yml --logging.config=config/logback-spring.xml &"
        	nohup java -jar $app_home/$app_name_jar --spring.config.location=$app_home/config/application.yml --logging.config=$app_home/config/logback-spring.xml &
		if [ $? -eq 0 ]; then
			echo "$app_name is start sucess"
                else
			echo "$app_name is start failed"
			exit 1
		fi
	fi
}
#==========================
#当前项目是否运行
#========================
projstatus(){
 if [ $app_pid ];then
	echo "$app_name is running! pid:$app_pid"
 else
	echo "$app_name is not running"
 fi
}

#===================
#杀掉当前项目的进程
#==================
stopproj(){
	if  [ -z $app_pid ];then
		echo "程序未启动"
		exit 1
	fi
        
       sucess=`kill -9 $app_pid`
	echo "sucess stop $app_id"
	exit 1
}

case "$1" in 
	start)
		startproj
		;;
	stop)
		stopproj
		;;
	status)
		projstatus
		;;
	*)
		info
	exit 1
esac
