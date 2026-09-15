package iso20022.auth108.iso.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth108.iso.TradeCounterpartyRelationship1Choice;
import iso20022.auth108.iso.validation.TradeCounterpartyRelationship1ChoiceTypeFormatValidator;
import iso20022.auth108.iso.validation.TradeCounterpartyRelationship1ChoiceValidator;
import iso20022.auth108.iso.validation.datarule.TradeCounterpartyRelationship1ChoiceChoice;
import iso20022.auth108.iso.validation.exists.TradeCounterpartyRelationship1ChoiceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=TradeCounterpartyRelationship1Choice.class)
public class TradeCounterpartyRelationship1ChoiceMeta implements RosettaMetaData<TradeCounterpartyRelationship1Choice> {

	@Override
	public List<Validator<? super TradeCounterpartyRelationship1Choice>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<TradeCounterpartyRelationship1Choice>create(TradeCounterpartyRelationship1ChoiceChoice.class)
		);
	}
	
	@Override
	public List<Function<? super TradeCounterpartyRelationship1Choice, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super TradeCounterpartyRelationship1Choice> validator(ValidatorFactory factory) {
		return factory.<TradeCounterpartyRelationship1Choice>create(TradeCounterpartyRelationship1ChoiceValidator.class);
	}

	@Override
	public Validator<? super TradeCounterpartyRelationship1Choice> typeFormatValidator(ValidatorFactory factory) {
		return factory.<TradeCounterpartyRelationship1Choice>create(TradeCounterpartyRelationship1ChoiceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super TradeCounterpartyRelationship1Choice> validator() {
		return new TradeCounterpartyRelationship1ChoiceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super TradeCounterpartyRelationship1Choice> typeFormatValidator() {
		return new TradeCounterpartyRelationship1ChoiceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TradeCounterpartyRelationship1Choice, Set<String>> onlyExistsValidator() {
		return new TradeCounterpartyRelationship1ChoiceOnlyExistsValidator();
	}
}
