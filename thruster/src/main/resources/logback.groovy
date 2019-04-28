// Register Status Listener
statusListener OnConsoleStatusListener
println "$hostname"
def appName = 'thruster'
def patternLayout = '%d{HH:mm:ss.SSS} |-%-5level | %t | %logger{5}:%L - %msg%n'
def maxLogArchiveHistoryDays = 120

def port = System.getProperty 'server.port'
def rootAppenders = ['rootDailyRollingFile']
def appAppenders = ['appDailyRollingFile']

def commonAppenderNames = ['root', 'app']
def individualAppenderNames = [appName]


def env = ('production' == System.getProperty('spring.profiles.active'))
def identify = { hostname ->
    "/var/logs/${appName}/$hostname/${port}"
}
def logFilePathPrefix = identify(hostname)

appender('console', ConsoleAppender) {
    encoder(PatternLayoutEncoder) {
        pattern = patternLayout
    }
}
(commonAppenderNames + individualAppenderNames).each { name ->
    createAppender name, logFilePathPrefix, maxLogArchiveHistoryDays, patternLayout
}

root env ? WARN : INFO, env ? rootAppenders : rootAppenders + 'console'
logger 'com.see', DEBUG, env ? appAppenders : appAppenders + 'console'
individualAppenderNames.each { name ->
    logger "com.see", DEBUG, ["${name}DailyRollingFile"]
}

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
