package fpml.consolidated.fx.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fx.FxSwapLeg;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("FxSwapLegChoice1")
@ImplementedBy(FxSwapLegChoice1.Default.class)
public interface FxSwapLegChoice1 extends Validator<FxSwapLeg> {
	
	String NAME = "FxSwapLegChoice1";
	String DEFINITION = "if valueDate exists then currency1ValueDate is absent and currency2ValueDate is absent else currency1ValueDate exists and currency2ValueDate exists";
	
	class Default implements FxSwapLegChoice1 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxSwapLeg fxSwapLeg) {
			ComparisonResult result = executeDataRule(fxSwapLeg);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FxSwapLeg", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "FxSwapLeg", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(FxSwapLeg fxSwapLeg) {
			try {
				if (exists(MapperS.of(fxSwapLeg).<ZonedDateTime>map("getValueDate", _fxSwapLeg -> _fxSwapLeg.getValueDate())).getOrDefault(false)) {
					return notExists(MapperS.of(fxSwapLeg).<ZonedDateTime>map("getCurrency1ValueDate", _fxSwapLeg -> _fxSwapLeg.getCurrency1ValueDate())).andNullSafe(notExists(MapperS.of(fxSwapLeg).<ZonedDateTime>map("getCurrency2ValueDate", _fxSwapLeg -> _fxSwapLeg.getCurrency2ValueDate())));
				}
				return exists(MapperS.of(fxSwapLeg).<ZonedDateTime>map("getCurrency1ValueDate", _fxSwapLeg -> _fxSwapLeg.getCurrency1ValueDate())).andNullSafe(exists(MapperS.of(fxSwapLeg).<ZonedDateTime>map("getCurrency2ValueDate", _fxSwapLeg -> _fxSwapLeg.getCurrency2ValueDate())));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FxSwapLegChoice1 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxSwapLeg fxSwapLeg) {
			return Collections.emptyList();
		}
	}
}
