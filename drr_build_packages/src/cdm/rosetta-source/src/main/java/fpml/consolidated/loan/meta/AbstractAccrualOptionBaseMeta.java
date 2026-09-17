package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.AbstractAccrualOptionBase;
import fpml.consolidated.loan.validation.AbstractAccrualOptionBaseTypeFormatValidator;
import fpml.consolidated.loan.validation.AbstractAccrualOptionBaseValidator;
import fpml.consolidated.loan.validation.exists.AbstractAccrualOptionBaseOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=AbstractAccrualOptionBase.class)
public class AbstractAccrualOptionBaseMeta implements RosettaMetaData<AbstractAccrualOptionBase> {

	@Override
	public List<Validator<? super AbstractAccrualOptionBase>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AbstractAccrualOptionBase, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AbstractAccrualOptionBase> validator(ValidatorFactory factory) {
		return factory.<AbstractAccrualOptionBase>create(AbstractAccrualOptionBaseValidator.class);
	}

	@Override
	public Validator<? super AbstractAccrualOptionBase> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AbstractAccrualOptionBase>create(AbstractAccrualOptionBaseTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AbstractAccrualOptionBase> validator() {
		return new AbstractAccrualOptionBaseValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AbstractAccrualOptionBase> typeFormatValidator() {
		return new AbstractAccrualOptionBaseTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AbstractAccrualOptionBase, Set<String>> onlyExistsValidator() {
		return new AbstractAccrualOptionBaseOnlyExistsValidator();
	}
}
