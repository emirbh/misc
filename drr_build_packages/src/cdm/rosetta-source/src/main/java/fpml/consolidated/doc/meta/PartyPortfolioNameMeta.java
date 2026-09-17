package fpml.consolidated.doc.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.doc.PartyPortfolioName;
import fpml.consolidated.doc.validation.PartyPortfolioNameTypeFormatValidator;
import fpml.consolidated.doc.validation.PartyPortfolioNameValidator;
import fpml.consolidated.doc.validation.exists.PartyPortfolioNameOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=PartyPortfolioName.class)
public class PartyPortfolioNameMeta implements RosettaMetaData<PartyPortfolioName> {

	@Override
	public List<Validator<? super PartyPortfolioName>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PartyPortfolioName, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PartyPortfolioName> validator(ValidatorFactory factory) {
		return factory.<PartyPortfolioName>create(PartyPortfolioNameValidator.class);
	}

	@Override
	public Validator<? super PartyPortfolioName> typeFormatValidator(ValidatorFactory factory) {
		return factory.<PartyPortfolioName>create(PartyPortfolioNameTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super PartyPortfolioName> validator() {
		return new PartyPortfolioNameValidator();
	}

	@Deprecated
	@Override
	public Validator<? super PartyPortfolioName> typeFormatValidator() {
		return new PartyPortfolioNameTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PartyPortfolioName, Set<String>> onlyExistsValidator() {
		return new PartyPortfolioNameOnlyExistsValidator();
	}
}
