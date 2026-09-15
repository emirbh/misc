package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LcIssuance;
import fpml.consolidated.loan.validation.LcIssuanceTypeFormatValidator;
import fpml.consolidated.loan.validation.LcIssuanceValidator;
import fpml.consolidated.loan.validation.exists.LcIssuanceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LcIssuance.class)
public class LcIssuanceMeta implements RosettaMetaData<LcIssuance> {

	@Override
	public List<Validator<? super LcIssuance>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LcIssuance, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LcIssuance> validator(ValidatorFactory factory) {
		return factory.<LcIssuance>create(LcIssuanceValidator.class);
	}

	@Override
	public Validator<? super LcIssuance> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LcIssuance>create(LcIssuanceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LcIssuance> validator() {
		return new LcIssuanceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LcIssuance> typeFormatValidator() {
		return new LcIssuanceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LcIssuance, Set<String>> onlyExistsValidator() {
		return new LcIssuanceOnlyExistsValidator();
	}
}
