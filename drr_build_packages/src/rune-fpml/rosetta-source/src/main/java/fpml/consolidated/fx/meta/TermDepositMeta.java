package fpml.consolidated.fx.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.TermDeposit;
import fpml.consolidated.fx.validation.TermDepositTypeFormatValidator;
import fpml.consolidated.fx.validation.TermDepositValidator;
import fpml.consolidated.fx.validation.datarule.TermDepositChoice;
import fpml.consolidated.fx.validation.exists.TermDepositOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=TermDeposit.class)
public class TermDepositMeta implements RosettaMetaData<TermDeposit> {

	@Override
	public List<Validator<? super TermDeposit>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<TermDeposit>create(TermDepositChoice.class)
		);
	}
	
	@Override
	public List<Function<? super TermDeposit, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super TermDeposit> validator(ValidatorFactory factory) {
		return factory.<TermDeposit>create(TermDepositValidator.class);
	}

	@Override
	public Validator<? super TermDeposit> typeFormatValidator(ValidatorFactory factory) {
		return factory.<TermDeposit>create(TermDepositTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super TermDeposit> validator() {
		return new TermDepositValidator();
	}

	@Deprecated
	@Override
	public Validator<? super TermDeposit> typeFormatValidator() {
		return new TermDepositTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TermDeposit, Set<String>> onlyExistsValidator() {
		return new TermDepositOnlyExistsValidator();
	}
}
