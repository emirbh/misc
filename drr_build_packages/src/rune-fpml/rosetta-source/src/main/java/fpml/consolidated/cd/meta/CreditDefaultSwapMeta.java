package fpml.consolidated.cd.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.cd.CreditDefaultSwap;
import fpml.consolidated.cd.validation.CreditDefaultSwapTypeFormatValidator;
import fpml.consolidated.cd.validation.CreditDefaultSwapValidator;
import fpml.consolidated.cd.validation.exists.CreditDefaultSwapOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CreditDefaultSwap.class)
public class CreditDefaultSwapMeta implements RosettaMetaData<CreditDefaultSwap> {

	@Override
	public List<Validator<? super CreditDefaultSwap>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CreditDefaultSwap, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CreditDefaultSwap> validator(ValidatorFactory factory) {
		return factory.<CreditDefaultSwap>create(CreditDefaultSwapValidator.class);
	}

	@Override
	public Validator<? super CreditDefaultSwap> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CreditDefaultSwap>create(CreditDefaultSwapTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CreditDefaultSwap> validator() {
		return new CreditDefaultSwapValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CreditDefaultSwap> typeFormatValidator() {
		return new CreditDefaultSwapTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CreditDefaultSwap, Set<String>> onlyExistsValidator() {
		return new CreditDefaultSwapOnlyExistsValidator();
	}
}
