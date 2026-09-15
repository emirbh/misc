package drr.regulation.csa.rewrite.trade.validation.datarule;

import cdm.base.staticdata.asset.common.AssetIdTypeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.base.trade.basket.BasketConstituentsReport;
import drr.regulation.csa.rewrite.trade.CSATransactionReportTrade;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("CSATransactionReportTradeDTCC_CSA_VR_0125_01")
@ImplementedBy(CSATransactionReportTradeDTCC_CSA_VR_0125_01.Default.class)
public interface CSATransactionReportTradeDTCC_CSA_VR_0125_01 extends Validator<CSATransactionReportTrade> {
	
	String NAME = "CSATransactionReportTradeDTCC_CSA_VR_0125_01";
	String DEFINITION = "if basketConstituents -> source exists then basketConstituents -> source count = basketConstituents -> identifier count";
	
	class Default implements CSATransactionReportTradeDTCC_CSA_VR_0125_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CSATransactionReportTrade cSATransactionReportTrade) {
			ComparisonResult result = executeDataRule(cSATransactionReportTrade);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CSATransactionReportTrade", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CSATransactionReportTrade", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(CSATransactionReportTrade cSATransactionReportTrade) {
			try {
				if (exists(MapperS.of(cSATransactionReportTrade).<BasketConstituentsReport>mapC("getBasketConstituents", _cSATransactionReportTrade -> _cSATransactionReportTrade.getBasketConstituents()).<AssetIdTypeEnum>map("getSource", basketConstituentsReport -> basketConstituentsReport.getSource())).getOrDefault(false)) {
					return areEqual(MapperS.of(MapperS.of(cSATransactionReportTrade).<BasketConstituentsReport>mapC("getBasketConstituents", _cSATransactionReportTrade -> _cSATransactionReportTrade.getBasketConstituents()).<AssetIdTypeEnum>map("getSource", basketConstituentsReport -> basketConstituentsReport.getSource()).resultCount()), MapperS.of(MapperS.of(cSATransactionReportTrade).<BasketConstituentsReport>mapC("getBasketConstituents", _cSATransactionReportTrade -> _cSATransactionReportTrade.getBasketConstituents()).<String>map("getIdentifier", basketConstituentsReport -> basketConstituentsReport.getIdentifier()).resultCount()), CardinalityOperator.All);
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CSATransactionReportTradeDTCC_CSA_VR_0125_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CSATransactionReportTrade cSATransactionReportTrade) {
			return Collections.emptyList();
		}
	}
}
