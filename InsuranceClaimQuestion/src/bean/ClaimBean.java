package bean;

public class ClaimBean
{

	private String claimNumber;
	private String claimReason;
	private String accidentLocationStreet;
	private String accidentCity;
	private String accidentState;
	private String accidentZip;
	private String claimType;
	private long policyNumber;
	
	
	
	public String getClaimNumber() 
	{
		return claimNumber;
	}
	public void setClaimNumber(String claimNumber) 
	{
		this.claimNumber = claimNumber;
	}
	public String getClaimReason()
	{
		return claimReason;
	}
	public void setClaimReason(String claimReason)
	{
		this.claimReason = claimReason;
	}
	public String getAccidentLocationStreet()
	{
		return accidentLocationStreet;
	}
	public void setAccidentLocationStreet(String accidentLocationStreet)
	{
		this.accidentLocationStreet = accidentLocationStreet;
	}
	public String getAccidentCity()
	{
		return accidentCity;
	}
	public void setAccidentCity(String accidentCity)
	{
		this.accidentCity = accidentCity;
	}
	public String getAccidentState()
	{
		return accidentState;
	}
	public void setAccidentState(String accidentState)
	{
		this.accidentState = accidentState;
	}
	
	public String getAccidentZip()
	{
		return accidentZip;
	}
	public void setAccidentZip(String accidentZip) 
	{
		this.accidentZip = accidentZip;
	}
	public String getClaimType() 
	{
		return claimType;
	}
	public void setClaimType(String claimType)
	{
		this.claimType = claimType;
	}
	public long getPolicyNumber()
	{
		return policyNumber;
	}
	public void setPolicyNumber(long policyNumber) 
	{
		this.policyNumber = policyNumber;
	}
	
	@Override
	public String toString()
	{
		return "ClaimBean [claimNumber=" + claimNumber + ", claimReason=" + claimReason + ", accidentLocationStreet="
				+ accidentLocationStreet + ", accidentCity=" + accidentCity + ", accidentState=" + accidentState
				+ ", accidentZip=" + accidentZip + ", claimType=" + claimType + ", policyNumber=" + policyNumber + "]";
	}
	
}
