package fpml.consolidated.asset.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.asset.Cash;
import fpml.consolidated.asset.validation.CashTypeFormatValidator;
import fpml.consolidated.asset.validation.CashValidator;
import fpml.consolidated.asset.validation.exists.CashOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=Cash.class)
public class CashMeta implements RosettaMetaData<Cash> {

	@Override
	public List<Validator<? super Cash>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Cash, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Cash> validator(ValidatorFactory factory) {
		return factory.<Cash>create(CashValidator.class);
	}

	@Override
	public Validator<? super Cash> typeFormatValidator(ValidatorFactory factory) {
		return factory.<Cash>create(CashTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super Cash> validator() {
		return new CashValidator();
	}

	@Deprecated
	@Override
	public Validator<? super Cash> typeFormatValidator() {
		return new CashTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Cash, Set<String>> onlyExistsValidator() {
		return new CashOnlyExistsValidator();
	}
}
