package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.TaxForm;
import fpml.consolidated.loan.validation.TaxFormTypeFormatValidator;
import fpml.consolidated.loan.validation.TaxFormValidator;
import fpml.consolidated.loan.validation.exists.TaxFormOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=TaxForm.class)
public class TaxFormMeta implements RosettaMetaData<TaxForm> {

	@Override
	public List<Validator<? super TaxForm>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super TaxForm, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super TaxForm> validator(ValidatorFactory factory) {
		return factory.<TaxForm>create(TaxFormValidator.class);
	}

	@Override
	public Validator<? super TaxForm> typeFormatValidator(ValidatorFactory factory) {
		return factory.<TaxForm>create(TaxFormTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super TaxForm> validator() {
		return new TaxFormValidator();
	}

	@Deprecated
	@Override
	public Validator<? super TaxForm> typeFormatValidator() {
		return new TaxFormTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TaxForm, Set<String>> onlyExistsValidator() {
		return new TaxFormOnlyExistsValidator();
	}
}
