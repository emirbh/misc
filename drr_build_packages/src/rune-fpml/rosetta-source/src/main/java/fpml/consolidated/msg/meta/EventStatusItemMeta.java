package fpml.consolidated.msg.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.msg.EventStatusItem;
import fpml.consolidated.msg.validation.EventStatusItemTypeFormatValidator;
import fpml.consolidated.msg.validation.EventStatusItemValidator;
import fpml.consolidated.msg.validation.exists.EventStatusItemOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=EventStatusItem.class)
public class EventStatusItemMeta implements RosettaMetaData<EventStatusItem> {

	@Override
	public List<Validator<? super EventStatusItem>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super EventStatusItem, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super EventStatusItem> validator(ValidatorFactory factory) {
		return factory.<EventStatusItem>create(EventStatusItemValidator.class);
	}

	@Override
	public Validator<? super EventStatusItem> typeFormatValidator(ValidatorFactory factory) {
		return factory.<EventStatusItem>create(EventStatusItemTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super EventStatusItem> validator() {
		return new EventStatusItemValidator();
	}

	@Deprecated
	@Override
	public Validator<? super EventStatusItem> typeFormatValidator() {
		return new EventStatusItemTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super EventStatusItem, Set<String>> onlyExistsValidator() {
		return new EventStatusItemOnlyExistsValidator();
	}
}
