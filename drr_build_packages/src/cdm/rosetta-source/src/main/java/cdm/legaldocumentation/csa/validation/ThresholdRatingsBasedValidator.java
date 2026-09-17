package cdm.legaldocumentation.csa.validation;

import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.legaldocumentation.csa.NotRatedByEnum;
import cdm.legaldocumentation.csa.NumberOfRatingAgenciesEnum;
import cdm.legaldocumentation.csa.RatingTypeEnum;
import cdm.legaldocumentation.csa.ThresholdRatedPartyEnum;
import cdm.legaldocumentation.csa.ThresholdRatingsBased;
import cdm.observable.asset.CreditNotationMismatchResolutionEnum;
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

public class ThresholdRatingsBasedValidator implements Validator<ThresholdRatingsBased> {

	private List<ComparisonResult> getComparisonResults(ThresholdRatingsBased o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("party", (CounterpartyRoleEnum) o.getParty() != null ? 1 : 0, 1, 1), 
				checkCardinality("currency", (ISOCurrencyCodeEnum) o.getCurrency() != null ? 1 : 0, 1, 1), 
				checkCardinality("ratingType", (RatingTypeEnum) o.getRatingType() != null ? 1 : 0, 1, 1), 
				checkCardinality("ratedParty", (ThresholdRatedPartyEnum) o.getRatedParty() != null ? 1 : 0, 0, 1), 
				checkCardinality("namedEntity", (String) o.getNamedEntity() != null ? 1 : 0, 0, 1), 
				checkCardinality("namedAffiliate", (String) o.getNamedAffiliate() != null ? 1 : 0, 0, 1), 
				checkCardinality("compare", (CreditNotationMismatchResolutionEnum) o.getCompare() != null ? 1 : 0, 0, 1), 
				checkCardinality("noRating", (Boolean) o.getNoRating() != null ? 1 : 0, 1, 1), 
				checkCardinality("notRatedBy", (NotRatedByEnum) o.getNotRatedBy() != null ? 1 : 0, 0, 1), 
				checkCardinality("numberOfRatingAgencies", (NumberOfRatingAgenciesEnum) o.getNumberOfRatingAgencies() != null ? 1 : 0, 0, 1), 
				checkCardinality("zeroEvent", (Boolean) o.getZeroEvent() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ThresholdRatingsBased o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ThresholdRatingsBased", ValidationResult.ValidationType.CARDINALITY, "ThresholdRatingsBased", path, "", res.getError());
				}
				return success("ThresholdRatingsBased", ValidationResult.ValidationType.CARDINALITY, "ThresholdRatingsBased", path, "");
			})
			.collect(toList());
	}

}
