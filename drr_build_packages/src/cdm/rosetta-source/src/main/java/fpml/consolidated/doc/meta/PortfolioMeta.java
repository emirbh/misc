package fpml.consolidated.doc.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.doc.Portfolio;
import fpml.consolidated.doc.validation.PortfolioTypeFormatValidator;
import fpml.consolidated.doc.validation.PortfolioValidator;
import fpml.consolidated.doc.validation.datarule.PortfolioChoice;
import fpml.consolidated.doc.validation.exists.PortfolioOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=Portfolio.class)
public class PortfolioMeta implements RosettaMetaData<Portfolio> {

	@Override
	public List<Validator<? super Portfolio>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<Portfolio>create(PortfolioChoice.class)
		);
	}
	
	@Override
	public List<Function<? super Portfolio, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Portfolio> validator(ValidatorFactory factory) {
		return factory.<Portfolio>create(PortfolioValidator.class);
	}

	@Override
	public Validator<? super Portfolio> typeFormatValidator(ValidatorFactory factory) {
		return factory.<Portfolio>create(PortfolioTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super Portfolio> validator() {
		return new PortfolioValidator();
	}

	@Deprecated
	@Override
	public Validator<? super Portfolio> typeFormatValidator() {
		return new PortfolioTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Portfolio, Set<String>> onlyExistsValidator() {
		return new PortfolioOnlyExistsValidator();
	}
}
