USE [BASEDATOS02]
GO
/****** Object:  StoredProcedure [dbo].[sp_CreateTicketTemp]    Script Date: 12/25/2013 14:54:28 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE procedure  [dbo].[sp_CreateTicketTemp]
as

SELECT Id, AccountId,
	dbo.FN_CHECKSUM_FORMAT(CheckSum)as CheckSum 
	,SalesTime
	,StatusId
	INTO ##TicketTemp FROM BASEDATOS02..Ticket 
