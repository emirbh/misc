package fpml.consolidated.cd.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.cd.BasketReferenceInformation;
import fpml.consolidated.cd.GeneralTerms;
import fpml.consolidated.cd.IndexReferenceInformation;
import fpml.consolidated.cd.ReferenceInformation;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.AdjustableDate2;
import fpml.consolidated.shared.BusinessDayAdjustments;
import fpml.consolidated.shared.PartyReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class GeneralTermsValidator implements Validator<GeneralTerms> {

	private List<ComparisonResult> getComparisonResults(GeneralTerms o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("effectiveDate", (AdjustableDate2) o.getEffectiveDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("scheduledTerminationDate", (AdjustableDate2) o.getScheduledTerminationDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("buyerPartyReference", (PartyReference) o.getBuyerPartyReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("buyerAccountReference", (AccountReference) o.getBuyerAccountReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("sellerPartyReference", (PartyReference) o.getSellerPartyReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("sellerAccountReference", (AccountReference) o.getSellerAccountReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("dateAdjustments", (BusinessDayAdjustments) o.getDateAdjustments() != null ? 1 : 0, 0, 1), 
				checkCardinality("referenceInformation", (ReferenceInformation) o.getReferenceInformation() != null ? 1 : 0, 0, 1), 
				checkCardinality("indexReferenceInformation", (IndexReferenceInformation) o.getIndexReferenceInformation() != null ? 1 : 0, 0, 1), 
				checkCardinality("basketReferenceInformation", (BasketReferenceInformation) o.getBasketReferenceInformation() != null ? 1 : 0, 0, 1), 
				checkCardinality("substitution", (Boolean) o.getSubstitution() != null ? 1 : 0, 0, 1), 
				checkCardinality("modifiedEquityDelivery", (Boolean) o.getModifiedEquityDelivery() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, GeneralTerms o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("GeneralTerms", ValidationResult.ValidationType.CARDINALITY, "GeneralTerms", path, "", res.getError());
				}
				return success("GeneralTerms", ValidationResult.ValidationType.CARDINALITY, "GeneralTerms", path, "");
			})
			.collect(toList());
	}

}
