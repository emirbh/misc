package drr.standards.iosco.upi;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version 7.7.0
 */
@RosettaEnum("AnnaDsbUseCaseEnum")
public enum AnnaDsbUseCaseEnum {

	@RosettaEnumValue(value = "ABS") 
	ABS("ABS", null),
	
	@RosettaEnumValue(value = "Barrier_Option", displayName = "Barrier_Option") 
	BARRIER_OPTION("Barrier_Option", "Barrier_Option"),
	
	@RosettaEnumValue(value = "Basis", displayName = "Basis") 
	BASIS("Basis", "Basis"),
	
	@RosettaEnumValue(value = "Basis_OIS", displayName = "Basis_OIS") 
	BASIS_OIS("Basis_OIS", "Basis_OIS"),
	
	@RosettaEnumValue(value = "Basis_Swap", displayName = "Basis_Swap") 
	BASIS_SWAP("Basis_Swap", "Basis_Swap"),
	
	@RosettaEnumValue(value = "Basket", displayName = "Basket") 
	BASKET("Basket", "Basket"),
	
	@RosettaEnumValue(value = "CapFloor", displayName = "CapFloor") 
	CAP_FLOOR("CapFloor", "CapFloor"),
	
	@RosettaEnumValue(value = "Contract_For_Difference", displayName = "Contract_For_Difference") 
	CONTRACT_FOR_DIFFERENCE("Contract_For_Difference", "Contract_For_Difference"),
	
	@RosettaEnumValue(value = "Corporate", displayName = "Corporate") 
	CORPORATE("Corporate", "Corporate"),
	
	@RosettaEnumValue(value = "Cross_Currency_Basis", displayName = "Cross_Currency_Basis") 
	CROSS_CURRENCY_BASIS("Cross_Currency_Basis", "Cross_Currency_Basis"),
	
	@RosettaEnumValue(value = "Cross_Currency_Fixed_Fixed", displayName = "Cross_Currency_Fixed_Fixed") 
	CROSS_CURRENCY_FIXED_FIXED("Cross_Currency_Fixed_Fixed", "Cross_Currency_Fixed_Fixed"),
	
	@RosettaEnumValue(value = "Cross_Currency_Fixed_Float", displayName = "Cross_Currency_Fixed_Float") 
	CROSS_CURRENCY_FIXED_FLOAT("Cross_Currency_Fixed_Float", "Cross_Currency_Fixed_Float"),
	
	@RosettaEnumValue(value = "Cross_Currency_Fixed_Float_NDS", displayName = "Cross_Currency_Fixed_Float_NDS") 
	CROSS_CURRENCY_FIXED_FLOAT_NDS("Cross_Currency_Fixed_Float_NDS", "Cross_Currency_Fixed_Float_NDS"),
	
	@RosettaEnumValue(value = "Cross_Currency_Inflation_Swap", displayName = "Cross_Currency_Inflation_Swap") 
	CROSS_CURRENCY_INFLATION_SWAP("Cross_Currency_Inflation_Swap", "Cross_Currency_Inflation_Swap"),
	
	@RosettaEnumValue(value = "Cross_Currency_Zero_Coupon", displayName = "Cross_Currency_Zero_Coupon") 
	CROSS_CURRENCY_ZERO_COUPON("Cross_Currency_Zero_Coupon", "Cross_Currency_Zero_Coupon"),
	
	@RosettaEnumValue(value = "Debt", displayName = "Debt") 
	DEBT("Debt", "Debt"),
	
	@RosettaEnumValue(value = "Debt_Option", displayName = "Debt_Option") 
	DEBT_OPTION("Debt_Option", "Debt_Option"),
	
	@RosettaEnumValue(value = "Digital_Option", displayName = "Digital_Option") 
	DIGITAL_OPTION("Digital_Option", "Digital_Option"),
	
	@RosettaEnumValue(value = "Fixed_Fixed", displayName = "Fixed_Fixed") 
	FIXED_FIXED("Fixed_Fixed", "Fixed_Fixed"),
	
	@RosettaEnumValue(value = "Fixed_Float", displayName = "Fixed_Float") 
	FIXED_FLOAT("Fixed_Float", "Fixed_Float"),
	
	@RosettaEnumValue(value = "Fixed_Float_OIS", displayName = "Fixed_Float_OIS") 
	FIXED_FLOAT_OIS("Fixed_Float_OIS", "Fixed_Float_OIS"),
	
	@RosettaEnumValue(value = "Fixed_Float_Zero_Coupon", displayName = "Fixed_Float_Zero_Coupon") 
	FIXED_FLOAT_ZERO_COUPON("Fixed_Float_Zero_Coupon", "Fixed_Float_Zero_Coupon"),
	
	@RosettaEnumValue(value = "Forward", displayName = "Forward") 
	FORWARD("Forward", "Forward"),
	
	@RosettaEnumValue(value = "Forward_Vol_Agreement", displayName = "Forward_Vol_Agreement") 
	FORWARD_VOL_AGREEMENT("Forward_Vol_Agreement", "Forward_Vol_Agreement"),
	
	@RosettaEnumValue(value = "FRA_Index", displayName = "FRA_Index") 
	FRA_INDEX("FRA_Index", "FRA_Index"),
	
	@RosettaEnumValue(value = "FRA_Other", displayName = "FRA_Other") 
	FRA_OTHER("FRA_Other", "FRA_Other"),
	
	@RosettaEnumValue(value = "FX_Swap", displayName = "FX_Swap") 
	FX_SWAP("FX_Swap", "FX_Swap"),
	
	@RosettaEnumValue(value = "Index", displayName = "Index") 
	INDEX("Index", "Index"),
	
	@RosettaEnumValue(value = "Index_Swaption", displayName = "Index_Swaption") 
	INDEX_SWAPTION("Index_Swaption", "Index_Swaption"),
	
	@RosettaEnumValue(value = "Index_Tranche", displayName = "Index_Tranche") 
	INDEX_TRANCHE("Index_Tranche", "Index_Tranche"),
	
	@RosettaEnumValue(value = "Inflation_Basis", displayName = "Inflation_Basis") 
	INFLATION_BASIS("Inflation_Basis", "Inflation_Basis"),
	
	@RosettaEnumValue(value = "Inflation_Basis_YoY", displayName = "Inflation_Basis_YoY") 
	INFLATION_BASIS_YO_Y("Inflation_Basis_YoY", "Inflation_Basis_YoY"),
	
	@RosettaEnumValue(value = "Inflation_Basis_Zero_Coupon", displayName = "Inflation_Basis_Zero_Coupon") 
	INFLATION_BASIS_ZERO_COUPON("Inflation_Basis_Zero_Coupon", "Inflation_Basis_Zero_Coupon"),
	
	@RosettaEnumValue(value = "Inflation_CapFloor", displayName = "Inflation_CapFloor") 
	INFLATION_CAP_FLOOR("Inflation_CapFloor", "Inflation_CapFloor"),
	
	@RosettaEnumValue(value = "Inflation_Fixed_Float_YoY", displayName = "Inflation_Fixed_Float_YoY") 
	INFLATION_FIXED_FLOAT_YO_Y("Inflation_Fixed_Float_YoY", "Inflation_Fixed_Float_YoY"),
	
	@RosettaEnumValue(value = "Inflation_Fixed_Float_Zero_Coupon", displayName = "Inflation_Fixed_Float_Zero_Coupon") 
	INFLATION_FIXED_FLOAT_ZERO_COUPON("Inflation_Fixed_Float_Zero_Coupon", "Inflation_Fixed_Float_Zero_Coupon"),
	
	@RosettaEnumValue(value = "Inflation_Swap", displayName = "Inflation_Swap") 
	INFLATION_SWAP("Inflation_Swap", "Inflation_Swap"),
	
	@RosettaEnumValue(value = "Loan", displayName = "Loan") 
	LOAN("Loan", "Loan"),
	
	@RosettaEnumValue(value = "Multi_Exotic_Forward", displayName = "Multi_Exotic_Forward") 
	MULTI_EXOTIC_FORWARD("Multi_Exotic_Forward", "Multi_Exotic_Forward"),
	
	@RosettaEnumValue(value = "Multi_Exotic_Option", displayName = "Multi_Exotic_Option") 
	MULTI_EXOTIC_OPTION("Multi_Exotic_Option", "Multi_Exotic_Option"),
	
	@RosettaEnumValue(value = "Multi_Exotic_Swap", displayName = "Multi_Exotic_Swap") 
	MULTI_EXOTIC_SWAP("Multi_Exotic_Swap", "Multi_Exotic_Swap"),
	
	@RosettaEnumValue(value = "Municipal", displayName = "Municipal") 
	MUNICIPAL("Municipal", "Municipal"),
	
	@RosettaEnumValue(value = "NDF") 
	NDF("NDF", null),
	
	@RosettaEnumValue(value = "NDO") 
	NDO("NDO", null),
	
	@RosettaEnumValue(value = "Non_Deliverable_FX_Swap", displayName = "Non_Deliverable_FX_Swap") 
	NON_DELIVERABLE_FX_SWAP("Non_Deliverable_FX_Swap", "Non_Deliverable_FX_Swap"),
	
	@RosettaEnumValue(value = "Non_Standard", displayName = "Non_Standard") 
	NON_STANDARD("Non_Standard", "Non_Standard"),
	
	@RosettaEnumValue(value = "Option", displayName = "Option") 
	OPTION("Option", "Option"),
	
	@RosettaEnumValue(value = "Parameter_Return_Dividend_Basket", displayName = "Parameter_Return_Dividend_Basket") 
	PARAMETER_RETURN_DIVIDEND_BASKET("Parameter_Return_Dividend_Basket", "Parameter_Return_Dividend_Basket"),
	
	@RosettaEnumValue(value = "Parameter_Return_Dividend_Single_Index", displayName = "Parameter_Return_Dividend_Single_Index") 
	PARAMETER_RETURN_DIVIDEND_SINGLE_INDEX("Parameter_Return_Dividend_Single_Index", "Parameter_Return_Dividend_Single_Index"),
	
	@RosettaEnumValue(value = "Parameter_Return_Dividend_Single_Name", displayName = "Parameter_Return_Dividend_Single_Name") 
	PARAMETER_RETURN_DIVIDEND_SINGLE_NAME("Parameter_Return_Dividend_Single_Name", "Parameter_Return_Dividend_Single_Name"),
	
	@RosettaEnumValue(value = "Parameter_Return_Variance_Basket", displayName = "Parameter_Return_Variance_Basket") 
	PARAMETER_RETURN_VARIANCE_BASKET("Parameter_Return_Variance_Basket", "Parameter_Return_Variance_Basket"),
	
	@RosettaEnumValue(value = "Parameter_Return_Variance_Single_Index", displayName = "Parameter_Return_Variance_Single_Index") 
	PARAMETER_RETURN_VARIANCE_SINGLE_INDEX("Parameter_Return_Variance_Single_Index", "Parameter_Return_Variance_Single_Index"),
	
	@RosettaEnumValue(value = "Parameter_Return_Variance_Single_Name", displayName = "Parameter_Return_Variance_Single_Name") 
	PARAMETER_RETURN_VARIANCE_SINGLE_NAME("Parameter_Return_Variance_Single_Name", "Parameter_Return_Variance_Single_Name"),
	
	@RosettaEnumValue(value = "Parameter_Return_Volatility_Basket", displayName = "Parameter_Return_Volatility_Basket") 
	PARAMETER_RETURN_VOLATILITY_BASKET("Parameter_Return_Volatility_Basket", "Parameter_Return_Volatility_Basket"),
	
	@RosettaEnumValue(value = "Parameter_Return_Volatility_Single_Index", displayName = "Parameter_Return_Volatility_Single_Index") 
	PARAMETER_RETURN_VOLATILITY_SINGLE_INDEX("Parameter_Return_Volatility_Single_Index", "Parameter_Return_Volatility_Single_Index"),
	
	@RosettaEnumValue(value = "Parameter_Return_Volatility_Single_Name", displayName = "Parameter_Return_Volatility_Single_Name") 
	PARAMETER_RETURN_VOLATILITY_SINGLE_NAME("Parameter_Return_Volatility_Single_Name", "Parameter_Return_Volatility_Single_Name"),
	
	@RosettaEnumValue(value = "Portfolio_Swap", displayName = "Portfolio_Swap") 
	PORTFOLIO_SWAP("Portfolio_Swap", "Portfolio_Swap"),
	
	@RosettaEnumValue(value = "Portfolio_Swap_Other", displayName = "Portfolio_Swap_Other") 
	PORTFOLIO_SWAP_OTHER("Portfolio_Swap_Other", "Portfolio_Swap_Other"),
	
	@RosettaEnumValue(value = "Portfolio_Swap_Single_Index", displayName = "Portfolio_Swap_Single_Index") 
	PORTFOLIO_SWAP_SINGLE_INDEX("Portfolio_Swap_Single_Index", "Portfolio_Swap_Single_Index"),
	
	@RosettaEnumValue(value = "Portfolio_Swap_Single_Name", displayName = "Portfolio_Swap_Single_Name") 
	PORTFOLIO_SWAP_SINGLE_NAME("Portfolio_Swap_Single_Name", "Portfolio_Swap_Single_Name"),
	
	@RosettaEnumValue(value = "Price_Return_Basic_Performance_Basket", displayName = "Price_Return_Basic_Performance_Basket") 
	PRICE_RETURN_BASIC_PERFORMANCE_BASKET("Price_Return_Basic_Performance_Basket", "Price_Return_Basic_Performance_Basket"),
	
	@RosettaEnumValue(value = "Price_Return_Basic_Performance_Basket_CFD", displayName = "Price_Return_Basic_Performance_Basket_CFD") 
	PRICE_RETURN_BASIC_PERFORMANCE_BASKET_CFD("Price_Return_Basic_Performance_Basket_CFD", "Price_Return_Basic_Performance_Basket_CFD"),
	
	@RosettaEnumValue(value = "Price_Return_Basic_Performance_Single_Index", displayName = "Price_Return_Basic_Performance_Single_Index") 
	PRICE_RETURN_BASIC_PERFORMANCE_SINGLE_INDEX("Price_Return_Basic_Performance_Single_Index", "Price_Return_Basic_Performance_Single_Index"),
	
	@RosettaEnumValue(value = "Price_Return_Basic_Performance_Single_Index_CFD", displayName = "Price_Return_Basic_Performance_Single_Index_CFD") 
	PRICE_RETURN_BASIC_PERFORMANCE_SINGLE_INDEX_CFD("Price_Return_Basic_Performance_Single_Index_CFD", "Price_Return_Basic_Performance_Single_Index_CFD"),
	
	@RosettaEnumValue(value = "Price_Return_Basic_Performance_Single_Name", displayName = "Price_Return_Basic_Performance_Single_Name") 
	PRICE_RETURN_BASIC_PERFORMANCE_SINGLE_NAME("Price_Return_Basic_Performance_Single_Name", "Price_Return_Basic_Performance_Single_Name"),
	
	@RosettaEnumValue(value = "Price_Return_Basic_Performance_Single_Name_CFD", displayName = "Price_Return_Basic_Performance_Single_Name_CFD") 
	PRICE_RETURN_BASIC_PERFORMANCE_SINGLE_NAME_CFD("Price_Return_Basic_Performance_Single_Name_CFD", "Price_Return_Basic_Performance_Single_Name_CFD"),
	
	@RosettaEnumValue(value = "Rolling_Spot", displayName = "Rolling_Spot") 
	ROLLING_SPOT("Rolling_Spot", "Rolling_Spot"),
	
	@RosettaEnumValue(value = "Single_Index", displayName = "Single_Index") 
	SINGLE_INDEX("Single_Index", "Single_Index"),
	
	@RosettaEnumValue(value = "Single_Name", displayName = "Single_Name") 
	SINGLE_NAME("Single_Name", "Single_Name"),
	
	@RosettaEnumValue(value = "Single_Name_Swaption", displayName = "Single_Name_Swaption") 
	SINGLE_NAME_SWAPTION("Single_Name_Swaption", "Single_Name_Swaption"),
	
	@RosettaEnumValue(value = "Sovereign", displayName = "Sovereign") 
	SOVEREIGN("Sovereign", "Sovereign"),
	
	@RosettaEnumValue(value = "Spreadbet", displayName = "Spreadbet") 
	SPREADBET("Spreadbet", "Spreadbet"),
	
	@RosettaEnumValue(value = "Swap", displayName = "Swap") 
	SWAP("Swap", "Swap"),
	
	@RosettaEnumValue(value = "Swaption", displayName = "Swaption") 
	SWAPTION("Swaption", "Swaption"),
	
	@RosettaEnumValue(value = "Target_Option", displayName = "Target_Option") 
	TARGET_OPTION("Target_Option", "Target_Option"),
	
	@RosettaEnumValue(value = "Total_Return_Swap", displayName = "Total_Return_Swap") 
	TOTAL_RETURN_SWAP("Total_Return_Swap", "Total_Return_Swap"),
	
	@RosettaEnumValue(value = "Undefined", displayName = "Undefined") 
	UNDEFINED("Undefined", "Undefined"),
	
	@RosettaEnumValue(value = "Vanilla_Option", displayName = "Vanilla_Option") 
	VANILLA_OPTION("Vanilla_Option", "Vanilla_Option"),
	
	@RosettaEnumValue(value = "Vol_Var", displayName = "Vol_Var") 
	VOL_VAR("Vol_Var", "Vol_Var")
;
	private static Map<String, AnnaDsbUseCaseEnum> values;
	static {
        Map<String, AnnaDsbUseCaseEnum> map = new ConcurrentHashMap<>();
		for (AnnaDsbUseCaseEnum instance : AnnaDsbUseCaseEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	AnnaDsbUseCaseEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static AnnaDsbUseCaseEnum fromDisplayName(String name) {
		AnnaDsbUseCaseEnum value = values.get(name);
		if (value == null) {
			throw new IllegalArgumentException("No enum constant with display name \"" + name + "\".");
		}
		return value;
	}

	@Override
	public String toString() {
		return toDisplayString();
	}

	public String toDisplayString() {
		return displayName != null ?  displayName : rosettaName;
	}
}
