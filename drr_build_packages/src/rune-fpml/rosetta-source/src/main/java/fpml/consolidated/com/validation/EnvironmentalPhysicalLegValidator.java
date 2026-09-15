package fpml.consolidated.com.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.EEPParameters;
import fpml.consolidated.com.EnvironmentalPhysicalLeg;
import fpml.consolidated.com.EnvironmentalProduct;
import fpml.consolidated.com.UnitQuantity;
import fpml.consolidated.fpmlenum.EnvironmentalAbandonmentOfSchemeEnum;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import fpml.consolidated.shared.BusinessCenters;
import fpml.consolidated.shared.BusinessCentersReference;
import fpml.consolidated.shared.DateOffset;
import fpml.consolidated.shared.PartyReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class EnvironmentalPhysicalLegValidator implements Validator<EnvironmentalPhysicalLeg> {

	private List<ComparisonResult> getComparisonResults(EnvironmentalPhysicalLeg o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("payerPartyReference", (PartyReference) o.getPayerPartyReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("payerAccountReference", (AccountReference) o.getPayerAccountReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("receiverPartyReference", (PartyReference) o.getReceiverPartyReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("receiverAccountReference", (AccountReference) o.getReceiverAccountReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("numberOfAllowances", (UnitQuantity) o.getNumberOfAllowances() != null ? 1 : 0, 1, 1), 
				checkCardinality("environmental", (EnvironmentalProduct) o.getEnvironmental() != null ? 1 : 0, 1, 1), 
				checkCardinality("abandonmentOfScheme", (EnvironmentalAbandonmentOfSchemeEnum) o.getAbandonmentOfScheme() != null ? 1 : 0, 0, 1), 
				checkCardinality("deliveryDate", (AdjustableOrRelativeDate) o.getDeliveryDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("paymentDate", (DateOffset) o.getPaymentDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("businessCentersReference", (BusinessCentersReference) o.getBusinessCentersReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("businessCenters", (BusinessCenters) o.getBusinessCenters() != null ? 1 : 0, 0, 1), 
				checkCardinality("failureToDeliverApplicable", (Boolean) o.getFailureToDeliverApplicable() != null ? 1 : 0, 0, 1), 
				checkCardinality("eEPParameters", (EEPParameters) o.getEEPParameters() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, EnvironmentalPhysicalLeg o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("EnvironmentalPhysicalLeg", ValidationResult.ValidationType.CARDINALITY, "EnvironmentalPhysicalLeg", path, "", res.getError());
				}
				return success("EnvironmentalPhysicalLeg", ValidationResult.ValidationType.CARDINALITY, "EnvironmentalPhysicalLeg", path, "");
			})
			.collect(toList());
	}

}
