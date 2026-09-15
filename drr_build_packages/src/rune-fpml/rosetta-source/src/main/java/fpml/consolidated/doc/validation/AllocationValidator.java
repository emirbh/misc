package fpml.consolidated.doc.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.doc.Allocation;
import fpml.consolidated.doc.Approvals;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.Collateral;
import fpml.consolidated.shared.Money;
import fpml.consolidated.shared.PartyReference;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class AllocationValidator implements Validator<Allocation> {

	private List<ComparisonResult> getComparisonResults(Allocation o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("partyReference", (PartyReference) o.getPartyReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("accountReference", (AccountReference) o.getAccountReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("allocatedFraction", (BigDecimal) o.getAllocatedFraction() != null ? 1 : 0, 0, 1), 
				checkCardinality("allocatedNotional", (List<? extends Money>) o.getAllocatedNotional() == null ? 0 : o.getAllocatedNotional().size(), 0, 2), 
				checkCardinality("collateral", (Collateral) o.getCollateral() != null ? 1 : 0, 0, 1), 
				checkCardinality("creditChargeAmount", (Money) o.getCreditChargeAmount() != null ? 1 : 0, 0, 1), 
				checkCardinality("approvals", (Approvals) o.getApprovals() != null ? 1 : 0, 0, 1), 
				checkCardinality("masterConfirmationDate", (ZonedDateTime) o.getMasterConfirmationDate() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Allocation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Allocation", ValidationResult.ValidationType.CARDINALITY, "Allocation", path, "", res.getError());
				}
				return success("Allocation", ValidationResult.ValidationType.CARDINALITY, "Allocation", path, "");
			})
			.collect(toList());
	}

}
