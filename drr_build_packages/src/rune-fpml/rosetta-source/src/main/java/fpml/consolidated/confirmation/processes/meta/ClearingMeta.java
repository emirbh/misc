package fpml.consolidated.confirmation.processes.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.confirmation.processes.Clearing;
import fpml.consolidated.confirmation.processes.validation.ClearingTypeFormatValidator;
import fpml.consolidated.confirmation.processes.validation.ClearingValidator;
import fpml.consolidated.confirmation.processes.validation.exists.ClearingOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=Clearing.class)
public class ClearingMeta implements RosettaMetaData<Clearing> {

	@Override
	public List<Validator<? super Clearing>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Clearing, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Clearing> validator(ValidatorFactory factory) {
		return factory.<Clearing>create(ClearingValidator.class);
	}

	@Override
	public Validator<? super Clearing> typeFormatValidator(ValidatorFactory factory) {
		return factory.<Clearing>create(ClearingTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super Clearing> validator() {
		return new ClearingValidator();
	}

	@Deprecated
	@Override
	public Validator<? super Clearing> typeFormatValidator() {
		return new ClearingTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Clearing, Set<String>> onlyExistsValidator() {
		return new ClearingOnlyExistsValidator();
	}
}
