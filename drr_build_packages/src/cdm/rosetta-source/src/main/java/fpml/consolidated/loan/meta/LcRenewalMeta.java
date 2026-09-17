package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LcRenewal;
import fpml.consolidated.loan.validation.LcRenewalTypeFormatValidator;
import fpml.consolidated.loan.validation.LcRenewalValidator;
import fpml.consolidated.loan.validation.exists.LcRenewalOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LcRenewal.class)
public class LcRenewalMeta implements RosettaMetaData<LcRenewal> {

	@Override
	public List<Validator<? super LcRenewal>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LcRenewal, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LcRenewal> validator(ValidatorFactory factory) {
		return factory.<LcRenewal>create(LcRenewalValidator.class);
	}

	@Override
	public Validator<? super LcRenewal> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LcRenewal>create(LcRenewalTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LcRenewal> validator() {
		return new LcRenewalValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LcRenewal> typeFormatValidator() {
		return new LcRenewalTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LcRenewal, Set<String>> onlyExistsValidator() {
		return new LcRenewalOnlyExistsValidator();
	}
}
