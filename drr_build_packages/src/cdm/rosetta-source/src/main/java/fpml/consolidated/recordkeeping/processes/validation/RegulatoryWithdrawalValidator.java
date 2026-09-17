package fpml.consolidated.recordkeeping.processes.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.doc.PartyTradeIdentifier;
import fpml.consolidated.msg.NotificationMessageHeader;
import fpml.consolidated.recordkeeping.processes.InapplicableRegulation;
import fpml.consolidated.recordkeeping.processes.RegulatoryWithdrawal;
import fpml.consolidated.shared.AssetClass;
import fpml.consolidated.shared.OnBehalfOf;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class RegulatoryWithdrawalValidator implements Validator<RegulatoryWithdrawal> {

	private List<ComparisonResult> getComparisonResults(RegulatoryWithdrawal o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("fpmlVersion", (String) o.getFpmlVersion() != null ? 1 : 0, 1, 1), 
				checkCardinality("expectedBuild", (Integer) o.getExpectedBuild() != null ? 1 : 0, 0, 1), 
				checkCardinality("actualBuild", (Integer) o.getActualBuild() != null ? 1 : 0, 0, 1), 
				checkCardinality("header", (NotificationMessageHeader) o.getHeader() != null ? 1 : 0, 0, 1), 
				checkCardinality("onBehalfOf", (List<? extends OnBehalfOf>) o.getOnBehalfOf() == null ? 0 : o.getOnBehalfOf().size(), 0, 4), 
				checkCardinality("tradeIdentifier", (PartyTradeIdentifier) o.getTradeIdentifier() != null ? 1 : 0, 0, 1), 
				checkCardinality("primaryAssetClass", (AssetClass) o.getPrimaryAssetClass() != null ? 1 : 0, 0, 1), 
				checkCardinality("inapplicableRegulation", (List<? extends InapplicableRegulation>) o.getInapplicableRegulation() == null ? 0 : o.getInapplicableRegulation().size(), 1, 0), 
				checkCardinality("withdrawalReason", (String) o.getWithdrawalReason() != null ? 1 : 0, 0, 1), 
				checkCardinality("fullyWithdrawn", (Boolean) o.getFullyWithdrawn() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, RegulatoryWithdrawal o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("RegulatoryWithdrawal", ValidationResult.ValidationType.CARDINALITY, "RegulatoryWithdrawal", path, "", res.getError());
				}
				return success("RegulatoryWithdrawal", ValidationResult.ValidationType.CARDINALITY, "RegulatoryWithdrawal", path, "");
			})
			.collect(toList());
	}

}
