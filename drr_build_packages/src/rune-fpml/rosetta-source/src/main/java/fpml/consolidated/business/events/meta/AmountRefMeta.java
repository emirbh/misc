package fpml.consolidated.business.events.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.business.events.AmountRef;
import fpml.consolidated.business.events.validation.AmountRefTypeFormatValidator;
import fpml.consolidated.business.events.validation.AmountRefValidator;
import fpml.consolidated.business.events.validation.exists.AmountRefOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=AmountRef.class)
public class AmountRefMeta implements RosettaMetaData<AmountRef> {

	@Override
	public List<Validator<? super AmountRef>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AmountRef, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AmountRef> validator(ValidatorFactory factory) {
		return factory.<AmountRef>create(AmountRefValidator.class);
	}

	@Override
	public Validator<? super AmountRef> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AmountRef>create(AmountRefTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AmountRef> validator() {
		return new AmountRefValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AmountRef> typeFormatValidator() {
		return new AmountRefTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AmountRef, Set<String>> onlyExistsValidator() {
		return new AmountRefOnlyExistsValidator();
	}
}
