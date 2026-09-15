package drr.regulation.csa.rewrite.dtcc.valuation.validation.exists;

import cdm.base.staticdata.asset.common.AssetClassEnum;
import cdm.base.staticdata.party.PartyIdentifierTypeEnum;
import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.regulation.common.SupervisoryBodyEnum;
import drr.regulation.csa.rewrite.dtcc.valuation.DTCCAdditionalValuationFields;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class DTCCAdditionalValuationFieldsOnlyExistsValidator implements ValidatorWithArg<DTCCAdditionalValuationFields, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends DTCCAdditionalValuationFields> ValidationResult<DTCCAdditionalValuationFields> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("tradeParty1IDType", ExistenceChecker.isSet((PartyIdentifierTypeEnum) o.getTradeParty1IDType()))
				.put("submittingPartyIDType", ExistenceChecker.isSet((PartyIdentifierTypeEnum) o.getSubmittingPartyIDType()))
				.put("usiIDPrefix", ExistenceChecker.isSet((String) o.getUsiIDPrefix()))
				.put("utiIDPrefix", ExistenceChecker.isSet((String) o.getUtiIDPrefix()))
				.put("submittedForParty", ExistenceChecker.isSet((String) o.getSubmittedForParty()))
				.put("tradeParty1ReportingDestination", ExistenceChecker.isSet((List<SupervisoryBodyEnum>) o.getTradeParty1ReportingDestination()))
				.put("tradeParty2ReportingDestination", ExistenceChecker.isSet((List<SupervisoryBodyEnum>) o.getTradeParty2ReportingDestination()))
				.put("primaryAssetClass", ExistenceChecker.isSet((AssetClassEnum) o.getPrimaryAssetClass()))
				.put("comment1", ExistenceChecker.isSet((String) o.getComment1()))
				.put("messageID", ExistenceChecker.isSet((String) o.getMessageID()))
				.put("messageType", ExistenceChecker.isSet((String) o.getMessageType()))
				.put("tradeParty2ExecutionAgentID", ExistenceChecker.isSet((String) o.getTradeParty2ExecutionAgentID()))
				.put("tradeParty2ExecutionAgentIDType", ExistenceChecker.isSet((PartyIdentifierTypeEnum) o.getTradeParty2ExecutionAgentIDType()))
				.put("tradeParty1ExecutionAgentID", ExistenceChecker.isSet((String) o.getTradeParty1ExecutionAgentID()))
				.put("tradeParty1ExecutionAgentIDType", ExistenceChecker.isSet((PartyIdentifierTypeEnum) o.getTradeParty1ExecutionAgentIDType()))
				.put("tradeParty1TransactionID", ExistenceChecker.isSet((String) o.getTradeParty1TransactionID()))
				.put("version", ExistenceChecker.isSet((String) o.getVersion()))
				.put("usiID", ExistenceChecker.isSet((String) o.getUsiID()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("DTCCAdditionalValuationFields", ValidationResult.ValidationType.ONLY_EXISTS, "DTCCAdditionalValuationFields", path, "");
		}
		return failure("DTCCAdditionalValuationFields", ValidationResult.ValidationType.ONLY_EXISTS, "DTCCAdditionalValuationFields", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
