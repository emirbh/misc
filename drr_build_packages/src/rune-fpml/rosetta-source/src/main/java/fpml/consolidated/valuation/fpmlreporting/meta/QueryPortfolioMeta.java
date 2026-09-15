package fpml.consolidated.valuation.fpmlreporting.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.valuation.fpmlreporting.Portfolio;
import fpml.consolidated.valuation.fpmlreporting.QueryPortfolio;
import fpml.consolidated.valuation.fpmlreporting.validation.QueryPortfolioTypeFormatValidator;
import fpml.consolidated.valuation.fpmlreporting.validation.QueryPortfolioValidator;
import fpml.consolidated.valuation.fpmlreporting.validation.datarule.PortfolioChoice;
import fpml.consolidated.valuation.fpmlreporting.validation.exists.QueryPortfolioOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=QueryPortfolio.class)
public class QueryPortfolioMeta implements RosettaMetaData<QueryPortfolio> {

	@Override
	public List<Validator<? super QueryPortfolio>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<Portfolio>create(PortfolioChoice.class)
		);
	}
	
	@Override
	public List<Function<? super QueryPortfolio, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super QueryPortfolio> validator(ValidatorFactory factory) {
		return factory.<QueryPortfolio>create(QueryPortfolioValidator.class);
	}

	@Override
	public Validator<? super QueryPortfolio> typeFormatValidator(ValidatorFactory factory) {
		return factory.<QueryPortfolio>create(QueryPortfolioTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super QueryPortfolio> validator() {
		return new QueryPortfolioValidator();
	}

	@Deprecated
	@Override
	public Validator<? super QueryPortfolio> typeFormatValidator() {
		return new QueryPortfolioTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super QueryPortfolio, Set<String>> onlyExistsValidator() {
		return new QueryPortfolioOnlyExistsValidator();
	}
}
