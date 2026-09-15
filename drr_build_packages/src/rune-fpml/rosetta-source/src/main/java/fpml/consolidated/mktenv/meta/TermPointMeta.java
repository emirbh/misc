package fpml.consolidated.mktenv.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.mktenv.TermPoint;
import fpml.consolidated.mktenv.validation.TermPointTypeFormatValidator;
import fpml.consolidated.mktenv.validation.TermPointValidator;
import fpml.consolidated.mktenv.validation.exists.TermPointOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=TermPoint.class)
public class TermPointMeta implements RosettaMetaData<TermPoint> {

	@Override
	public List<Validator<? super TermPoint>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super TermPoint, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super TermPoint> validator(ValidatorFactory factory) {
		return factory.<TermPoint>create(TermPointValidator.class);
	}

	@Override
	public Validator<? super TermPoint> typeFormatValidator(ValidatorFactory factory) {
		return factory.<TermPoint>create(TermPointTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super TermPoint> validator() {
		return new TermPointValidator();
	}

	@Deprecated
	@Override
	public Validator<? super TermPoint> typeFormatValidator() {
		return new TermPointTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TermPoint, Set<String>> onlyExistsValidator() {
		return new TermPointOnlyExistsValidator();
	}
}
