package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Constants 
{
	//public static final String PropertyFile="src/test/resources/constants.properties";
	
	public static final String PropertyFile="D:/GitTest/TestingScripts/HomeUnion/src/test/resources/constants.properties";
	public static JavaHelpers JH = new JavaHelpers();

	/*
	Selenium Specific parameters
	*/
	public static final int WebDriverWaitDuration= Integer.parseInt(GetPropertyValue("WebDriverWaitDuration"));
	public static final int ThreadWaitInmiliseconds= Integer.parseInt(GetPropertyValue("ThreadWaitInmiliseconds"));
	
	
	/*
	Homeunion specific parameters
	*/
	
		public static final String  Env= GetSysPropertyValue("Env");
		
	
		/*Admin Portal environment Details*/
		public static final String 	AdminPortal= SetPropertyValue(Env ,"AdminPortal");
		public static final String 	AdminPortal_Username= SetPropertyValue(Env ,"AdminPortal_Username");
		public static final String 	AdminPortal_Password= SetPropertyValue(Env ,"AdminPortal_Password");
		
		public static final String 	AdminPortal_RETSListing= AdminPortal + GetPropertyValue("AdminPortal_RETSListing");
		public static final String 	AdminPortal_ViewProperties= AdminPortal + GetPropertyValue("AdminPortal_ViewProperties");
		public static final String 	AdminPortal_ViewProperties_PropInfo= AdminPortal + GetPropertyValue("AdminPortal_ViewProperties_PropInfo");
		public static final String 	AdminPortal_ViewProperties_PropFinancialInfo= AdminPortal + GetPropertyValue("AdminPortal_ViewProperties_PropFinancialInfo");
		public static final String 	AdminPortal_AssetClassPropertiesList= AdminPortal + GetPropertyValue("AdminPortal_AssetClassPropertiesList");

		
		/*Investor Portal environment Details*/
		public static final String 	InvestorPortal= SetPropertyValue(Env ,"InvestorPortal");
		public static final String 	InvestorPortal_Username= SetPropertyValue(Env ,"InvestorPortal_Username");
		public static final String 	InvestorPortal_Password= SetPropertyValue(Env ,"InvestorPortal_Password");
		public static final String 	InvestorPortal_Username_Other= GetPropertyValue("InvestorPortal_Username_Other");
		public static final String 	InvestorPortal_Password_Other= GetPropertyValue("InvestorPortal_Password_Other");
		public static final String 	InvestorPortal_ForgotPassword_Email= SetPropertyValue(Env ,"InvestorPortal_ForgotPassword_Email");
		public static final String 	InvestorPortal_Username_WishList= SetPropertyValue(Env ,"InvestorPortal_Username_WishList");
		public static final String 	InvestorPortal_Password_WishList= SetPropertyValue(Env ,"InvestorPortal_Password_WishList");
		public static final String 	InvestorPortal_Username_Existing= SetPropertyValue(Env ,"InvestorPortal_Username_Existing");
		public static final String 	InvestorPortal_Password_Existing= SetPropertyValue(Env ,"InvestorPortal_Password_Existing");
		public static final String 	InvestorPortalrecoengine= SetPropertyValue(Env ,"InvestorPortalrecoengine");
		
		/*Embrace environment Details*/
		public static final String 	Embrace_root= GetPropertyValue("Embrace_root");
		public static final String 	Embrace= SetPropertyValue(Env ,"Embrace");
		public static final String 	Embrace_Login= GetPropertyValue("Embrace_Loginpage");
		public static final String 	Embrace_Username= SetPropertyValue(Env ,"Embrace_Username");
		public static final String 	Embrace_Password= SetPropertyValue(Env ,"Embrace_Password");
		public static final String 	Embrace_VendorName= GetPropertyValue("Embrace_VendorName");
		public static final String 	Embrace_VendorUsername= GetPropertyValue("Embrace_VendorUsername");
		public static final String 	Embrace_VendorPassword= GetPropertyValue("Embrace_VendorPassword");
		public static final String 	Embrace_InvestorSearch= Embrace + GetPropertyValue("Embrace_InvestorSearch");
		public static final String 	Embrace_PropertySearch= Embrace + GetPropertyValue("Embrace_PropertySearch");
		public static final String 	Embrace_OpportunitiesSearch= Embrace + GetPropertyValue("Embrace_OpportunitiesSearch");
		public static final String 	Embrace_ClosingSearch= Embrace + GetPropertyValue("Embrace_ClosingSearch");
		public static final String  Embrace_AssetsSearch = Embrace + GetPropertyValue("Embrace_AssetsSearch");
		public static final String  Embrace_RehabSearch = Embrace + GetPropertyValue("Embrace_RehabSearch");
		public static final String  Embrace_LeasingSearch = Embrace + GetPropertyValue("Embrace_LeasingSearch");
		public static final String  Embrace_MarketingSearch = Embrace + GetPropertyValue("Embrace_MarketingSearch");
		public static final String 	Embrace_Logout= Embrace + GetPropertyValue("Embrace_Logout");
		public static final String 	Embrace_InvestorFullName= GetPropertyValue("Embrace_InvestorFullName");
		public static final String 	Embrace_Username_Indianapolis= GetPropertyValue("Embrace_Username_Indianapolis");
		public static final String 	Embrace_Password_Indianapolis= GetPropertyValue("Embrace_Password_Indianapolis");
		public static final String 	Embrace_RETSListing= Embrace_root + GetPropertyValue("Embrace_RETSListing");
		public static final String 	Embrace_BPORETSListing= Embrace_root + GetPropertyValue("Embrace_BPORETSListing");
		public static final String 	Embrace_PropertyDetails= GetPropertyValue("Embrace_PropertyDetails");
		public static final String 	Embrace_RentReviewListing= GetPropertyValue("Embrace_RentReviewListing");
		public static final String 	Embrace_RehabReviewListing= GetPropertyValue("Embrace_RehabReviewListing");
		public static final String 	Embrace_ILMReview= GetPropertyValue("Embrace_ILMReview");
		public static final String 	Embrace_RedShiftPropertySearch= GetPropertyValue("Embrace_RedShiftPropertySearch");
		public static final String 	Embrace_BPOUser= SetPropertyValue(Env ,"Embrace_BPOUser");
		public static final String 	Embrace_InventoryAdmin_Integ= GetPropertyValue("Embrace_InventoryAdmin_Integ");
		//public static final String 	Embrace_BPOUser_Prod= GetPropertyValue("Embrace_BPOUser_Prod");
		public static final String 	Embrace_InventoryAdmin_Prod= GetPropertyValue("Embrace_InventoryAdmin_Prod");
		
		public static final String 	Embrace_Prod_InvestorDetailsPage= GetPropertyValue("Embrace_Prod_InvestorDetailsPage");
		public static final String 	Embrace_Prod_OpportunityDetailsPage= GetPropertyValue("Embrace_Prod_OpportunityDetailsPage");
		public static final String 	Embrace_Prod_ClosingDetailsPage= GetPropertyValue("Embrace_Prod_ClosingDetailsPage");
		public static final String 	Embrace_Prod_AssetDetailsPage= GetPropertyValue("Embrace_Prod_AssetDetailsPage");
		public static final String 	Embrace_Prod_PropertyDetailsPage= GetPropertyValue("Embrace_Prod_PropertyDetailsPage");
		public static final String 	Embrace_Prod_RehabDetailsPage= GetPropertyValue("Embrace_Prod_RehabDetailsPage");
		public static final String 	Embrace_Prod_MarketingDetailsPage= GetPropertyValue("Embrace_Prod_MarketingDetailsPage");

		
		/*PropertyWare environment Details*/
		public static final String 	PropertyWare= GetPropertyValue("PropertyWare");
		public static final String 	PropertyWareLogin= GetPropertyValue("PropertyWareLogin");
		public static final String 	PropertyWareUserName= GetPropertyValue("PropertyWareUserName");
		public static final String 	PropertyWarePassword= GetPropertyValue("PropertyWarePassword");
		public static final String 	JasperServer= GetPropertyValue("JasperServer");
		public static final String 	JasperServer_TotalIncome_ByProperty= GetPropertyValue("JasperServer_TotalIncome_ByProperty");
		public static final String 	JasperServer_TotalExpense_ByProperty= GetPropertyValue("JasperServer_TotalExpense_ByProperty");
		public static final String 	JasperServer_Username= GetPropertyValue("JasperServer_Username");
		public static final String 	JasperServer_Password= GetPropertyValue("JasperServer_Password");		
		
		/*Yardi environment Details*/
		public static final String 	YardiPortal= GetPropertyValue("YardiPortal");
		public static final String 	yardiUsername= GetPropertyValue("yardiUsername");
		public static final String 	yardiPassword= GetPropertyValue("yardiPassword");
		
		
		/*Workspace Email Login*/
		public static final String 	WS_Email_Login= GetPropertyValue("WS_Email_Login");
		public static final String 	WS_Email_Username= GetPropertyValue("WS_Email_Username");
		public static final String 	WS_Email_Password= GetPropertyValue("WS_Email_Password");
	

	/*
	Test Data for Admin Portal
	*/
		public static final String 	MLS= GetPropertyValue("MLS");
		public static final String 	UndoProcessJar= SetPropertyValue(Env ,"UndoProcessJar");
		
	/*
	Test Data for Embrace 
	*/
		public static final String  DocPathForPurchaseAgreement= JH.File_GetAbsolutePath(GetPropertyValue("DocPathForPurchaseAgreement"));
		public static final String 	DocPathForEarnestMoneyDepositEMDImage= JH.File_GetAbsolutePath(GetPropertyValue("DocPathForEarnestMoneyDepositEMDImage"));
		public static final String 	DocPathForPreInspectionDocument= JH.File_GetAbsolutePath(GetPropertyValue("DocPathForPreInspectionDocument"));
		public static final String 	DocPathForAssetManagementAgreement= JH.File_GetAbsolutePath(GetPropertyValue("DocPathForAssetManagementAgreement"));
		public static final String 	DocPathForInsuranceDeclaration= JH.File_GetAbsolutePath(GetPropertyValue("DocPathForInsuranceDeclaration"));
		public static final String 	DocPathForPropertyInspection= JH.File_GetAbsolutePath(GetPropertyValue("DocPathForPropertyInspection"));
		public static final String 	DocPathForPreliminaryHUD= JH.File_GetAbsolutePath(GetPropertyValue("DocPathForPreliminaryHUD"));
		public static final String 	DocPathForFinalHUD= JH.File_GetAbsolutePath(GetPropertyValue("DocPathForFinalHUD"));
		public static final String 	DocPathForFinalHUDMortgageNote= JH.File_GetAbsolutePath(GetPropertyValue("DocPathForFinalHUDMortgageNote"));
		public static final String 	DocPathForFinalHUDTitle= JH.File_GetAbsolutePath(GetPropertyValue("DocPathForFinalHUDTitle"));
		public static final String 	DocPathForFinalHUDTaxCertificate= JH.File_GetAbsolutePath(GetPropertyValue("DocPathForFinalHUDTaxCertificate"));
		public static final String 	DocPathForSellerDisclosure= JH.File_GetAbsolutePath(GetPropertyValue("DocPathForSellerDisclosure"));
		public static final String 	DocPathForFLDDisclosure= JH.File_GetAbsolutePath(GetPropertyValue("DocPathForFLDDisclosure"));
		public static final String 	DocPathForMLSSheet= JH.File_GetAbsolutePath(GetPropertyValue("DocPathForMLSSheet"));
		public static final String 	DocPathForHOAStatement= JH.File_GetAbsolutePath(GetPropertyValue("DocPathForHOAStatement"));
		public static final String 	DocPathForWireInstructions= JH.File_GetAbsolutePath(GetPropertyValue("DocPathForWireInstructions"));
		public static final String 	DocPathForTitleDocument= JH.File_GetAbsolutePath(GetPropertyValue("DocPathForTitleDocument"));
		public static final String 	DocPathForTaxCertificate= JH.File_GetAbsolutePath(GetPropertyValue("DocPathForTaxCertificate"));
		public static final String 	DocPathForFeeSheet= JH.File_GetAbsolutePath(GetPropertyValue("DocPathForFeeSheet"));
		public static final String 	DocPathForFeeImage= JH.File_GetAbsolutePath(GetPropertyValue("DocPathForFeeImage"));
		public static final String  DocPathForRentalAgreement = JH.File_GetAbsolutePath(GetPropertyValue("DocPathForRentalAgreement"));
				
		//Insurance Process - Quotes docs
		public static final String 	DocPathForPolicyDetails1= JH.File_GetAbsolutePath(GetPropertyValue("DocPathForPolicyDetails1"));
		public static final String 	DocPathForPolicyDetails2= JH.File_GetAbsolutePath(GetPropertyValue("DocPathForPolicyDetails2"));
		public static final String 	DocPathForPolicyDetails3= JH.File_GetAbsolutePath(GetPropertyValue("DocPathForPolicyDetails3"));
		public static final String 	DocPathForPolicyDetails4= JH.File_GetAbsolutePath(GetPropertyValue("DocPathForPolicyDetails4"));
		
		public static final String 	DocPathForCertificateIssuance= JH.File_GetAbsolutePath(GetPropertyValue("DocPathForCertificateIssuance"));
		public static final String 	DocPathForEvidenceIssuance= JH.File_GetAbsolutePath(GetPropertyValue("DocPathForEvidenceIssuance"));
		public static final String 	DocPathForInsuranceApplication= JH.File_GetAbsolutePath(GetPropertyValue("DocPathForInsuranceApplication"));
		public static final String 	DocPathForInvoice= JH.File_GetAbsolutePath(GetPropertyValue("DocPathForInvoice"));
		public static final String 	DocPathForUploadImage= JH.File_GetAbsolutePath(GetPropertyValue("DocPathForUploadImage"));
		
		//Marketing Work Flow documents
		public static final String 	DocPathForConfirm_Deposit_Receipt= JH.File_GetAbsolutePath(GetPropertyValue("DocPathForConfirm_Deposit_Receipt"));
		public static final String 	DocPathForConfirm_Lease_Signed= JH.File_GetAbsolutePath(GetPropertyValue("DocPathForConfirm_Lease_Signed"));
		public static final String 	DocPathForExecuted_Lease_listing_Agreement= JH.File_GetAbsolutePath(GetPropertyValue("DocPathForExecuted_Lease_listing_Agreement"));
		public static final String 	DocPathForLease_listing_Agreement= JH.File_GetAbsolutePath(GetPropertyValue("DocPathForLease_listing_Agreement"));
		public static final String 	DocPathForMove_In_Document= JH.File_GetAbsolutePath(GetPropertyValue("DocPathForMove_In_Document"));
		public static final String 	DocPathForMove_in_Inspection= JH.File_GetAbsolutePath(GetPropertyValue("DocPathForMove_in_Inspection"));
		
		
		
		

	/*
	Test Data for Investor Portal
	*/
		public static final String 	comp_propertyid= SetPropertyValue(Env ,"comp_propertyid");
		public static final String 	comp_propertyid1= SetPropertyValue(Env ,"comp_propertyid1");
	
		
	/*
	Sauce Labs details
	*/
		public static final String 	SL_USERNAME= GetPropertyValue("SL_USERNAME");
		public static final String 	SL_ACCESS_KEY= GetPropertyValue("SL_ACCESS_KEY");
		
	/*
	 Database details
	*/
		public static final String 	dbUrl= SetPropertyValue(Env,"dbUrl");
		public static final String 	db_username= SetPropertyValue(Env,"db_username");
		public static final String 	db_password= SetPropertyValue(Env,"db_password");
		public static final String  autoreconnect= SetPropertyValue(Env,"autoreconnect");
		public static final String  maxReconnects= SetPropertyValue(Env,"maxReconnects");
		
	/*
	Reading a propertyfile and getting value of any property defined
	@Param PropertyName - Name of property for which you want to get value
	*/	
	public static Properties prop;
	static String PropertyValue;	
	public static String GetPropertyValue(String PropertyName)
	{
		prop = AccessPropertiesFile();

			try{
				PropertyValue= prop.getProperty(PropertyName);	
				}

			catch(Exception e){
				}	
			return PropertyValue;
	}
	public static Properties AccessPropertiesFile()
	{
		prop = new Properties();

		// try retrieve data from file
		try 
		{

			prop.load(new FileInputStream(PropertyFile));
		}
		// catch exception in case properties file does not exist
		catch (IOException e) 
		{
			e.printStackTrace();
		}

		return prop;
	}
	
	public static String GetSysPropertyValue(String property)
	{
		String PropertyNew=System.getProperty(property);
		
		if(PropertyNew == null || PropertyNew.isEmpty()) 
		{	
			PropertyNew=GetPropertyValue(property);
		}
		return PropertyNew;
		
	}
	
	
	public static String SetPropertyValue(String env, String property)
	{
		
		String PropertyNew ="";
		if(env.equals("INTEG"))
			{
				PropertyNew = GetPropertyValue(property+"_INTEG");
			}
		else if(env.equals("PROD"))
			{
				PropertyNew = GetPropertyValue(property+"_PROD");
			}
		else if(env.equals("STAGING"))
		{
			PropertyNew = GetPropertyValue(property+"_STAGING");
		}
		else if(env.equals("STGIPEXP"))
		{
			PropertyNew = GetPropertyValue(property+"_STGIPexp");
		}
		return PropertyNew;
		
	}
}
