package fpml.consolidated.riskdef.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.riskdef.TermPointReference;
import fpml.consolidated.riskdef.validation.TermPointReferenceTypeFormatValidator;
import fpml.consolidated.riskdef.validation.TermPointReferenceValidator;
import fpml.consolidated.riskdef.validation.exists.TermPointReferenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=TermPointReference.class)
public class TermPointReferenceMeta implements RosettaMetaData<TermPointReference> {

	@Override
	public List<Validator<? super TermPointReference>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super TermPointReference, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super TermPointReference> validator(ValidatorFactory factory) {
		return factory.<TermPointReference>create(TermPointReferenceValidator.class);
	}

	@Override
	public Validator<? super TermPointReference> typeFormatValidator(ValidatorFactory factory) {
		return factory.<TermPointReference>create(TermPointReferenceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super TermPointReference> validator() {
		return new TermPointReferenceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super TermPointReference> typeFormatValidator() {
		return new TermPointReferenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TermPointReference, Set<String>> onlyExistsValidator() {
		return new TermPointReferenceOnlyExistsValidator();
	}
}
