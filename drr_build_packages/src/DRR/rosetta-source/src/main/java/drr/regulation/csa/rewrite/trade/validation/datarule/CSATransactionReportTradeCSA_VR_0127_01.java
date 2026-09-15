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
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("CSATransactionReportTradeCSA_VR_0127_01")
@ImplementedBy(CSATransactionReportTradeCSA_VR_0127_01.Default.class)
public interface CSATransactionReportTradeCSA_VR_0127_01 extends Validator<CSATransactionReportTrade> {
	
	String NAME = "CSATransactionReportTradeCSA_VR_0127_01";
	String DEFINITION = "if basketConstituents -> identifier exists then basketConstituents -> unitOfMeasure count = basketConstituents -> numberOfUnits count and basketConstituents -> unitOfMeasure count = basketConstituents -> identifier count and basketConstituents -> unitOfMeasure count = basketConstituents -> source count else basketConstituents -> unitOfMeasure is absent";
	
	class Default implements CSATransactionReportTradeCSA_VR_0127_01 {
	
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
				if (exists(MapperS.of(cSATransactionReportTrade).<BasketConstituentsReport>mapC("getBasketConstituents", _cSATransactionReportTrade -> _cSATransactionReportTrade.getBasketConstituents()).<String>map("getIdentifier", basketConstituentsReport -> basketConstituentsReport.getIdentifier())).getOrDefault(false)) {
					return areEqual(MapperS.of(MapperS.of(cSATransactionReportTrade).<BasketConstituentsReport>mapC("getBasketConstituents", _cSATransactionReportTrade -> _cSATransactionReportTrade.getBasketConstituents()).<String>map("getUnitOfMeasure", basketConstituentsReport -> basketConstituentsReport.getUnitOfMeasure()).resultCount()), MapperS.of(MapperS.of(cSATransactionReportTrade).<BasketConstituentsReport>mapC("getBasketConstituents", _cSATransactionReportTrade -> _cSATransactionReportTrade.getBasketConstituents()).<BigDecimal>map("getNumberOfUnits", basketConstituentsReport -> basketConstituentsReport.getNumberOfUnits()).resultCount()), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(MapperS.of(cSATransactionReportTrade).<BasketConstituentsReport>mapC("getBasketConstituents", _cSATransactionReportTrade -> _cSATransactionReportTrade.getBasketConstituents()).<String>map("getUnitOfMeasure", basketConstituentsReport -> basketConstituentsReport.getUnitOfMeasure()).resultCount()), MapperS.of(MapperS.of(cSATransactionReportTrade).<BasketConstituentsReport>mapC("getBasketConstituents", _cSATransactionReportTrade -> _cSATransactionReportTrade.getBasketConstituents()).<String>map("getIdentifier", basketConstituentsReport -> basketConstituentsReport.getIdentifier()).resultCount()), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(MapperS.of(cSATransactionReportTrade).<BasketConstituentsReport>mapC("getBasketConstituents", _cSATransactionReportTrade -> _cSATransactionReportTrade.getBasketConstituents()).<String>map("getUnitOfMeasure", basketConstituentsReport -> basketConstituentsReport.getUnitOfMeasure()).resultCount()), MapperS.of(MapperS.of(cSATransactionReportTrade).<BasketConstituentsReport>mapC("getBasketConstituents", _cSATransactionReportTrade -> _cSATransactionReportTrade.getBasketConstituents()).<AssetIdTypeEnum>map("getSource", basketConstituentsReport -> basketConstituentsReport.getSource()).resultCount()), CardinalityOperator.All));
				}
				return notExists(MapperS.of(cSATransactionReportTrade).<BasketConstituentsReport>mapC("getBasketConstituents", _cSATransactionReportTrade -> _cSATransactionReportTrade.getBasketConstituents()).<String>map("getUnitOfMeasure", basketConstituentsReport -> basketConstituentsReport.getUnitOfMeasure()));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CSATransactionReportTradeCSA_VR_0127_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CSATransactionReportTrade cSATransactionReportTrade) {
			return Collections.emptyList();
		}
	}
}
