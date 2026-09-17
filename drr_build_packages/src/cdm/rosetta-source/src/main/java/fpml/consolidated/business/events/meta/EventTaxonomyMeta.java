package fpml.consolidated.business.events.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.business.events.EventTaxonomy;
import fpml.consolidated.business.events.validation.EventTaxonomyTypeFormatValidator;
import fpml.consolidated.business.events.validation.EventTaxonomyValidator;
import fpml.consolidated.business.events.validation.exists.EventTaxonomyOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=EventTaxonomy.class)
public class EventTaxonomyMeta implements RosettaMetaData<EventTaxonomy> {

	@Override
	public List<Validator<? super EventTaxonomy>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super EventTaxonomy, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super EventTaxonomy> validator(ValidatorFactory factory) {
		return factory.<EventTaxonomy>create(EventTaxonomyValidator.class);
	}

	@Override
	public Validator<? super EventTaxonomy> typeFormatValidator(ValidatorFactory factory) {
		return factory.<EventTaxonomy>create(EventTaxonomyTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super EventTaxonomy> validator() {
		return new EventTaxonomyValidator();
	}

	@Deprecated
	@Override
	public Validator<? super EventTaxonomy> typeFormatValidator() {
		return new EventTaxonomyTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super EventTaxonomy, Set<String>> onlyExistsValidator() {
		return new EventTaxonomyOnlyExistsValidator();
	}
}
