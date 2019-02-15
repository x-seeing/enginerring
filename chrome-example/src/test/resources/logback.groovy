def appName = 'chrome-example'

statusListener OnConsoleStatusListener
def port = System.getProperty 'server.port'
def patternLayout = '%d{HH:mm:ss.SSS} |-%-5level | %t | %logger{5}:%L - %msg%n'
def maxLogArchiveHistoryDays = 180

def appenderNames = ['root', appName]
def rootAppenders = ['rootDailyRollingFile']
def appAppenders = ["${appName}DailyRollingFile".toString()]

appender('console', ConsoleAppender) {
    encoder(PatternLayoutEncoder) {
        pattern = patternLayout
    }
}
appenderNames.each { name ->
    createAppender name, "/var/logs/${appName}/${hostname}/${port}",
        maxLogArchiveHistoryDays, patternLayout
}

// TODO profile based
root INFO, rootAppenders + 'console'
logger 'com.see', DEBUG, appAppenders

private void createAppender(name, logFilePathPrefix, maxLogArchiveHistoryDays, patternLayout) {
    appender("${name}DailyRollingFile", RollingFileAppender) {
        file = "$logFilePathPrefix/${name}.log"
        rollingPolicy(TimeBasedRollingPolicy) {
            fileNamePattern = "$logFilePathPrefix/${name}.%d{yyyy-MM-dd}.gz"
            maxHistory = maxLogArchiveHistoryDays
        }
        encoder(PatternLayoutEncoder) {
            pattern = patternLayout
        }
    }
}
