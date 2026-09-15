package drr.regulation.cftc.rewrite.trade.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.base.trade.price.PriceFormat;
import drr.base.trade.price.PriceNotationEnum;
import drr.regulation.cftc.rewrite.trade.CFTCPart45TransactionReport;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("CFTCPart45TransactionReportStrikePriceNotationCondition")
@ImplementedBy(CFTCPart45TransactionReportStrikePriceNotationCondition.Default.class)
public interface CFTCPart45TransactionReportStrikePriceNotationCondition extends Validator<CFTCPart45TransactionReport> {
	
	String NAME = "CFTCPart45TransactionReportStrikePriceNotationCondition";
	String DEFINITION = "if strikePrice exists then strikePriceNotation exists else strikePriceNotation is absent";
	
	class Default implements CFTCPart45TransactionReportStrikePriceNotationCondition {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CFTCPart45TransactionReport cFTCPart45TransactionReport) {
			ComparisonResult result = executeDataRule(cFTCPart45TransactionReport);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CFTCPart45TransactionReport", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CFTCPart45TransactionReport", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(CFTCPart45TransactionReport cFTCPart45TransactionReport) {
			try {
				if (exists(MapperS.of(cFTCPart45TransactionReport).<PriceFormat>map("getStrikePrice", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getStrikePrice())).getOrDefault(false)) {
					return exists(MapperS.of(cFTCPart45TransactionReport).<PriceNotationEnum>map("getStrikePriceNotation", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getStrikePriceNotation()));
				}
				return notExists(MapperS.of(cFTCPart45TransactionReport).<PriceNotationEnum>map("getStrikePriceNotation", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getStrikePriceNotation()));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CFTCPart45TransactionReportStrikePriceNotationCondition {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CFTCPart45TransactionReport cFTCPart45TransactionReport) {
			return Collections.emptyList();
		}
	}
}
