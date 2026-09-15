package fpml.consolidated.reg.fpmlreporting.product.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.reg.fpmlreporting.product.RegulatoryReportingProductParties;
import fpml.consolidated.shared.PartyReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class RegulatoryReportingProductPartiesValidator implements Validator<RegulatoryReportingProductParties> {

	private List<ComparisonResult> getComparisonResults(RegulatoryReportingProductParties o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("buyerPartyReference", (PartyReference) o.getBuyerPartyReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("sellerPartyReference", (PartyReference) o.getSellerPartyReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("fixedPayerPartyReference", (PartyReference) o.getFixedPayerPartyReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("fixedReceiverPartyReference", (PartyReference) o.getFixedReceiverPartyReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("floatingPayerPartyReference", (PartyReference) o.getFloatingPayerPartyReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("floatingReceiverPartyReference", (PartyReference) o.getFloatingReceiverPartyReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("floating2PayerPartyReference", (PartyReference) o.getFloating2PayerPartyReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("floating2ReceiverPartyReference", (PartyReference) o.getFloating2ReceiverPartyReference() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, RegulatoryReportingProductParties o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("RegulatoryReportingProductParties", ValidationResult.ValidationType.CARDINALITY, "RegulatoryReportingProductParties", path, "", res.getError());
				}
				return success("RegulatoryReportingProductParties", ValidationResult.ValidationType.CARDINALITY, "RegulatoryReportingProductParties", path, "");
			})
			.collect(toList());
	}

}
