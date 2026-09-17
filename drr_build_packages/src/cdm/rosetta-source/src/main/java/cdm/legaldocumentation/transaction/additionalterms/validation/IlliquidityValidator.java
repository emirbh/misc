package cdm.legaldocumentation.transaction.additionalterms.validation;

import cdm.base.datetime.AdjustedRelativeDateOffset;
import cdm.base.math.Quantity;
import cdm.legaldocumentation.transaction.additionalterms.EscrowArrangement;
import cdm.legaldocumentation.transaction.additionalterms.Illiquidity;
import cdm.observable.asset.SettlementRateOption;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class IlliquidityValidator implements Validator<Illiquidity> {

	private List<ComparisonResult> getComparisonResults(Illiquidity o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("illiquidityIsApplicable", (Boolean) o.getIlliquidityIsApplicable() != null ? 1 : 0, 1, 1), 
				checkCardinality("escrowArrangement", (EscrowArrangement) o.getEscrowArrangement() != null ? 1 : 0, 0, 1), 
				checkCardinality("minimumAmount", (Quantity) o.getMinimumAmount() != null ? 1 : 0, 0, 1), 
				checkCardinality("fallbackReferencePrice", (SettlementRateOption) o.getFallbackReferencePrice() != null ? 1 : 0, 0, 1), 
				checkCardinality("illiquidityValuationDate", (AdjustedRelativeDateOffset) o.getIlliquidityValuationDate() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Illiquidity o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Illiquidity", ValidationResult.ValidationType.CARDINALITY, "Illiquidity", path, "", res.getError());
				}
				return success("Illiquidity", ValidationResult.ValidationType.CARDINALITY, "Illiquidity", path, "");
			})
			.collect(toList());
	}

}
