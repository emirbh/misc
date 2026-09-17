package cdm.observable.asset.meta;

import cdm.observable.asset.InterestRateIndex;
import cdm.observable.asset.validation.InterestRateIndexTypeFormatValidator;
import cdm.observable.asset.validation.InterestRateIndexValidator;
import cdm.observable.asset.validation.datarule.InterestRateIndexChoice;
import cdm.observable.asset.validation.exists.InterestRateIndexOnlyExistsValidator;
import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 6.23.0
 */
@RosettaMeta(model=InterestRateIndex.class)
public class InterestRateIndexMeta implements RosettaMetaData<InterestRateIndex> {

	@Override
	public List<Validator<? super InterestRateIndex>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<InterestRateIndex>create(InterestRateIndexChoice.class)
		);
	}
	
	@Override
	public List<Function<? super InterestRateIndex, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super InterestRateIndex> validator(ValidatorFactory factory) {
		return factory.<InterestRateIndex>create(InterestRateIndexValidator.class);
	}

	@Override
	public Validator<? super InterestRateIndex> typeFormatValidator(ValidatorFactory factory) {
		return factory.<InterestRateIndex>create(InterestRateIndexTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super InterestRateIndex> validator() {
		return new InterestRateIndexValidator();
	}

	@Deprecated
	@Override
	public Validator<? super InterestRateIndex> typeFormatValidator() {
		return new InterestRateIndexTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super InterestRateIndex, Set<String>> onlyExistsValidator() {
		return new InterestRateIndexOnlyExistsValidator();
	}
}
