package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.Rollover;
import fpml.consolidated.loan.validation.RolloverTypeFormatValidator;
import fpml.consolidated.loan.validation.RolloverValidator;
import fpml.consolidated.loan.validation.exists.RolloverOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=Rollover.class)
public class RolloverMeta implements RosettaMetaData<Rollover> {

	@Override
	public List<Validator<? super Rollover>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Rollover, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Rollover> validator(ValidatorFactory factory) {
		return factory.<Rollover>create(RolloverValidator.class);
	}

	@Override
	public Validator<? super Rollover> typeFormatValidator(ValidatorFactory factory) {
		return factory.<Rollover>create(RolloverTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super Rollover> validator() {
		return new RolloverValidator();
	}

	@Deprecated
	@Override
	public Validator<? super Rollover> typeFormatValidator() {
		return new RolloverTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Rollover, Set<String>> onlyExistsValidator() {
		return new RolloverOnlyExistsValidator();
	}
}
