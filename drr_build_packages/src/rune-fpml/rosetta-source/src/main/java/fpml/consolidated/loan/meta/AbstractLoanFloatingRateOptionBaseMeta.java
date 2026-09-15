package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.AbstractLoanFloatingRateOptionBase;
import fpml.consolidated.loan.validation.AbstractLoanFloatingRateOptionBaseTypeFormatValidator;
import fpml.consolidated.loan.validation.AbstractLoanFloatingRateOptionBaseValidator;
import fpml.consolidated.loan.validation.exists.AbstractLoanFloatingRateOptionBaseOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=AbstractLoanFloatingRateOptionBase.class)
public class AbstractLoanFloatingRateOptionBaseMeta implements RosettaMetaData<AbstractLoanFloatingRateOptionBase> {

	@Override
	public List<Validator<? super AbstractLoanFloatingRateOptionBase>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AbstractLoanFloatingRateOptionBase, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AbstractLoanFloatingRateOptionBase> validator(ValidatorFactory factory) {
		return factory.<AbstractLoanFloatingRateOptionBase>create(AbstractLoanFloatingRateOptionBaseValidator.class);
	}

	@Override
	public Validator<? super AbstractLoanFloatingRateOptionBase> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AbstractLoanFloatingRateOptionBase>create(AbstractLoanFloatingRateOptionBaseTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AbstractLoanFloatingRateOptionBase> validator() {
		return new AbstractLoanFloatingRateOptionBaseValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AbstractLoanFloatingRateOptionBase> typeFormatValidator() {
		return new AbstractLoanFloatingRateOptionBaseTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AbstractLoanFloatingRateOptionBase, Set<String>> onlyExistsValidator() {
		return new AbstractLoanFloatingRateOptionBaseOnlyExistsValidator();
	}
}
