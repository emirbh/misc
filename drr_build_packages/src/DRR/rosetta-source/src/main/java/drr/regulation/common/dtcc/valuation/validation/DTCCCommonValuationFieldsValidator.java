package drr.regulation.common.dtcc.valuation.validation;

import cdm.base.staticdata.asset.common.AssetClassEnum;
import cdm.base.staticdata.party.PartyIdentifierTypeEnum;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.common.dtcc.valuation.DTCCCommonValuationFields;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class DTCCCommonValuationFieldsValidator implements Validator<DTCCCommonValuationFields> {

	private List<ComparisonResult> getComparisonResults(DTCCCommonValuationFields o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("tradeParty1IDType", (PartyIdentifierTypeEnum) o.getTradeParty1IDType() != null ? 1 : 0, 0, 1), 
				checkCardinality("submittingPartyIDType", (PartyIdentifierTypeEnum) o.getSubmittingPartyIDType() != null ? 1 : 0, 0, 1), 
				checkCardinality("usiIDPrefix", (String) o.getUsiIDPrefix() != null ? 1 : 0, 0, 1), 
				checkCardinality("utiIDPrefix", (String) o.getUtiIDPrefix() != null ? 1 : 0, 0, 1), 
				checkCardinality("submittedForParty", (String) o.getSubmittedForParty() != null ? 1 : 0, 0, 1), 
				checkCardinality("primaryAssetClass", (AssetClassEnum) o.getPrimaryAssetClass() != null ? 1 : 0, 1, 1), 
				checkCardinality("comment1", (String) o.getComment1() != null ? 1 : 0, 0, 1), 
				checkCardinality("messageID", (String) o.getMessageID() != null ? 1 : 0, 0, 1), 
				checkCardinality("messageType", (String) o.getMessageType() != null ? 1 : 0, 0, 1), 
				checkCardinality("tradeParty2ExecutionAgentID", (String) o.getTradeParty2ExecutionAgentID() != null ? 1 : 0, 0, 1), 
				checkCardinality("tradeParty2ExecutionAgentIDType", (PartyIdentifierTypeEnum) o.getTradeParty2ExecutionAgentIDType() != null ? 1 : 0, 0, 1), 
				checkCardinality("tradeParty1ExecutionAgentID", (String) o.getTradeParty1ExecutionAgentID() != null ? 1 : 0, 0, 1), 
				checkCardinality("tradeParty1ExecutionAgentIDType", (PartyIdentifierTypeEnum) o.getTradeParty1ExecutionAgentIDType() != null ? 1 : 0, 0, 1), 
				checkCardinality("tradeParty1TransactionID", (String) o.getTradeParty1TransactionID() != null ? 1 : 0, 0, 1), 
				checkCardinality("version", (String) o.getVersion() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, DTCCCommonValuationFields o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("DTCCCommonValuationFields", ValidationResult.ValidationType.CARDINALITY, "DTCCCommonValuationFields", path, "", res.getError());
				}
				return success("DTCCCommonValuationFields", ValidationResult.ValidationType.CARDINALITY, "DTCCCommonValuationFields", path, "");
			})
			.collect(toList());
	}

}
