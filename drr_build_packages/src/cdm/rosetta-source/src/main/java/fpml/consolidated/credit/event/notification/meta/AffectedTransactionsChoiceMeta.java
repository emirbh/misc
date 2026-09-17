package fpml.consolidated.credit.event.notification.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.credit.event.notification.AffectedTransactionsChoice;
import fpml.consolidated.credit.event.notification.validation.AffectedTransactionsChoiceTypeFormatValidator;
import fpml.consolidated.credit.event.notification.validation.AffectedTransactionsChoiceValidator;
import fpml.consolidated.credit.event.notification.validation.datarule.AffectedTransactionsChoiceChoice;
import fpml.consolidated.credit.event.notification.validation.exists.AffectedTransactionsChoiceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=AffectedTransactionsChoice.class)
public class AffectedTransactionsChoiceMeta implements RosettaMetaData<AffectedTransactionsChoice> {

	@Override
	public List<Validator<? super AffectedTransactionsChoice>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<AffectedTransactionsChoice>create(AffectedTransactionsChoiceChoice.class)
		);
	}
	
	@Override
	public List<Function<? super AffectedTransactionsChoice, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AffectedTransactionsChoice> validator(ValidatorFactory factory) {
		return factory.<AffectedTransactionsChoice>create(AffectedTransactionsChoiceValidator.class);
	}

	@Override
	public Validator<? super AffectedTransactionsChoice> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AffectedTransactionsChoice>create(AffectedTransactionsChoiceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AffectedTransactionsChoice> validator() {
		return new AffectedTransactionsChoiceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AffectedTransactionsChoice> typeFormatValidator() {
		return new AffectedTransactionsChoiceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AffectedTransactionsChoice, Set<String>> onlyExistsValidator() {
		return new AffectedTransactionsChoiceOnlyExistsValidator();
	}
}
