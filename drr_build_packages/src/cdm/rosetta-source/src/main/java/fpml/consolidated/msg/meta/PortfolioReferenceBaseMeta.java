package fpml.consolidated.msg.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.msg.PortfolioReferenceBase;
import fpml.consolidated.msg.validation.PortfolioReferenceBaseTypeFormatValidator;
import fpml.consolidated.msg.validation.PortfolioReferenceBaseValidator;
import fpml.consolidated.msg.validation.exists.PortfolioReferenceBaseOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=PortfolioReferenceBase.class)
public class PortfolioReferenceBaseMeta implements RosettaMetaData<PortfolioReferenceBase> {

	@Override
	public List<Validator<? super PortfolioReferenceBase>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PortfolioReferenceBase, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PortfolioReferenceBase> validator(ValidatorFactory factory) {
		return factory.<PortfolioReferenceBase>create(PortfolioReferenceBaseValidator.class);
	}

	@Override
	public Validator<? super PortfolioReferenceBase> typeFormatValidator(ValidatorFactory factory) {
		return factory.<PortfolioReferenceBase>create(PortfolioReferenceBaseTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super PortfolioReferenceBase> validator() {
		return new PortfolioReferenceBaseValidator();
	}

	@Deprecated
	@Override
	public Validator<? super PortfolioReferenceBase> typeFormatValidator() {
		return new PortfolioReferenceBaseTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PortfolioReferenceBase, Set<String>> onlyExistsValidator() {
		return new PortfolioReferenceBaseOnlyExistsValidator();
	}
}
