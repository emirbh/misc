package fpml.consolidated.loan.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.FacilityCommitment;
import fpml.consolidated.loan.MoneyWithParticipantShare;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("FacilityCommitmentChoice")
@ImplementedBy(FacilityCommitmentChoice.Default.class)
public interface FacilityCommitmentChoice extends Validator<FacilityCommitment> {
	
	String NAME = "FacilityCommitmentChoice";
	String DEFINITION = "if requiredFundedAmount exists then requiredUnfundedAmount is absent and fundedAmount is absent else if requiredUnfundedAmount exists then requiredFundedAmount is absent and unfundedAmount is absent else requiredFundedAmount is absent and requiredUnfundedAmount is absent and unfundedAmount is absent and fundedAmount is absent";
	
	class Default implements FacilityCommitmentChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FacilityCommitment facilityCommitment) {
			ComparisonResult result = executeDataRule(facilityCommitment);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FacilityCommitment", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "FacilityCommitment", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(FacilityCommitment facilityCommitment) {
			try {
				if (exists(MapperS.of(facilityCommitment).<MoneyWithParticipantShare>map("getRequiredFundedAmount", _facilityCommitment -> _facilityCommitment.getRequiredFundedAmount())).getOrDefault(false)) {
					return notExists(MapperS.of(facilityCommitment).<MoneyWithParticipantShare>map("getRequiredUnfundedAmount", _facilityCommitment -> _facilityCommitment.getRequiredUnfundedAmount())).andNullSafe(notExists(MapperS.of(facilityCommitment).<MoneyWithParticipantShare>map("getFundedAmount", _facilityCommitment -> _facilityCommitment.getFundedAmount())));
				}
				if (exists(MapperS.of(facilityCommitment).<MoneyWithParticipantShare>map("getRequiredUnfundedAmount", _facilityCommitment -> _facilityCommitment.getRequiredUnfundedAmount())).getOrDefault(false)) {
					return notExists(MapperS.of(facilityCommitment).<MoneyWithParticipantShare>map("getRequiredFundedAmount", _facilityCommitment -> _facilityCommitment.getRequiredFundedAmount())).andNullSafe(notExists(MapperS.of(facilityCommitment).<MoneyWithParticipantShare>map("getUnfundedAmount", _facilityCommitment -> _facilityCommitment.getUnfundedAmount())));
				}
				return notExists(MapperS.of(facilityCommitment).<MoneyWithParticipantShare>map("getRequiredFundedAmount", _facilityCommitment -> _facilityCommitment.getRequiredFundedAmount())).andNullSafe(notExists(MapperS.of(facilityCommitment).<MoneyWithParticipantShare>map("getRequiredUnfundedAmount", _facilityCommitment -> _facilityCommitment.getRequiredUnfundedAmount()))).andNullSafe(notExists(MapperS.of(facilityCommitment).<MoneyWithParticipantShare>map("getUnfundedAmount", _facilityCommitment -> _facilityCommitment.getUnfundedAmount()))).andNullSafe(notExists(MapperS.of(facilityCommitment).<MoneyWithParticipantShare>map("getFundedAmount", _facilityCommitment -> _facilityCommitment.getFundedAmount())));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FacilityCommitmentChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FacilityCommitment facilityCommitment) {
			return Collections.emptyList();
		}
	}
}
