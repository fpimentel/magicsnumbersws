USE [BASEDATOS02]
GO
/****** Object:  UserDefinedFunction [dbo].[FN_CHECKSUM_FORMAT]    Script Date: 12/22/2013 18:34:40 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
ALTER FUNCTION [dbo].[FN_CHECKSUM_FORMAT] (@check_sum VARCHAR(200))
RETURNS VARCHAR(200)
AS 
	BEGIN
	DECLARE @index int,
			@check_sum_len int,
			@counter int,
			@check_sum_result varchar(200);
	set @index =1;
	set @counter =1;
	set @check_sum_result='';
	set @check_sum_len = LEN(@check_sum)

	WHILE @index <= @check_sum_len
		BEGIN						
			set @check_sum_result = (@check_sum_result + substring(@check_sum,@index,1));
			IF @counter = 9 AND @index < @check_sum_len 
				BEGIN
					SET @check_sum_result = @check_sum_result + '-';	
					SET @counter =0;	
				END				
				SET @index = @index + 1;		
				SET @counter = @counter +1;
		END 
    RETURN @check_sum_result;
END

