:del temp.ftp
@echo off
echo "1[%1] 2[%2]"
:     1[option] 2[host]
if "%1"=="b" (
  cd  /gitWorkspace/misc
  git pull
  start /b gradlew efrost:bootJar

  cd /gitWorkspace/vue/enginerring
  git pull
  start /b npm run build


) else (
  if "%1"=="u" (
	  set /p pwd=password:
	  E:\programs\HaoZip\HaoZipC a -tzip  dist.zip  /gitWorkspace/vue/enginerring/dist
	   XCOPY \gitWorkspace\misc\efrost\build\libs\efrost.jar efrost.jar /Y

  )
)
@echo on
 echo =========[success!]
cd /engineering

