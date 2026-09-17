package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LcPurpose;
import fpml.consolidated.loan.validation.LcPurposeTypeFormatValidator;
import fpml.consolidated.loan.validation.LcPurposeValidator;
import fpml.consolidated.loan.validation.exists.LcPurposeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LcPurpose.class)
public class LcPurposeMeta implements RosettaMetaData<LcPurpose> {

	@Override
	public List<Validator<? super LcPurpose>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LcPurpose, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LcPurpose> validator(ValidatorFactory factory) {
		return factory.<LcPurpose>create(LcPurposeValidator.class);
	}

	@Override
	public Validator<? super LcPurpose> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LcPurpose>create(LcPurposeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LcPurpose> validator() {
		return new LcPurposeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LcPurpose> typeFormatValidator() {
		return new LcPurposeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LcPurpose, Set<String>> onlyExistsValidator() {
		return new LcPurposeOnlyExistsValidator();
	}
}
