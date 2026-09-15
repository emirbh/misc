package fpml.consolidated.com.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.CommodityPhysicalAmericanExercise;
import fpml.consolidated.com.CommodityPhysicalEuropeanExercise;
import fpml.consolidated.com.CommodityPhysicalExercise;
import fpml.consolidated.shared.SwaptionPhysicalSettlement;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CommodityPhysicalExerciseValidator implements Validator<CommodityPhysicalExercise> {

	private List<ComparisonResult> getComparisonResults(CommodityPhysicalExercise o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("americanExercise", (CommodityPhysicalAmericanExercise) o.getAmericanExercise() != null ? 1 : 0, 0, 1), 
				checkCardinality("europeanExercise", (CommodityPhysicalEuropeanExercise) o.getEuropeanExercise() != null ? 1 : 0, 0, 1), 
				checkCardinality("automaticExercise", (Boolean) o.getAutomaticExercise() != null ? 1 : 0, 0, 1), 
				checkCardinality("writtenConfirmation", (Boolean) o.getWrittenConfirmation() != null ? 1 : 0, 0, 1), 
				checkCardinality("clearingInstructions", (SwaptionPhysicalSettlement) o.getClearingInstructions() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityPhysicalExercise o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityPhysicalExercise", ValidationResult.ValidationType.CARDINALITY, "CommodityPhysicalExercise", path, "", res.getError());
				}
				return success("CommodityPhysicalExercise", ValidationResult.ValidationType.CARDINALITY, "CommodityPhysicalExercise", path, "");
			})
			.collect(toList());
	}

}
