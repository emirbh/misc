package fpml.consolidated.business.events.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.business.events.ClearingStatusItem;
import fpml.consolidated.business.events.validation.ClearingStatusItemTypeFormatValidator;
import fpml.consolidated.business.events.validation.ClearingStatusItemValidator;
import fpml.consolidated.business.events.validation.datarule.ClearingStatusItemChoice;
import fpml.consolidated.business.events.validation.exists.ClearingStatusItemOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ClearingStatusItem.class)
public class ClearingStatusItemMeta implements RosettaMetaData<ClearingStatusItem> {

	@Override
	public List<Validator<? super ClearingStatusItem>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<ClearingStatusItem>create(ClearingStatusItemChoice.class)
		);
	}
	
	@Override
	public List<Function<? super ClearingStatusItem, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ClearingStatusItem> validator(ValidatorFactory factory) {
		return factory.<ClearingStatusItem>create(ClearingStatusItemValidator.class);
	}

	@Override
	public Validator<? super ClearingStatusItem> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ClearingStatusItem>create(ClearingStatusItemTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ClearingStatusItem> validator() {
		return new ClearingStatusItemValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ClearingStatusItem> typeFormatValidator() {
		return new ClearingStatusItemTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ClearingStatusItem, Set<String>> onlyExistsValidator() {
		return new ClearingStatusItemOnlyExistsValidator();
	}
}
