package fpml.consolidated.ird.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.ird.Notional;
import fpml.consolidated.ird.validation.NotionalTypeFormatValidator;
import fpml.consolidated.ird.validation.NotionalValidator;
import fpml.consolidated.ird.validation.exists.NotionalOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=Notional.class)
public class NotionalMeta implements RosettaMetaData<Notional> {

	@Override
	public List<Validator<? super Notional>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Notional, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Notional> validator(ValidatorFactory factory) {
		return factory.<Notional>create(NotionalValidator.class);
	}

	@Override
	public Validator<? super Notional> typeFormatValidator(ValidatorFactory factory) {
		return factory.<Notional>create(NotionalTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super Notional> validator() {
		return new NotionalValidator();
	}

	@Deprecated
	@Override
	public Validator<? super Notional> typeFormatValidator() {
		return new NotionalTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Notional, Set<String>> onlyExistsValidator() {
		return new NotionalOnlyExistsValidator();
	}
}
