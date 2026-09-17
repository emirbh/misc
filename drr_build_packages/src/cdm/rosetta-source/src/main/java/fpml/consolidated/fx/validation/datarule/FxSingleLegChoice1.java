package fpml.consolidated.fx.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fx.FxSingleLeg;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("FxSingleLegChoice1")
@ImplementedBy(FxSingleLegChoice1.Default.class)
public interface FxSingleLegChoice1 extends Validator<FxSingleLeg> {
	
	String NAME = "FxSingleLegChoice1";
	String DEFINITION = "if valueDate exists then currency1ValueDate is absent and currency2ValueDate is absent else currency1ValueDate exists and currency2ValueDate exists";
	
	class Default implements FxSingleLegChoice1 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxSingleLeg fxSingleLeg) {
			ComparisonResult result = executeDataRule(fxSingleLeg);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FxSingleLeg", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "FxSingleLeg", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(FxSingleLeg fxSingleLeg) {
			try {
				if (exists(MapperS.of(fxSingleLeg).<ZonedDateTime>map("getValueDate", _fxSingleLeg -> _fxSingleLeg.getValueDate())).getOrDefault(false)) {
					return notExists(MapperS.of(fxSingleLeg).<ZonedDateTime>map("getCurrency1ValueDate", _fxSingleLeg -> _fxSingleLeg.getCurrency1ValueDate())).andNullSafe(notExists(MapperS.of(fxSingleLeg).<ZonedDateTime>map("getCurrency2ValueDate", _fxSingleLeg -> _fxSingleLeg.getCurrency2ValueDate())));
				}
				return exists(MapperS.of(fxSingleLeg).<ZonedDateTime>map("getCurrency1ValueDate", _fxSingleLeg -> _fxSingleLeg.getCurrency1ValueDate())).andNullSafe(exists(MapperS.of(fxSingleLeg).<ZonedDateTime>map("getCurrency2ValueDate", _fxSingleLeg -> _fxSingleLeg.getCurrency2ValueDate())));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FxSingleLegChoice1 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxSingleLeg fxSingleLeg) {
			return Collections.emptyList();
		}
	}
}
