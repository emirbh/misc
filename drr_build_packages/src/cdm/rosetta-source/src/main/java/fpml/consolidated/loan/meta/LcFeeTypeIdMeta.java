package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LcFeeTypeId;
import fpml.consolidated.loan.validation.LcFeeTypeIdTypeFormatValidator;
import fpml.consolidated.loan.validation.LcFeeTypeIdValidator;
import fpml.consolidated.loan.validation.exists.LcFeeTypeIdOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LcFeeTypeId.class)
public class LcFeeTypeIdMeta implements RosettaMetaData<LcFeeTypeId> {

	@Override
	public List<Validator<? super LcFeeTypeId>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LcFeeTypeId, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LcFeeTypeId> validator(ValidatorFactory factory) {
		return factory.<LcFeeTypeId>create(LcFeeTypeIdValidator.class);
	}

	@Override
	public Validator<? super LcFeeTypeId> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LcFeeTypeId>create(LcFeeTypeIdTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LcFeeTypeId> validator() {
		return new LcFeeTypeIdValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LcFeeTypeId> typeFormatValidator() {
		return new LcFeeTypeIdTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LcFeeTypeId, Set<String>> onlyExistsValidator() {
		return new LcFeeTypeIdOnlyExistsValidator();
	}
}
