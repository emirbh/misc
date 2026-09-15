package fpml.consolidated.credit.event.notification.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.credit.event.notification.Bankruptcy;
import fpml.consolidated.credit.event.notification.validation.BankruptcyTypeFormatValidator;
import fpml.consolidated.credit.event.notification.validation.BankruptcyValidator;
import fpml.consolidated.credit.event.notification.validation.exists.BankruptcyOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=Bankruptcy.class)
public class BankruptcyMeta implements RosettaMetaData<Bankruptcy> {

	@Override
	public List<Validator<? super Bankruptcy>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Bankruptcy, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Bankruptcy> validator(ValidatorFactory factory) {
		return factory.<Bankruptcy>create(BankruptcyValidator.class);
	}

	@Override
	public Validator<? super Bankruptcy> typeFormatValidator(ValidatorFactory factory) {
		return factory.<Bankruptcy>create(BankruptcyTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super Bankruptcy> validator() {
		return new BankruptcyValidator();
	}

	@Deprecated
	@Override
	public Validator<? super Bankruptcy> typeFormatValidator() {
		return new BankruptcyTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Bankruptcy, Set<String>> onlyExistsValidator() {
		return new BankruptcyOnlyExistsValidator();
	}
}
