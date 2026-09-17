package cdm.legaldocumentation.transaction.additionalterms.meta;

import cdm.legaldocumentation.transaction.additionalterms.IndexAdjustmentEvents;
import cdm.legaldocumentation.transaction.additionalterms.validation.IndexAdjustmentEventsTypeFormatValidator;
import cdm.legaldocumentation.transaction.additionalterms.validation.IndexAdjustmentEventsValidator;
import cdm.legaldocumentation.transaction.additionalterms.validation.exists.IndexAdjustmentEventsOnlyExistsValidator;
import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 6.23.0
 */
@RosettaMeta(model=IndexAdjustmentEvents.class)
public class IndexAdjustmentEventsMeta implements RosettaMetaData<IndexAdjustmentEvents> {

	@Override
	public List<Validator<? super IndexAdjustmentEvents>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super IndexAdjustmentEvents, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super IndexAdjustmentEvents> validator(ValidatorFactory factory) {
		return factory.<IndexAdjustmentEvents>create(IndexAdjustmentEventsValidator.class);
	}

	@Override
	public Validator<? super IndexAdjustmentEvents> typeFormatValidator(ValidatorFactory factory) {
		return factory.<IndexAdjustmentEvents>create(IndexAdjustmentEventsTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super IndexAdjustmentEvents> validator() {
		return new IndexAdjustmentEventsValidator();
	}

	@Deprecated
	@Override
	public Validator<? super IndexAdjustmentEvents> typeFormatValidator() {
		return new IndexAdjustmentEventsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super IndexAdjustmentEvents, Set<String>> onlyExistsValidator() {
		return new IndexAdjustmentEventsOnlyExistsValidator();
	}
}
