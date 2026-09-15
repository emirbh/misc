package drr.regulation.common.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.common.CorporateSector;
import drr.regulation.common.HKMAPartyInformation;
import drr.regulation.common.NatureOfPartyEnum;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("HKMAPartyInformationCorporateSector")
@ImplementedBy(HKMAPartyInformationCorporateSector.Default.class)
public interface HKMAPartyInformationCorporateSector extends Validator<HKMAPartyInformation> {
	
	String NAME = "HKMAPartyInformationCorporateSector";
	String DEFINITION = "if natureOfParty = Financial or natureOfParty = NonFinancial then corporateSector exists else corporateSector is absent";
	
	class Default implements HKMAPartyInformationCorporateSector {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, HKMAPartyInformation hKMAPartyInformation) {
			ComparisonResult result = executeDataRule(hKMAPartyInformation);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "HKMAPartyInformation", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "HKMAPartyInformation", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(HKMAPartyInformation hKMAPartyInformation) {
			try {
				if (areEqual(MapperS.of(hKMAPartyInformation).<NatureOfPartyEnum>map("getNatureOfParty", _hKMAPartyInformation -> _hKMAPartyInformation.getNatureOfParty()), MapperS.of(NatureOfPartyEnum.FINANCIAL), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(hKMAPartyInformation).<NatureOfPartyEnum>map("getNatureOfParty", _hKMAPartyInformation -> _hKMAPartyInformation.getNatureOfParty()), MapperS.of(NatureOfPartyEnum.NON_FINANCIAL), CardinalityOperator.All)).getOrDefault(false)) {
					return exists(MapperS.of(hKMAPartyInformation).<CorporateSector>map("getCorporateSector", _hKMAPartyInformation -> _hKMAPartyInformation.getCorporateSector()));
				}
				return notExists(MapperS.of(hKMAPartyInformation).<CorporateSector>map("getCorporateSector", _hKMAPartyInformation -> _hKMAPartyInformation.getCorporateSector()));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements HKMAPartyInformationCorporateSector {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, HKMAPartyInformation hKMAPartyInformation) {
			return Collections.emptyList();
		}
	}
}
