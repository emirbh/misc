package fpml.consolidated.eq.shared.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.eq.shared.DividendPaymentDate;
import fpml.consolidated.fpmlenum.DividendDateReferenceEnum;
import fpml.consolidated.shared.AdjustableDate;
import fpml.consolidated.shared.Offset;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("DividendPaymentDateChoice")
@ImplementedBy(DividendPaymentDateChoice.Default.class)
public interface DividendPaymentDateChoice extends Validator<DividendPaymentDate> {
	
	String NAME = "DividendPaymentDateChoice";
	String DEFINITION = "adjustableDate is absent or dividendDateReference is absent and paymentDateOffset is absent";
	
	class Default implements DividendPaymentDateChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, DividendPaymentDate dividendPaymentDate) {
			ComparisonResult result = executeDataRule(dividendPaymentDate);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "DividendPaymentDate", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "DividendPaymentDate", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(DividendPaymentDate dividendPaymentDate) {
			try {
				return notExists(MapperS.of(dividendPaymentDate).<AdjustableDate>map("getAdjustableDate", _dividendPaymentDate -> _dividendPaymentDate.getAdjustableDate())).orNullSafe(notExists(MapperS.of(dividendPaymentDate).<DividendDateReferenceEnum>map("getDividendDateReference", _dividendPaymentDate -> _dividendPaymentDate.getDividendDateReference())).andNullSafe(notExists(MapperS.of(dividendPaymentDate).<Offset>map("getPaymentDateOffset", _dividendPaymentDate -> _dividendPaymentDate.getPaymentDateOffset()))));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements DividendPaymentDateChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, DividendPaymentDate dividendPaymentDate) {
			return Collections.emptyList();
		}
	}
}
