package cdm.event.position.validation.datarule;

import cdm.base.staticdata.party.PartyRole;
import cdm.base.staticdata.party.PartyRoleEnum;
import cdm.event.position.AvailableInventoryRecord;
import cdm.event.position.functions.IsValidPartyRole;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;


/**
 * @version 6.23.0
 */
@RosettaDataRule("AvailableInventoryRecordValidPartyRole")
@ImplementedBy(AvailableInventoryRecordValidPartyRole.Default.class)
public interface AvailableInventoryRecordValidPartyRole extends Validator<AvailableInventoryRecord> {
	
	String NAME = "AvailableInventoryRecordValidPartyRole";
	String DEFINITION = "IsValidPartyRole( partyRole, [PartyRoleEnum -> AgentLender, PartyRoleEnum -> BeneficialOwner, PartyRoleEnum -> Custodian, PartyRoleEnum -> Lender] )";
	
	class Default implements AvailableInventoryRecordValidPartyRole {
	
		@Inject protected IsValidPartyRole isValidPartyRole;
		
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, AvailableInventoryRecord availableInventoryRecord) {
			ComparisonResult result = executeDataRule(availableInventoryRecord);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "AvailableInventoryRecord", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "AvailableInventoryRecord", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(AvailableInventoryRecord availableInventoryRecord) {
			try {
				return ComparisonResult.ofNullSafe(MapperS.of(isValidPartyRole.evaluate(MapperS.of(availableInventoryRecord).<PartyRole>mapC("getPartyRole", _availableInventoryRecord -> _availableInventoryRecord.getPartyRole()).getMulti(), MapperC.<PartyRoleEnum>of(MapperS.of(PartyRoleEnum.AGENT_LENDER), MapperS.of(PartyRoleEnum.BENEFICIAL_OWNER), MapperS.of(PartyRoleEnum.CUSTODIAN), MapperS.of(PartyRoleEnum.LENDER)).getMulti())));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements AvailableInventoryRecordValidPartyRole {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, AvailableInventoryRecord availableInventoryRecord) {
			return Collections.emptyList();
		}
	}
}
