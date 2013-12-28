USE [BASEDATOS02]
GO
/****** Object:  StoredProcedure [dbo].[SP_CREATE_CUSTOMER_FILES]    Script Date: 12/25/2013 15:01:43 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO


ALTER procedure [dbo].[SP_CREATE_CUSTOMER_FILES]
as
SET NOCOUNT ON;
DECLARE @accountId int,
		@sql varchar(8000),
		@ServerName varchar(80),
		@querySQL varchar(1000);
set @ServerName ='C61317-131053'

DECLARE CUSTOMER_IDS  CURSOR FOR 
SELECT DISTINCT ACCOUNTID
FROM dbo.Ticket ;

OPEN CUSTOMER_IDS

FETCH NEXT FROM CUSTOMER_IDS 
		INTO @accountId
EXECUTE [BASEDATOS02].[dbo].[sp_CreateTicketTemp] 
WHILE @@FETCH_STATUS = 0
	BEGIN
		
		PRINT ''+@accountId  
		SET @querySQL = '"select Id, CheckSum, SalesTime, CASE StatusId WHEN 1 THEN ''NULO'' ELSE CONVERT(VARCHAR, StatusId) END from ##TicketTemp where AccountId ='+cast (@accountId AS varchar(50))+'"';
		print @querySQL
		SELECT @sql ='bcp ' +@querySQL
		+' queryout C:\CLIENTS_REPO\'+'REP-'+cast (@accountId AS varchar(50))+'-'+ convert (char(10),GETDATE(),21)+ '.csv -c -t, -T -S'
		+@ServerName		
		EXEC BASEDATOS02..xp_cmdshell @sql
		FETCH NEXT FROM CUSTOMER_IDS 
		INTO @accountId
	END
CLOSE CUSTOMER_IDS;
DEALLOCATE CUSTOMER_IDS;

SET @querySQL = '"select Id, CheckSum, SalesTime, CASE StatusId WHEN 1 THEN ''NULO'' ELSE CONVERT(VARCHAR, StatusId) END from BASEDATOS02..Ticket"';
SELECT @sql ='bcp ' +@querySQL
+' queryout C:\CLIENTS_REPO\'+'REP-GENERAL-'+ convert (char(10),GETDATE(),21)+ '.csv -c -t, -T -S'
+@ServerName		
EXEC BASEDATOS01..xp_cmdshell @sql

EXECUTE [BASEDATOS02].[dbo].sp_DeleteTicketTemp
