;Run application
Run("C:\WINDOWS\system32\cmd.exe")

;Wait for CMD to be opened
WinWaitActive("C:\WINDOWS\system32\cmd.exe")

;Write some commands on cmd
send('cd E:\Workspace\flightSpeak' & "{ENTER}")
Sleep(5000)

send('ant' & "{ENTER}")
Sleep(5000)

send('ant generateReport' & "{ENTER}")
Sleep(5000)