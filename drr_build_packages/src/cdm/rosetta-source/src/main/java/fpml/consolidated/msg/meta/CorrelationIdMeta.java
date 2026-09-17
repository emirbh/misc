package fpml.consolidated.msg.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.msg.CorrelationId;
import fpml.consolidated.msg.validation.CorrelationIdTypeFormatValidator;
import fpml.consolidated.msg.validation.CorrelationIdValidator;
import fpml.consolidated.msg.validation.exists.CorrelationIdOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CorrelationId.class)
public class CorrelationIdMeta implements RosettaMetaData<CorrelationId> {

	@Override
	public List<Validator<? super CorrelationId>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CorrelationId, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CorrelationId> validator(ValidatorFactory factory) {
		return factory.<CorrelationId>create(CorrelationIdValidator.class);
	}

	@Override
	public Validator<? super CorrelationId> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CorrelationId>create(CorrelationIdTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CorrelationId> validator() {
		return new CorrelationIdValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CorrelationId> typeFormatValidator() {
		return new CorrelationIdTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CorrelationId, Set<String>> onlyExistsValidator() {
		return new CorrelationIdOnlyExistsValidator();
	}
}
