package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.CashPayable;
import fpml.consolidated.loan.validation.CashPayableTypeFormatValidator;
import fpml.consolidated.loan.validation.CashPayableValidator;
import fpml.consolidated.loan.validation.exists.CashPayableOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CashPayable.class)
public class CashPayableMeta implements RosettaMetaData<CashPayable> {

	@Override
	public List<Validator<? super CashPayable>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CashPayable, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CashPayable> validator(ValidatorFactory factory) {
		return factory.<CashPayable>create(CashPayableValidator.class);
	}

	@Override
	public Validator<? super CashPayable> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CashPayable>create(CashPayableTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CashPayable> validator() {
		return new CashPayableValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CashPayable> typeFormatValidator() {
		return new CashPayableTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CashPayable, Set<String>> onlyExistsValidator() {
		return new CashPayableOnlyExistsValidator();
	}
}
