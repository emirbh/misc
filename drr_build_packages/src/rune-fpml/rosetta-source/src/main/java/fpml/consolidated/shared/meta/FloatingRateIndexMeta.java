package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.FloatingRateIndex;
import fpml.consolidated.shared.validation.FloatingRateIndexTypeFormatValidator;
import fpml.consolidated.shared.validation.FloatingRateIndexValidator;
import fpml.consolidated.shared.validation.exists.FloatingRateIndexOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FloatingRateIndex.class)
public class FloatingRateIndexMeta implements RosettaMetaData<FloatingRateIndex> {

	@Override
	public List<Validator<? super FloatingRateIndex>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FloatingRateIndex, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FloatingRateIndex> validator(ValidatorFactory factory) {
		return factory.<FloatingRateIndex>create(FloatingRateIndexValidator.class);
	}

	@Override
	public Validator<? super FloatingRateIndex> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FloatingRateIndex>create(FloatingRateIndexTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FloatingRateIndex> validator() {
		return new FloatingRateIndexValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FloatingRateIndex> typeFormatValidator() {
		return new FloatingRateIndexTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FloatingRateIndex, Set<String>> onlyExistsValidator() {
		return new FloatingRateIndexOnlyExistsValidator();
	}
}
