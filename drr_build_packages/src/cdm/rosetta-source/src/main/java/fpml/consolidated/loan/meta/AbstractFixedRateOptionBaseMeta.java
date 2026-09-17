package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.AbstractFixedRateOptionBase;
import fpml.consolidated.loan.validation.AbstractFixedRateOptionBaseTypeFormatValidator;
import fpml.consolidated.loan.validation.AbstractFixedRateOptionBaseValidator;
import fpml.consolidated.loan.validation.exists.AbstractFixedRateOptionBaseOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=AbstractFixedRateOptionBase.class)
public class AbstractFixedRateOptionBaseMeta implements RosettaMetaData<AbstractFixedRateOptionBase> {

	@Override
	public List<Validator<? super AbstractFixedRateOptionBase>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AbstractFixedRateOptionBase, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AbstractFixedRateOptionBase> validator(ValidatorFactory factory) {
		return factory.<AbstractFixedRateOptionBase>create(AbstractFixedRateOptionBaseValidator.class);
	}

	@Override
	public Validator<? super AbstractFixedRateOptionBase> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AbstractFixedRateOptionBase>create(AbstractFixedRateOptionBaseTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AbstractFixedRateOptionBase> validator() {
		return new AbstractFixedRateOptionBaseValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AbstractFixedRateOptionBase> typeFormatValidator() {
		return new AbstractFixedRateOptionBaseTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AbstractFixedRateOptionBase, Set<String>> onlyExistsValidator() {
		return new AbstractFixedRateOptionBaseOnlyExistsValidator();
	}
}
