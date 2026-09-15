package fpml.consolidated.com.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.CommodityAmericanExercise;
import fpml.consolidated.com.CommodityDigitalExercise;
import fpml.consolidated.com.CommodityEuropeanExercise;
import fpml.consolidated.com.CommodityRelativePaymentDates;
import fpml.consolidated.shared.AdjustableDatesOrRelativeDateOffset;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CommodityDigitalExerciseValidator implements Validator<CommodityDigitalExercise> {

	private List<ComparisonResult> getComparisonResults(CommodityDigitalExercise o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("americanExercise", (CommodityAmericanExercise) o.getAmericanExercise() != null ? 1 : 0, 0, 1), 
				checkCardinality("europeanExercise", (CommodityEuropeanExercise) o.getEuropeanExercise() != null ? 1 : 0, 0, 1), 
				checkCardinality("automaticExercise", (Boolean) o.getAutomaticExercise() != null ? 1 : 0, 0, 1), 
				checkCardinality("writtenConfirmation", (Boolean) o.getWrittenConfirmation() != null ? 1 : 0, 0, 1), 
				checkCardinality("relativePaymentDates", (CommodityRelativePaymentDates) o.getRelativePaymentDates() != null ? 1 : 0, 0, 1), 
				checkCardinality("paymentDates", (AdjustableDatesOrRelativeDateOffset) o.getPaymentDates() != null ? 1 : 0, 0, 1), 
				checkCardinality("masterAgreementPaymentDates", (Boolean) o.getMasterAgreementPaymentDates() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityDigitalExercise o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityDigitalExercise", ValidationResult.ValidationType.CARDINALITY, "CommodityDigitalExercise", path, "", res.getError());
				}
				return success("CommodityDigitalExercise", ValidationResult.ValidationType.CARDINALITY, "CommodityDigitalExercise", path, "");
			})
			.collect(toList());
	}

}
