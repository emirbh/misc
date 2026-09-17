package cdm.product.asset.validation.datarule;

import cdm.product.asset.DividendPaymentDate;
import cdm.product.asset.DividendPeriod;
import cdm.product.asset.DividendPeriodEnum;
import cdm.product.asset.DividendReturnTerms;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 6.23.0
 */
@RosettaDataRule("DividendReturnTermsDividendPeriod")
@ImplementedBy(DividendReturnTermsDividendPeriod.Default.class)
public interface DividendReturnTermsDividendPeriod extends Validator<DividendReturnTerms> {
	
	String NAME = "DividendReturnTermsDividendPeriod";
	String DEFINITION = "if firstOrSecondPeriod exists then dividendPeriod -> startDate is absent and dividendPeriod -> endDate is absent";
	
	class Default implements DividendReturnTermsDividendPeriod {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, DividendReturnTerms dividendReturnTerms) {
			ComparisonResult result = executeDataRule(dividendReturnTerms);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "DividendReturnTerms", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "DividendReturnTerms", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(DividendReturnTerms dividendReturnTerms) {
			try {
				if (exists(MapperS.of(dividendReturnTerms).<DividendPeriodEnum>map("getFirstOrSecondPeriod", _dividendReturnTerms -> _dividendReturnTerms.getFirstOrSecondPeriod())).getOrDefault(false)) {
					return notExists(MapperS.of(dividendReturnTerms).<DividendPeriod>mapC("getDividendPeriod", _dividendReturnTerms -> _dividendReturnTerms.getDividendPeriod()).<DividendPaymentDate>map("getStartDate", dividendPeriod -> dividendPeriod.getStartDate())).andNullSafe(notExists(MapperS.of(dividendReturnTerms).<DividendPeriod>mapC("getDividendPeriod", _dividendReturnTerms -> _dividendReturnTerms.getDividendPeriod()).<DividendPaymentDate>map("getEndDate", dividendPeriod -> dividendPeriod.getEndDate())));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements DividendReturnTermsDividendPeriod {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, DividendReturnTerms dividendReturnTerms) {
			return Collections.emptyList();
		}
	}
}
