package fpml.consolidated.mktenv.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.mktenv.FxRateSet;
import fpml.consolidated.mktenv.validation.FxRateSetTypeFormatValidator;
import fpml.consolidated.mktenv.validation.FxRateSetValidator;
import fpml.consolidated.mktenv.validation.exists.FxRateSetOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FxRateSet.class)
public class FxRateSetMeta implements RosettaMetaData<FxRateSet> {

	@Override
	public List<Validator<? super FxRateSet>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxRateSet, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FxRateSet> validator(ValidatorFactory factory) {
		return factory.<FxRateSet>create(FxRateSetValidator.class);
	}

	@Override
	public Validator<? super FxRateSet> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FxRateSet>create(FxRateSetTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FxRateSet> validator() {
		return new FxRateSetValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FxRateSet> typeFormatValidator() {
		return new FxRateSetTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxRateSet, Set<String>> onlyExistsValidator() {
		return new FxRateSetOnlyExistsValidator();
	}
}
