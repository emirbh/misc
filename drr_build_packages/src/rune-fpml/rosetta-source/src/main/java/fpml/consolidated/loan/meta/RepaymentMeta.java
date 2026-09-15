package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.Repayment;
import fpml.consolidated.loan.validation.RepaymentTypeFormatValidator;
import fpml.consolidated.loan.validation.RepaymentValidator;
import fpml.consolidated.loan.validation.exists.RepaymentOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=Repayment.class)
public class RepaymentMeta implements RosettaMetaData<Repayment> {

	@Override
	public List<Validator<? super Repayment>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Repayment, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Repayment> validator(ValidatorFactory factory) {
		return factory.<Repayment>create(RepaymentValidator.class);
	}

	@Override
	public Validator<? super Repayment> typeFormatValidator(ValidatorFactory factory) {
		return factory.<Repayment>create(RepaymentTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super Repayment> validator() {
		return new RepaymentValidator();
	}

	@Deprecated
	@Override
	public Validator<? super Repayment> typeFormatValidator() {
		return new RepaymentTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Repayment, Set<String>> onlyExistsValidator() {
		return new RepaymentOnlyExistsValidator();
	}
}
