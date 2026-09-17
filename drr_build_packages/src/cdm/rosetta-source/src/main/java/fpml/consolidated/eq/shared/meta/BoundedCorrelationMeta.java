package fpml.consolidated.eq.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.eq.shared.BoundedCorrelation;
import fpml.consolidated.eq.shared.validation.BoundedCorrelationTypeFormatValidator;
import fpml.consolidated.eq.shared.validation.BoundedCorrelationValidator;
import fpml.consolidated.eq.shared.validation.exists.BoundedCorrelationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=BoundedCorrelation.class)
public class BoundedCorrelationMeta implements RosettaMetaData<BoundedCorrelation> {

	@Override
	public List<Validator<? super BoundedCorrelation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super BoundedCorrelation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super BoundedCorrelation> validator(ValidatorFactory factory) {
		return factory.<BoundedCorrelation>create(BoundedCorrelationValidator.class);
	}

	@Override
	public Validator<? super BoundedCorrelation> typeFormatValidator(ValidatorFactory factory) {
		return factory.<BoundedCorrelation>create(BoundedCorrelationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super BoundedCorrelation> validator() {
		return new BoundedCorrelationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super BoundedCorrelation> typeFormatValidator() {
		return new BoundedCorrelationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super BoundedCorrelation, Set<String>> onlyExistsValidator() {
		return new BoundedCorrelationOnlyExistsValidator();
	}
}
