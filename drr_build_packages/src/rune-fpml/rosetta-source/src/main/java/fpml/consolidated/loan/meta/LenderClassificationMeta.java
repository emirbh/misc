package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LenderClassification;
import fpml.consolidated.loan.validation.LenderClassificationTypeFormatValidator;
import fpml.consolidated.loan.validation.LenderClassificationValidator;
import fpml.consolidated.loan.validation.exists.LenderClassificationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LenderClassification.class)
public class LenderClassificationMeta implements RosettaMetaData<LenderClassification> {

	@Override
	public List<Validator<? super LenderClassification>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LenderClassification, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LenderClassification> validator(ValidatorFactory factory) {
		return factory.<LenderClassification>create(LenderClassificationValidator.class);
	}

	@Override
	public Validator<? super LenderClassification> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LenderClassification>create(LenderClassificationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LenderClassification> validator() {
		return new LenderClassificationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LenderClassification> typeFormatValidator() {
		return new LenderClassificationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LenderClassification, Set<String>> onlyExistsValidator() {
		return new LenderClassificationOnlyExistsValidator();
	}
}
