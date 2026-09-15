package fpml.consolidated.msg.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.msg.PortfolioReference;
import fpml.consolidated.msg.validation.PortfolioReferenceTypeFormatValidator;
import fpml.consolidated.msg.validation.PortfolioReferenceValidator;
import fpml.consolidated.msg.validation.exists.PortfolioReferenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=PortfolioReference.class)
public class PortfolioReferenceMeta implements RosettaMetaData<PortfolioReference> {

	@Override
	public List<Validator<? super PortfolioReference>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PortfolioReference, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PortfolioReference> validator(ValidatorFactory factory) {
		return factory.<PortfolioReference>create(PortfolioReferenceValidator.class);
	}

	@Override
	public Validator<? super PortfolioReference> typeFormatValidator(ValidatorFactory factory) {
		return factory.<PortfolioReference>create(PortfolioReferenceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super PortfolioReference> validator() {
		return new PortfolioReferenceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super PortfolioReference> typeFormatValidator() {
		return new PortfolioReferenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PortfolioReference, Set<String>> onlyExistsValidator() {
		return new PortfolioReferenceOnlyExistsValidator();
	}
}
