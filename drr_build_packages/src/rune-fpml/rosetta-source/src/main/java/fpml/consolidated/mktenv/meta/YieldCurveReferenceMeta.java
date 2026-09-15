package fpml.consolidated.mktenv.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.mktenv.YieldCurveReference;
import fpml.consolidated.mktenv.validation.YieldCurveReferenceTypeFormatValidator;
import fpml.consolidated.mktenv.validation.YieldCurveReferenceValidator;
import fpml.consolidated.mktenv.validation.exists.YieldCurveReferenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=YieldCurveReference.class)
public class YieldCurveReferenceMeta implements RosettaMetaData<YieldCurveReference> {

	@Override
	public List<Validator<? super YieldCurveReference>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super YieldCurveReference, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super YieldCurveReference> validator(ValidatorFactory factory) {
		return factory.<YieldCurveReference>create(YieldCurveReferenceValidator.class);
	}

	@Override
	public Validator<? super YieldCurveReference> typeFormatValidator(ValidatorFactory factory) {
		return factory.<YieldCurveReference>create(YieldCurveReferenceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super YieldCurveReference> validator() {
		return new YieldCurveReferenceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super YieldCurveReference> typeFormatValidator() {
		return new YieldCurveReferenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super YieldCurveReference, Set<String>> onlyExistsValidator() {
		return new YieldCurveReferenceOnlyExistsValidator();
	}
}
