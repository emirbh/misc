package iso20022.auth108.hkma.tr.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth108.hkma.tr.PortfolioCode5Choice;
import iso20022.auth108.hkma.tr.validation.PortfolioCode5ChoiceTypeFormatValidator;
import iso20022.auth108.hkma.tr.validation.PortfolioCode5ChoiceValidator;
import iso20022.auth108.hkma.tr.validation.datarule.PortfolioCode5ChoiceChoice;
import iso20022.auth108.hkma.tr.validation.exists.PortfolioCode5ChoiceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=PortfolioCode5Choice.class)
public class PortfolioCode5ChoiceMeta implements RosettaMetaData<PortfolioCode5Choice> {

	@Override
	public List<Validator<? super PortfolioCode5Choice>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<PortfolioCode5Choice>create(PortfolioCode5ChoiceChoice.class)
		);
	}
	
	@Override
	public List<Function<? super PortfolioCode5Choice, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PortfolioCode5Choice> validator(ValidatorFactory factory) {
		return factory.<PortfolioCode5Choice>create(PortfolioCode5ChoiceValidator.class);
	}

	@Override
	public Validator<? super PortfolioCode5Choice> typeFormatValidator(ValidatorFactory factory) {
		return factory.<PortfolioCode5Choice>create(PortfolioCode5ChoiceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super PortfolioCode5Choice> validator() {
		return new PortfolioCode5ChoiceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super PortfolioCode5Choice> typeFormatValidator() {
		return new PortfolioCode5ChoiceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PortfolioCode5Choice, Set<String>> onlyExistsValidator() {
		return new PortfolioCode5ChoiceOnlyExistsValidator();
	}
}
