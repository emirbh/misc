package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.Rate;
import fpml.consolidated.shared.validation.RateTypeFormatValidator;
import fpml.consolidated.shared.validation.RateValidator;
import fpml.consolidated.shared.validation.exists.RateOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=Rate.class)
public class RateMeta implements RosettaMetaData<Rate> {

	@Override
	public List<Validator<? super Rate>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Rate, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Rate> validator(ValidatorFactory factory) {
		return factory.<Rate>create(RateValidator.class);
	}

	@Override
	public Validator<? super Rate> typeFormatValidator(ValidatorFactory factory) {
		return factory.<Rate>create(RateTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super Rate> validator() {
		return new RateValidator();
	}

	@Deprecated
	@Override
	public Validator<? super Rate> typeFormatValidator() {
		return new RateTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Rate, Set<String>> onlyExistsValidator() {
		return new RateOnlyExistsValidator();
	}
}
