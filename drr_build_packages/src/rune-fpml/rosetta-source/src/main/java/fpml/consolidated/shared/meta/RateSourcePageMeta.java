package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.RateSourcePage;
import fpml.consolidated.shared.validation.RateSourcePageTypeFormatValidator;
import fpml.consolidated.shared.validation.RateSourcePageValidator;
import fpml.consolidated.shared.validation.exists.RateSourcePageOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=RateSourcePage.class)
public class RateSourcePageMeta implements RosettaMetaData<RateSourcePage> {

	@Override
	public List<Validator<? super RateSourcePage>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super RateSourcePage, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super RateSourcePage> validator(ValidatorFactory factory) {
		return factory.<RateSourcePage>create(RateSourcePageValidator.class);
	}

	@Override
	public Validator<? super RateSourcePage> typeFormatValidator(ValidatorFactory factory) {
		return factory.<RateSourcePage>create(RateSourcePageTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super RateSourcePage> validator() {
		return new RateSourcePageValidator();
	}

	@Deprecated
	@Override
	public Validator<? super RateSourcePage> typeFormatValidator() {
		return new RateSourcePageTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RateSourcePage, Set<String>> onlyExistsValidator() {
		return new RateSourcePageOnlyExistsValidator();
	}
}
