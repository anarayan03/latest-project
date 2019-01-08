package dao;

public interface QueryMapper
{
	public static String EXECUTE_QUERY = "Select * from question_table where  BUSINESS_SEGMENT=?";
	public static String INSERT_QUERY = "insert into claim values(?,?,?,?,?,?,?,?)";
	public static String EXECUTE_QUERY2 = "Select * from claim order by claimNo";
	public static String GEN_SEQ = "select claimno.nextval from dual";
}
