package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.Lag;
import fpml.consolidated.com.validation.LagTypeFormatValidator;
import fpml.consolidated.com.validation.LagValidator;
import fpml.consolidated.com.validation.exists.LagOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=Lag.class)
public class LagMeta implements RosettaMetaData<Lag> {

	@Override
	public List<Validator<? super Lag>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Lag, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Lag> validator(ValidatorFactory factory) {
		return factory.<Lag>create(LagValidator.class);
	}

	@Override
	public Validator<? super Lag> typeFormatValidator(ValidatorFactory factory) {
		return factory.<Lag>create(LagTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super Lag> validator() {
		return new LagValidator();
	}

	@Deprecated
	@Override
	public Validator<? super Lag> typeFormatValidator() {
		return new LagTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Lag, Set<String>> onlyExistsValidator() {
		return new LagOnlyExistsValidator();
	}
}
