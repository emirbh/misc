package drr.enrichment.lei.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.enrichment.lei.LeiCategoryEnum;
import drr.enrichment.lei.LeiData;
import drr.enrichment.lei.LeiGeneralCategoryEnum;
import drr.enrichment.lei.LeiRegistrationStatusEnum;
import drr.enrichment.lei.LeiStatusEnum;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class LeiDataValidator implements Validator<LeiData> {

	private List<ComparisonResult> getComparisonResults(LeiData o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("lei", (String) o.getLei() != null ? 1 : 0, 0, 1), 
				checkCardinality("entityName", (String) o.getEntityName() != null ? 1 : 0, 0, 1), 
				checkCardinality("entityCategory", (LeiCategoryEnum) o.getEntityCategory() != null ? 1 : 0, 0, 1), 
				checkCardinality("entityStatus", (LeiStatusEnum) o.getEntityStatus() != null ? 1 : 0, 0, 1), 
				checkCardinality("branchEntityStatus", (LeiStatusEnum) o.getBranchEntityStatus() != null ? 1 : 0, 0, 1), 
				checkCardinality("generalCategory", (LeiGeneralCategoryEnum) o.getGeneralCategory() != null ? 1 : 0, 0, 1), 
				checkCardinality("registrationStatus", (LeiRegistrationStatusEnum) o.getRegistrationStatus() != null ? 1 : 0, 0, 1), 
				checkCardinality("registrationDate", (ZonedDateTime) o.getRegistrationDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("published", (Boolean) o.getPublished() != null ? 1 : 0, 0, 1), 
				checkCardinality("leiValidation", (Boolean) o.getLeiValidation() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LeiData o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LeiData", ValidationResult.ValidationType.CARDINALITY, "LeiData", path, "", res.getError());
				}
				return success("LeiData", ValidationResult.ValidationType.CARDINALITY, "LeiData", path, "");
			})
			.collect(toList());
	}

}
