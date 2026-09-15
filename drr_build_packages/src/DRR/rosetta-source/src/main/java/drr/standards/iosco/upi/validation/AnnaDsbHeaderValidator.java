package drr.standards.iosco.upi.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.standards.iosco.upi.AnnaDsbAssetClassEnum;
import drr.standards.iosco.upi.AnnaDsbHeader;
import drr.standards.iosco.upi.AnnaDsbInstrumentTypeEnum;
import drr.standards.iosco.upi.AnnaDsbLevelEnum;
import drr.standards.iosco.upi.AnnaDsbUseCaseEnum;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class AnnaDsbHeaderValidator implements Validator<AnnaDsbHeader> {

	private List<ComparisonResult> getComparisonResults(AnnaDsbHeader o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("InstrumentType", (AnnaDsbInstrumentTypeEnum) o.getInstrumentType() != null ? 1 : 0, 1, 1), 
				checkCardinality("UseCase", (AnnaDsbUseCaseEnum) o.getUseCase() != null ? 1 : 0, 1, 1), 
				checkCardinality("Level", (AnnaDsbLevelEnum) o.getLevel() != null ? 1 : 0, 1, 1), 
				checkCardinality("AssetClass", (AnnaDsbAssetClassEnum) o.getAssetClass() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AnnaDsbHeader o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AnnaDsbHeader", ValidationResult.ValidationType.CARDINALITY, "AnnaDsbHeader", path, "", res.getError());
				}
				return success("AnnaDsbHeader", ValidationResult.ValidationType.CARDINALITY, "AnnaDsbHeader", path, "");
			})
			.collect(toList());
	}

}
