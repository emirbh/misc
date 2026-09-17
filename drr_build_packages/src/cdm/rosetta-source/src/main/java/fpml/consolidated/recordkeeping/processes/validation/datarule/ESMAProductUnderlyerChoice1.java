package fpml.consolidated.recordkeeping.processes.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.recordkeeping.processes.ESMAIndexIdentification;
import fpml.consolidated.recordkeeping.processes.ESMAProductUnderlyer;
import fpml.consolidated.shared.InstrumentId;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("ESMAProductUnderlyerChoice1")
@ImplementedBy(ESMAProductUnderlyerChoice1.Default.class)
public interface ESMAProductUnderlyerChoice1 extends Validator<ESMAProductUnderlyer> {
	
	String NAME = "ESMAProductUnderlyerChoice1";
	String DEFINITION = "if instrumentId is absent and index is absent then maturityDate exists";
	
	class Default implements ESMAProductUnderlyerChoice1 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ESMAProductUnderlyer eSMAProductUnderlyer) {
			ComparisonResult result = executeDataRule(eSMAProductUnderlyer);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ESMAProductUnderlyer", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "ESMAProductUnderlyer", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(ESMAProductUnderlyer eSMAProductUnderlyer) {
			try {
				if (notExists(MapperS.of(eSMAProductUnderlyer).<InstrumentId>mapC("getInstrumentId", _eSMAProductUnderlyer -> _eSMAProductUnderlyer.getInstrumentId())).andNullSafe(notExists(MapperS.of(eSMAProductUnderlyer).<ESMAIndexIdentification>map("getIndex", _eSMAProductUnderlyer -> _eSMAProductUnderlyer.getIndex()))).getOrDefault(false)) {
					return exists(MapperS.of(eSMAProductUnderlyer).<ZonedDateTime>map("getMaturityDate", _eSMAProductUnderlyer -> _eSMAProductUnderlyer.getMaturityDate()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ESMAProductUnderlyerChoice1 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ESMAProductUnderlyer eSMAProductUnderlyer) {
			return Collections.emptyList();
		}
	}
}
