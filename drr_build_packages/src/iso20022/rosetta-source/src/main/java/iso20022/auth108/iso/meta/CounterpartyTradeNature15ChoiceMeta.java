package iso20022.auth108.iso.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth108.iso.CounterpartyTradeNature15Choice;
import iso20022.auth108.iso.validation.CounterpartyTradeNature15ChoiceTypeFormatValidator;
import iso20022.auth108.iso.validation.CounterpartyTradeNature15ChoiceValidator;
import iso20022.auth108.iso.validation.datarule.CounterpartyTradeNature15ChoiceChoice;
import iso20022.auth108.iso.validation.exists.CounterpartyTradeNature15ChoiceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CounterpartyTradeNature15Choice.class)
public class CounterpartyTradeNature15ChoiceMeta implements RosettaMetaData<CounterpartyTradeNature15Choice> {

	@Override
	public List<Validator<? super CounterpartyTradeNature15Choice>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<CounterpartyTradeNature15Choice>create(CounterpartyTradeNature15ChoiceChoice.class)
		);
	}
	
	@Override
	public List<Function<? super CounterpartyTradeNature15Choice, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CounterpartyTradeNature15Choice> validator(ValidatorFactory factory) {
		return factory.<CounterpartyTradeNature15Choice>create(CounterpartyTradeNature15ChoiceValidator.class);
	}

	@Override
	public Validator<? super CounterpartyTradeNature15Choice> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CounterpartyTradeNature15Choice>create(CounterpartyTradeNature15ChoiceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CounterpartyTradeNature15Choice> validator() {
		return new CounterpartyTradeNature15ChoiceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CounterpartyTradeNature15Choice> typeFormatValidator() {
		return new CounterpartyTradeNature15ChoiceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CounterpartyTradeNature15Choice, Set<String>> onlyExistsValidator() {
		return new CounterpartyTradeNature15ChoiceOnlyExistsValidator();
	}
}
