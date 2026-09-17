package fpml.consolidated.mktenv.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.mktenv.MultiDimensionalPricingData;
import fpml.consolidated.mktenv.validation.MultiDimensionalPricingDataTypeFormatValidator;
import fpml.consolidated.mktenv.validation.MultiDimensionalPricingDataValidator;
import fpml.consolidated.mktenv.validation.datarule.MultiDimensionalPricingDataChoice;
import fpml.consolidated.mktenv.validation.exists.MultiDimensionalPricingDataOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=MultiDimensionalPricingData.class)
public class MultiDimensionalPricingDataMeta implements RosettaMetaData<MultiDimensionalPricingData> {

	@Override
	public List<Validator<? super MultiDimensionalPricingData>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<MultiDimensionalPricingData>create(MultiDimensionalPricingDataChoice.class)
		);
	}
	
	@Override
	public List<Function<? super MultiDimensionalPricingData, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super MultiDimensionalPricingData> validator(ValidatorFactory factory) {
		return factory.<MultiDimensionalPricingData>create(MultiDimensionalPricingDataValidator.class);
	}

	@Override
	public Validator<? super MultiDimensionalPricingData> typeFormatValidator(ValidatorFactory factory) {
		return factory.<MultiDimensionalPricingData>create(MultiDimensionalPricingDataTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super MultiDimensionalPricingData> validator() {
		return new MultiDimensionalPricingDataValidator();
	}

	@Deprecated
	@Override
	public Validator<? super MultiDimensionalPricingData> typeFormatValidator() {
		return new MultiDimensionalPricingDataTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super MultiDimensionalPricingData, Set<String>> onlyExistsValidator() {
		return new MultiDimensionalPricingDataOnlyExistsValidator();
	}
}
