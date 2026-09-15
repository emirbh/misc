package fpml.consolidated.doc.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.doc.StrategyComponentIdentification;
import fpml.consolidated.doc.validation.StrategyComponentIdentificationTypeFormatValidator;
import fpml.consolidated.doc.validation.StrategyComponentIdentificationValidator;
import fpml.consolidated.doc.validation.exists.StrategyComponentIdentificationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=StrategyComponentIdentification.class)
public class StrategyComponentIdentificationMeta implements RosettaMetaData<StrategyComponentIdentification> {

	@Override
	public List<Validator<? super StrategyComponentIdentification>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super StrategyComponentIdentification, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super StrategyComponentIdentification> validator(ValidatorFactory factory) {
		return factory.<StrategyComponentIdentification>create(StrategyComponentIdentificationValidator.class);
	}

	@Override
	public Validator<? super StrategyComponentIdentification> typeFormatValidator(ValidatorFactory factory) {
		return factory.<StrategyComponentIdentification>create(StrategyComponentIdentificationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super StrategyComponentIdentification> validator() {
		return new StrategyComponentIdentificationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super StrategyComponentIdentification> typeFormatValidator() {
		return new StrategyComponentIdentificationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super StrategyComponentIdentification, Set<String>> onlyExistsValidator() {
		return new StrategyComponentIdentificationOnlyExistsValidator();
	}
}
