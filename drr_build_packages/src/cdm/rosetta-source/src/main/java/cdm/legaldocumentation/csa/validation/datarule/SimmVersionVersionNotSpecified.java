package cdm.legaldocumentation.csa.validation.datarule;

import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.legaldocumentation.csa.SimmVersion;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
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
@RosettaDataRule("SimmVersionVersionNotSpecified")
@ImplementedBy(SimmVersionVersionNotSpecified.Default.class)
public interface SimmVersionVersionNotSpecified extends Validator<SimmVersion> {
	
	String NAME = "SimmVersionVersionNotSpecified";
	String DEFINITION = "if isSpecified = False then partyVersion is absent";
	
	class Default implements SimmVersionVersionNotSpecified {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, SimmVersion simmVersion) {
			ComparisonResult result = executeDataRule(simmVersion);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "SimmVersion", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "SimmVersion", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(SimmVersion simmVersion) {
			try {
				if (areEqual(MapperS.of(simmVersion).<Boolean>map("getIsSpecified", _simmVersion -> _simmVersion.getIsSpecified()), MapperS.of(false), CardinalityOperator.All).getOrDefault(false)) {
					return notExists(MapperS.of(simmVersion).<CounterpartyRoleEnum>map("getPartyVersion", _simmVersion -> _simmVersion.getPartyVersion()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements SimmVersionVersionNotSpecified {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, SimmVersion simmVersion) {
			return Collections.emptyList();
		}
	}
}
