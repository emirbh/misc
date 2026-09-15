package drr.standards.iso.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.standards.iso.MicData;
import drr.standards.iso.MicMarketCategoryEnum;
import drr.standards.iso.MicTypeEnum;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class MicDataValidator implements Validator<MicData> {

	private List<ComparisonResult> getComparisonResults(MicData o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("mic", (String) o.getMic() != null ? 1 : 0, 0, 1), 
				checkCardinality("operatingMic", (String) o.getOperatingMic() != null ? 1 : 0, 0, 1), 
				checkCardinality("micType", (MicTypeEnum) o.getMicType() != null ? 1 : 0, 0, 1), 
				checkCardinality("nameInstitutionDescription", (String) o.getNameInstitutionDescription() != null ? 1 : 0, 0, 1), 
				checkCardinality("legalEntityName", (String) o.getLegalEntityName() != null ? 1 : 0, 0, 1), 
				checkCardinality("marketCategory", (MicMarketCategoryEnum) o.getMarketCategory() != null ? 1 : 0, 0, 1), 
				checkCardinality("marketCategoryEsma", (MicMarketCategoryEnum) o.getMarketCategoryEsma() != null ? 1 : 0, 0, 1), 
				checkCardinality("marketCategoryFca", (MicMarketCategoryEnum) o.getMarketCategoryFca() != null ? 1 : 0, 0, 1), 
				checkCardinality("acronym", (String) o.getAcronym() != null ? 1 : 0, 0, 1), 
				checkCardinality("countryCode", (String) o.getCountryCode() != null ? 1 : 0, 0, 1), 
				checkCardinality("city", (String) o.getCity() != null ? 1 : 0, 0, 1), 
				checkCardinality("website", (String) o.getWebsite() != null ? 1 : 0, 0, 1), 
				checkCardinality("status", (String) o.getStatus() != null ? 1 : 0, 0, 1), 
				checkCardinality("creationDate", (Date) o.getCreationDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("lastUpdateDate", (Date) o.getLastUpdateDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("lastValidationDate", (Date) o.getLastValidationDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("expiryDate", (Date) o.getExpiryDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("micValidation", (Boolean) o.getMicValidation() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, MicData o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("MicData", ValidationResult.ValidationType.CARDINALITY, "MicData", path, "", res.getError());
				}
				return success("MicData", ValidationResult.ValidationType.CARDINALITY, "MicData", path, "");
			})
			.collect(toList());
	}

}
