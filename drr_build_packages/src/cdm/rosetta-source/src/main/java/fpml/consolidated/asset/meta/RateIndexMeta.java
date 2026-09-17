package fpml.consolidated.asset.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.asset.RateIndex;
import fpml.consolidated.asset.validation.RateIndexTypeFormatValidator;
import fpml.consolidated.asset.validation.RateIndexValidator;
import fpml.consolidated.asset.validation.exists.RateIndexOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=RateIndex.class)
public class RateIndexMeta implements RosettaMetaData<RateIndex> {

	@Override
	public List<Validator<? super RateIndex>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super RateIndex, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super RateIndex> validator(ValidatorFactory factory) {
		return factory.<RateIndex>create(RateIndexValidator.class);
	}

	@Override
	public Validator<? super RateIndex> typeFormatValidator(ValidatorFactory factory) {
		return factory.<RateIndex>create(RateIndexTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super RateIndex> validator() {
		return new RateIndexValidator();
	}

	@Deprecated
	@Override
	public Validator<? super RateIndex> typeFormatValidator() {
		return new RateIndexTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RateIndex, Set<String>> onlyExistsValidator() {
		return new RateIndexOnlyExistsValidator();
	}
}
