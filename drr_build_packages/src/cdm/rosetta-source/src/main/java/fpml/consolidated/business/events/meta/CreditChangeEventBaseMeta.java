package fpml.consolidated.business.events.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.business.events.CreditChangeEventBase;
import fpml.consolidated.business.events.validation.CreditChangeEventBaseTypeFormatValidator;
import fpml.consolidated.business.events.validation.CreditChangeEventBaseValidator;
import fpml.consolidated.business.events.validation.exists.CreditChangeEventBaseOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CreditChangeEventBase.class)
public class CreditChangeEventBaseMeta implements RosettaMetaData<CreditChangeEventBase> {

	@Override
	public List<Validator<? super CreditChangeEventBase>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CreditChangeEventBase, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CreditChangeEventBase> validator(ValidatorFactory factory) {
		return factory.<CreditChangeEventBase>create(CreditChangeEventBaseValidator.class);
	}

	@Override
	public Validator<? super CreditChangeEventBase> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CreditChangeEventBase>create(CreditChangeEventBaseTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CreditChangeEventBase> validator() {
		return new CreditChangeEventBaseValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CreditChangeEventBase> typeFormatValidator() {
		return new CreditChangeEventBaseTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CreditChangeEventBase, Set<String>> onlyExistsValidator() {
		return new CreditChangeEventBaseOnlyExistsValidator();
	}
}
