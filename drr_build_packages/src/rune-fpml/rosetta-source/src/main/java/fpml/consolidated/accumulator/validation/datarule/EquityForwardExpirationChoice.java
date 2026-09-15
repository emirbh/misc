package fpml.consolidated.accumulator.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.accumulator.EquityForwardExpiration;
import fpml.consolidated.fpmlenum.TimeTypeEnum;
import fpml.consolidated.shared.BusinessCenterTime;
import fpml.consolidated.shared.DeterminationMethod;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("EquityForwardExpirationChoice")
@ImplementedBy(EquityForwardExpirationChoice.Default.class)
public interface EquityForwardExpirationChoice extends Validator<EquityForwardExpiration> {
	
	String NAME = "EquityForwardExpirationChoice";
	String DEFINITION = "if equityExpirationTimeType exists then expirationTimeDetermination is absent else if expirationTimeDetermination exists then equityExpirationTimeType is absent and equityExpirationTime is absent else False";
	
	class Default implements EquityForwardExpirationChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, EquityForwardExpiration equityForwardExpiration) {
			ComparisonResult result = executeDataRule(equityForwardExpiration);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "EquityForwardExpiration", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "EquityForwardExpiration", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(EquityForwardExpiration equityForwardExpiration) {
			try {
				if (exists(MapperS.of(equityForwardExpiration).<TimeTypeEnum>map("getEquityExpirationTimeType", _equityForwardExpiration -> _equityForwardExpiration.getEquityExpirationTimeType())).getOrDefault(false)) {
					return notExists(MapperS.of(equityForwardExpiration).<DeterminationMethod>map("getExpirationTimeDetermination", _equityForwardExpiration -> _equityForwardExpiration.getExpirationTimeDetermination()));
				}
				if (exists(MapperS.of(equityForwardExpiration).<DeterminationMethod>map("getExpirationTimeDetermination", _equityForwardExpiration -> _equityForwardExpiration.getExpirationTimeDetermination())).getOrDefault(false)) {
					return notExists(MapperS.of(equityForwardExpiration).<TimeTypeEnum>map("getEquityExpirationTimeType", _equityForwardExpiration -> _equityForwardExpiration.getEquityExpirationTimeType())).andNullSafe(notExists(MapperS.of(equityForwardExpiration).<BusinessCenterTime>map("getEquityExpirationTime", _equityForwardExpiration -> _equityForwardExpiration.getEquityExpirationTime())));
				}
				return ComparisonResult.ofNullSafe(MapperS.of(false));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements EquityForwardExpirationChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, EquityForwardExpiration equityForwardExpiration) {
			return Collections.emptyList();
		}
	}
}
