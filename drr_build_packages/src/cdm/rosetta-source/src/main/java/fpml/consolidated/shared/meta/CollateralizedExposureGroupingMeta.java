package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.CollateralizedExposureGrouping;
import fpml.consolidated.shared.validation.CollateralizedExposureGroupingTypeFormatValidator;
import fpml.consolidated.shared.validation.CollateralizedExposureGroupingValidator;
import fpml.consolidated.shared.validation.exists.CollateralizedExposureGroupingOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CollateralizedExposureGrouping.class)
public class CollateralizedExposureGroupingMeta implements RosettaMetaData<CollateralizedExposureGrouping> {

	@Override
	public List<Validator<? super CollateralizedExposureGrouping>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CollateralizedExposureGrouping, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CollateralizedExposureGrouping> validator(ValidatorFactory factory) {
		return factory.<CollateralizedExposureGrouping>create(CollateralizedExposureGroupingValidator.class);
	}

	@Override
	public Validator<? super CollateralizedExposureGrouping> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CollateralizedExposureGrouping>create(CollateralizedExposureGroupingTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CollateralizedExposureGrouping> validator() {
		return new CollateralizedExposureGroupingValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CollateralizedExposureGrouping> typeFormatValidator() {
		return new CollateralizedExposureGroupingTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CollateralizedExposureGrouping, Set<String>> onlyExistsValidator() {
		return new CollateralizedExposureGroupingOnlyExistsValidator();
	}
}
