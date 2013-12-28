USE [BASEDATOS02]
GO
/****** Object:  StoredProcedure [dbo].[sp_DeleteTicketTemp]    Script Date: 12/25/2013 14:56:45 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
ALTER procedure [dbo].[sp_DeleteTicketTemp] 
as
drop table ##TicketTemp