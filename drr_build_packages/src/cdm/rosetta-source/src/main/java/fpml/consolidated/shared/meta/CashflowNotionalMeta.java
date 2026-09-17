package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.CashflowNotional;
import fpml.consolidated.shared.validation.CashflowNotionalTypeFormatValidator;
import fpml.consolidated.shared.validation.CashflowNotionalValidator;
import fpml.consolidated.shared.validation.datarule.CashflowNotionalChoice;
import fpml.consolidated.shared.validation.exists.CashflowNotionalOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CashflowNotional.class)
public class CashflowNotionalMeta implements RosettaMetaData<CashflowNotional> {

	@Override
	public List<Validator<? super CashflowNotional>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<CashflowNotional>create(CashflowNotionalChoice.class)
		);
	}
	
	@Override
	public List<Function<? super CashflowNotional, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CashflowNotional> validator(ValidatorFactory factory) {
		return factory.<CashflowNotional>create(CashflowNotionalValidator.class);
	}

	@Override
	public Validator<? super CashflowNotional> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CashflowNotional>create(CashflowNotionalTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CashflowNotional> validator() {
		return new CashflowNotionalValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CashflowNotional> typeFormatValidator() {
		return new CashflowNotionalTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CashflowNotional, Set<String>> onlyExistsValidator() {
		return new CashflowNotionalOnlyExistsValidator();
	}
}
