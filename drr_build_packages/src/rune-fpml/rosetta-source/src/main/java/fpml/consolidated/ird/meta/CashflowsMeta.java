package fpml.consolidated.ird.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.ird.Cashflows;
import fpml.consolidated.ird.validation.CashflowsTypeFormatValidator;
import fpml.consolidated.ird.validation.CashflowsValidator;
import fpml.consolidated.ird.validation.exists.CashflowsOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=Cashflows.class)
public class CashflowsMeta implements RosettaMetaData<Cashflows> {

	@Override
	public List<Validator<? super Cashflows>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Cashflows, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Cashflows> validator(ValidatorFactory factory) {
		return factory.<Cashflows>create(CashflowsValidator.class);
	}

	@Override
	public Validator<? super Cashflows> typeFormatValidator(ValidatorFactory factory) {
		return factory.<Cashflows>create(CashflowsTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super Cashflows> validator() {
		return new CashflowsValidator();
	}

	@Deprecated
	@Override
	public Validator<? super Cashflows> typeFormatValidator() {
		return new CashflowsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Cashflows, Set<String>> onlyExistsValidator() {
		return new CashflowsOnlyExistsValidator();
	}
}
