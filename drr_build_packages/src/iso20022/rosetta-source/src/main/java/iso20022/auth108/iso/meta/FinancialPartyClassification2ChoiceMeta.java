package iso20022.auth108.iso.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth108.iso.FinancialPartyClassification2Choice;
import iso20022.auth108.iso.validation.FinancialPartyClassification2ChoiceTypeFormatValidator;
import iso20022.auth108.iso.validation.FinancialPartyClassification2ChoiceValidator;
import iso20022.auth108.iso.validation.datarule.FinancialPartyClassification2ChoiceChoice;
import iso20022.auth108.iso.validation.exists.FinancialPartyClassification2ChoiceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FinancialPartyClassification2Choice.class)
public class FinancialPartyClassification2ChoiceMeta implements RosettaMetaData<FinancialPartyClassification2Choice> {

	@Override
	public List<Validator<? super FinancialPartyClassification2Choice>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<FinancialPartyClassification2Choice>create(FinancialPartyClassification2ChoiceChoice.class)
		);
	}
	
	@Override
	public List<Function<? super FinancialPartyClassification2Choice, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FinancialPartyClassification2Choice> validator(ValidatorFactory factory) {
		return factory.<FinancialPartyClassification2Choice>create(FinancialPartyClassification2ChoiceValidator.class);
	}

	@Override
	public Validator<? super FinancialPartyClassification2Choice> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FinancialPartyClassification2Choice>create(FinancialPartyClassification2ChoiceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FinancialPartyClassification2Choice> validator() {
		return new FinancialPartyClassification2ChoiceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FinancialPartyClassification2Choice> typeFormatValidator() {
		return new FinancialPartyClassification2ChoiceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FinancialPartyClassification2Choice, Set<String>> onlyExistsValidator() {
		return new FinancialPartyClassification2ChoiceOnlyExistsValidator();
	}
}
